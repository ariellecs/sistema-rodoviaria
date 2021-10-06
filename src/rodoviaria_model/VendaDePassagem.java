package rodoviaria_model;

public class VendaDePassagem {
    private final int codigoVenda;
    Viagem viagem;
    private double valor;

    public VendaDePassagem(int codigoVenda, Viagem viagem) {
        this.codigoVenda = codigoVenda;
        this.viagem = viagem;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void calculaValor(VendaDePassagem venda, int qtdPassagem){
        
        if(venda.viagem.getLugaresLivres() > 0){
            if(venda.viagem.getLugaresLivres() - qtdPassagem > 0){
                venda.viagem.setLugaresLivres(venda.viagem.getLugaresLivres() - qtdPassagem);
                setValor(venda.viagem.calculaCusto() * qtdPassagem);
            }
        }
    }
}
