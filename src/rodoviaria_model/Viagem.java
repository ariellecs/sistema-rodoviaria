package rodoviaria_model;

public class Viagem {
    private String codigoViagem;
    private String dataViagem;
    private String horaViagem;
    private int lugaresLivres;
    private Onibus onibus;
    private Rota rota;

    public Viagem(String codigoViagem, String data, String hora, Onibus onibus, Rota rota) {
        this.codigoViagem = codigoViagem;
        this.dataViagem = data;
        this.horaViagem = hora;
        this.onibus = onibus;
        this.rota = rota;
        this.lugaresLivres = onibus.getLugares();
    }

    public String getCodigoViagem() {
        return codigoViagem;
    }

    public void setCodigoViagem(String codigoViagem) {
        this.codigoViagem = codigoViagem;
    }

    public String getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(String dataViagem) {
        this.dataViagem = dataViagem;
    }

    public String getHoraViagem() {
        return horaViagem;
    }

    public void setHoraViagem(String horaViagem) {
        this.horaViagem = horaViagem;
    }

    
    public int getLugaresLivres() {
        return lugaresLivres;
    }

    public void setLugaresLivres(int lugaresLivres) {
        this.lugaresLivres = lugaresLivres;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
    
    public double calculaCusto(){
        double valor;
        valor = getRota().getCustoDaRota() + getOnibus().getCustoDeUso();
        return valor;
    }
    
}
