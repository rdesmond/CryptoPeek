package crypto.rest_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.model.miningContracts.MiningContracts;
import crypto.model.miningEquipment.MiningEquipment;
import crypto.model.tablePOJOs.HistoDataDB;
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

    //Taner
    //straight-through API call to TopPairs at CryptoCompare
    @RequestMapping("/top/pairs")
    public TopPairs getTopPairs (@RequestParam(value="fsym")String fsym,
                                 @RequestParam(value="tsym", required = false)String tsym,
                                 @RequestParam(value="limit", required = false)Integer limit,
                                 @RequestParam(value="sign", required = false)boolean sign)
            throws APIUnavailableException {

        return cryptoService.getTopPairs(fsym, tsym, limit, sign);
    }

    //Taner
    //straight-through API call to MiningContracts at CryptoCompare
    @RequestMapping("/mining/contracts")
    public MiningContracts getMiningContracts ()
            throws APIUnavailableException {

        return cryptoService.getMiningContracts();
    }

    //Taner
    //straight-through API call to MiningEquipment at CryptoCompare
    @RequestMapping("/mining/equipment")
    public MiningEquipment getMiningEquipment ()
            throws APIUnavailableException {

        return cryptoService.getMiningEquipment();
    }

    //Taner
    //backloads previously (in the past) missing minutely, hourly and/or daily historical
    //data from CryptoCompare to database;
    @RequestMapping("/backload/missing")
    public void backloadPreviouslyMissingHistoData() throws APIUnavailableException {

        backloadHistoDataService.backloadPreviouslyMissingHistoData();
    }

    //Taner
    @RequestMapping("/backload/recent")
    public void backloadRecentHistoData()

            throws APIUnavailableException {

        backloadHistoDataService.backloadRecentHistoData();
    }

    //Taner
    //used for sending email
    @RequestMapping("/sendemail")
    public void sendEmail (@RequestParam(value="toAddress")String toAddress)
            throws Exception {

        emailSendingService.sendEmail(toAddress, emailMessageRepository.findBySubject("BTC price alert"));
    }

    //Taner
    @RequestMapping("/top/minutely")
    public ArrayList<HistoDataDB> topMinutelyMovers() {
        return priceChangeService.topMinutelyMovers();
    }

    //Taner
    @RequestMapping("/top/hourly")
    public ArrayList<HistoDataDB> topHourlyMovers() {
        return priceChangeService.topHourlyMovers();
    }

    //Taner
    @RequestMapping("/top/daily")
    public ArrayList<HistoDataDB> topDailyMovers() {
        return priceChangeService.topDailyMovers();
    }

}
