package crypto.mappers;

import crypto.model.tablePOJOs.HistoDataDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by tanerali on 21/09/2017.
 */
@RunWith(SpringRunner.class)
@MybatisTest
public class BackloadHistoDataMapperTest {

    @Autowired
    private BackloadHistoDataMapper backloadHistoDataMapper;

    @Test
    public void insertHistoMinuteData() throws Exception {
        ArrayList<HistoDataDB> histoDataDBArrayList = new ArrayList<>();
        histoDataDBArrayList.add(new HistoDataDB(1, 1505903382, 423.423, 423.423,
                0, 420.05,425.05, 59.5, 237284.15, 1));

        backloadHistoDataMapper.insertHistoMinuteData(histoDataDBArrayList);

    }

    @Test
    public void insertHistoMinuteIntoDB() throws Exception {
    }

    @Test
    public void getLastHistominEntry() throws Exception {
    }

    @Test
    public void getTopMinutelyMovers() throws Exception {
    }

    @Test
    public void getTopHourlyMovers() throws Exception {
    }

    @Test
    public void getTopDailyMovers() throws Exception {
    }

    @Test
    public void getAllMinutelyTimestamps() throws Exception {
    }

}