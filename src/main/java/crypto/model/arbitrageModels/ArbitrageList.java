package crypto.model.arbitrageModels;

/**
 * Created by aaron on 9/11/17.
 */
public class ArbitrageList {

    String difference;

    public ArbitrageList(String difference) {
        this.difference = difference;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }
}
