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
    CryptoCallsMapper cryptoCallsMapper;

    // Author: Nicola
    // This method checks to make sure we have mad no more than 4000 calls within the last hour
    public boolean haveCallsRemaining() throws NullPointerException{

        if (cryptoCallsMapper.getLastCallLastHour() - cryptoCallsMapper.getFirstCallLastHour() <= 4000) {
            return true;
        }else {
            return false;
        }
    }

    // This method logs every call we make or try to make to the cryptoCompare API
    public void logCryptoCalls(String urlRequest, boolean underLimit){

        CryptoCalls cryptoCalls;
        ArrayList<CryptoCalls> responses = new ArrayList<>();

        cryptoCalls = new CryptoCalls();
        cryptoCalls.setUrlRequest(urlRequest);
        cryptoCalls.setUnderLimit(underLimit);
        responses.add(cryptoCalls);

        cryptoCallsMapper.insertCryptoCalls(cryptoCalls);

    }

}
