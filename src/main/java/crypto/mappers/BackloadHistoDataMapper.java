package crypto.mappers;

import crypto.model.historicalModels.Data;
import crypto.model.tablePOJOs.HistoDataDB;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * Created by tanerali on 27/08/2017.
 */
@Mapper
public interface BackloadHistoDataMapper {

    String INSERT_HISTO_MINUTE = "INSERT INTO `cryptopeek`.raw_histoMinute (time, close, high, low, open, " +
            "volumefrom, volumeto) VALUES (#{time}, #{close}, #{high}, #{low}, #{open}, " +
            "#{volumefrom}, #{volumeto})";

    String INSERT_HISTO_HOUR = "INSERT INTO `cryptopeek`.raw_histoHour (time, close, high, low, open, " +
            "volumefrom, volumeto) VALUES (#{time}, #{close}, #{high}, #{low}, #{open}, " +
            "#{volumefrom}, #{volumeto})";

    String INSERT_HISTO_DAY = "INSERT INTO `cryptopeek`.raw_histoDay (time, close, high, low, open, " +
            "volumefrom, volumeto) VALUES (#{time}, #{close}, #{high}, #{low}, #{open}, " +
            "#{volumefrom}, #{volumeto})";

    @Insert(INSERT_HISTO_MINUTE)
    void insertHistoMinuteIntoDB(HistoDataDB histoDataDB);

    @Insert(INSERT_HISTO_HOUR)
    void insertHistoHourIntoDB(HistoDataDB histoDataDB);

    @Insert(INSERT_HISTO_DAY)
    void insertHistoDayIntoDB(HistoDataDB histoDataDB);
}
