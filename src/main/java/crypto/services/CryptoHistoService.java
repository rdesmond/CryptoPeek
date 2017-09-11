package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.model.historicalModels.HistoDay;
import crypto.model.historicalModels.HistoHour;
import crypto.model.historicalModels.HistoMinute;
import crypto.model.historicalModels.ThirtyDayAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by aaron on 8/11/17.
 *
 * Contains straight-through API calls to the historical data and
 * a method calculating the 30 day moving average
 */
@Service
public class CryptoHistoService {

    @Autowired
    RestTemplate restTemplate;

    public HistoDay getHistoricalDailyData(String fsym, String tsym, String exchange) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/histoday?fsym=" + fsym + "&tsym=" + tsym +"&e="+exchange;
        HistoDay historical;
        try {
            historical = restTemplate.getForObject(url, HistoDay.class);

            if (historical.getData().length < 1){
                throw new APIUnavailableException();
            }

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return historical;
    }

    public HistoHour getHistoricalHourlyData(String fsym, String tsym, String exchange) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/histohour?fsym=" + fsym + "&tsym=" + tsym +"&e="+exchange;
        HistoHour historical;
        try {
            historical = restTemplate.getForObject(url, HistoHour.class);

            if (historical.getData().length < 1){
                throw new APIUnavailableException();
            }

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return historical;
    }

    public HistoMinute getHistoricalMinutelyData(String fsym, String tsym, String exchange) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/histominute?fsym=" +
                fsym + "&tsym=" + tsym +"&e="+exchange;

        HistoMinute historical;
        try {
            historical = restTemplate.getForObject(url, HistoMinute.class);

            if (historical.getData().length < 1){
                throw new APIUnavailableException();
            }

        } catch (Exception e){
            throw new APIUnavailableException();
        }
        return historical;
    }

    public ThirtyDayAverage  getThirtyDayMovingAverage (String fsym, String tsym, String exchange) throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/histoday?fsym=" + fsym + "&tsym=" + tsym +"&e="+exchange;
        HistoDay historical;
        ThirtyDayAverage thirtyDayAverage = new ThirtyDayAverage();

        try {
            historical = restTemplate.getForObject(url, HistoDay.class);

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
