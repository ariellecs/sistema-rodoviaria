package rodoviaria_control;

import java.util.ArrayList;
import rodoviaria_model.Onibus;
import java.util.HashMap;
import rodoviaria_exceptions.OnibusInexistenteException;
import rodoviaria_exceptions.OnibusJaCadastradoException;
import rodoviaria_exceptions.PassagemInsuficienteException;
import rodoviaria_exceptions.RotaInexistenteException;
import rodoviaria_exceptions.RotaJaCadastradaException;
import rodoviaria_exceptions.ViagemInexistenteException;
import rodoviaria_exceptions.ViagemJaCadastradaException;
import rodoviaria_model.Rota;
import rodoviaria_model.VendaDePassagem;
import rodoviaria_model.Viagem;

/**
 *
 * @author Arielle
 */
public class Controlador {
   
   private final HashMap<String,Onibus> frota = new HashMap(); 
   private final HashMap<String,Rota> rotas = new HashMap();
   private final HashMap<String,Viagem> viagens = new HashMap();
   private final ArrayList<VendaDePassagem> vendas = new ArrayList();

   
   public void cadastrarOnibus(String placa, int lugares, String classe, double custoDeUso) throws OnibusJaCadastradoException{
       Onibus o;
       o = buscarOnibus(placa);
       
       if(o != null){
           throw new OnibusJaCadastradoException();
       }
       else{
            o = new Onibus(placa, lugares, classe, custoDeUso);
            frota.put(placa, o);
       }
   }
   
   public void cadastrarRota(String codigoRota, String origem, String destino, String duracao, double custoDaRota) throws RotaJaCadastradaException{
       Rota r;
       r = buscarRota(codigoRota);
       
       if(r != null){
           throw new RotaJaCadastradaException();
       }else{
           r = new Rota(codigoRota, origem, destino, duracao, custoDaRota);
           rotas.put(codigoRota, r);
       }
       
   }
   
   public void cadastrarViagem(String placa, String codigoRota, String codigoViagem, String data, String hora) throws RotaInexistenteException, OnibusInexistenteException, ViagemJaCadastradaException{
   /* selecionar o onibus e a rota
       digitar o codigo da rota
       digitar a data e hora
       set lugares ocupados = lugares
       */
    
    //verifica se existe o onibus, a rota e viagem passados
    Onibus o;
    o = buscarOnibus(placa);
    if(o == null)
        throw new OnibusInexistenteException();
    
    Rota r;
    r = buscarRota(codigoRota);
    if(r == null)
        throw new RotaInexistenteException();
   
    Viagem v;
    v = buscarViagem(codigoViagem);
    if(v != null)
        throw new ViagemJaCadastradaException();
    
    //cadastra a viagem
    v = new Viagem(codigoViagem, data, hora, o, r);
    viagens.put(codigoViagem, v);
    
   }
   
   private Onibus buscarOnibus(String placa){
       return frota.get(placa);    
   }
   
   private Rota buscarRota(String codigo){
       return rotas.get(codigo);    
   }
   
   private Viagem buscarViagem(String codigo){
       return viagens.get(codigo);
   }
   
   public void iniciarVenda(String codigoViagem, int qtdPassagem) throws ViagemInexistenteException, PassagemInsuficienteException{
       Viagem v;
       v = buscarViagem(codigoViagem);
       if (v == null)
           throw new ViagemInexistenteException();
       
       VendaDePassagem vender;
       vender = new VendaDePassagem(vendas.size()+1, v);
       vender.calculaValor(vender, qtdPassagem);
       if(vender.getValor() == 0){
           throw new PassagemInsuficienteException();
       }
       vendas.add(vender);
           
       System.out.println("Valor total da passagem: " + vender.getValor());
  
   }
   
}

/*Exercício 1
Fazer um sistema para controlar a venda de passagens de uma empresa de viagens. 
O sistema deve controlar a frota de ônibus, as rotas que a empresa faz e as viagens.
Cada ônibus possui placa, número de lugares, sua classe (econômica, executiva ou luxo) e o custo de seu uso. 
Uma rota tem origem, destino, duração (horas e minutos) e o custo da rota.
Cada Viagem tem um ônibus, uma rota, a data de inicio da viagem (dia, mês, ano, hora e minuto) e os lugares ocupados.
O preço da viagem é dado pela soma do custo do ônibus e o custo da rota. O sistema deve permitir: 
- Cadastrar um ônibus,	 
- Cadastrar uma rota, 
- Cadastrar uma viagem, 
- vender passagem */