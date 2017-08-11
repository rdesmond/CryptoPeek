package crypto.model.cryptoCompareModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/8/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    String algorithm; //: "SHA256",
    String proofType; //: "PoW",
    int blockNumber; //: 479694,
    double netHashesPerSecond; //: 6157802778.035059,
    int totalCoinsMined; //: 16496162,
    double blockReward; //: 12.5,
    AggregatedData aggregatedData; //: {},
    Exchanges[] exchanges; //: []


    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public double getNetHashesPerSecond() {
        return netHashesPerSecond;
    }

    public void setNetHashesPerSecond(double netHashesPerSecond) {
        this.netHashesPerSecond = netHashesPerSecond;
    }

    public int getTotalCoinsMined() {
        return totalCoinsMined;
    }

    public void setTotalCoinsMined(int totalCoinsMined) {
        this.totalCoinsMined = totalCoinsMined;
    }

    public double getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(double blockReward) {
        this.blockReward = blockReward;
    }

    public AggregatedData getAggregatedData() {
        return aggregatedData;
    }

    public void setAggregatedData(AggregatedData aggregatedData) {
        this.aggregatedData = aggregatedData;
    }

    public Exchanges[] getExchanges() {
        return exchanges;
    }

    public void setExchanges(Exchanges[] exchanges) {
        this.exchanges = exchanges;
    }
}

