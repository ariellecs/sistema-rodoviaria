package rodoviaria_view;

import rodoviaria_control.Controlador;
import java.util.Scanner;
import rodoviaria_exceptions.OnibusInexistenteException;
import rodoviaria_exceptions.OnibusJaCadastradoException;
import rodoviaria_exceptions.PassagemInsuficienteException;
import rodoviaria_exceptions.RotaInexistenteException;
import rodoviaria_exceptions.RotaJaCadastradaException;
import rodoviaria_exceptions.ViagemInexistenteException;
import rodoviaria_exceptions.ViagemJaCadastradaException;

/**
 *
 * @author Arielle Cardoso
 */

public class Rodoviaria {
 
    private final Controlador ctrl;
    
    public static void main(String[] args) throws OnibusJaCadastradoException, RotaJaCadastradaException, RotaInexistenteException, OnibusInexistenteException, ViagemJaCadastradaException, ViagemInexistenteException, PassagemInsuficienteException{
        Rodoviaria r = new Rodoviaria();
        r.menu();
    }
     public Rodoviaria(){
        ctrl = new Controlador();
    }
    
      public void menu() throws OnibusJaCadastradoException, RotaJaCadastradaException, RotaInexistenteException, OnibusInexistenteException, ViagemJaCadastradaException, ViagemInexistenteException, PassagemInsuficienteException{
        int opcao;
        Scanner sc = new Scanner(System.in);
        do{
        
            System.out.println("Rodoviaria");
            System.out.println("1 - Cadastrar Onibus");
            System.out.println("2 - Cadastrar Rota");
            System.out.println("3 - Cadastrar Viagem");
            System.out.println("4 - Vender passagem");
            System.out.println("5 - Sair");
            
            opcao = sc.nextInt();
            switch(opcao){
                case 1:cadastrarOnibus();
                    break;
                case 2:cadastrarRota();
                   break;
                case 3:cadastrarViagem();
                   break;
                case 4:venderPassagem();
                    break;
            }
        }while(opcao != 5);
    }
    
    public void cadastrarOnibus() throws OnibusJaCadastradoException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a placa:" );
        String placa = sc.next();
        
        System.out.print("Digite o numero de lugares:" );
        int lugares = sc.nextInt();
          
        System.out.print("Digite a classe:" );
        String classe = sc.next();
          
        System.out.print("Digite o custo de uso:" );
        double custo = sc.nextDouble();
        
        try{
            ctrl.cadastrarOnibus(placa, lugares, classe, custo);
            System.out.println("Ônibus cadastrado com sucesso!");
        }
        catch(OnibusJaCadastradoException ex){
            System.out.println(ex.getMessage());
            System.out.println("Ônibus NÃO Cadastrado!");  
        }
    }
    
    public void cadastrarRota() throws RotaJaCadastradaException{
        Scanner sc = new Scanner(System.in);
          
        System.out.print("Digite o código da rota:" );
        String codigo = sc.next();
          
        System.out.print("Digite a origem da rota:" );
        String origem = sc.next();
          
        System.out.print("Digite o destino da rota:" );
        String destino = sc.next();
          
        System.out.print("Digite a duração da rota:" );
        String duracao = sc.next();
          
        System.out.print("Digite o custo da rota:" );
        double custoDaRota = sc.nextDouble();
          
        try{
            ctrl.cadastrarRota(codigo, origem, destino, duracao, custoDaRota);
            System.out.println("Rota cadastrada com sucesso!");
        }
        catch(RotaJaCadastradaException ex){
            System.out.println(ex.getMessage());
            System.out.println("Rota NÃO Cadastrada!");  
        }  
    }
    
    public void cadastrarViagem() throws RotaInexistenteException, OnibusInexistenteException, ViagemJaCadastradaException{
        Scanner sc = new Scanner(System.in);
          
        System.out.print("Digite o código da viagem:" );
        String codigoViagem = sc.next();
          
        System.out.print("Digite a placa do ônibus a ser alocado:" );
        String placa = sc.next();
          
        System.out.print("Digite o código da rota a ser percorrida:" );
        String codigoRota = sc.next();
          
        System.out.print("Digite a data da viagem:" );
        String data = sc.next();
        
        System.out.print("Digite a hora da viagem:" );
        String hora = sc.next();
        
        try{
            ctrl.cadastrarViagem(placa, codigoRota, codigoViagem, data, hora);
            System.out.println("Viagem Cadastrada!");
        }
        catch(ViagemJaCadastradaException ex){
            System.out.println(ex.getMessage());  
            System.out.println("Viagem NÃO Cadastrada!"); 
        }               
        catch(RotaInexistenteException | OnibusInexistenteException ex){
            System.out.println(ex.getMessage());  
            System.out.println("Viagem NÃO Cadastrada!");  
        }
        
          
    }
    
    public void venderPassagem() throws ViagemInexistenteException, PassagemInsuficienteException{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o código da viagem:" );
        String codigo = sc.next();
        
        System.out.print("Digite a quantidade de passagens:" );
        int qtdPassagem = sc.nextInt();

        try{
            ctrl.iniciarVenda(codigo, qtdPassagem);
            System.out.println("Venda Cadastrada!");
        }catch(ViagemInexistenteException ex){
            System.out.println(ex.getMessage());  
            System.out.println("Venda NÃO Cadastrada!"); 
        }catch(PassagemInsuficienteException ex){
            System.out.println(ex.getMessage());  
            System.out.println("Venda NÃO Cadastrada!"); 
        }
    }
    
}