package crypto.model.tablePOJOs;

import javax.persistence.*;

/**
 * Created by tanerali on 01/09/2017.
 */
@Entity
@Table(name = "email_logs")
public class EmailLogDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String to_address;
    String date;
    int email_message_id;

    public EmailLogDB(String to_address, String date, int email_message_id) {
        this.to_address = to_address;
        this.date = date;
        this.email_message_id = email_message_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo_address() {
        return to_address;
    }

    public void setTo_address(String to_address) {
        this.to_address = to_address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEmail_message_id() {
        return email_message_id;
    }

    public void setEmail_message_id(int email_message_id) {
        this.email_message_id = email_message_id;
    }
}
