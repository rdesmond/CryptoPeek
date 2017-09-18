package crypto.mappers;

import crypto.model.arbitrageModels.ArbitrageModel;
import crypto.model.arbitrageModels.ArbitrageStatsForDbInsert;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by aaron on 9/14/17.
 */
@Mapper
public interface ArbitrageMapper {

    String INSERT_ARBITRAGE_STATS = "INSERT INTO cryptopeek.arbitrage_stats (symbol, difference_in_USD, " +
            "high_exchange_name, high_exchange_price, low_exchange_name, low_exchange_price) VALUES " +
            "(#{symbol}, #{differencein$USD}, #{highExchangeName}, #{highExchangePrice}, #{lowExchangeName}, " +
            "#{lowExchangePrice})";

    @Insert(INSERT_ARBITRAGE_STATS)
    public void addArbitrageStatsToDb(ArbitrageModel arbitrageModel);
}
