package crypto.model.topCoins;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by daniel on 26.08.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopCoins {
    String name;
    String symbol;
    int rank;
    double market_cap_usd;
    int entry_id;
    int coin_id;

    public int getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(int entry_id) {
        this.entry_id = entry_id;
    }

    public int getCoin_id() {
        return coin_id;
    }

    public void setCoin_id(int coin_id) {
        this.coin_id = coin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = Integer.parseInt(rank);
    }

    public double getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd = Double.parseDouble(market_cap_usd);
    }
}
