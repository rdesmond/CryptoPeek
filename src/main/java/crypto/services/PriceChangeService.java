package crypto.services;

import crypto.mappers.BackloadHistoDataMapper;
import crypto.mappers.TopCoinsMapper;
import crypto.model.tablePOJOs.HistoDataDB;
import crypto.util.DateUnix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by tanerali on 06/09/2017.
 */
@Service
public class PriceChangeService {

    @Autowired
    BackloadHistoDataMapper backloadHistoDataMapper;

    //Taner
    //gets the top 5 coins that have increased the most in terms of price in the
    //minutely, hourly and daily timeframe
    public ArrayList<HistoDataDB> topMinutelyMovers() {

        ArrayList<HistoDataDB> topMinutelyMovers =
                backloadHistoDataMapper.getTopMinutelyMovers(DateUnix.toPreviousWholeMinute());

        return topMinutelyMovers;
    }

    public ArrayList<HistoDataDB> topHourlyMovers() {
        ArrayList<HistoDataDB> topHourlyMovers =
                backloadHistoDataMapper.getTopHourlyMovers(DateUnix.toPreviousWholeHour());

        return topHourlyMovers;
    }

    public ArrayList<HistoDataDB> topDailyMovers() {
        ArrayList<HistoDataDB> topDailyMovers =
                backloadHistoDataMapper.getTopDailyMovers(DateUnix.toPreviousWholeDay());

        return topDailyMovers;
    }


}
