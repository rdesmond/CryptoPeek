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

    public CryptoCompare callCryptoCompareAPI(String url, CryptoCompare returnType){
        boolean callsRemaining = cryptoCallsUtil.haveCallsRemaining();
        if(callsRemaining) {
            CryptoCompare cc = restTemplate.getForObject(url, returnType.getClass());
            cryptoCallsUtil.logCryptoCalls(url, callsRemaining);
            return cc;
        }else {
            cryptoCallsUtil.logCryptoCalls(url, callsRemaining);
            return null;
        }
    }
}
