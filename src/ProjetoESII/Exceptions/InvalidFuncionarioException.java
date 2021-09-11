package ProjetoESII.Exceptions;

import java.io.Serializable;

public class InvalidFuncionarioException extends Exception implements Serializable{
    public InvalidFuncionarioException(String message) { super(message);}
}
