package crypto.exceptions;

/**
 * Created by aaron on 8/10/17.
 */
public class CustomError {

    String message;
    int error_code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
