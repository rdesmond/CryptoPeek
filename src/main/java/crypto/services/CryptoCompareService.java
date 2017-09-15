package crypto.services;

import crypto.model.cryptoCompareModels.CryptoCompare;
import crypto.util.CryptoCallsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoCompareService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CryptoCallsUtil cryptoCallsUtil;

    /**
     *
     * @param url of the API call that you are making ie. https://min-api.cryptocompare.com/...
     * @param returnType name if model you are using
     * @return your call will run if there are calls to the API left if not your attempt will be logged but the
     * call will not be run.
     */
    // Author: Nicola
    public CryptoCompare callCryptoCompareAPI(String url, CryptoCompare returnType){
        boolean callsRemaining = cryptoCallsUtil.haveCallsRemaining();

        // Checks the database to see if we have hit the 4000 calls per hour limit and if there are call remaining
        // it will run the requested call.
        if(callsRemaining) {

            // Using the restTemplate to make the api call to CryptoCompare
            CryptoCompare cc = restTemplate.getForObject(url, returnType.getClass());

            // Loggs the call to the DB
            cryptoCallsUtil.logCryptoCalls(url, callsRemaining);
            return cc;

        }else {

            // If the 4000 call limit has been reached this logs the attempt and does not make the requested call.
            cryptoCallsUtil.logCryptoCalls(url, callsRemaining);
            return null;
        }
    }
}
