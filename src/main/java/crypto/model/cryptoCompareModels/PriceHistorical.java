package crypto.model.cryptoCompareModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PriceHistorical extends CryptoCompare{

    BTC btc;
    String response;
    String message;
    int type;
    boolean aggregated;
    Data data;
    String Warning;
    boolean hasWarning;

    public String getWarning() {
        return Warning;
    }

    public void setWarning(String warning) {
        Warning = warning;
    }

    public boolean isHasWarning() {
        return hasWarning;
    }

    public void setHasWarning(boolean hasWarning) {
        this.hasWarning = hasWarning;
    }

    public BTC getBtc() {
        return btc;
    }

    public void setBtc(BTC btc) {
        this.btc = btc;
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
}
