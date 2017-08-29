package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.mappers.BackloadHistoDataMapper;
import crypto.model.historicalModels.HistoDay;
import crypto.model.historicalModels.HistoHour;
import crypto.model.historicalModels.HistoMinute;
import crypto.model.tablePOJOs.HistoDataDB;
import crypto.util.DateUnix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tanerali on 26/08/2017.
 */
@Service
public class BackloadHistoDataService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BackloadHistoDataMapper backloadHistoDataMapper;


    public void backloadHistoricalData (String fsym, String tsym, String exchange)
            throws APIUnavailableException {

        saveMinutelyHistoricalDataToDB(fsym, tsym, exchange);
        saveHourlyHistoricalDataToDB(fsym, tsym, exchange);
        saveDailyHistoricalDataToDB(fsym, tsym, exchange);
    }




    public void saveMinutelyHistoricalDataToDB (String fsym, String tsym, String exchange)
            throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/histominute?fsym=" + fsym + "&tsym=" + tsym
                +"&limit=2000&e="+exchange;
        HistoMinute historical;
        try {
            historical = restTemplate.getForObject(url, HistoMinute.class);

            if (historical.getData().length < 1){
                throw new APIUnavailableException();
            }

        } catch (Exception e){
            throw new APIUnavailableException();
        }

        for (int i =0; i < historical.getData().length; i++) {

            HistoDataDB histoDataDB = new HistoDataDB();

            histoDataDB.setTime( DateUnix.secondsToSpecificTime( historical.getData()[i].getTime() ) );
            histoDataDB.setClose( historical.getData()[i].getClose() );
            histoDataDB.setHigh( historical.getData()[i].getHigh() );
            histoDataDB.setLow( historical.getData()[i].getLow() );
            histoDataDB.setOpen( historical.getData()[i].getOpen() );
            histoDataDB.setVolumefrom( historical.getData()[i].getVolumefrom() );
            histoDataDB.setVolumeto( historical.getData()[i].getVolumeto() );


            backloadHistoDataMapper.insertHistoMinuteIntoDB(histoDataDB);
        }

    }


    public void saveHourlyHistoricalDataToDB (String fsym, String tsym, String exchange)
            throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/histohour?fsym=" + fsym + "&tsym=" + tsym
                +"&limit=2000&e="+exchange;
        HistoHour historical;
        try {
            historical = restTemplate.getForObject(url, HistoHour.class);

            if (historical.getData().length < 1){
                throw new APIUnavailableException();
            }

        } catch (Exception e){
            throw new APIUnavailableException();
        }

        for (int i =0; i < historical.getData().length; i++) {

            HistoDataDB histoDataDB = new HistoDataDB();

            histoDataDB.setTime( DateUnix.secondsToSpecificTime( historical.getData()[i].getTime() ) );
            histoDataDB.setClose( historical.getData()[i].getClose() );
            histoDataDB.setHigh( historical.getData()[i].getHigh() );
            histoDataDB.setLow( historical.getData()[i].getLow() );
            histoDataDB.setOpen( historical.getData()[i].getOpen() );
            histoDataDB.setVolumefrom( historical.getData()[i].getVolumefrom() );
            histoDataDB.setVolumeto( historical.getData()[i].getVolumeto() );


            backloadHistoDataMapper.insertHistoHourIntoDB(histoDataDB);
        }

    }


    public void saveDailyHistoricalDataToDB (String fsym, String tsym, String exchange)
            throws APIUnavailableException {

        String url = "https://min-api.cryptocompare.com/data/histoday?fsym=" + fsym + "&tsym=" + tsym
                +"&limit=2000&e="+exchange;
        HistoDay historical;
        try {
            historical = restTemplate.getForObject(url, HistoDay.class);

            if (historical.getData().length < 1){
                throw new APIUnavailableException();
            }

        } catch (Exception e){
            throw new APIUnavailableException();
        }

        for (int i =0; i < historical.getData().length; i++) {

            HistoDataDB histoDataDB = new HistoDataDB();

            histoDataDB.setTime( DateUnix.secondsToSpecificTime( historical.getData()[i].getTime() ) );
            histoDataDB.setClose( historical.getData()[i].getClose() );
            histoDataDB.setHigh( historical.getData()[i].getHigh() );
            histoDataDB.setLow( historical.getData()[i].getLow() );
            histoDataDB.setOpen( historical.getData()[i].getOpen() );
            histoDataDB.setVolumefrom( historical.getData()[i].getVolumefrom() );
            histoDataDB.setVolumeto( historical.getData()[i].getVolumeto() );


            backloadHistoDataMapper.insertHistoDayIntoDB(histoDataDB);
        }

    }

}
