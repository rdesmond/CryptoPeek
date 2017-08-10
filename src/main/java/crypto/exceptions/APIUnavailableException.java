package crypto.exceptions;

/**
 * Created by aaron on 8/10/17.
 */
public class APIUnavailableException extends Exception {

    public String toString(){
        return "The CryptoCompare API is currently unavailable - please try again later.";
    }

}
