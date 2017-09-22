package crypto.services;

import crypto.exceptions.ExchangeNotFoundException;
import crypto.mappers.TopCoinsMapper;
import crypto.mappers.VolumeMapper;
import crypto.model.arbitrageModels.ArbitrageModel;
import crypto.model.arbitrageModels.SymbolList;
import crypto.model.cryptoCompareModels.CryptoCompare;
import crypto.model.cryptoCompareModels.CryptoModel;
import crypto.model.cryptoVolumeModel.CryptoVolume;
import crypto.model.topCoins.TopCoins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by aaron on 9/20/17.
 */
@Service
public class VolumeService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TopCoinsMapper topCoinsMapper;

    @Autowired
    VolumeMapper volumeMapper;

    //Aaron
    public CryptoVolume getCryptoVolume1coin (String fsym, String tsym) throws ExchangeNotFoundException {

        String url = "https://www.cryptocompare.com/api/data/coinsnapshot/?fsym=" + fsym + "&tsym=" + tsym;
        // iterate through each exchange and sum up the volume from each, after all exchanges
        // them create a CryptoVolume object and set the fsym, tysm, volume, and value (volume24hourto)
        // then return that object to the controller which will return a view that displays that data

        CryptoVolume cryptoVolume = new CryptoVolume();
        try {
            CryptoModel cryptoModel = restTemplate.getForObject(url, CryptoModel.class);

            double sumVolume = 0;
            double sumValue = 0;
            for (int i = 0; i < cryptoModel.getData().getExchanges().length; i++) {
                sumVolume += Double.parseDouble(cryptoModel.getData().getExchanges()[i].getVolume24hour());
                sumValue += Double.parseDouble(cryptoModel.getData().getExchanges()[i].getVolume24hourto());
            }

            cryptoVolume.setTotal_volume(sumVolume);
            cryptoVolume.setTotal_value(sumValue);
            cryptoVolume.setSymbol(fsym);
            cryptoVolume.setTo_currency(tsym);

            return cryptoVolume;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExchangeNotFoundException();
        }

    }

    public ArrayList<String> getTopCoinsArrayList() {
        ArrayList<TopCoins> coinSymbolArrayList = new ArrayList<>();
        coinSymbolArrayList = topCoinsMapper.getMostRecentTop();
        ArrayList<String> retVal = new ArrayList<String>();
        for (int i = 0; i < coinSymbolArrayList.size(); i++) {
            retVal.add(coinSymbolArrayList.get(i).getSymbol());
        }
        return retVal;
    }

    public ArrayList<CryptoVolume> getTop5Volumes() {

        ArrayList<String> topCoins = getTopCoinsArrayList();
        ArrayList<CryptoVolume> topFiveVolumeModels = new ArrayList<>();

        for (String symbol : topCoins) {
            try {
                CryptoVolume cryptoVolume = getCryptoVolume1coin (symbol, "USD");
                topFiveVolumeModels.add(cryptoVolume);
            } catch (ExchangeNotFoundException e) {
                e.printStackTrace();
            }
        }
        ArrayList<CryptoVolume> retVal = new ArrayList<CryptoVolume>();
        //The following sorts the topFiveVolumeModels arraylist
        Collections.sort(topFiveVolumeModels, (o1, o2) -> o1.getTotal_volume().compareTo(o2.getTotal_volume()));

        for (int i = topFiveVolumeModels.size(); retVal.size() < 5 && i > 0; i--) {
            if (!(topFiveVolumeModels.get(i - 1).getTotal_volume() == 0)) {
                retVal.add(topFiveVolumeModels.get(i - 1));
                volumeMapper.addVolumeStatsToDb(topFiveVolumeModels.get(i-1));
            }

        }

        for (CryptoVolume a : topFiveVolumeModels) {
            System.out.println("currency = " + a.getSymbol() + " volume = " + a.getTotal_volume());
        }

        return retVal;

    }

    public ArrayList<CryptoVolume> getTop5Values() {

        ArrayList<String> topCoins = getTopCoinsArrayList();
        ArrayList<CryptoVolume> topFiveValueModels = new ArrayList<>();

        for (String symbol : topCoins) {
            try {
                CryptoVolume cryptoVolume = getCryptoVolume1coin (symbol, "USD");
                topFiveValueModels.add(cryptoVolume);
            } catch (ExchangeNotFoundException e) {
                e.printStackTrace();
            }
        }
        ArrayList<CryptoVolume> retVal = new ArrayList<CryptoVolume>();
        //The following sorts the topFiveValueModels arraylist
        Collections.sort(topFiveValueModels, (o1, o2) -> o1.getTotal_value().compareTo(o2.getTotal_value()));

        for (int i = topFiveValueModels.size(); retVal.size() < 5 && i > 0; i--) {
            if (!(topFiveValueModels.get(i - 1).getTotal_value() == 0)) {
                retVal.add(topFiveValueModels.get(i - 1));
                //volumeMapper.addVolumeStatsToDb(topFiveValueModels.get(i-1));
            }

        }

        for (CryptoVolume a : topFiveValueModels) {
            System.out.println("currency = " + a.getSymbol() + " volume = " + a.getTotal_volume());
        }

        return retVal;

    }
}


