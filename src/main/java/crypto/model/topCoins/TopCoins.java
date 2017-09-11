package crypto.model.topCoins;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by daniel on 26.08.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopCoins {
    String id;
    String name;
    String symbol;
    int rank;
    double price_usd;
    double price_btc;
    double market_cap_usd;
    double percent_change_1h;
    double percent_change_24h;
    double percent_change_7d;
    String last_updated;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd = Double.parseDouble(price_usd);
    }

    public double getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(String price_btc) {
        this.price_btc = Double.parseDouble(price_btc);
    }

    public double getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd = Double.parseDouble(market_cap_usd);
    }

    public double getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(String percent_change_1h) {
        this.percent_change_1h = Double.parseDouble(percent_change_1h);
    }

    public double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(String percent_change_24h) {
        this.percent_change_24h = Double.parseDouble(percent_change_24h);
    }

    public double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(String percent_change_7d) {
        this.percent_change_7d = Double.parseDouble(percent_change_7d);
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
