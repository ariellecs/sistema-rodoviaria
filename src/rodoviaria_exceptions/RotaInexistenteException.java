package rodoviaria_exceptions;

public class RotaInexistenteException extends Exception {

    public RotaInexistenteException() {
        super("A rota inserida não existe no sistema!");
    }
    
    
}
