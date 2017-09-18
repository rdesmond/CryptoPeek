package crypto.rest_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.model.miningContracts.MiningContracts;
import crypto.model.miningEquipment.MiningEquipment;
import crypto.model.topPairs.TopPairs;
import crypto.repository.EmailMessageRepository;
import crypto.services.BackloadHistoDataService;
import crypto.services.CryptoService;
import crypto.services.EmailSendingService;
import crypto.services.PriceChangeService;
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

    @Autowired
    EmailMessageRepository emailMessageRepository;

    @Autowired
    PriceChangeService priceChangeService;

    //straight-through API call to TopPairs at CryptoCompare
    @RequestMapping("/top/pairs")
    public TopPairs getTopPairs (@RequestParam(value="fsym")String fsym,
                                 @RequestParam(value="tsym", required = false)String tsym,
                                 @RequestParam(value="limit", required = false)Integer limit,
                                 @RequestParam(value="sign", required = false)boolean sign)
            throws APIUnavailableException {

        return cryptoService.getTopPairs(fsym, tsym, limit, sign);
    }

    //straight-through API call to MiningContracts at CryptoCompare
    @RequestMapping("/mining/contracts")
    public MiningContracts getMiningContracts ()
            throws APIUnavailableException {

        return cryptoService.getMiningContracts();
    }

    //straight-through API call to MiningEquipment at CryptoCompare
    @RequestMapping("/mining/equipment")
    public MiningEquipment getMiningEquipment ()
            throws APIUnavailableException {

        return cryptoService.getMiningEquipment();
    }

//    //backloads all available minutely, hourly and daily historical data from
//    //CryptoCompare to database
//    @RequestMapping("/backload/alldata")
//    public void backloadHistoData (@RequestParam(value="tsym")String tsym,
//                                   @RequestParam(value="exchange")String exchange)
//            throws APIUnavailableException {
//
//        //fsym should be going to DB and getting the top 30 coins' coin_ids
//
//        backloadHistoDataService.backloadHistoricalData(tsym, exchange);
//    }

    //backloads previously (in the past) missing minutely, hourly and/or daily historical
    //data from CryptoCompare to database;
    //Taner
    @RequestMapping("/backload")
    public void backloadPreviouslyMissingHistoData() throws APIUnavailableException {

        backloadHistoDataService.backloadPreviouslyMissingHistoData();
    }

    //Taner
    @RequestMapping("/backload/missing")
    public void backloadMissingHistoData()

            throws APIUnavailableException {

        backloadHistoDataService.backloadRecentHistoData();
    }

    //used for sending email
    //Taner
    @RequestMapping("/sendemail")
    public void sendEmail (@RequestParam(value="toAddress")String toAddress)
            throws Exception {

        emailSendingService.sendEmail(toAddress, emailMessageRepository.findBySubject("BTC price alert"));
    }

    //Taner
    @RequestMapping("/pricechange")
    public void priceChange() {
        priceChangeService.topMovers();
    }

}
