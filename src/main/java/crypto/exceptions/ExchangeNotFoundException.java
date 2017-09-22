package crypto.exceptions;

/**
 * Created by aaron on 8/10/17.
 */
public class ExchangeNotFoundException extends Exception{

    @Override
    public String toString(){
        return "Unfortunately, you're requested exchange was not found.";
    }

}
