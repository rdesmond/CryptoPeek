package crypto.model.socialStatsModels;

/**
 * Created by aaron on 8/26/17.
 */
public class SocialStatsCoins {

    String symbol;
    String coin_name;
    int coin_id;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public int getCoin_id() {
        return coin_id;
    }

    public void setCoin_id(int coin_id) {
        this.coin_id = coin_id;
    }
}
