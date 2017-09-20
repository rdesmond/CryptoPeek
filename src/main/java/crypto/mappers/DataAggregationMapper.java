package crypto.mappers;

import crypto.model.historicalModels.PersistHistoMinute;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * Author: Nicola
 * Mappers to load the averages for the last hour, day, and week for each coin in top_30 table to the database.
 */
@Mapper
public interface DataAggregationMapper {

    String GET_LAST_HOUR_AVG_FROM_MIN = "SELECT IFNULL(avg(percent_change), 0) as percent_change, IFNULL(avg(low), 0) as low, IFNULL(avg(high), 0) as high, " +
            "IFNULL(avg(volumefrom), 0) as volumefrom, IFNULL(avg(volumeto), 0) as volumeto " +
            "FROM `cryptopeek`.raw_histo_minute WHERE time > #{param1} and coin_id = #{param2}";
    String GET_LAST_HOUR_OPEN_CLOSE_FROM_MIN = "SELECT time, open, close FROM `cryptopeek`.raw_histo_minute " +
            "WHERE time > #{param1} and coin_id = #{param2}";
    String INSERT_HOUR_DATA_IN_DB = "INSERT INTO `cryptopeek`.raw_histo_hour (time, open, close, percent_change, low, high, " +
            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{percent_change}, #{low}, #{high}, #{volumefrom}, " +
            "#{volumeto}, #{coinId})"  ;
    String GET_LAST_DAY_AVG_FROM_HOUR = "SELECT IFNULL(avg(percent_change), 0) as percent_change, IFNULL(avg(low), 0) as low, IFNULL(avg(high), 0) as high, " +
            "IFNULL(avg(volumefrom), 0) as volumefrom, IFNULL(avg(volumeto), 0) as volumeto " +
            "FROM `cryptopeek`.raw_histo_minute WHERE time > #{param1} and coin_id = #{param2}";
    String GET_LAST_DAY_OPEN_CLOSE_FROM_HOUR = "SELECT time, open, close FROM `cryptopeek`.raw_histo_minute " +
            "WHERE time > #{param1} and coin_id = #{param2}";
    String INSERT_DAY_DATA_IN_DB = "INSERT INTO `cryptopeek`.raw_histo_hour (time, open, close, low, high, " +
            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{percent_change}, #{low}, #{high}, #{volumefrom}, " +
            "#{volumeto}, #{coinId})"  ;
    String GET_LAST_WEEK_AVG_FROM_DAY = "SELECT IFNULL(avg(percent_change), 0) as percent_change, IFNULL(avg(low), 0) as low, IFNULL(avg(high), 0) as high, " +
            "IFNULL(avg(volumefrom), 0) as volumefrom, IFNULL(avg(volumeto), 0) as volumeto " +
            "FROM `cryptopeek`.raw_histo_minute WHERE time > #{param1} and coin_id = #{param2}";
    String GET_LAST_WEEK_OPEN_CLOSE_FROM_DAY = "SELECT time, open, close FROM `cryptopeek`.raw_histo_minute " +
            "WHERE time > #{param1} and coin_id = #{param2}";
    String INSERT_WEEK_DATA_IN_DB = "INSERT INTO `cryptopeek`.raw_histo_hour (time, open, close, low, high, " +
            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{percent_change}, #{low}, #{high}, #{volumefrom}, " +
            "#{volumeto}, #{coinId})"  ;


    /**
     * @author Nicola
     * @param coinId The id of the coin we want the info of
     * @param time The the last hour in unix timestamp
     * @return Average data for the given coin
     */
    @Select(GET_LAST_HOUR_AVG_FROM_MIN)
    public ArrayList<PersistHistoMinute> getLastHourAvgFromMin(@Param("param2") int coinId, @Param("param1") long time);

    /**
     * @author Nicola
     * @param coinId The id of the coin we want the info of
     * @param time The the last hour in unix timestamp
     * @return Open and Close for the start and end of the timeframe for the given coin
     */
    @Select(GET_LAST_HOUR_OPEN_CLOSE_FROM_MIN)
    public ArrayList<PersistHistoMinute> getLastHourOpenCloseFromMin(@Param("param2") int coinId, @Param("param1") long time);

    /**
     * @author Nicola
     * @param persistHistoMinute
     * @return
     *
     * This inserts the new last hours worth or data into the HistoHour table.
     */
    @Insert(INSERT_HOUR_DATA_IN_DB)
    public int insertHourDataInDB(PersistHistoMinute persistHistoMinute);

    /**
     * @author Nicola
     * @param coinId The id of the coin we want the info of
     * @param time The the last hour in unix timestamp
     * @return Average data for the given coin
     */
    @Select(GET_LAST_DAY_AVG_FROM_HOUR)
    public ArrayList<PersistHistoMinute> getLastDayAvgFromHour(@Param("param2") int coinId, @Param("param1") long time);

    /**
     * @author Nicola
     * @param coinId The id of the coin we want the info of
     * @param time The the last hour in unix timestamp
     * @return Open and Close for the start and end of the timeframe for the given coin
     */
    @Select(GET_LAST_DAY_OPEN_CLOSE_FROM_HOUR)
    public ArrayList<PersistHistoMinute> getLastDayOpenCloseFromHour(@Param("param2") int coinId, @Param("param1") long time);

    /**
     * @author Nicola
     * @param persistHistoMinute
     * @return
     */
    @Insert(INSERT_DAY_DATA_IN_DB)
    public int insertDayDataInDB(PersistHistoMinute persistHistoMinute);

    /**
     * @author Nicola
     * @param coinId The id of the coin we want the info of
     * @param time The the last hour in unix timestamp
     * @return Average data for the given coin
     */
    @Select(GET_LAST_WEEK_AVG_FROM_DAY)
    public ArrayList<PersistHistoMinute> getLastWeekAvgFromDay(@Param("param2") int coinId, @Param("param1") long time);

    /**
     * @author Nicola
     * @param coinId The id of the coin we want the info of
     * @param time The the last hour in unix timestamp
     * @return Open and Close for the start and end of the timeframe for the given coin
     */
    @Select(GET_LAST_WEEK_OPEN_CLOSE_FROM_DAY)
    public ArrayList<PersistHistoMinute> getLastWeekOpenCloseFromDay(@Param("param2") int coinId, @Param("param1") long time);

    /**
     * @author Nicola
     * @param persistHistoMinute
     * @return
     */
    @Insert(INSERT_WEEK_DATA_IN_DB)
    public int insertWeekDataInDB(PersistHistoMinute persistHistoMinute);

}
