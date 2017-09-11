package crypto.rest_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.model.miningContracts.MiningContracts;
import crypto.model.miningEquipment.MiningEquipment;
import crypto.model.topCoins.TopCoins;
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

import java.util.ArrayList;

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

    //backloads all available minutely, hourly and daily historical data from
    //CryptoCompare to database
    @RequestMapping("/backload/alldata")
    public void backloadHistoData (@RequestParam(value="fsym")String fsym,
                                   @RequestParam(value="tsym")String tsym,
                                   @RequestParam(value="exchange")String exchange)
            throws APIUnavailableException {

        //fsym should be going to DB and getting the top 30 coins' coin_ids

        backloadHistoDataService.backloadHistoricalData(tsym, exchange);
    }

    //backloads specified minutely, hourly and/or daily historical data from
    //CryptoCompare to database
    @RequestMapping("/backload")
    public void backloadSpecificMinutesHistoData
            (@RequestParam(value="fsym")String fsym,
             @RequestParam(value="tsym")String tsym,
             @RequestParam(value="exchange")String exchange,
             @RequestParam(value="minutes", required = false, defaultValue = "0")int minutes,
             @RequestParam(value="hours", required = false, defaultValue = "0")int hours,
             @RequestParam(value="days", required = false, defaultValue = "0")int days)

            throws APIUnavailableException {

        backloadHistoDataService.backloadSpecificHistoData(fsym, tsym, exchange, minutes, hours, days);
    }

    //used for sending email
    @RequestMapping("/sendemail")
    public void sendEmail (@RequestParam(value="toAddress")String toAddress)
            throws Exception {

        emailSendingService.sendEmail(toAddress, emailMessageRepository.findBySubject("BTC price alert"));
    }

}
