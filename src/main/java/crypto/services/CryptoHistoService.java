package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.exceptions.ExchangeNotFoundException;
import crypto.model.cryptoCompareModels.CryptoModel;
import crypto.model.cryptoCompareModels.Exchanges;
import crypto.model.historicalModels.Data;
import crypto.model.historicalModels.Historical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by aaron on 8/11/17.
 */
@Service
public class CryptoHistoService {

    @Autowired
    RestTemplate restTemplate;

    public Historical getHistoricalCryptoData (String fsym, String tsym, String exchange) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/histoday?fsym=" + fsym + "&tsym=" + tsym +"&e="+exchange;
        Historical historical;
        try {
            historical = restTemplate.getForObject(url, Historical.class);

            if (historical.getData().length < 1){
                throw new APIUnavailableException();
            }

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return historical;
    }
}
