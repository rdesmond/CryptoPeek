package crypto.model.emails;

/**
 * Created by tanerali on 05/09/2017.
 */
public class Emails {


    /*
    THESE SHOULD BE PUT INTO THE DATABASE
     */


    //Email 1
    public static final String testSubject = "Amazon SES test (SMTP interface accessed using Java)";

    public static final String testBody = String.join(
            System.getProperty("line.separator"),
            "<h1>Amazon SES SMTP Email Test</h1>",
            "<p>This email was sent with Amazon SES using the ",
            "<a href='https://github.com/javaee/javamail'>Javamail Package</a>",
            " for <a href='https://www.java.com'>Java</a>."
    );


    //Email 2
    public static final String priceAlertSubject = "crypto.symbol price alert";

    public static final String priceAlertBody = String.join(
            System.getProperty("line.separator"),
            "<h1>The price for #{crypto.symbol} has passed the #{x.x} level</h1>",
            "<p>Find details and real-time data about coin here:  ",
            "<a href='https://cryptopeek.net/#{coin.symbol}'>Javamail Package</a>"
    );

    //Email 3
    //....
}
