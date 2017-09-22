package crypto.model.topPairs;

import crypto.model.cryptoCompareModels.CryptoCompare;

/**
 * Created by tanerali on 23/08/2017.
 */
public class TopPairs extends CryptoCompare{

    String response;
    Data[] data;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
