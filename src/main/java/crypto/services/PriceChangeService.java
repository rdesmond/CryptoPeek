package crypto.services;

import crypto.mappers.TopCoinsMapper;
import crypto.model.topCoins.TopCoins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by tanerali on 06/09/2017.
 */
@Service
public class PriceChangeService {

    @Autowired
    TopCoinsMapper topCoinsMapper;


    /* % increase = Increase ÷ Original Number × 100.
    if negative number, then this is a percentage decrease
    method for calculating percentage change between opening and closing prices of a given coin
    turns out not necessary since CoinMarketCap has an API call that returns percentage changes
    for most recent period (be it hour, day, week); will be necessary if we want to calculate
    which were the top 5 movers in some period in the past
    */
//    public void getHourlyPriceChange (int coin_id) {
//
//        //get all the open and close historical prices for all coins
//        ArrayList<HistoDataDB> histoHourDataDBArrayList = backloadHistoDataMapper.getHourlyHistoricalData(coin_id);
//
//        //index of last element histoHourDataDBArrayList
//        int lastIndex = histoHourDataDBArrayList.size() - 1;
//
//        //open price for most recent hourly price
//        double open = histoHourDataDBArrayList.get(lastIndex).getOpen();
//
//        double close = histoHourDataDBArrayList.get(lastIndex).getClose();
//
//        double percentChange = ( (( close - open)/open) * 100);
//    }


    //Taner
    //gets the top 5 hourly movers by percentage
    public ArrayList<TopCoins> getTop5Hourly () {

        ArrayList<TopCoins> top5HourlyMoversArrayList = topCoinsMapper.getTop5HourlyMovers();

        return top5HourlyMoversArrayList;
    }

    //Taner
    public ArrayList<TopCoins> getTop5Daily () {

        ArrayList<TopCoins> top5DailyMoversArrayList = topCoinsMapper.getTop5DailyMovers();

        return top5DailyMoversArrayList;
    }

    //Taner
    public ArrayList<TopCoins> getTop5Weekly () {

        ArrayList<TopCoins> top5WeeklyMoversArrayList = topCoinsMapper.getTop5WeeklyMovers();

        return top5WeeklyMoversArrayList;
    }

}
