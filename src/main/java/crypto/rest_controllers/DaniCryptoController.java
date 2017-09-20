package crypto.rest_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.exceptions.ExchangeNotFoundException;
import crypto.model.coinList.Coins;
import crypto.model.topCoins.CoinExchanges;
import crypto.model.topCoins.TopCoins;
import crypto.services.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daniel on 27.08.17.
 */
@RestController
public class DaniCryptoController {

    @Autowired
    CryptoService cryptoService;

    //gets the current top 30 coins from CoinMarketCap and populates it to the database
    @RequestMapping("/api/top30")
    public TopCoins[] getTopCoins() throws ExchangeNotFoundException {
        return cryptoService.getTop30();
    }

    //populates all coins in database
    @RequestMapping("/api/allcoins")
    public Coins getAllCoins() throws APIUnavailableException {
        return cryptoService.getAllCoins();
    }

    //gets the exchange prices of our top30 coins
    @RequestMapping("/api/allcoinsallexchanges")
    public CoinExchanges[] getAllCoinsAllExchanges() throws APIUnavailableException {
        return cryptoService.getAllCoinsAllExchanges();
    }
}
