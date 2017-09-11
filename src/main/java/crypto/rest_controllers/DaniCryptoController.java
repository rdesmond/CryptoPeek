package crypto.rest_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.exceptions.ExchangeNotFoundException;
import crypto.model.coinList.Coins;
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

    @RequestMapping("/api/top30")
    public TopCoins[] getTopCoins() throws ExchangeNotFoundException {
        return cryptoService.getTop30();
    }

    @RequestMapping("/api/allcoins")
    public Coins getAllCoins() throws APIUnavailableException {
        return cryptoService.getAllCoins();
    }
}
