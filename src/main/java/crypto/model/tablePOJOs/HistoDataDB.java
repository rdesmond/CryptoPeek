package crypto.model.tablePOJOs;


import javax.persistence.*;

/**
 * Created by tanerali on 27/08/2017.
 */
@Entity
@Table(name = "raw_histo_minute")
public class HistoDataDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String time;
    double close;
    double high;
    double low;
    double open;
    double volumefrom;
    double volumeto;

    //method that takes the results from the Data field from the histo API response
    //and then puts them into an array of HistoDataDB objects that can be inserted into the database;
    //time is modified from int to String with the utility method secondsToSpecificTime()
//    public static HistoDataDB[] convertToHistoDataDB (Data[] data) {
//        HistoDataDB[] histoDataDBs = new HistoDataDB[data.length];
//
//        for (int i =0; i < data.length; i++) {
//            histoDataDBs[i].setTime( DateUnix.secondsToSpecificTime( data[i].getTime() ) );
//            histoDataDBs[i].setClose( data[i].getClose() );
//            histoDataDBs[i].setHigh( data[i].getHigh() );
//            histoDataDBs[i].setLow( data[i].getLow() );
//            histoDataDBs[i].setOpen( data[i].getOpen() );
//            histoDataDBs[i].setVolumefrom( data[i].getVolumefrom() );
//            histoDataDBs[i].setVolumeto( data[i].getVolumeto() );
//        }
//
//        return histoDataDBs;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
