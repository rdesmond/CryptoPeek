package crypto.mappers;

import crypto.model.historicalModels.CoinPojo;
import crypto.model.historicalModels.PersistHistoMinute;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * Created by nicola on 30/08/2017.
 */

@Mapper
public interface PersistData {

    String GET_COIN_FROM_DB = "SELECT entry_id as id, symbol FROM `cryptopeek`.top_30 WHERE symbol != 'BTC'";
    String GET_ALL_COIN_FROM_DB = "SELECT entry_id as id, symbol FROM `cryptopeek`.top_30";
    String INSERT_HISTO_MINUTE_DATA = "INSERT INTO `cryptopeek`.raw_histo_minute (close, high, low, open, time, " +
            "volumefrom, volumeto, coin_id) " +
            "VALUES (#{close}, #{high}, #{low}, #{open}, #{time}, #{volumefrom}, #{volumeto}, " +
            "#{coinId})"  ;
    String GET_MOST_RECENT_TIME = "SELECT time FROM `cryptopeek`.raw_histo_minute ORDER BY time desc LIMIT 1";
    String GET_MOST_RECENT_TIME_BTC = "SELECT time FROM `cryptopeek`.raw_histo_minute WHERE coin_id = '1' " +
            "ORDER BY time desc LIMIT 1";


    /**
     * @author Nicola
     * @return All coin id's and symbols except BTC from the top_30 table in the database
     */
    @Select(GET_COIN_FROM_DB)
    public ArrayList<CoinPojo> getCoinFromDB();

    /**
     * @author Nicola
     * @return All coin id's and symbols from the top_30 table in the database
     */
    @Select(GET_ALL_COIN_FROM_DB)
    public ArrayList<Coin> getAllCoinFromDB();

    /**
     * @author Nicola
     * @param persistHistoMinute
     * @return
     * Inserts raw data from cryptopeek into histoMinute table in DB
     */
    @Insert(INSERT_HISTO_MINUTE_DATA)
    public int insertHistoMinuteData(PersistHistoMinute persistHistoMinute);

    /**
     * @author Nicola
     * @return The timestamp for the last item entered into the histoMinute table in the database for all coins
     */
    @Select(GET_MOST_RECENT_TIME)
    public String getMostRecentTime();

    /**
     * @author Nicola
     * @return The timestamp for the last item entered into the histoMinute table in the database for BTC
     */
    @Select(GET_MOST_RECENT_TIME_BTC)
    public String getMostRecentTimeBTC();

}
