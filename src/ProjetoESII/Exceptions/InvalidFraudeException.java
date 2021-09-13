package ProjetoESII.Exceptions;
import java.io.Serializable;


public class InvalidFraudeException extends Exception implements Serializable {
    public InvalidFraudeException(String message) {
        super(message);
    }
}
