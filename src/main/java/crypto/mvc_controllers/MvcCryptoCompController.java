package crypto.mvc_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.exceptions.ExchangeNotFoundException;
import crypto.model.cryptoCompareModels.*;
import crypto.services.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by aaron on 8/10/17.
 */
@Controller
public class MvcCryptoCompController {

    @Autowired
    CryptoService cryptoService;

    @RequestMapping("/mvc")
    public String showForm(Model model){
        return "btc_form";
    }

    @RequestMapping(value = "/test/form", method = RequestMethod.GET )
    public String weatherInputs(Model model) {
        System.out.println("step 1");
        model.addAttribute("cryptoForm", new CryptoForm());
        System.out.println("step 2");
        return "btcform";
    }

    @RequestMapping(value = "/test/form", method = RequestMethod.POST )
    public String weatherSomething( Model model, CryptoForm cryptoInputs) {

        System.out.println("step 3");
        //model.addAttribute("weatherInputs", weatherInputs);
        return "redirect:/crypto/mvc?currency_1="+cryptoInputs.getCurrency_1()+"&currency_2="+cryptoInputs.getCurrency_2();
    }

    @RequestMapping("/crypto/mvc")
    public String showExchanges(@RequestParam(value="currency_1")String currency_1,
                                @RequestParam(value="currency_2")String currency_2,
                                Model model) throws APIUnavailableException{
        CryptoModel rad_data = cryptoService.getCoinSnapshot(currency_1, currency_2);
        Exchanges[] exchanges = rad_data.getData().getExchanges();
        model.addAttribute("exchanges", exchanges);
        return "crypto_base";
    }

    @RequestMapping(value = "/test/form/average", method = RequestMethod.GET )
    public String averageInputs(Model model) {
        System.out.println("step 1");
        model.addAttribute("averageModel", new AverageModel());
        System.out.println("step 2");
        return "averageform";
    }

    @RequestMapping(value = "/test/form/average", method = RequestMethod.POST )
    public String averageSomething( Model model, AverageModel averageInputs) {

        System.out.println("step 3");
        //model.addAttribute("weatherInputs", weatherInputs);
        return "redirect:/crypto/mvc/average?currency_1="+averageInputs.getCurrency_1()+"&currency_2="+averageInputs.getCurrency_2();
    }

    @RequestMapping("/crypto/mvc/average")
    public String showAverage(@RequestParam(value="currency_1")String currency_1,
                                @RequestParam(value="currency_2")String currency_2,
                                Model model) throws APIUnavailableException{
        try {
            CryptoAverage rad_data = cryptoService.getAveragePrice(currency_1, currency_2);
            model.addAttribute("average", rad_data);
            return "averageoutput";
        } catch (ExchangeNotFoundException e){
            return null;
        }

    }
}
