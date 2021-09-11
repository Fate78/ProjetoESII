package ProjetoESII.Exceptions;

import java.io.Serializable;

public class InvalidEbookException extends Exception implements Serializable{
    public InvalidEbookException(String message) {
        super(message);
    }
}
