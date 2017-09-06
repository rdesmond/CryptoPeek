package crypto.repository;

import crypto.model.tablePOJOs.EmailLogDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tanerali on 05/09/2017.
 */
@Repository("emailLogRepository")
public interface EmailLogRepository extends JpaRepository<EmailLogDB, Integer>{
}