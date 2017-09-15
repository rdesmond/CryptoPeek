package crypto.mappers;

import crypto.model.cryptoCompareModels.CryptoCalls;
import crypto.model.historicalModels.Coin;
import crypto.model.historicalModels.PersistHistoMinute;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * Author: Nicola
 */
@Mapper
public interface DataAggregationMapper {

    //Syntax does not work yet
    String GET_LAST_HOUR_AVG_FROM_MIN = "SELECT avg(low), avg(high), avg(volumefrom), avg(volumeto) " +
            "FROM `cryptopeek`.raw_histo_minute WHERE time > #{time} and coin_id = #{coinId}";
    String GET_LAST_HOUR_OPEN_CLOSE_FROM_MIN = "SELECT time, open, close FROM `cryptopeek`.raw_histo_minute " +
            "WHERE time > #{time} and coin_id = #{coinId}";
    String INSERT_HOUR_DATA_IN_DB = "INSERT INTO `cryptopeek`.raw_histo_hour (time, open, close, low, high, " +
            "volumefrom, volumeto, coin_id) VALUES (#{time}, #{open}, #{close}, #{low}, #{high}, #{volumefrom}, " +
            "#{volumeto}, #{coinId})"  ;

    @Select(GET_LAST_HOUR_AVG_FROM_MIN)
    public ArrayList<PersistHistoMinute> getLastHourAvgFromMin(int coinId, long time);

    @Select(GET_LAST_HOUR_OPEN_CLOSE_FROM_MIN)
    public ArrayList<PersistHistoMinute> getLastHourOpenCloseFromMin(int coinId, long time);

    @Insert(INSERT_HOUR_DATA_IN_DB)
    public int insertHourDataInDB(PersistHistoMinute persistHistoMinute);

}
