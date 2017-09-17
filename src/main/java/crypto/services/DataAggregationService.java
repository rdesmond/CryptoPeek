package crypto.services;

import crypto.exceptions.APIUnavailableException;
import crypto.mappers.DataAggregationMapper;
import crypto.mappers.PersistData;
import crypto.model.historicalModels.*;
import crypto.util.DateUnix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataAggregationService {

    @Autowired
    DataAggregationMapper dataAggregationMapper;

    @Autowired
    PersistData persistData;

    /**
     * @author Nicola
     * @return The averages for the last Hour of raw data for the DB
     * @throws APIUnavailableException
     */
    public ArrayList<PersistHistoMinute> getLastHourDataFromMin() throws APIUnavailableException {


        ArrayList<PersistHistoMinute> avgs = new ArrayList<>();
        // Gets all of the ID and Symbols for all of the coins we are following from the DB.
        ArrayList<Coin> coinArrayList = persistData.getAllCoinFromDB();

        Coin coin;
        PersistHistoHour persistHistoHour;
        PersistHistoMinute persistHistoMinute;
        // Gets the unix timestamp for the last hour
        long param1 = DateUnix.oneHourInPastInSecs();
        // Gets the current unix timestamp
        long currentTime = DateUnix.currentTimeToSecs();
        int i = 0;
        for (i = 0; i < coinArrayList.size(); i++) {

            coin = coinArrayList.get(i);

            //  Gets the last hour of data from the rawHistoMinute table in the DB.
            ArrayList<PersistHistoMinute> rawData = dataAggregationMapper.getLastHourOpenCloseFromMin(coin.getId(), param1);
            // Gets the average of the Low, High, Volumefrom and Volumeto from the rawHistoMinute table in the DB.
            ArrayList<PersistHistoMinute> avgData = dataAggregationMapper.getLastHourAvgFromMin(coin.getId(), param1);

            persistHistoMinute = new PersistHistoMinute();
            persistHistoHour = new PersistHistoHour();

            // Saves the averages from HistoMinute to the rawHistoHour table in the DB.
            persistHistoHour.setTime(currentTime);
            persistHistoHour.setOpen(rawData.get(0).getOpen());
            persistHistoHour.setClose(rawData.get(rawData.size()-1).getClose());
            persistHistoHour.setLow(avgData.get(0).getLow());
            persistHistoHour.setHigh(avgData.get(0).getHigh());
            persistHistoHour.setVolumefrom(avgData.get(0).getVolumefrom());
            persistHistoHour.setVolumeto(avgData.get(0).getVolumeto());
            avgs.add(persistHistoMinute);

            dataAggregationMapper.insertHourDataInDB(persistHistoMinute);

        }return avgs;
    }
    /**
     * @author Nicola
     * @return The averages for the last Day of raw data for the DB
     * @throws APIUnavailableException
     */
    public ArrayList<PersistHistoMinute> getLastDayDataFromHour() throws APIUnavailableException {


        ArrayList<PersistHistoMinute> avgs = new ArrayList<>();
        // Gets all of the ID and Symbols for all of the coins we are following from the DB.
        ArrayList<Coin> coinArrayList = persistData.getAllCoinFromDB();

        Coin coin;
        PersistHistoHour persistHistoHour;
        PersistHistoMinute persistHistoMinute;
        // Gets the unix timestamp for the last day
        long param1 = DateUnix.oneDayInPastInSecs();
        // Gets the current unix timestamp
        long currentTime = DateUnix.currentTimeToSecs();
        int i = 0;
        for (i = 0; i < coinArrayList.size(); i++) {

            coin = coinArrayList.get(i);

            //  Gets the last day of data from the rawHistoHour table in the DB.
            ArrayList<PersistHistoMinute> rawData = dataAggregationMapper.getLastDayOpenCloseFromHour(coin.getId(), param1);
            // Gets the average of the Low, High, Volumefrom and Volumeto from the rawHistoHour table in the DB.
            ArrayList<PersistHistoMinute> avgData = dataAggregationMapper.getLastDayAvgFromHour(coin.getId(), param1);

            persistHistoMinute = new PersistHistoMinute();
            persistHistoHour = new PersistHistoHour();

            // Saves the averages from HistoHour to the rawHistoDay table in the DB.
            persistHistoHour.setTime(currentTime);
            persistHistoHour.setOpen(rawData.get(0).getOpen());
            persistHistoHour.setClose(rawData.get(rawData.size()-1).getClose());
            persistHistoHour.setLow(avgData.get(0).getLow());
            persistHistoHour.setHigh(avgData.get(0).getHigh());
            persistHistoHour.setVolumefrom(avgData.get(0).getVolumefrom());
            persistHistoHour.setVolumeto(avgData.get(0).getVolumeto());
            avgs.add(persistHistoMinute);

            dataAggregationMapper.insertDayDataInDB(persistHistoMinute);

        }return avgs;
    }
    /**
     * @author Nicola
     * @return The averages for the last Week of raw data for the DB
     * @throws APIUnavailableException
     */
    public ArrayList<PersistHistoMinute> getLastWeekDataFromDay() throws APIUnavailableException {


        ArrayList<PersistHistoMinute> avgs = new ArrayList<>();
        // Gets all of the ID and Symbols for all of the coins we are following from the DB.
        ArrayList<Coin> coinArrayList = persistData.getAllCoinFromDB();

        Coin coin;
        PersistHistoHour persistHistoHour;
        PersistHistoMinute persistHistoMinute;
        // Gets the unix timestamp for the last week
        long param1 = DateUnix.oneWeekInPastInSecs();
        // Gets the current unix timestamp
        long currentTime = DateUnix.currentTimeToSecs();
        int i = 0;
        for (i = 0; i < coinArrayList.size(); i++) {

            coin = coinArrayList.get(i);

            //  Gets the last week of data from the rawHistoDay table in the DB.
            ArrayList<PersistHistoMinute> rawData = dataAggregationMapper.getLastWeekOpenCloseFromDay(coin.getId(), param1);
            // Gets the average of the Low, High, Volumefrom and Volumeto from the rawHistoDay table in the DB.
            ArrayList<PersistHistoMinute> avgData = dataAggregationMapper.getLastWeekAvgFromDay(coin.getId(), param1);

            persistHistoMinute = new PersistHistoMinute();
            persistHistoHour = new PersistHistoHour();

            // Saves the averages from HistoDay to the rawHistoWeek table in the DB.
            persistHistoHour.setTime(currentTime);
            persistHistoHour.setOpen(rawData.get(0).getOpen());
            persistHistoHour.setClose(rawData.get(rawData.size()-1).getClose());
            persistHistoHour.setLow(avgData.get(0).getLow());
            persistHistoHour.setHigh(avgData.get(0).getHigh());
            persistHistoHour.setVolumefrom(avgData.get(0).getVolumefrom());
            persistHistoHour.setVolumeto(avgData.get(0).getVolumeto());
            avgs.add(persistHistoMinute);

            dataAggregationMapper.insertWeekDataInDB(persistHistoMinute);

        }return avgs;
    }
}
