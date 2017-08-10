package crypto.model;

/**
 * Created by aaron on 8/10/17.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/8/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AggregatedData {

    String type; //: "5",
    String market; //: "CCCAGG",
    String fromsymbol; //: "BTC",
    String tosymbol; //: "USD",
    String flags; //: "1",
    String price; //: "3359.71",
    String lastupdate; //: "1502208902",
    String lastvolume; //: "0.00022521",
    String lastvolumeto; //: "0.74274788",
    String lasttradeid; //: "17080515",
    String volume24hour; //: "105056.82282044677",
    String volume24hourto; //: "358315533.41489124",
    String open24hour; //: "3389.44",
    String high24hour; //: "3498.92",
    String low24hour; //: "3329.97",
    String lastmarket; //: "Exmo"

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
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

    public String getLasttradeid() {
        return lasttradeid;
    }

    public void setLasttradeid(String lasttradeid) {
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
}
