package crypto.services;

import crypto.mappers.BackloadHistoDataMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by tanerali on 21/09/2017.
 */
@RunWith(SpringRunner.class)
public class BackloadHistoDataServiceTest {

    @TestConfiguration
    static class BackloadHistoDataServiceTestContextConfig {

        @Bean
        public BackloadHistoDataService backloadHistoDataService() {
            return new BackloadHistoDataService();
        }
    }

    @Autowired
    private BackloadHistoDataService backloadHistoDataService;

    @MockBean
    private BackloadHistoDataMapper backloadHistoDataMapper;

    @Before
    public void setUp() {
    }


    @Test
    public void backloadPreviouslyMissingHistoData() throws Exception {
    }

    @Test
    public void backloadSpecificMinutelyData() throws Exception {
    }

    @Test
    public void backloadRecentHistoData() throws Exception {
    }

}