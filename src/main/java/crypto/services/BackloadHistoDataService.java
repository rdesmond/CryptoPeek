package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.mappers.BackloadHistoDataMapper;
import crypto.model.historicalModels.HistoDay;
import crypto.model.historicalModels.HistoHour;
import crypto.model.historicalModels.HistoMinute;
import crypto.model.tablePOJOs.HistoDataDB;
import crypto.repository.CoinRepository;
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

//    @Autowired
//    SessionFactory sessionFactory;

    //if going to use hibernate to upload data to DB
//    @Autowired
//    BackloadHistoDataRepository backloadHistoDataRepository;

    @Autowired
    CoinRepository coinRepository;


    public void backloadHistoricalData (String fsym, String tsym, String exchange)
            throws APIUnavailableException {

        saveMinutelyHistoricalDataToDB(fsym, tsym, exchange);
        saveHourlyHistoricalDataToDB(fsym, tsym, exchange);
        saveDailyHistoricalDataToDB(fsym, tsym, exchange);
    }

    public void backloadSpecificHistoData (String fsym, String tsym, String exchange,
                                           int minutes, int hours, int days)
            throws APIUnavailableException {

        String urlMinutes = "https://min-api.cryptocompare.com/data/histominute?fsym=" + fsym + "&tsym=" + tsym
                +"&limit="+ minutes+ "&e="+exchange;

        String urlHours = "https://min-api.cryptocompare.com/data/histohour?fsym=" + fsym + "&tsym=" + tsym
                +"&limit="+ hours+ "&e="+exchange;

        String urlDays = "https://min-api.cryptocompare.com/data/histoday?fsym=" + fsym + "&tsym=" + tsym
                +"&limit="+ days+ "&e="+exchange;

        int coin_id = coinRepository.findBySymbol(fsym).getId();

        if (minutes > 0) {

            HistoMinute histoMinute;
            try {
                histoMinute = restTemplate.getForObject(urlMinutes, HistoMinute.class);

                if (histoMinute.getData().length < 1){
                    throw new APIUnavailableException();
                }

            } catch (Exception e){
                throw new APIUnavailableException();
            }

            for (int i =0; i < histoMinute.getData().length; i++) {

                HistoDataDB histoDataDB = new HistoDataDB();

//                can be used to convert time in seconds from API call to specific date and time
//                histoDataDB.setTime( DateUnix.secondsToSpecificTime( histoMinute.getData()[i].getTime() ) );

                histoDataDB.setTime( histoMinute.getData()[i].getTime() );
                histoDataDB.setClose( histoMinute.getData()[i].getClose() );
                histoDataDB.setHigh( histoMinute.getData()[i].getHigh() );
                histoDataDB.setLow( histoMinute.getData()[i].getLow() );
                histoDataDB.setOpen( histoMinute.getData()[i].getOpen() );
                histoDataDB.setVolumefrom( histoMinute.getData()[i].getVolumefrom() );
                histoDataDB.setVolumeto( histoMinute.getData()[i].getVolumeto() );
                histoDataDB.setCoin_id( coin_id );

                backloadHistoDataMapper.insertHistoMinuteIntoDB(histoDataDB);
            }

        } else if (hours > 0) {
            HistoHour histoHour;
            try {
                histoHour = restTemplate.getForObject(urlHours, HistoHour.class);

                if (histoHour.getData().length < 1){
                    throw new APIUnavailableException();
                }

            } catch (Exception e){
                throw new APIUnavailableException();
            }

            for (int i =0; i < histoHour.getData().length; i++) {

                HistoDataDB histoDataDB = new HistoDataDB();

                histoDataDB.setTime( histoHour.getData()[i].getTime() );
                histoDataDB.setClose( histoHour.getData()[i].getClose() );
                histoDataDB.setHigh( histoHour.getData()[i].getHigh() );
                histoDataDB.setLow( histoHour.getData()[i].getLow() );
                histoDataDB.setOpen( histoHour.getData()[i].getOpen() );
                histoDataDB.setVolumefrom( histoHour.getData()[i].getVolumefrom() );
                histoDataDB.setVolumeto( histoHour.getData()[i].getVolumeto() );
                histoDataDB.setCoin_id( coin_id );

                backloadHistoDataMapper.insertHistoHourIntoDB(histoDataDB);
            }

        } else if (days > 0) {

            HistoDay histoDay;
            try {
                histoDay = restTemplate.getForObject(urlDays, HistoDay.class);

                if (histoDay.getData().length < 1){
                    throw new APIUnavailableException();
                }

            } catch (Exception e){
                throw new APIUnavailableException();
            }

            for (int i =0; i < histoDay.getData().length; i++) {

                HistoDataDB histoDataDB = new HistoDataDB();

                histoDataDB.setTime( histoDay.getData()[i].getTime() );
                histoDataDB.setClose( histoDay.getData()[i].getClose() );
                histoDataDB.setHigh( histoDay.getData()[i].getHigh() );
                histoDataDB.setLow( histoDay.getData()[i].getLow() );
                histoDataDB.setOpen( histoDay.getData()[i].getOpen() );
                histoDataDB.setVolumefrom( histoDay.getData()[i].getVolumefrom() );
                histoDataDB.setVolumeto( histoDay.getData()[i].getVolumeto() );
                histoDataDB.setCoin_id( coin_id );

                backloadHistoDataMapper.insertHistoDayIntoDB(histoDataDB);
            }
        }

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

        int coin_id = coinRepository.findBySymbol(fsym).getId();

        for (int i =0; i < historical.getData().length; i++) {

            HistoDataDB histoDataDB = new HistoDataDB();

            histoDataDB.setTime( historical.getData()[i].getTime() );
            histoDataDB.setClose( historical.getData()[i].getClose() );
            histoDataDB.setHigh( historical.getData()[i].getHigh() );
            histoDataDB.setLow( historical.getData()[i].getLow() );
            histoDataDB.setOpen( historical.getData()[i].getOpen() );
            histoDataDB.setVolumefrom( historical.getData()[i].getVolumefrom() );
            histoDataDB.setVolumeto( historical.getData()[i].getVolumeto() );
            histoDataDB.setCoin_id( coin_id );


            backloadHistoDataMapper.insertHistoMinuteIntoDB(histoDataDB);
        }


        //batch insert attempt 1
        //seems hibernate cannot insert an ArrayList into DB

//        ArrayList<HistoDataDB> histoDataDBArrayList = new ArrayList<>();
//
//        for (int i =0; i < historical.getData().length; i++) {
//
//            HistoDataDB histoDataDB = new HistoDataDB();
//
//            histoDataDB.setTime( DateUnix.secondsToSpecificTime( historical.getData()[i].getTime() ) );
//            histoDataDB.setClose( historical.getData()[i].getClose() );
//            histoDataDB.setHigh( historical.getData()[i].getHigh() );
//            histoDataDB.setLow( historical.getData()[i].getLow() );
//            histoDataDB.setOpen( historical.getData()[i].getOpen() );
//            histoDataDB.setVolumefrom( historical.getData()[i].getVolumefrom() );
//            histoDataDB.setVolumeto( historical.getData()[i].getVolumeto() );
//
//            histoDataDBArrayList.add(histoDataDB);
//        }
//
//        backloadHistoDataRepository.save(histoDataDBArrayList);



        //batch insert attempt 2
        //errors: cant create sessionFactoryBean properly

//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        for ( int i=0; i<historical.getData().length; i++ ) {
//            HistoDataDB histoDataDB = new HistoDataDB();
//
//            histoDataDB.setTime( DateUnix.secondsToSpecificTime( historical.getData()[i].getTime() ) );
//            histoDataDB.setClose( historical.getData()[i].getClose() );
//            histoDataDB.setHigh( historical.getData()[i].getHigh() );
//            histoDataDB.setLow( historical.getData()[i].getLow() );
//            histoDataDB.setOpen( historical.getData()[i].getOpen() );
//            histoDataDB.setVolumefrom( historical.getData()[i].getVolumefrom() );
//            histoDataDB.setVolumeto( historical.getData()[i].getVolumeto() );
//
//            session.save(histoDataDB);
//            if( i % 20 == 0 ) { // Same as the JDBC batch size
//                //flush a batch of inserts and release memory:
//                session.flush();
//                session.clear();
//            }
//        }
//        tx.commit();
//        session.close();

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

        int coin_id = coinRepository.findBySymbol(fsym).getId();

        for (int i =0; i < historical.getData().length; i++) {

            HistoDataDB histoDataDB = new HistoDataDB();

            histoDataDB.setTime( historical.getData()[i].getTime() );
            histoDataDB.setClose( historical.getData()[i].getClose() );
            histoDataDB.setHigh( historical.getData()[i].getHigh() );
            histoDataDB.setLow( historical.getData()[i].getLow() );
            histoDataDB.setOpen( historical.getData()[i].getOpen() );
            histoDataDB.setVolumefrom( historical.getData()[i].getVolumefrom() );
            histoDataDB.setVolumeto( historical.getData()[i].getVolumeto() );
            histoDataDB.setCoin_id( coin_id );


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

        int coin_id = coinRepository.findBySymbol(fsym).getId();

        for (int i =0; i < historical.getData().length; i++) {

            HistoDataDB histoDataDB = new HistoDataDB();

            histoDataDB.setTime( historical.getData()[i].getTime() );
            histoDataDB.setClose( historical.getData()[i].getClose() );
            histoDataDB.setHigh( historical.getData()[i].getHigh() );
            histoDataDB.setLow( historical.getData()[i].getLow() );
            histoDataDB.setOpen( historical.getData()[i].getOpen() );
            histoDataDB.setVolumefrom( historical.getData()[i].getVolumefrom() );
            histoDataDB.setVolumeto( historical.getData()[i].getVolumeto() );
            histoDataDB.setCoin_id( coin_id );

            backloadHistoDataMapper.insertHistoDayIntoDB(histoDataDB);
        }

    }

}
