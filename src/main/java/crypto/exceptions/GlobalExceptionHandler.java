package crypto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aaron on 8/10/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)  // 409
    @ExceptionHandler(APIUnavailableException.class)
    public @ResponseBody CustomError handle404() {
        CustomError error = new CustomError();
        error.setMessage("Apologies, it appears the CryptoCompare API is currently offline. We are not able" +
                " to process your request. Please try again later.");
        error.setError_code(503);
        return error;
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)  // 409
    @ExceptionHandler(ExchangeNotFoundException.class)
    public @ResponseBody CustomError handleNotFound() {
        CustomError error = new CustomError();
        error.setMessage("Unfortunately, you're requested exchange was not found. Please try again with a valid crypto currency.");
        error.setError_code(500);
        return error;
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)  // 409
    @ExceptionHandler(DataBaseAccessException.class)
    public @ResponseBody CustomError unableToAccessDataBase() {
        CustomError error = new CustomError();
        error.setMessage("Unfortunately, you could not access the database.");
        error.setError_code(500);
        return error;
    }
}
