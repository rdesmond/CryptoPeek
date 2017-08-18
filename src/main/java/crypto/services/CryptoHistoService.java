package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.exceptions.ExchangeNotFoundException;
import crypto.model.cryptoCompareModels.CryptoModel;
import crypto.model.cryptoCompareModels.Exchanges;
import crypto.model.historicalModels.Data;
import crypto.model.historicalModels.Historical;
import crypto.model.historicalModels.ThirtyDayAverage;
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

    public ThirtyDayAverage getThirtyDayMovingAverage (String fsym, String tsym, String exchange) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/histoday?fsym=" + fsym + "&tsym=" + tsym +"&e="+exchange;
        Historical historical;
        ThirtyDayAverage thirtyDayAverage = new ThirtyDayAverage();

        try {
            historical = restTemplate.getForObject(url, Historical.class);

            if (historical.getData().length < 1){
                throw new APIUnavailableException();
            }
            double sum =0;
            for (int i = 0; i < historical.getData().length; i++){
                sum += historical.getData()[i].getClose();
            }
            double avg = sum / (historical.getData().length);
            thirtyDayAverage.setAvg_price(avg);
            thirtyDayAverage.setFrom_currency(fsym);
            thirtyDayAverage.setTo_currency(tsym);
            return thirtyDayAverage;
        } catch (Exception e){
            throw new APIUnavailableException();
        }

    }


}
