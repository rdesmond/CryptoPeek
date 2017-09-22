package crypto.model.arbitrageModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by aaron on 9/8/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArbitrageModel {

    String name;
    String symbol;
    Double differencein$USD;
    String highExchangeName;
    String highExchangePrice;
    String lowExchangeName;
    String lowExchangePrice;

    public Double getDifferencein$USD() {
//        DecimalFormat df = new DecimalFormat("#.############");
//        df.setRoundingMode(RoundingMode.CEILING);
//        System.out.println("get difference "+df.format(difference));
//        return Double.parseDouble(df.format(difference));
        return differencein$USD;
    }

    public void setDifferencein$USD(Double differencein$USD) {
        this.differencein$USD = Math.round(differencein$USD*100.0)/100.0;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHighExchangeName() {
        return highExchangeName;
    }

    public void setHighExchangeName(String highExchangeName) {
        this.highExchangeName = highExchangeName;
    }

    public String getHighExchangePrice() {
        return highExchangePrice;
    }

    public void setHighExchangePrice(String highExchangePrice) {
        this.highExchangePrice = highExchangePrice;
    }

    public String getLowExchangeName() {
        return lowExchangeName;
    }

    public void setLowExchangeName(String lowExchangeName) {
        this.lowExchangeName = lowExchangeName;
    }

    public String getLowExchangePrice() {
        return lowExchangePrice;
    }

    public void setLowExchangePrice(String lowExchangePrice) {
        this.lowExchangePrice = lowExchangePrice;
    }
}
