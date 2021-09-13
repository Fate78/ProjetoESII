package ProjetoESII.Exceptions;

import java.io.Serializable;

public class InvalidExtensaoEmprestimoException extends Exception implements Serializable
{
    public InvalidExtensaoEmprestimoException(String message){super(message);}
}
