package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.model.cryptoCompareModels.CryptoPrice;
import crypto.model.historicalModels.Historical;
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
}
