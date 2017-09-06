package crypto.configuration;

/**
 * Created by tanerali on 05/09/2017.
 */
public class EmailConfig {

    public static final String FROM = "cryptopeek@gmail.com";


    // Replace smtp_username with your Amazon SES SMTP user name.
    // NEVER UPLOAD TO GITHUB
    public static final String SMTP_USERNAME = "USERNAME";


    // Replace smtp_password with your Amazon SES SMTP password.
    // NEVER UPLOAD TO GITHUB
    public static final String SMTP_PASSWORD = "PASSWORD";

    // The name of the Configuration Set to use for this message.
    // If you comment out or remove this variable, you will also need to
    // comment out or remove the header on line 50 in EmailSendingService.
//    static final String CONFIGSET = "ConfigSet";

    // Amazon SES SMTP host name. This example uses the US West (Oregon) Region.
    public static final String HOST = "email-smtp.us-west-2.amazonaws.com";

    // The port you will connect to on the Amazon SES SMTP endpoint.
    public static final int PORT = 465;

}