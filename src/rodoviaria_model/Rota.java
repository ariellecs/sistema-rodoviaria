package rodoviaria_model;


public class Rota {
    private String codigoRota;
    private String origem;
    private String destino;
    private String duracao;
    private double custoDaRota;  

    public Rota(String codigoRota, String origem, String destino, String duracao, double custoDaRota){
        this.codigoRota = codigoRota;
        this.origem = origem;
        this.destino = destino;
        this.duracao = duracao;
        this.custoDaRota = custoDaRota;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public double getCustoDaRota() {
        return custoDaRota;
    }

    public void setCustoDaRota(double custoDaRota) {
        this.custoDaRota = custoDaRota;
    }

    public String getCodigoRota() {
        return codigoRota;
    }

    public void setCodigoRota(String codigoRota) {
        this.codigoRota = codigoRota;
    }
    
}
