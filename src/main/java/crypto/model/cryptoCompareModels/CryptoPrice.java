package crypto.model.cryptoCompareModels;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CryptoPrice {

    String response;
    String message;
    int type;
    boolean aggregated;
    Data data;
    double btc;
    double coin1;

    public CryptoPrice() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isAggregated() {
        return aggregated;
    }

    public void setAggregated(boolean aggregated) {
        this.aggregated = aggregated;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public double getBtc() {
        return btc;
    }

    public void setBtc(double btc) {
        this.btc = btc;
    }

    public double getCoin1() {
        return coin1;
    }

    public void setCoin1(double coin1) {
        this.coin1 = coin1;
    }
}
