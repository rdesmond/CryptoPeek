package crypto.rest_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.model.miningContracts.MiningContracts;
import crypto.model.miningEquipment.MiningEquipment;
import crypto.model.topPairs.TopPairs;
import crypto.services.BackloadHistoDataService;
import crypto.services.CryptoService;
import crypto.services.EmailSendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanerali on 24/08/2017.
 */
@RequestMapping("/api")
@RestController
public class TanerCryptoController {

    @Autowired
    CryptoService cryptoService;

    @Autowired
    BackloadHistoDataService backloadHistoDataService;

    @Autowired
    EmailSendingService emailSendingService;

    @RequestMapping("/top/pairs")
    public TopPairs getTopPairs (@RequestParam(value="fsym")String fsym,
                                 @RequestParam(value="tsym", required = false)String tsym,
                                 @RequestParam(value="limit", required = false)Integer limit,
                                 @RequestParam(value="sign", required = false)boolean sign)
            throws APIUnavailableException {

        return cryptoService.getTopPairs(fsym, tsym, limit, sign);
    }

    @RequestMapping("/mining/contracts")
    public MiningContracts getMiningContracts ()
            throws APIUnavailableException {

        return cryptoService.getMiningContracts();
    }

    @RequestMapping("/mining/equipment")
    public MiningEquipment getMiningEquipment ()
            throws APIUnavailableException {

        return cryptoService.getMiningEquipment();
    }

    @RequestMapping("/backload/data")
    public void backloadHistoData (@RequestParam(value="fsym")String fsym,
                                   @RequestParam(value="tsym")String tsym,
                                   @RequestParam(value="exchange")String exchange)
            throws APIUnavailableException {

        backloadHistoDataService.backloadHistoricalData(fsym, tsym, exchange);

    }

}
