package crypto.services.threads;

import crypto.mappers.CoinsMapper;
import crypto.mappers.TopCoinsMapper;
import crypto.model.topCoins.TopCoins;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by daniel on 05.09.17.
 */
@Service
public class CryptoID implements Runnable {

    @Autowired
    TopCoinsMapper topCoinsMapper;

    @Autowired
    CoinsMapper coinsMapper;

    //This thread populates the newly added top30 coins in the
    // database with their appropriate coin_ids from CryptoCompare

    public void run() {
        //get the most recent top 30 (the ones just inserted in the DB from the calling method)
        ArrayList<TopCoins> tc = topCoinsMapper.getMostRecentTop();
        for (int i=0; i<tc.size(); i++){
            //For each element in array get the symbol, name, and entry id
            String symbol = tc.get(i).getSymbol();
            String name = tc.get(i).getName();
            int entry_id = tc.get(i).getEntry_id();
            System.out.println(name);

            //If symbol is not found in the coins DB a BindingException is thrown
            try {
                int coin_id = coinsMapper.getCoinIdBySymbol(symbol);
                String image_url = "https://www.cryptocompare.com"+coinsMapper.getImageUrlBySymbol(symbol);
                topCoinsMapper.addCoinIdAndImageUrl(coin_id, image_url, entry_id);

            } catch (BindingException e) {
                //if coin symbol is not found in DB try searching by coin name
                //I put this here because the coin symbols sometimes differ between CoinMarketCap and CryptoCompare
                try {
                    int coin_id = coinsMapper.getCoinIdByName(name);
                    String image_url = "https://www.cryptocompare.com"+coinsMapper.getImageUrlByName(name);
                    topCoinsMapper.addCoinIdAndImageUrl(coin_id, image_url, entry_id);
                    //If coin name is not found as well, print exception and continue,
                    //thus leaving coin_id as 'null' in the top30 table
                } catch (BindingException b) {
                    b.printStackTrace();
                    System.out.println("Top30 coin not found in Coins database.");
                    continue;
                }
            }
        }
    }
}
