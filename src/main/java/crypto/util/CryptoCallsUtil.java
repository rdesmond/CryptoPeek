package crypto.util;

import crypto.mappers.CryptoCallsMapper;
import crypto.model.cryptoCompareModels.CryptoCalls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Author: Nicola
 */
@Component
public class CryptoCallsUtil {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CryptoCallsMapper cryptoCallsMapper;

    // Author: Nicola
    public boolean getCurrentCalls() throws NullPointerException{

        try {
            if (cryptoCallsMapper.getLastCallLastHour() - cryptoCallsMapper.getFirstCallLastHour() <= 4000) {
                return true;
            }
        }catch (NullPointerException e){
            return true;
        }
        return true;
    }
    public ArrayList<CryptoCalls> logCryptoCalls(String urlRequest){

        CryptoCalls cryptoCalls;
        ArrayList<CryptoCalls> responses = new ArrayList<>();
        if (getCurrentCalls()) {

            cryptoCalls = new CryptoCalls();
            cryptoCalls.setUnderLimit(true);
            responses.add(cryptoCalls);

        }else {
            cryptoCalls = new CryptoCalls();
            cryptoCalls.setUnderLimit(false);
            responses.add(cryptoCalls);
        }

        cryptoCalls = new CryptoCalls();
        cryptoCalls.setUrlRequest(urlRequest);
        responses.add(cryptoCalls);

        cryptoCallsMapper.insertCryptoCalls(cryptoCalls);

        return responses;
    }

}
