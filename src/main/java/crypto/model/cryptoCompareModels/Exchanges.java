package crypto.model.cryptoCompareModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

 /**
 * Created by aaron on 8/8/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Exchanges {

    String type; //: "2",
    String market; //: "Cexio",
    String fromsymbol; //: "BTC",
    String tosymbol; //: "USD",
    String flags; //: "1",
    String price; //: "3411.0572",
    String lastupdate; //: "1502208866",
    String lastvolume; //: "0.012",
    String lastvolumeto; //: "40.9326864",
    String lasttradeid; //: "2799686",
    String volume24hour; //: "978.9186601000001",
    String volume24hourto; //: "3387137.435645728",
    String open24hour; //: "3404.3482",
    String high24hour; //: "3549.0544",
    String low24hour; //: "3365.0001"


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
}
