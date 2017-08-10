package crypto.services;

/**
 * Created by aaron on 8/10/17.
 */

import crypto.model.CryptoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by aaron on 8/8/17.
 */
@Service
public class CryptoService {

    @Autowired
    RestTemplate restTemplate;

    public CryptoModel getCoinSnapshot(String fsym, String tsym) {
        String url = "https://www.cryptocompare.com/api/data/coinsnapshot/?fsym=" + fsym + "&tsym=" + tsym;
        System.out.println(url);
        CryptoModel cryptoModel;
        cryptoModel = restTemplate.getForObject(url, CryptoModel.class);
        System.out.println(url);
        System.out.println(cryptoModel.getResponse().length());
        System.out.println("Cryptoservice running");

        return cryptoModel;
    }
}