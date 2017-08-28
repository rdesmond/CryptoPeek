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

    public CryptoPrice getPrice (String fsym, String tsyms) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/price?fsym=" + fsym + "&tsyms=" + tsyms;
        CryptoPrice cryptoPrice;
        try{
                cryptoPrice=restTemplate.getForObject(url, CryptoPrice.class);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return cryptoPrice;
    }

    public CryptoPrice getPriceMulti (String fsyms, String tsyms) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=" + fsyms + "&tsyms=" + tsyms;
        CryptoPrice cryptoPrice;
        try{
            cryptoPrice=restTemplate.getForObject(url, CryptoPrice.class);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return cryptoPrice;
    }
    public CryptoPrice getPriceMultiFull (String fsyms, String tsyms) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/pricemultifull?fsyms=" + fsyms + "&tsyms=" + tsyms;
        CryptoPrice cryptoPrice;
        try{
            cryptoPrice=restTemplate.getForObject(url, CryptoPrice.class);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return cryptoPrice;
    }
    public CryptoPrice getGenerateAvg (String fsym, String tsym, String markets) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/generateAvg?fsym=" + fsym + "&tsym=" + tsym +
                        "&markets=" + markets;
        CryptoPrice cryptoPrice;
        try{
            cryptoPrice=restTemplate.getForObject(url, CryptoPrice.class);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return cryptoPrice;
    }
    public CryptoPrice getDayAvg (String fsym, String tsym) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/dayAvg?fsym=" + fsym + "&tsym=" + tsym;
        CryptoPrice cryptoPrice;
        try{
            cryptoPrice=restTemplate.getForObject(url, CryptoPrice.class);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return cryptoPrice;
    }
    public PriceHistorical getPriceHistorical (String tsyms, String ts) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/pricehistorical?fsym=BTC&tsyms=" + tsyms + "&ts=" + ts;
        PriceHistorical priceHistorical;
        try{
            priceHistorical=restTemplate.getForObject(url, PriceHistorical.class);

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return priceHistorical;
    }
}
