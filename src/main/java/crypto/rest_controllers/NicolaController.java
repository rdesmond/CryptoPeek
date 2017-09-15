package crypto.rest_controllers;


import crypto.exceptions.APIUnavailableException;
import crypto.model.cryptoCompareModels.CryptoPrice;
import crypto.model.cryptoCompareModels.PriceHistorical;
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

    // Author: Nicola
    @RequestMapping("/price")
    public CryptoPrice getPrice(@RequestParam(value ="fsym")String fsym,
                                @RequestParam(value ="tsyms")String tsyms) throws APIUnavailableException {
        return nicolaService.getPrice(fsym,tsyms);
    }
    // Author: Nicola
    @RequestMapping("/pricemulti")
    public PriceHistorical getPriceMulti(@RequestParam(value ="tsyms")String tsyms) throws APIUnavailableException {
        return nicolaService.getPriceMulti(tsyms);
    }
//    need to decide if we want to use this feature before creating the pojos for every coin that would be called with it.
//    // Author: Nicola
//    @RequestMapping("/pricemultifull")
//    public CryptoPrice getPriceMultiFull(@RequestParam(value ="fsyms")String fsyms,
//                                     @RequestParam(value ="tsyms")String tsyms) throws APIUnavailableException {
//        return nicolaService.getPriceMultiFull(fsyms,tsyms);
//    }

    // Author: Nicola
    @RequestMapping("/generateAvg")
    public CryptoPrice getGenerateAvg(@RequestParam(value ="fsym")String fsym,
                                         @RequestParam(value ="tsym")String tsym,
                                            @RequestParam(value ="markets")String markets) throws APIUnavailableException {
        return nicolaService.getGenerateAvg(fsym,tsym, markets);
    }

    // Author: Nicola
    @RequestMapping("/dayAvg")
    public CryptoPrice getDayAvg(@RequestParam(value ="fsym")String fsym,
                                 @RequestParam(value ="tsym")String tsym) throws APIUnavailableException {
        return nicolaService.getDayAvg(fsym,tsym);
    }

    // Author: Nicola
    @RequestMapping("/priceHistorical")
    public PriceHistorical getPriceHistorical(@RequestParam(value ="tsyms")String tsyms,
                                              @RequestParam(value ="ts")String ts) throws APIUnavailableException {
        return nicolaService.getPriceHistorical(tsyms, ts);
    }

}
