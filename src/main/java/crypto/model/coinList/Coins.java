package crypto.model.coinList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coins {

    String Response; //"Success",
    String Message; //"CoinPojo list succesfully returned!",
    String BaseImageUrl; //"https://www.cryptocompare.com",
    String BaseLinkUrl; //"https://www.cryptocompare.com",
    Data Data; //;
    int Type; //100

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getBaseImageUrl() {
        return BaseImageUrl;
    }

    public void setBaseImageUrl(String baseImageUrl) {
        BaseImageUrl = baseImageUrl;
    }

    public String getBaseLinkUrl() {
        return BaseLinkUrl;
    }

    public void setBaseLinkUrl(String baseLinkUrl) {
        BaseLinkUrl = baseLinkUrl;
    }

    public Data getData() {
        return Data;
    }

    public void setData(Data data) {
        this.Data = data;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

}