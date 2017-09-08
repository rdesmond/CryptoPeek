package crypto.mappers;

import crypto.model.topCoins.TopCoins;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

/**
 * Created by daniel on 27.08.17.
 */
@Mapper
public interface TopCoinsMapper {

    String INSERT_NEW_TOP30 = "INSERT INTO top_30 (id, name, symbol, rank, price_usd, price_btc, percent_change_1h, " +
            "percent_change_24h, percent_change_7d, last_updated, market_cap_usd) " +
            "values (#{id}, #{name} , #{symbol}, #{rank}, #{price_usd}, #{price_btc}, #{percent_change_1h}, " +
            "#{percent_change_24h}, #{percent_change_7d}, #{last_updated}, #{market_cap_usd})";

    String GET_MOST_RECENT_TOP30 = "SELECT * FROM top_30 ORDER BY `entry_id` DESC LIMIT 30";

    String ADD_COIN_ID = "UPDATE top_30 SET coin_id = #{coin_id} WHERE symbol = #{symbol}";

    @Insert(INSERT_NEW_TOP30)
    public void addNewTop (TopCoins t);

    @Select(GET_MOST_RECENT_TOP30)
    public ArrayList<TopCoins> getMostRecentTop ();

    @Update(ADD_COIN_ID)
    public void addCoinId (String coin_id, String symbol);

}
