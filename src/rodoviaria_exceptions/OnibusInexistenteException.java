
package rodoviaria_exceptions;

public class OnibusInexistenteException extends Exception{

    public OnibusInexistenteException() {
        super("O ônibus inserido não existe no sistema!");
    }
    
}
