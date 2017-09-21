package crypto.rest_controllers;

import crypto.configuration.WebMvcConfig;
import crypto.model.tablePOJOs.HistoDataDB;
import crypto.services.BackloadHistoDataService;
import crypto.services.CryptoService;
import crypto.services.PriceChangeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



/**
 * Created by tanerali on 20/09/2017.
 */
public class TanerCryptoControllerTest {

    //MockMvc is the main entry point for server-side Spring MVC test support.
    //Perform a request and return a type that allows chaining further actions,
    //such as asserting expectations, on the result.
    private MockMvc mockMvc;


    //By annotating the UserService with the @Mock annotation, we can return
    //mocked data when we call a method from this service

    @Mock
    private PriceChangeService priceChangeService;


    //Using the @InjectMocks
    //annotation, we can inject the mocked service inside our UserController
    @InjectMocks
    private TanerCryptoController tanerCryptoController;


    //Before each test, we must initialize these mocks
    //using the MockitoAnnotations.initMocks(this)
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(tanerCryptoController)
                .build();
    }

    @Test
    public void getTopPairs() throws Exception {
    }

    @Test
    public void getMiningContracts() throws Exception {
    }

    @Test
    public void getMiningEquipment() throws Exception {
    }

    @Test
    public void backloadPreviouslyMissingHistoData() throws Exception {
//        List<HistoDataDB> histoDataDBs = Arrays.asList(
//                new HistoDataDB(1, 1505903382, 423.423, 423.423, 0, 420.05,
//                        425.05, 59.5, 237284.15, 1));

    }

    @Test
    public void backloadRecentHistoData() throws Exception {
    }

    @Test
    public void sendEmail() throws Exception {
    }

    @Test
    public void topMinutelyMovers() throws Exception {
        ArrayList<HistoDataDB> histoDataDBs = new ArrayList<>();

        //Create test data which’ll be returned as a response in the rest service.
        histoDataDBs.add(new HistoDataDB(1, 1505903382, 423.423, 423.423,
                0, 420.05,425.05, 59.5, 237284.15, 1));

        //Configure mock object to return the test data when the topMinutelyMovers()
        //method of the priceChangeService is invoked
        when(priceChangeService.topMinutelyMovers()).thenReturn(histoDataDBs);

        //Invoke an HTTP GET request to the /api/top/minutely URI.
        //DONT FORGET THE FIRST SLASH /
        mockMvc.perform(get("/api/top/minutely"))
                //Verify that the HTTP status code is 200 (OK).
                .andExpect(status().isOk())
                //Verify that the content-type of the response is application/json and its character set is UTF-8.
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                //Verify that the collection contains 2 items.
                .andExpect(jsonPath("$", hasSize(1)))
                //Verify that the id attribute of the first element equals to 1.
                .andExpect(jsonPath("$[0].id", is(1)))
                //Verify that the opening price attribute of the first element equals to 423.423
                .andExpect(jsonPath("$[0].open", is(423.423)));
        //Verify that the topMinutelyMovers() method of the PriceChangeService is invoked exactly once.
        verify(priceChangeService, times(1)).topMinutelyMovers();
        //Verify that after the response, no more interactions are made to the PriceChangeService
        verifyNoMoreInteractions(priceChangeService);

    }

    @Test
    public void topHourlyMovers() throws Exception {
    }

    @Test
    public void topDailyMovers() throws Exception {
    }

}