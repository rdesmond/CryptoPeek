package crypto.mappers;

import crypto.model.arbitrageModels.SymbolList;
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

    final String INSERT_NEW_TOP30 = "INSERT INTO top_30 (id, name, symbol, rank, price_usd, price_btc, percent_change_1h, " +
            "percent_change_24h, percent_change_7d, last_updated, market_cap_usd) " +
            "values (#{id}, #{name} , #{symbol}, #{rank}, #{price_usd}, #{price_btc}, #{percent_change_1h}, " +
            "#{percent_change_24h}, #{percent_change_7d}, #{last_updated}, #{market_cap_usd})";

    String SELECT_COIN_SYMBOL = "SELECT name, symbol FROM top_30;";


    @Insert(INSERT_NEW_TOP30)
    public void addNewTop (TopCoins t);

    @Select(SELECT_COIN_SYMBOL)
    ArrayList<SymbolList> getCoinSymbols();


}
