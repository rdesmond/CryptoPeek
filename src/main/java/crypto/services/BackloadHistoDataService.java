package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.mappers.BackloadHistoDataMapper;
import crypto.mappers.TopCoinsMapper;
import crypto.model.historicalModels.HistoDay;
import crypto.model.historicalModels.HistoHour;
import crypto.model.historicalModels.HistoMinute;
import crypto.model.tablePOJOs.HistoDataDB;
import crypto.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Created by tanerali on 26/08/2017.
 * Used for backloading raw historical data from CryptoCompare into database
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
//    BackloadHistoMinuteRepository backloadHistoDataRepository;


    //used to access the coins table
    @Autowired
    CoinRepository coinRepository;

    @Autowired
    TopCoinsMapper topCoinsMapper;


    //Taner
    //calls all 3 methods for backloading historical data into all 3
    //raw historical data tables;
    //it does this for all top 30 coins by getting the coin symbols from
    //the top 30 coins table
    public void backloadHistoricalData (String tsym, String exchange)
            throws APIUnavailableException {

        //gets the coin symbols from the top 30 coins table and backloads the histo
        //data for each coin in each table
        for (int i = 0; i < topCoinsMapper.getAllSymbols().size(); i++) {

            String fsym = topCoinsMapper.getAllSymbols().get(i).getSymbol();

            saveMinutelyHistoricalDataToDB(fsym, tsym, exchange);
            saveHourlyHistoricalDataToDB(fsym, tsym, exchange);
            saveDailyHistoricalDataToDB(fsym, tsym, exchange);
        }
    }

    //Taner
    /**
     * Backload historical data into one of the 3 historical data tables (histo_minute,
     * histo_hour or histo_day) depending on which parameter is specified (e.g. if
     * minutes parameter is specified, method will backload historical data into the
     * histo_minute table as far back as the specified amount of minutes)
     * @param fsym symbol for which the data is fetched
     * @param tsym the currency specified in fsym is converted to this currency
     * @throws APIUnavailableException
     */
    public void backloadSpecificHistoData (String fsym, String tsym, String exchange,
                                           int minutes, int hours, int days)
            throws APIUnavailableException {

        //using Hibernate to retrieve the coin that corresponds to the fsym parameter;
        //assigning the id of the given coin to variable coin_id in order to
        //save the historical data to DB with the id of the coin for which the data
        //is being saved
        int coin_id = coinRepository.findBySymbol(fsym).getId();

        //conditional depending on which parameter (minutes, hours, days) has been specified;
        //it is possible to specify more than one and the method would backload data for as
        //many as specified
        //in this case, if minutes are specified
        if (minutes > 0) {

            //API call to cryptocompare for historical minutely data
            String urlMinutes = "https://min-api.cryptocompare.com/data/histominute?fsym=" + fsym + "&tsym=" + tsym
                    +"&limit="+ minutes+ "&e="+exchange;

            //object that will contain the response from the API call
            HistoMinute histoMinute;
            try {
                histoMinute = restTemplate.getForObject(urlMinutes, HistoMinute.class);

                if (histoMinute.getData().length < 1){
                    throw new APIUnavailableException();
                }

            } catch (Exception e){
                throw new APIUnavailableException();
            }

            //loop that will iterate as many times as there are data objects in the response,
            //assign each data object to a HistoDataDB object and then upload that HistoDataDB
            //object to DB
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

            //if hours are specified
        } else if (hours > 0) {

            //API call to cryptocompare for historical hourly data
            String urlHours = "https://min-api.cryptocompare.com/data/histohour?fsym=" + fsym + "&tsym=" + tsym
                    +"&limit="+ hours+ "&e="+exchange;

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

            //API call to cryptocompare for historical daily data
            String urlDays = "https://min-api.cryptocompare.com/data/histoday?fsym=" + fsym + "&tsym=" + tsym
                    +"&limit="+ days+ "&e="+exchange;

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


    //Taner
    //used for backloading minutely historical data to DB
    public void saveMinutelyHistoricalDataToDB (String fsym, String tsym, String exchange)
            throws APIUnavailableException {

        //API call to cryptocompare for historical minutely data
        String url = "https://min-api.cryptocompare.com/data/histominute?fsym=" + fsym + "&tsym=" + tsym
                +"&limit=2000&e="+exchange;

        //object that will receive the response from the API call
        HistoMinute historical;
        try {
            //API call being assigned to HistoMinute object
            historical = restTemplate.getForObject(url, HistoMinute.class);

            if (historical.getData().length < 1){
                throw new APIUnavailableException();
            }

        } catch (Exception e){
            throw new APIUnavailableException();
        }

        //using Hibernate to retrieve the coin that corresponds to the fsym parameter;
        //assigning the id of the given coin to variable coin_id in order to
        //save the historical data to DB with the id of the coin for which the data
        //is being saved
        int coin_id = coinRepository.findBySymbol(fsym).getId();

        //loop that will iterate as many times as there are data objects in the response,
        //assign each data object to a HistoDataDB object and then upload that HistoDataDB
        //object to DB
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
        //seems mybatis cannot insert an ArrayList into DB (tried with hibernate too)

//        ArrayList<HistoDataDB> histoDataDBArrayList = new ArrayList<>();
//
//        for (int i =0; i < historical.getData().length; i++) {
//
//            HistoDataDB histoDataDB = new HistoDataDB();
//
//            histoDataDB.setTime( historical.getData()[i].getTime() );
//            histoDataDB.setClose( historical.getData()[i].getClose() );
//            histoDataDB.setHigh( historical.getData()[i].getHigh() );
//            histoDataDB.setLow( historical.getData()[i].getLow() );
//            histoDataDB.setOpen( historical.getData()[i].getOpen() );
//            histoDataDB.setVolumefrom( historical.getData()[i].getVolumefrom() );
//            histoDataDB.setVolumeto( historical.getData()[i].getVolumeto() );
//            histoDataDB.setCoin_id( coin_id );
//
//            histoDataDBArrayList.add(histoDataDB);
//        }
//
//        backloadHistoDataMapper.insertHistoMinuteArrayIntoDB(histoDataDBArrayList);



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
//            session.insertHistoMinuteArrayIntoDB(histoDataDB);
//            if( i % 20 == 0 ) { // Same as the JDBC batch size
//                //flush a batch of inserts and release memory:
//                session.flush();
//                session.clear();
//            }
//        }
//        tx.commit();
//        session.close();

    }


    //Taner
    //same method as above, just used for backloading hourly historical data
    public void saveHourlyHistoricalDataToDB (String fsym, String tsym, String exchange)
            throws APIUnavailableException {

        //API call to cryptocompare for historical hourly data
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

    //Taner
    //same method as above, just used for backloading daily historical data
    public void saveDailyHistoricalDataToDB (String fsym, String tsym, String exchange)
            throws APIUnavailableException {

        //API call to cryptocompare for historical daily data
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
