package crypto.repository;

import crypto.model.tablePOJOs.EmailMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tanerali on 05/09/2017.
 */
@Repository("emailMessageRepository")
public interface EmailMessageRepository extends JpaRepository<EmailMessage, Integer>{
    EmailMessage findBySubject(String subject);
}
