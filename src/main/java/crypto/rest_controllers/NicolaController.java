package crypto.rest_controllers;


import crypto.exceptions.APIUnavailableException;
import crypto.model.cryptoCompareModels.CryptoPrice;
import crypto.services.NicolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nicola")
public class NicolaController {


    @Autowired
    NicolaService nicolaService;

    @RequestMapping("/price")
    public CryptoPrice getPrice(@RequestParam(value ="fsym")String fsym,
                                @RequestParam(value ="tsyms")String tsyms) throws APIUnavailableException {
        return nicolaService.getPrice(fsym,tsyms);
    }

}
