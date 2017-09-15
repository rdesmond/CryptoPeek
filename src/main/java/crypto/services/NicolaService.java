package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.model.cryptoCompareModels.CryptoPrice;
import crypto.model.cryptoCompareModels.PriceHistorical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NicolaService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CryptoCompareService cryptoCompareService;

    // Author: Nicola
    public CryptoPrice getPrice (String fsym, String tsyms) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/price?fsym=" + fsym + "&tsyms=" + tsyms;
        CryptoPrice cryptoPrice = new CryptoPrice();
        try{
                cryptoPrice= (CryptoPrice) cryptoCompareService.callCryptoCompareAPI(url, cryptoPrice);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return cryptoPrice;
    }

    // Author: Nicola
    public PriceHistorical getPriceMulti (String tsyms) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC&tsyms=" + tsyms;
        PriceHistorical priceHistorical = new PriceHistorical();
        try{
            priceHistorical=(PriceHistorical) cryptoCompareService.callCryptoCompareAPI(url, priceHistorical);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return priceHistorical;
    }

    // Author: Nicola
//    public CryptoPrice getPriceMultiFull (String fsyms, String tsyms) throws APIUnavailableException {
//
//        String url = "https://min-api.cryptocompare.com/data/pricemultifull?fsyms=" + fsyms + "&tsyms=" + tsyms;
//        CryptoPrice cryptoPrice = new CryptoPrice;
//        try{
//            cryptoPrice=(HistoMinute) cryptoCompareService.callCryptoCompareAPI(url, cryptoPrice);
//
//        } catch (Exception e){
//            throw new APIUnavailableException();
//        }
//        return cryptoPrice;
//    }

    // Author: Nicola
    public CryptoPrice getGenerateAvg (String fsym, String tsym, String markets) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/generateAvg?fsym=" + fsym + "&tsym=" + tsym +
                        "&markets=" + markets;
        CryptoPrice cryptoPrice = new CryptoPrice();
        try{
            cryptoPrice = (CryptoPrice) cryptoCompareService.callCryptoCompareAPI(url, cryptoPrice);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return cryptoPrice;
    }

    // Author: Nicola
    public CryptoPrice getDayAvg (String fsym, String tsym) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/dayAvg?fsym=" + fsym + "&tsym=" + tsym;
        CryptoPrice cryptoPrice = new CryptoPrice();
        try{
            cryptoPrice = (CryptoPrice) cryptoCompareService.callCryptoCompareAPI(url, cryptoPrice);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return cryptoPrice;
    }

    // Author: Nicola
    public PriceHistorical getPriceHistorical (String tsyms, String ts) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/pricehistorical?fsym=BTC&tsyms=" + tsyms + "&ts=" + ts;
        PriceHistorical priceHistorical = new PriceHistorical();
        try{
            priceHistorical = (PriceHistorical) cryptoCompareService.callCryptoCompareAPI(url, priceHistorical);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return priceHistorical;
    }
}
