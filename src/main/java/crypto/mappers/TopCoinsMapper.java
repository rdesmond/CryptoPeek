package crypto.mappers;

import crypto.model.topCoins.TopCoins;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by daniel on 27.08.17.
 */
@Mapper
public interface TopCoinsMapper {

    String INSERT_NEW_TOP30 = "INSERT INTO top_30 (id, name, symbol, rank, price_usd, price_btc, percent_change_1h, " +
            "percent_change_24h, percent_change_7d, last_updated, market_cap_usd) " +
            "values (#{id}, #{name} , #{symbol}, #{rank}, #{price_usd}, #{price_btc}, #{percent_change_1h}, " +
            "#{percent_change_24h}, #{percent_change_7d}, #{last_updated}, #{market_cap_usd})";

    String TOP5_HOURLY_MOVERS = "SELECT percent_change_1h, id FROM cryptopeek.top_30 ORDER BY percent_change_1h DESC";

    String TOP5_DAILY_MOVERS = "SELECT percent_change_24h, id FROM cryptopeek.top_30 ORDER BY percent_change_24h DESC";

    String TOP5_WEEKLY_MOVERS = "SELECT percent_change_7d, id FROM cryptopeek.top_30 ORDER BY percent_change_7d DESC";

    @Insert(INSERT_NEW_TOP30)
    public void addNewTop (TopCoins t);



}
