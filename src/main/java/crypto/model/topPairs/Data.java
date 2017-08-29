package crypto.model.topPairs;

/**
 * Created by tanerali on 23/08/2017.
 */
public class Data {

    String exchange;
    String fromSymbol;
    String toSymbol;
    double volume24h;
    double volume24hTo;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getFromSymbol() {
        return fromSymbol;
    }

    public void setFromSymbol(String fromSymbol) {
        this.fromSymbol = fromSymbol;
    }

    public String getToSymbol() {
        return toSymbol;
    }

    public void setToSymbol(String toSymbol) {
        this.toSymbol = toSymbol;
    }

    public double getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(double volume24h) {
        this.volume24h = volume24h;
    }

    public double getVolume24hTo() {
        return volume24hTo;
    }

    public void setVolume24hTo(double volume24hTo) {
        this.volume24hTo = volume24hTo;
    }
}
