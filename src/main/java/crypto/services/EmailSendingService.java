package crypto.services;

import crypto.model.tablePOJOs.EmailLogDB;
import crypto.model.tablePOJOs.EmailMessageDB;
import crypto.repository.EmailLogRepository;
import crypto.util.DateUnix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static crypto.configuration.EmailConfig.*;


/**
 * Created by tanerali on 27/08/2017.
 */
@Service
public class EmailSendingService {

    @Autowired
    EmailLogRepository emailLogRepository;


    public void sendEmail(String to, EmailMessageDB emailMessageDB) throws Exception {

        // Create a Properties object to contain connection configuration information.
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties.
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information.
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(emailMessageDB.getSubject());
        msg.setContent(emailMessageDB.getMessage(),"text/html");

        // Add a configuration set header. Comment or delete the
        // next line if you are not using a configuration set
//        msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);

        // Create a transport.
        Transport transport = session.getTransport();

        // Send the message.
        try
        {
            System.out.println("Sending...");

            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }

        logEmailSent (to, emailMessageDB.getId());
    }

    private void logEmailSent(String to, int email_message_id) {

        EmailLogDB emailLogDB = new EmailLogDB(to, DateUnix.currentTimeToString(), email_message_id);

        emailLogRepository.save(emailLogDB);
    }

}
