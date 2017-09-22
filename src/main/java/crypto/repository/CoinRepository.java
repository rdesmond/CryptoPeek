package crypto.repository;

import crypto.model.tablePOJOs.CoinDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tanerali on 06/09/2017.
 * Used for accessing the coins table and performing queries with Hibernate
 */
@Repository
public interface CoinRepository extends JpaRepository<CoinDB, Integer>{
    CoinDB findBySymbol (String symbol);
}
