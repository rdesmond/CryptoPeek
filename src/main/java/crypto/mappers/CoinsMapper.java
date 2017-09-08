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

    String GET_COIN_ID = "SELECT `coin_id` FROM coins WHERE symbol=#{symbol}";

    @Insert(INSERT_COIN)
    public void insertCoin(Coin c);

    @Select(GET_COIN_ID)
    public String getCoinId(String symbol);
}
