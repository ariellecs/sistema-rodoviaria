package rodoviaria_exceptions;

public class ViagemJaCadastradaException extends Exception {

    public ViagemJaCadastradaException() {
        super("Viagem já cadastrada com esse código!");
    }
    
}
