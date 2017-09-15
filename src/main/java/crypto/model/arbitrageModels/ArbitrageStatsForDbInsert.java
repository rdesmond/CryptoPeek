package crypto.model.arbitrageModels;

import crypto.util.DateUnix;

/**
 * Created by aaron on 9/14/17.
 */
public class ArbitrageStatsForDbInsert {

    //String name;
    String symbol;
    double differencein$USD;
    String highExchangeName;
    String highExchangePrice;
    String lowExchangeName;
    String lowExchangePrice;
    String time;

    public ArbitrageStatsForDbInsert(ArbitrageModel arbitrageModel){
        //this.name = arbitrageModel.getName();
        this.symbol = arbitrageModel.getSymbol();
        this.differencein$USD = arbitrageModel.getDifferencein$USD();
        this.highExchangeName = arbitrageModel.getHighExchangeName();
        this.highExchangePrice = arbitrageModel.getHighExchangePrice();
        this.lowExchangeName = arbitrageModel.getLowExchangeName();
        this.lowExchangePrice = arbitrageModel.getLowExchangePrice();
        this.time = DateUnix.currentTimeToString();
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getDifferencein$USD() {
        return differencein$USD;
    }

    public void setDifferencein$USD(double differencein$USD) {
        this.differencein$USD = differencein$USD;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
