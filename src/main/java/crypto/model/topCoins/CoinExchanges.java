package crypto.model.topCoins;

/**
 * Created by daniel on 14.09.17.
 */
//This object contains the name of a coin and its price in all 5 exchanges.
public class CoinExchanges {

    String coin_name;
    double coinbase;
    double bitfinex;
    double bittrex;
    double poloniex;
    double kraken;

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public double getCoinbase() {
        return coinbase;
    }

    public void setCoinbase(double coinbase) {
        this.coinbase = coinbase;
    }

    public double getBitfinex() {
        return bitfinex;
    }

    public void setBitfinex(double bitfinex) {
        this.bitfinex = bitfinex;
    }

    public double getBittrex() {
        return bittrex;
    }

    public void setBittrex(double bittrex) {
        this.bittrex = bittrex;
    }

    public double getPoloniex() {
        return poloniex;
    }

    public void setPoloniex(double poloniex) {
        this.poloniex = poloniex;
    }

    public double getKraken() {
        return kraken;
    }

    public void setKraken(double kraken) {
        this.kraken = kraken;
    }

    public void exchangeMissing(CoinExchanges e) {
        e.setKraken(0);
        e.setPoloniex(0);
        e.setBittrex(0);
        e.setBitfinex(0);
        e.setCoinbase(0);
    }
}
