package crypto.model.cryptoCompareModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Raw {

    String market;
    String fromsymbol;
    String tosymbol;
    double flags;
    double price;
    long lastupdate;
    double lastvolume;
    double lastvolumeto;
    long lasttradeid;
    double volume24hour;
    double volume24hourto;
    double open24hour;
    double high24hour;
    double low24hour;
    String lastmarket;
    double change24hour;
    double changepct24hour;

    public Raw() {
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getFromsymbol() {
        return fromsymbol;
    }

    public void setFromsymbol(String fromsymbol) {
        this.fromsymbol = fromsymbol;
    }

    public String getTosymbol() {
        return tosymbol;
    }

    public void setTosymbol(String tosymbol) {
        this.tosymbol = tosymbol;
    }

    public double getFlags() {
        return flags;
    }

    public void setFlags(double flags) {
        this.flags = flags;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(long lastupdate) {
        this.lastupdate = lastupdate;
    }

    public double getLastvolume() {
        return lastvolume;
    }

    public void setLastvolume(double lastvolume) {
        this.lastvolume = lastvolume;
    }

    public double getLastvolumeto() {
        return lastvolumeto;
    }

    public void setLastvolumeto(double lastvolumeto) {
        this.lastvolumeto = lastvolumeto;
    }

    public long getLasttradeid() {
        return lasttradeid;
    }

    public void setLasttradeid(long lasttradeid) {
        this.lasttradeid = lasttradeid;
    }

    public double getVolume24hour() {
        return volume24hour;
    }

    public void setVolume24hour(double volume24hour) {
        this.volume24hour = volume24hour;
    }

    public double getVolume24hourto() {
        return volume24hourto;
    }

    public void setVolume24hourto(double volume24hourto) {
        this.volume24hourto = volume24hourto;
    }

    public double getOpen24hour() {
        return open24hour;
    }

    public void setOpen24hour(double open24hour) {
        this.open24hour = open24hour;
    }

    public double getHigh24hour() {
        return high24hour;
    }

    public void setHigh24hour(double high24hour) {
        this.high24hour = high24hour;
    }

    public double getLow24hour() {
        return low24hour;
    }

    public void setLow24hour(double low24hour) {
        this.low24hour = low24hour;
    }

    public String getLastmarket() {
        return lastmarket;
    }

    public void setLastmarket(String lastmarket) {
        this.lastmarket = lastmarket;
    }

    public double getChange24hour() {
        return change24hour;
    }

    public void setChange24hour(double change24hour) {
        this.change24hour = change24hour;
    }

    public double getChangepct24hour() {
        return changepct24hour;
    }

    public void setChangepct24hour(double changepct24hour) {
        this.changepct24hour = changepct24hour;
    }
}
