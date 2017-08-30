package crypto.model.cryptoCompareModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Display {

    String fromsymbol;
    String tosymbol;
    String market;
    String price;
    String lastupdate;
    String lastvolume;
    String lastvolumeto;
    long lasttradeid;
    String volume24hour;
    String volume24hourto;
    String open24hour;
    String high24hour;
    String low24hour;
    String lastmarket;
    String change24hour;
    String changepct24hour;

    public Display() {
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

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getLastvolume() {
        return lastvolume;
    }

    public void setLastvolume(String lastvolume) {
        this.lastvolume = lastvolume;
    }

    public String getLastvolumeto() {
        return lastvolumeto;
    }

    public void setLastvolumeto(String lastvolumeto) {
        this.lastvolumeto = lastvolumeto;
    }

    public long getLasttradeid() {
        return lasttradeid;
    }

    public void setLasttradeid(long lasttradeid) {
        this.lasttradeid = lasttradeid;
    }

    public String getVolume24hour() {
        return volume24hour;
    }

    public void setVolume24hour(String volume24hour) {
        this.volume24hour = volume24hour;
    }

    public String getVolume24hourto() {
        return volume24hourto;
    }

    public void setVolume24hourto(String volume24hourto) {
        this.volume24hourto = volume24hourto;
    }

    public String getOpen24hour() {
        return open24hour;
    }

    public void setOpen24hour(String open24hour) {
        this.open24hour = open24hour;
    }

    public String getHigh24hour() {
        return high24hour;
    }

    public void setHigh24hour(String high24hour) {
        this.high24hour = high24hour;
    }

    public String getLow24hour() {
        return low24hour;
    }

    public void setLow24hour(String low24hour) {
        this.low24hour = low24hour;
    }

    public String getLastmarket() {
        return lastmarket;
    }

    public void setLastmarket(String lastmarket) {
        this.lastmarket = lastmarket;
    }

    public String getChange24hour() {
        return change24hour;
    }

    public void setChange24hour(String change24hour) {
        this.change24hour = change24hour;
    }

    public String getChangepct24hour() {
        return changepct24hour;
    }

    public void setChangepct24hour(String changepct24hour) {
        this.changepct24hour = changepct24hour;
    }
}
