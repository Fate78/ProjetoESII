package ProjetoESII.Exceptions;

import java.io.Serializable;

public class InvalidUtilizadorException extends Exception implements Serializable{
    public InvalidUtilizadorException(String message) { super(message);}
}
