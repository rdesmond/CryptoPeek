package crypto.mappers;

import crypto.model.tablePOJOs.HistoDataDB;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by tanerali on 27/08/2017.
 */
@Mapper
public interface BackloadHistoDataMapper {

    String INSERT_HISTO_MINUTE = "INSERT INTO `cryptopeek`.raw_histo_minute (time, open, close, low, high, " +
            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{low}, #{high}, " +
            "#{volumefrom}, #{volumeto}, #{coin_id})";

    String INSERT_HISTO_HOUR = "INSERT INTO `cryptopeek`.raw_histo_hour (time, open, close, low, high, " +
            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{low}, #{high}, " +
            "#{volumefrom}, #{volumeto}, #{coin_id})";

    String INSERT_HISTO_DAY = "INSERT INTO `cryptopeek`.raw_histo_day (time, open, close, low, high, " +
            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{low}, #{high}, " +
            "#{volumefrom}, #{volumeto}, #{coin_id})";

    @Insert(INSERT_HISTO_MINUTE)
    void insertHistoMinuteIntoDB(HistoDataDB histoDataDB);

    @Insert(INSERT_HISTO_HOUR)
    void insertHistoHourIntoDB(HistoDataDB histoDataDB);

    @Insert(INSERT_HISTO_DAY)
    void insertHistoDayIntoDB(HistoDataDB histoDataDB);



    String GET_LAST_OBJECT_ID_FROM_HISTOMINUTE = "SELECT id, time FROM cryptopeek.raw_histo_minute " +
            "WHERE coin_id = #{coin_id} ORDER BY id DESC LIMIT 1";

    String GET_LAST_OBJECT_ID_FROM_HISTOHOUR = "SELECT id, time FROM cryptopeek.raw_histo_hour " +
            "WHERE coin_id = #{coin_id} ORDER BY id DESC LIMIT 1";

    String GET_LAST_OBJECT_ID_FROM_HISTODAY = "SELECT id, time FROM cryptopeek.raw_histo_day " +
            "WHERE coin_id = #{coin_id} ORDER BY id DESC LIMIT 1";

    @Select(GET_LAST_OBJECT_ID_FROM_HISTOMINUTE)
    HistoDataDB getLastHistominEntry(int coin_id);

    @Select(GET_LAST_OBJECT_ID_FROM_HISTOHOUR)
    HistoDataDB getLastHistohourEntry(int coin_id);

    @Select(GET_LAST_OBJECT_ID_FROM_HISTODAY)
    HistoDataDB getLastHistodayEntry(int coin_id);


    //used for calculating
//    String GET_HISTO_MINUTE = "SELECT * FROM `cryptopeek`.raw_histo_minute WHERE coin_id = #{coin_id}";
//
//    String GET_HISTO_HOUR = "SELECT open, close FROM `cryptopeek`.raw_histo_hour WHERE coin_id = #{coin_id}";
//
//    String GET_HISTO_DAY = "SELECT * FROM `cryptopeek`.raw_histo_day WHERE coin_id = #{coin_id}";
//
//    @Select(GET_HISTO_MINUTE)
//    ArrayList<HistoDataDB> getMinutelyHistoricalData(int coin_id);
//
//    @Select(GET_HISTO_HOUR)
//    ArrayList<HistoDataDB> getHourlyHistoricalData(int coin_id);
//
//    @Select(GET_HISTO_DAY)
//    ArrayList<HistoDataDB> getDailyHistoricalData(int coin_id);



//    String INSERT_HISTO_MINUTE_AS_ARRAY = "INSERT INTO `cryptopeek`.raw_histo_minute (time, open, close, low, high, " +
//            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{low}, #{high}, " +
//            "#{volumefrom}, #{volumeto}, #{coin_id})";
//
//    @Insert(INSERT_HISTO_MINUTE_AS_ARRAY)
//    void insertHistoMinuteArrayIntoDB(ArrayList<HistoDataDB> histoDataDBArrayList);
}
