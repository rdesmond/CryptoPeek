package crypto.repository;

import crypto.model.tablePOJOs.TopCoinsDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tanerali on 06/09/2017.
 * Used for accessing the coins table and performing queries with Hibernate
 */
@Repository
public interface TopCoinsRepository extends JpaRepository<TopCoinsDB, Integer>{
    TopCoinsDB findBySymbol (String symbol);
}
