package crypto.services;

import crypto.model.tablePOJOs.HistoDataDB;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by tanerali on 11/09/2017.
 */

public class PricePredictionService {

    @Autowired
    PriceChangeService priceChangeService;

    public double momentumBased() {
        /*
        if the price has seen strong movement in a particular direction,
        it is the job of this method to predict whether the movement will
        continue and for how long before there is a reversal
        */

        ArrayList<HistoDataDB> histoDataDBArrayList = priceChangeService.topMinutelyMovers();

        

        return 0.0;
    }

    public double reversionBased() {
        /*
        this method has to predict when there is going to be a reversal
        in a given price movement
        */
        return 0.0;
    }

    public double valueBased() {
        /*
        gives points to a coin based on historical price levels;
        if it finds the current price to be undervaluing the coin, gives it
        very high points and vice versa; the purpose is to find
        undervalued/overvalued coins based on how far away their current price
        is from historical price levels
         */
        return 0.0;
    }

}
