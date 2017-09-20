package crypto.mappers;

import crypto.model.cryptoCompareModels.CryptoCalls;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Author: Nicola
 */


@Mapper
public interface CryptoCallsMapper {

    String GET_FIRST_CALL_LAST_HOUR = "SELECT IFNULL(( SELECT id FROM `cryptopeek`.crypto_compare_calls " +
            "WHERE time > DATE_SUB(NOW(), INTERVAL 1 HOUR) ORDER BY time asc LIMIT 1), 0) as id";
    String GET_LAST_CALL_LAST_HOUR = "SELECT IFNULL(( SELECT id FROM `cryptopeek`.crypto_compare_calls " +
            "WHERE time > DATE_SUB(NOW(), INTERVAL 1 HOUR) ORDER BY time desc LIMIT 1), 0) as id";

    String INSERT_CRYPTO_CALLS = "INSERT INTO `cryptopeek`.crypto_compare_calls (url_request, under_limit) " +
            "VALUES (#{urlRequest}, #{underLimit})"  ;

    /**
     * @author Nicola
     * @return The number(id) of the first call made within the last hour
     */
    @Select(GET_FIRST_CALL_LAST_HOUR)
    public int getFirstCallLastHour();

    /**
     * @author Nicola
     * @return The number(id) of the last call made within the last hour
     */
    @Select(GET_LAST_CALL_LAST_HOUR)
    public int getLastCallLastHour();

    /**
     * @author Nicola
     * @param cryptoCalls
     * @return
     * Inserts the cryptocompair calls into the logger in the DB
     */
    @Insert(INSERT_CRYPTO_CALLS)
    public int insertCryptoCalls(CryptoCalls cryptoCalls);


}
