package crypto.repository;

import crypto.model.tablePOJOs.HistoDataDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by tanerali on 29/08/2017.
 */
@Repository("histoDataRepository")
public interface BackloadHistoDataRepository extends JpaRepository<HistoDataDB, Integer>{
}