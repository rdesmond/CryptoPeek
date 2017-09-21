package crypto.model.miningContracts;

/**
 * Created by tanerali on 23/08/2017.
 */
public class CoinDetails {

    double priceUSD;
    String symbol;
    String difficultyAdjustment;
    String blockRewardReduction;
    long blockNumber;
    int blockTime;
    double netHashesPerSecond;
    long totalCoinsMined;
    int previousTotalCoinsMined;
    double blockReward;

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDifficultyAdjustment() {
        return difficultyAdjustment;
    }

    public void setDifficultyAdjustment(String difficultyAdjustment) {
        this.difficultyAdjustment = difficultyAdjustment;
    }

    public String getBlockRewardReduction() {
        return blockRewardReduction;
    }

    public void setBlockRewardReduction(String blockRewardReduction) {
        this.blockRewardReduction = blockRewardReduction;
    }

    public long getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(long blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(int blockTime) {
        this.blockTime = blockTime;
    }

    public double getNetHashesPerSecond() {
        return netHashesPerSecond;
    }

    public void setNetHashesPerSecond(double netHashesPerSecond) {
        this.netHashesPerSecond = netHashesPerSecond;
    }

    public long getTotalCoinsMined() {
        return totalCoinsMined;
    }

    public void setTotalCoinsMined(long totalCoinsMined) {
        this.totalCoinsMined = totalCoinsMined;
    }

    public int getPreviousTotalCoinsMined() {
        return previousTotalCoinsMined;
    }

    public void setPreviousTotalCoinsMined(int previousTotalCoinsMined) {
        this.previousTotalCoinsMined = previousTotalCoinsMined;
    }

    public double getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(double blockReward) {
        this.blockReward = blockReward;
    }
}
