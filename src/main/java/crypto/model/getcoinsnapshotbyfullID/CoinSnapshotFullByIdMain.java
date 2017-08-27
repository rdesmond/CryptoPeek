package crypto.model.getcoinsnapshotbyfullID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/23/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinSnapshotFullByIdMain {

    String response; //: "Success",
    String message; //: "Coin full snapshot successfully returned",
    Data data; //: {},
    int type; //: 100

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
