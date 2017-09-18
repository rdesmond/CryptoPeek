package crypto.model.tablePOJOs;

/**
 * Created by tanerali on 27/08/2017.
 */

/*
The following can be used if using Hibernate for backloading historical data.
For now myBatis is used for inserting HistoDataDB objects into DB

@Entity
@Table(name = "raw_histo_minute")
@Table(name = "raw_histo_hour")
@Table(name = "raw_histo_day")
*/

public class HistoDataDB {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)

    int id;
    long time;
    double open;
    double close;
    double percent_change;
    double low;
    double high;
    double volumefrom;
    double volumeto;
    int coin_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getPercent_change() {
        return percent_change;
    }

    public void setPercent_change(double percent_change) {
        this.percent_change = percent_change;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
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

    public int getCoin_id() {
        return coin_id;
    }

    public void setCoin_id(int coin_id) {
        this.coin_id = coin_id;
    }
}
