package crypto.rest_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.model.historicalModels.HistoDay;
import crypto.model.historicalModels.HistoHour;
import crypto.model.historicalModels.HistoMinute;
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


//    @RequestMapping("/api/historical")
//    public Historical get30Records(@RequestParam(value ="fsym")String fsym,
//                                   @RequestParam(value ="tsym")String tsym,
//                                   @RequestParam(value ="e")String e) throws APIUnavailableException {
//        return cryptoHistoService.getHistoricalCryptoData(fsym,tsym,e);
//    }


    @RequestMapping("/api/historical/daily")
    public HistoDay getHistoDaily(@RequestParam(value ="fsym")String fsym,
                                  @RequestParam(value ="tsym")String tsym,
                                  @RequestParam(value ="e")String e) throws APIUnavailableException {
        return cryptoHistoService.getHistoricalDailyData(fsym,tsym,e);
    }

    @RequestMapping("/api/historical/hourly")
    public HistoHour getHistoHourly(@RequestParam(value ="fsym")String fsym,
                                    @RequestParam(value ="tsym")String tsym,
                                    @RequestParam(value ="e")String e) throws APIUnavailableException {
        return cryptoHistoService.getHistoricalHourlyData(fsym,tsym,e);
    }

    @RequestMapping("/api/historical/minutely")
    public HistoMinute getHistoMinutely(@RequestParam(value ="fsym")String fsym,
                                        @RequestParam(value ="tsym")String tsym,
                                        @RequestParam(value ="e")String e) throws APIUnavailableException {
        return cryptoHistoService.getHistoricalMinutelyData(fsym,tsym,e);
    }




    @RequestMapping("/api/historical/30day")
    public ThirtyDayAverage thirtyDayAverage(@RequestParam(value ="fsym")String fsym,
                                             @RequestParam(value ="tsym")String tsym,
                                             @RequestParam(value ="e")String e) throws APIUnavailableException {
        return cryptoHistoService.getThirtyDayMovingAverage(fsym,tsym,e);
    }
}
