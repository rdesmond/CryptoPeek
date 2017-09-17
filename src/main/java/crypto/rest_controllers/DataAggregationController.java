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

    /**
     * @author Nicola
     * @return Loads the last hour of data to the DB
     * @throws APIUnavailableException
     */
    @RequestMapping("/api/loadHourToDB")
    public ArrayList<PersistHistoMinute> getLastHourDataFromMin() throws APIUnavailableException {
       return dataAggregationService.getLastHourDataFromMin();
    }

    /**
     * @author Nicola
     * @return Loads the last day of data to the DB
     * @throws APIUnavailableException
     */
    @RequestMapping("/api/loadDayToDB")
    public ArrayList<PersistHistoMinute> getLastDayDataFromHour() throws APIUnavailableException {
        return dataAggregationService.getLastDayDataFromHour();
    }

    /**
     * @author Nicola
     * @return Loads the last week of data to the DB
     * @throws APIUnavailableException
     */
    @RequestMapping("/api/loadWeekToDB")
    public ArrayList<PersistHistoMinute> getLastWeekDataFromDay() throws APIUnavailableException {
        return dataAggregationService.getLastWeekDataFromDay();
    }
}
