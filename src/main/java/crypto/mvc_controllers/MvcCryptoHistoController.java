package crypto.mvc_controllers;

import crypto.services.CryptoHistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by aaron on 8/11/17.
 */
@Controller
public class MvcCryptoHistoController {

    @Autowired
    CryptoHistoService cryptoHistoService;



}
