package rodoviaria_exceptions;

public class PassagemInsuficienteException extends Exception {

    public PassagemInsuficienteException() {
        super("Quantidade de passagem acima do possível!");
    }
    
}
