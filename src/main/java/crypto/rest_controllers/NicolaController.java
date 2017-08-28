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

    @RequestMapping("/price")
    public CryptoPrice getPrice(@RequestParam(value ="fsym")String fsym,
                                @RequestParam(value ="tsyms")String tsyms) throws APIUnavailableException {
        return nicolaService.getPrice(fsym,tsyms);
    }

    @RequestMapping("/pricemulti")
    public CryptoPrice getPriceMulti(@RequestParam(value ="fsyms")String fsyms,
                                @RequestParam(value ="tsyms")String tsyms) throws APIUnavailableException {
        return nicolaService.getPriceMulti(fsyms,tsyms);
    }

    @RequestMapping("/pricemultifull")
    public CryptoPrice getPriceMultiFull(@RequestParam(value ="fsyms")String fsyms,
                                     @RequestParam(value ="tsyms")String tsyms) throws APIUnavailableException {
        return nicolaService.getPriceMultiFull(fsyms,tsyms);
    }

    @RequestMapping("/generateAvg")
    public CryptoPrice getGenerateAvg(@RequestParam(value ="fsym")String fsym,
                                         @RequestParam(value ="tsym")String tsym,
                                            @RequestParam(value ="markets")String markets) throws APIUnavailableException {
        return nicolaService.getGenerateAvg(fsym,tsym, markets);
    }

    @RequestMapping("/dayAvg")
    public CryptoPrice getDayAvg(@RequestParam(value ="fsym")String fsym,
                                 @RequestParam(value ="tsym")String tsym) throws APIUnavailableException {
        return nicolaService.getDayAvg(fsym,tsym);
    }

    @RequestMapping("/priceHistorical")
    public PriceHistorical getPriceHistorical(@RequestParam(value ="tsyms")String tsyms,
                                              @RequestParam(value ="ts")String ts) throws APIUnavailableException {
        return nicolaService.getPriceHistorical(tsyms, ts);
    }

}
