package crypto.model.cryptoVolumeModel;

/**
 * Created by aaron on 9/20/17.
 */
public class CryptoVolume {

    String symbol;
    String to_currency;
    Double total_volume;
    Double total_value;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTo_currency() {
        return to_currency;
    }

    public void setTo_currency(String to_currency) {
        this.to_currency = to_currency;
    }

    public Double getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(Double total_volume) {
        this.total_volume = Math.round(total_volume*100.00)/100.00;//Math.round(differencein$USD*100.0)/100.0
    }

    public Double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Double total_value) {
        this.total_value = Math.round(total_value*100.00)/100.00;
    }
}
