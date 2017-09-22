package crypto.mappers;

import crypto.model.arbitrageModels.SymbolList;
import crypto.model.topCoins.TopCoins;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

/**
 * Created by daniel on 27.08.17.
 */
@Mapper
public interface TopCoinsMapper {

    String INSERT_NEW_TOP30 = "INSERT INTO top_30 (name, symbol, rank, market_cap_usd) " +
            "values (#{name} , #{symbol}, #{rank}, #{market_cap_usd})";

    String GET_MOST_RECENT_TOP30 = "SELECT * FROM top_30 ORDER BY entry_id DESC LIMIT 30";

    String ADD_COIN_ID_AND_IMAGE_URL = "UPDATE top_30 SET coin_id = #{coin_id}, image_url = #{image_url} WHERE entry_id = #{entry_id}";

    String SELECT_COIN_SYMBOL = "SELECT name, symbol FROM top_30;";

    @Insert(INSERT_NEW_TOP30)
    public void addNewTop (TopCoins t);

    //This method returns the most recent top30 coins
    //Keep in mind that it returns them in reverse order (i.e rank 30 is first, rank 1 is last item in the list)
    @Select(GET_MOST_RECENT_TOP30)
    public ArrayList<TopCoins> getMostRecentTop ();

    @Update(ADD_COIN_ID_AND_IMAGE_URL)
    public void addCoinIdAndImageUrl (@Param("coin_id")int coin_id, @Param("image_url") String image_url, @Param("entry_id") int entry_id);


    String GET_TOP_COINS = "SELECT symbol, entry_id FROM cryptopeek.top_30";

    String FIND_BY_SYMBOL = "SELECT entry_id FROM cryptopeek.top_30 WHERE symbol = #{symbol}";

    //Taner
    @Select(GET_TOP_COINS)
    ArrayList<TopCoins> getTopCoins();


    @Select(SELECT_COIN_SYMBOL)
    ArrayList<SymbolList> getCoinSymbols();

    //Taner
    @Select(FIND_BY_SYMBOL)
    TopCoins findBySymbol(String symbol);
}
