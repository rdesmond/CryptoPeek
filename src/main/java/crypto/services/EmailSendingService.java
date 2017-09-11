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

//Taner
@Service
public class EmailSendingService {

    @Autowired
    EmailLogRepository emailLogRepository;

    //Taner

    /**
     * Sends email using Amazon SES. Configuration file is in crypto.configuration.EmailConfig
     * @param to address to which email will be sent
     * @param emailMessageDB specifies which email message will be sent since there are
     *                       predefined messages in the DB; argument will be passed by
     *                       accessing DB and retrieving one of predefined messages which contains
     *                       both the subject and the message
     * @throws Exception
     */
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

    //Taner
    //method will log each email sent and specify to whom it was sent and what
    //the message was
    private void logEmailSent(String to, int email_message_id) {

        EmailLogDB emailLogDB = new EmailLogDB(to, DateUnix.currentTimeToString(), email_message_id);

        emailLogRepository.save(emailLogDB);
    }

}
