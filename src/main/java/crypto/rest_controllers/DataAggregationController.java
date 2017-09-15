package crypto.rest_controllers;

import crypto.exceptions.APIUnavailableException;
import crypto.model.historicalModels.PersistHistoMinute;
import crypto.services.DataAggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DataAggregationController {

    @Autowired
    DataAggregationService dataAggregationService;

    // Author: Nicola
    @RequestMapping("/api/loadHourToDB")
    public ArrayList<PersistHistoMinute> getLastHourDataFromMin() throws APIUnavailableException {
       return dataAggregationService.getLastHourDataFromMin();
    }
}
