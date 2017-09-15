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

    // Author: Nicola
    public ArrayList<PersistHistoMinute> getLastHourDataFromMin() throws APIUnavailableException {


        ArrayList<PersistHistoMinute> avgs = new ArrayList<>();
        // Gets all of the ID and Symbols for all of the coins we are following from the DB.
        ArrayList<Coin> coinArrayList = persistData.getAllCoinFromDB();

        Coin coin;
        PersistHistoHour persistHistoHour;
        PersistHistoMinute persistHistoMinute;
        // Gets the unix timestamp for the last hour
        long time = DateUnix.oneHourInPastInSecs();
        // Gets the current unix timestamp
        long currentTime = DateUnix.currentTimeToSecs();
        int i = 0;
        for (i = 0; i < coinArrayList.size(); i++) {

            coin = coinArrayList.get(i);

            //  Gets the last hour of data from the rawHistoMinute table in the DB.
            ArrayList<PersistHistoMinute> rawData = dataAggregationMapper.getLastHourOpenCloseFromMin(coin.getId(), time);
            // Gets the average of the Low, High, Volumefrom and Volumeto from the rawHistoMinute table in the DB.
            ArrayList<PersistHistoMinute> avgData = dataAggregationMapper.getLastHourAvgFromMin(coin.getId(), time);

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
}
