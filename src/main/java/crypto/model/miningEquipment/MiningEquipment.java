package crypto.model.miningEquipment;

/**
 * Created by tanerali on 23/08/2017.
 */
public class MiningEquipment {

    String response;
    String message;
    MiningData miningData;
    CoinData coinData;
    int type;

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

    public MiningData getMiningData() {
        return miningData;
    }

    public void setMiningData(MiningData miningData) {
        this.miningData = miningData;
    }

    public CoinData getCoinData() {
        return coinData;
    }

    public void setCoinData(CoinData coinData) {
        this.coinData = coinData;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}