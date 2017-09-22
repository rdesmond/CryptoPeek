package crypto.mappers;

import crypto.model.coinList.Coin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by daniel on 08.09.17.
 */
@Mapper
public interface CoinsMapper {
    String INSERT_COIN = "INSERT INTO coins (symbol, coin_name, coin_id, image_url)" +
            "values (#{name}, #{coinName} , #{id}, #{imageUrl})";

    String GET_COIN_ID_BY_SYMBOL = "SELECT coin_id FROM coins WHERE symbol=#{symbol}";

    String GET_COIN_ID_BY_NAME = "SELECT coin_id FROM coins WHERE coin_name=#{coin_name}";

    String GET_COIN_BY_NAME = "SELECT * FROM coins  WHERE coin_name=#{coin_name}";

    @Insert(INSERT_COIN)
    public void insertCoin(Coin c);

    @Select(GET_COIN_ID_BY_SYMBOL)
    public int getCoinIdBySymbol(String symbol);

    @Select(GET_COIN_ID_BY_NAME)
    public int getCoinIdByName(String coin_name);

    @Select(GET_COIN_BY_NAME)
    public Coin getCoinByName(String coin_name);


}
