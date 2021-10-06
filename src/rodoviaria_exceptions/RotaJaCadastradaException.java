package rodoviaria_exceptions;

public class RotaJaCadastradaException extends Exception {
    public RotaJaCadastradaException(){
        super("Rota já cadastrada!");
    }
}
