package crypto.model.topCoins;

/**
 * Created by daniel on 14.09.17.
 */
//This object contains the name of a coin and its price in all 5 exchanges.
public class CoinExchanges {

    String coin_name;
    String Kraken;
    String Poloniex;
    String Bittrex;
    String Bitfinex;
    String Coinbase;
    String image_url;

    public CoinExchanges() {
        Kraken="";
        Poloniex="";
        Bitfinex="";
        Bittrex="";
        Coinbase="";
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public String getKraken() {
        return Kraken;
    }

    public void setKraken(String kraken) {
        Kraken = kraken;
    }

    public String getPoloniex() {
        return Poloniex;
    }

    public void setPoloniex(String poloniex) {
        Poloniex = poloniex;
    }

    public String getBittrex() {
        return Bittrex;
    }

    public void setBittrex(String bittrex) {
        Bittrex = bittrex;
    }

    public String getBitfinex() {
        return Bitfinex;
    }

    public void setBitfinex(String bitfinex) {
        Bitfinex = bitfinex;
    }

    public String getCoinbase() {
        return Coinbase;
    }

    public void setCoinbase(String coinbase) {
        Coinbase = coinbase;
    }

}
