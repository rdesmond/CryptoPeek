package crypto.mappers;

import crypto.model.topCoins.TopCoins;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Insert(INSERT_NEW_TOP30)
    public void addNewTop (TopCoins t);


    String TOP5_HOURLY_MOVERS = "SELECT percent_change_1h, symbol " +
            "FROM cryptopeek.top_30 ORDER BY percent_change_1h DESC LIMIT 5";

    String TOP5_DAILY_MOVERS = "SELECT percent_change_24h, symbol " +
            "FROM cryptopeek.top_30 ORDER BY percent_change_24h DESC LIMIT 5";

    String TOP5_WEEKLY_MOVERS = "SELECT percent_change_7d, symbol " +
            "FROM cryptopeek.top_30 ORDER BY percent_change_7d DESC LIMIT 5";

    @Select(TOP5_HOURLY_MOVERS)
    ArrayList<TopCoins> getTop5HourlyMovers ();

    @Select(TOP5_DAILY_MOVERS)
    ArrayList<TopCoins> getTop5DailyMovers ();

    @Select(TOP5_WEEKLY_MOVERS)
    ArrayList<TopCoins> getTop5WeeklyMovers ();

    String GET_SYMBOLS = "SELECT symbol FROM cryptopeek.top_30";

    @Select(GET_SYMBOLS)
    ArrayList<TopCoins> getAllSymbols();
}
