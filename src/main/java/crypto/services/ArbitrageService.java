package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.exceptions.ExchangeNotFoundException;
import crypto.mappers.ArbitrageMapper;
import crypto.mappers.TopCoinsMapper;
import crypto.model.BTCPrice;
import crypto.model.arbitrageModels.ArbitrageModel;
import crypto.model.cryptoCompareModels.CryptoModel;
import crypto.model.cryptoCompareModels.Exchanges;
import crypto.model.arbitrageModels.ArbitrageList;
import crypto.model.arbitrageModels.SymbolList;
import crypto.model.topCoins.TopCoins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by aaron on 9/8/17.
 */
@Service
public class ArbitrageService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TopCoinsMapper topCoinsMapper;

    @Autowired
    ArbitrageMapper arbitrageMapper;

    /**
     *
     * @param fsym
     * @param tsym
     * @return arbitragemodel
     * @throws ExchangeNotFoundException
     *
     * This method calculates the price difference(arbitrage opportunity) between the highest and lowest valid exchange for
     * a given cryptocurrency.
     *
     */
    public ArbitrageModel getDifferenceHighestandLowestBTC (String fsym, String tsym) throws ExchangeNotFoundException {
        Double dif;
        String url = "https://www.cryptocompare.com/api/data/coinsnapshot/?fsym=" + fsym + "&tsym=" + tsym;
        CryptoModel cryptoModel;
        TopCoins topcoins = new TopCoins();
        ArbitrageModel arbitrageModel = new ArbitrageModel();
        double btcPrice = 0;
        //ArbitrageModel getBTCPrice = getDifferenceHighestandLowestUSD("BTC", "USD");
        try {
            btcPrice = restTemplate.getForObject("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD",
                    BTCPrice.class).getUSD();
            cryptoModel = restTemplate.getForObject(url, CryptoModel.class);

            if (cryptoModel.getData().getExchanges().length < 1){
                throw new APIUnavailableException();
            }

            // get all the exchanges into an array we can loop through
            Exchanges[] ex = cryptoModel.getData().getExchanges();
            Exchanges[] result = new Exchanges[2];

            Exchanges highestExchange = null;
            Exchanges lowestExchange = null;

            for (Exchanges e : ex){
                if (isValidExchange(e.getMarket())){
                    highestExchange = e;
                    lowestExchange = e;
                    break;
                }
            }

            for (int i = 0 ; i < ex.length ; i++){

                //this exchange higher than previous highest exchange return it
                if ((Double.parseDouble(ex[i].getPrice()) > Double.parseDouble(highestExchange.getPrice())) && isValidExchange(ex[i].getMarket())){

                    highestExchange = ex[i];
                }

            }
            result[0] = highestExchange;

            for (int i = 0 ; i < ex.length ; i++){
                //this exchange higher than previous highest exchange return it
                if (Double.parseDouble(ex[i].getPrice()) < Double.parseDouble(lowestExchange.getPrice())
                        && isValidExchange(ex[i].getMarket())){

                    lowestExchange = ex[i];
                }

            }
            result[1] = lowestExchange;

            dif = Double.parseDouble(highestExchange.getPrice()) - Double.parseDouble(lowestExchange.getPrice());
            arbitrageModel.setLowExchangePrice(lowestExchange.getPrice());
            arbitrageModel.setHighExchangePrice(highestExchange.getPrice());
            arbitrageModel.setLowExchangeName(lowestExchange.getMarket());
            arbitrageModel.setHighExchangeName(highestExchange.getMarket());
            if (fsym.equalsIgnoreCase("BTC")){
                arbitrageModel.setDifferencein$USD(dif);
            } else {
                arbitrageModel.setDifferencein$USD(dif * btcPrice);
            }
            arbitrageModel.setSymbol(fsym);
            return arbitrageModel;

        } catch (Exception e){
            e.printStackTrace();
            throw new ExchangeNotFoundException();
        }
    }

    /**
     * @author Aaron
     * @return retVal - an arraylist of Strings from the topCoinsMapper
     */
    public ArrayList<String> getTopCoinsArrayList(){
        ArrayList<TopCoins> coinSymbolArrayList = new ArrayList<>();
        coinSymbolArrayList = topCoinsMapper.getMostRecentTop();
        ArrayList<String> retVal = new ArrayList<String>();
        for (int i = 0; i < coinSymbolArrayList.size(); i++){
            retVal.add(coinSymbolArrayList.get(i).getSymbol());
        }
        return retVal;
    }

    /**
     * @author Aaron
     * @return retVal - an arraylist of arbitragemodels
     *
     * This method iterates through the 30 symbols in topCoins and calls the method that returns the arbitragemodel
     * with the price difference calculated.
     */
    public ArrayList<ArbitrageModel> getTopArbitrageOps(){

        ArrayList<String> topCoins = getTopCoinsArrayList();
        ArrayList<ArbitrageModel> topFiveArbitrageModels = new ArrayList<>();

        for (String symbol : topCoins){
            if (symbol.equalsIgnoreCase("BTC")){
                try {
                    ArbitrageModel arbitrageModel = getDifferenceHighestandLowestBTC(symbol,"USD");
                    topFiveArbitrageModels.add(arbitrageModel);
                } catch (ExchangeNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    ArbitrageModel arbitrageModel = getDifferenceHighestandLowestBTC(symbol,"BTC");
                    topFiveArbitrageModels.add(arbitrageModel);
                } catch (ExchangeNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        ArrayList<ArbitrageModel> retVal = new ArrayList<ArbitrageModel>();
        //The following sorts the topFiveArbitrageModels arraylist
        Collections.sort(topFiveArbitrageModels, (o1, o2) -> o1.getDifferencein$USD().compareTo(o2.getDifferencein$USD()));
        //The for loop below iterates through from topFiveArbitrageModels.size to zero and finds the first five (biggest)
        //price differences and adds them to a new array called retVal.
        for (int i = topFiveArbitrageModels.size(); retVal.size() < 5 && i > 0 ; i--){
            if (!(topFiveArbitrageModels.get(i-1).getDifferencein$USD() == 0)){
                retVal.add(topFiveArbitrageModels.get(i-1));
                arbitrageMapper.addArbitrageStatsToDb(topFiveArbitrageModels.get(i-1));
            }

        }

        for (ArbitrageModel a : topFiveArbitrageModels){
            System.out.println("symbol = " + a.getSymbol() + " difference = " +a.getDifferencein$USD());
        }

        return retVal;


    }

    /**
     * @author Aaron
     * @param exchange
     * @return boolean
     *
     * The following method checks to see if the the exchange is valid based upon a check of five exchanges
     */
    public boolean isValidExchange(String exchange){
        if (exchange.equalsIgnoreCase("Coinbase")){
            return true;
        } else if (exchange.equalsIgnoreCase("Bitfinex")){
            return true;
        } else if (exchange.equalsIgnoreCase("BitTrex")){
            return true;
        } else if (exchange.equalsIgnoreCase("Poloniex")){
            return true;
        } else if (exchange.equalsIgnoreCase("Kraken")){
            return true;
        } else if (exchange.equalsIgnoreCase("CCCAGG")){
            return true;
        } else {
            return false;
        }
    }


}
