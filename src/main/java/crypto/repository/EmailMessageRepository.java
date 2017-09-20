package crypto.repository;

import crypto.model.tablePOJOs.EmailMessageDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tanerali on 05/09/2017.
 * Used for accessing the email_messages table and performing queries with Hibernate
 */
@Repository("emailMessageRepository")
public interface EmailMessageRepository extends JpaRepository<EmailMessageDB, Integer>{
    EmailMessageDB findBySubject(String subject);
}
