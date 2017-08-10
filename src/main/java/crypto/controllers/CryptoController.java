package crypto.controllers;

import java.util.concurrent.atomic.AtomicLong;

import crypto.model.CryptoModel;
import crypto.services.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoController {

    @Autowired
    CryptoService cryptoService;

    @RequestMapping("/crypto")
    public CryptoModel getSnapShot(@RequestParam(value="fsym")String fsym, @RequestParam(value="tsym")String tsym) {
        System.out.println("requestmapping");
        return cryptoService.getCoinSnapshot(fsym, tsym);
    }
}
