package crypto.mappers;

import crypto.model.tablePOJOs.HistoDataDB;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * Created by tanerali on 27/08/2017.
 */
@Mapper
public interface BackloadHistoDataMapper {

    String INSERT_HISTO_MINUTE = "INSERT INTO `cryptopeek`.raw_histo_minute (time, open, close, percent_change, " +
            "low, high, volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{percent_change}, #{low}, " +
            "#{high}, #{volumefrom}, #{volumeto}, #{coin_id})";

    String INSERT_HISTO_HOUR = "INSERT INTO `cryptopeek`.raw_histo_hour (time, open, close, percent_change, low, high, " +
            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{percent_change}, #{low}, #{high}, " +
            "#{volumefrom}, #{volumeto}, #{coin_id})";

    String INSERT_HISTO_DAY = "INSERT INTO `cryptopeek`.raw_histo_day (time, open, close, percent_change, low, high, " +
            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{percent_change}, #{low}, #{high}, " +
            "#{volumefrom}, #{volumeto}, #{coin_id})";

    //Taner
    @Insert(INSERT_HISTO_MINUTE)
    void insertHistoMinuteIntoDB(HistoDataDB histoDataDB);

    @Insert(INSERT_HISTO_HOUR)
    void insertHistoHourIntoDB(HistoDataDB histoDataDB);

    @Insert(INSERT_HISTO_DAY)
    void insertHistoDayIntoDB(HistoDataDB histoDataDB);



    String GET_LAST_TIMESTAMP_FROM_HISTOMINUTE = "SELECT id, time FROM cryptopeek.raw_histo_minute " +
            "WHERE coin_id = #{coin_id} ORDER BY id DESC LIMIT 1";

    String GET_LAST_TIMESTAMP_FROM_HISTOHOUR = "SELECT id, time FROM cryptopeek.raw_histo_hour " +
            "WHERE coin_id = #{coin_id} ORDER BY id DESC LIMIT 1";

    String GET_LAST_TIMESTAMP_FROM_HISTODAY = "SELECT id, time FROM cryptopeek.raw_histo_day " +
            "WHERE coin_id = #{coin_id} ORDER BY id DESC LIMIT 1";

    //Taner
    @Select(GET_LAST_TIMESTAMP_FROM_HISTOMINUTE)
    HistoDataDB getLastHistominEntry(int coin_id);

    @Select(GET_LAST_TIMESTAMP_FROM_HISTOHOUR)
    HistoDataDB getLastHistohourEntry(int coin_id);

    @Select(GET_LAST_TIMESTAMP_FROM_HISTODAY)
    HistoDataDB getLastHistodayEntry(int coin_id);



    String GET_TOP_MINUTELY_MOVERS = "SELECT * FROM cryptopeek.raw_histo_minute WHERE time = #{time} "+
            "ORDER BY percent_change DESC LIMIT 5";

    String GET_TOP_HOURLY_MOVERS = "SELECT * FROM cryptopeek.raw_histo_hour WHERE time = #{time} "+
            "ORDER BY percent_change DESC LIMIT 5";

    String GET_TOP_DAILY_MOVERS = "SELECT * FROM cryptopeek.raw_histo_day WHERE time = #{time} "+
            "ORDER BY percent_change DESC LIMIT 5";

    //Taner
    @Select(GET_TOP_MINUTELY_MOVERS)
    ArrayList<HistoDataDB> getTopMinutelyMovers(@Param("time") long currentTime);

    @Select(GET_TOP_HOURLY_MOVERS)
    ArrayList<HistoDataDB> getTopHourlyMovers(@Param("time") long currentTime);

    @Select(GET_TOP_DAILY_MOVERS)
    ArrayList<HistoDataDB> getTopDailyMovers(@Param("time") long currentTime);



    String GET_ALL_MINUTELY_TIMESTAMPS = "SELECT time FROM cryptopeek.raw_histo_minute WHERE coin_id = #{coin_id}";

    String GET_ALL_HOURLY_TIMESTAMPS = "SELECT time FROM cryptopeek.raw_histo_hour WHERE coin_id = #{coin_id}";

    String GET_ALL_DAILY_TIMESTAMPS = "SELECT time FROM cryptopeek.raw_histo_day WHERE coin_id = #{coin_id}";

    //Taner
    @Select(GET_ALL_MINUTELY_TIMESTAMPS)
    HistoDataDB[] getAllMinutelyTimestamps(int coin_id);

    @Select(GET_ALL_HOURLY_TIMESTAMPS)
    HistoDataDB[] getAllHourlyTimestamps(int coin_id);

    @Select(GET_ALL_DAILY_TIMESTAMPS)
    HistoDataDB[] getAllDailyTimestamps(int coin_id);


    //batch insert attempt
//    String INSERT_HISTO_MINUTE_AS_ARRAY = "INSERT INTO `cryptopeek`.raw_histo_minute (time, open, close, low, high, " +
//            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{low}, #{high}, " +
//            "#{volumefrom}, #{volumeto}, #{coin_id})";
//
//    @Insert(INSERT_HISTO_MINUTE_AS_ARRAY)
//    void insertHistoMinuteArrayIntoDB(ArrayList<HistoDataDB> histoDataDBArrayList);
}
