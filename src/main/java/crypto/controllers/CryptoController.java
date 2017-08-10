package crypto.controllers;

import java.util.concurrent.atomic.AtomicLong;

import crypto.exceptions.APIUnavailableException;
import crypto.exceptions.CustomError;
import crypto.model.CryptoModel;
import crypto.services.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CryptoController {

    @Autowired
    CryptoService cryptoService;

    @RequestMapping("/crypto")
    public CryptoModel getSnapShot(@RequestParam(value="fsym")String fsym, @RequestParam(value="tsym")String tsym)
            throws APIUnavailableException {
        System.out.println("requestmapping");
        return cryptoService.getCoinSnapshot(fsym, tsym);
    }
}
