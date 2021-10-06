package rodoviaria_model;

public class Onibus {
    private final String placa;
    private final int lugares;
    private final String classe;
    private double custoDeUso;

    public Onibus(String placa, int lugares, String classe, double custoDeUso) {
        this.placa = placa;
        this.lugares = lugares;
        this.classe = classe;
        this.custoDeUso = custoDeUso;
    }

    public double getCustoDeUso() {
        return custoDeUso;
    }

    public void setCustoDeUso(double custoDeUso) {
        this.custoDeUso = custoDeUso;
    }

    public String getPlaca() {
        return placa;
    }

    public int getLugares() {
        return lugares;
    }

    public String getClasse() {
        return classe;
    }
    
    
    
}

