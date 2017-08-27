package crypto.rest_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.model.historicalModels.Historical;
import crypto.model.historicalModels.ThirtyDayAverage;
import crypto.services.CryptoHistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aaron on 8/11/17.
 */
@RestController
public class CryptoHistoController {

    @Autowired
    CryptoHistoService cryptoHistoService;

    @RequestMapping("/crypto/historical")
    public Historical get30Records(@RequestParam(value ="fsym")String fsym,
                                   @RequestParam(value ="tsym")String tsym,
                                   @RequestParam(value ="e")String e) throws APIUnavailableException {
        return cryptoHistoService.getDailyHistoricalCryptoData(fsym,tsym,e);
    }

    @RequestMapping("/crypto/historical/30day")
    public ThirtyDayAverage thirtyDayAverage(@RequestParam(value ="fsym")String fsym,
                                             @RequestParam(value ="tsym")String tsym,
                                             @RequestParam(value ="e")String e) throws APIUnavailableException {
        return cryptoHistoService.getThirtyDayMovingAverage(fsym,tsym,e);
    }
}
