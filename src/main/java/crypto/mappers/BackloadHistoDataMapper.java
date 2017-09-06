package crypto.mappers;

import crypto.model.tablePOJOs.HistoDataDB;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by tanerali on 27/08/2017.
 */
@Mapper
public interface BackloadHistoDataMapper {

    String INSERT_HISTO_MINUTE = "INSERT INTO `cryptopeek`.raw_histo_minute (time, close, high, low, open, " +
            "volumefrom, volumeto) VALUES (#{time}, #{close}, #{high}, #{low}, #{open}, " +
            "#{volumefrom}, #{volumeto})";

    String INSERT_HISTO_HOUR = "INSERT INTO `cryptopeek`.raw_histo_hour (time, close, high, low, open, " +
            "volumefrom, volumeto) VALUES (#{time}, #{close}, #{high}, #{low}, #{open}, " +
            "#{volumefrom}, #{volumeto})";

    String INSERT_HISTO_DAY = "INSERT INTO `cryptopeek`.raw_histo_day (time, close, high, low, open, " +
            "volumefrom, volumeto) VALUES (#{time}, #{close}, #{high}, #{low}, #{open}, " +
            "#{volumefrom}, #{volumeto})";

    @Insert(INSERT_HISTO_MINUTE)
    void insertHistoMinuteIntoDB(HistoDataDB histoDataDB);

    @Insert(INSERT_HISTO_HOUR)
    void insertHistoHourIntoDB(HistoDataDB histoDataDB);

    @Insert(INSERT_HISTO_DAY)
    void insertHistoDayIntoDB(HistoDataDB histoDataDB);
}
