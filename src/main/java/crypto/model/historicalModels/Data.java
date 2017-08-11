package crypto.model.historicalModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    int time; //: 1486771200,
    double close; //: 11.39,
    double high; //: 11.49,
    double low; //: 11.19,
    double open; //: 11.34,
    double volumefrom; //: 251882.27000000002,
    double volumeto; //: 2856237.07

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

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
}
