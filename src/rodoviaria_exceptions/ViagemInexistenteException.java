
package rodoviaria_exceptions;

public class ViagemInexistenteException extends Exception {

    public ViagemInexistenteException() {
        super("Viagem não cadastrada no sistema!");
    }
    
}
