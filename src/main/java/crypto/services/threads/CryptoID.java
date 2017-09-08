package crypto.services.threads;

import crypto.mappers.CoinsMapper;
import crypto.mappers.TopCoinsMapper;
import crypto.model.topCoins.TopCoins;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by daniel on 05.09.17.
 */
public class CryptoID implements Runnable {

    @Autowired
    TopCoinsMapper topCoinsMapper;

    @Autowired
    CoinsMapper coinsMapper;

    public void run() {
        ArrayList<TopCoins> t = topCoinsMapper.getMostRecentTop();
        for (int i=0; i<t.size(); i++){
            //TODO: we need the CoinList for this!!!
            //this will populate each of the top30 coins with their CryptoCompare IDs.
            String symbol = t.get(i).getSymbol();
            String coin_id = coinsMapper.getCoinId(symbol);
            topCoinsMapper.addCoinId(coin_id, symbol);
        }
    }
}
