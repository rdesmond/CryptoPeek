package crypto.model.historicalModels;

public class PersistHistoMinute {

    double close;
    double high;
    double low;
    double open;
    int time;
    double volumefrom;
    double volumeto;
    int coinId;
    String coinSymbol;

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getVolumefrom() {
        return volumefrom;
    }

    public void setVolumefrom(double volumefrom) {
        this.volumefrom = volumefrom;
    }

    public double getVolumeto() {
        return volumeto;
    }

    public void setVolumeto(double volumeto) {
        this.volumeto = volumeto;
    }

    public int getCoinId() {
        return coinId;
    }

    public void setCoinId(int coinId) {
        this.coinId = coinId;
    }

    public String getCoinSymbol() {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol) {
        this.coinSymbol = coinSymbol;
    }
}
