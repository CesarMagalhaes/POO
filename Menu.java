import java.util.Scanner;
import java.lang.String;

/**
 * Escreva a descrição da classe Interface aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Menu {
    
    public static void menu(){
        System.out.println("\tGEOCACHING");
        System.out.println("1. LOGIN");
        System.out.println("2. REGISTO");
        System.out.println("0. SAIR");
        System.out.println("Opcao:");
    }


    public static void login(){
        System.out.println("INTRODUZA E-MAIL:");
        String email;
        Scanner mail = new Scanner(System.in);
        email = mail.nextLine();
        System.out.println("PASSWORD:");
        String password;
        Scanner pass = new Scanner(System.in);
        password = pass.nextLine();
        GeocachingAdmin geoadmin = new GeocachingAdmin();
        if((geoadmin.verificaAdmin(email)== false)){
            System.out.println("NÃO É ADMIN.");
            if(geoadmin.existeUtilizadorEmail(email)==false){
                System.out.println("NÃO EXISTE USER");
                login();
            }
            else{usermenu();} // FALTA VERIFICAR PASSWORD
        }
          else {System.out.println("É ADMIN.");
            adminmenu();}
        }
        
    public static void usermenu(){
        System.out.println("1. Inserir");
        System.out.println("2. Amigos");
        System.out.println("3. Eventos");
        System.out.println("4. Estatisticas");
        System.out.println("Opcao:");
        int opcao;
        Scanner nextopcao = new Scanner(System.in);
        
        do{
            cachemenu();
            opcao = nextopcao.nextInt();
            
            switch(opcao){
            case 1:
                inserir();
                break;
                
            case 2:
                amigos();
                break;
            
            case 3:
                eventos();
                break;
            
            case 4:
                estatisticas();
                break;
            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
    public static void adminmenu(){}    
    public static void cachemenu(){}
    public static void inserir(){}
    public static void amigos(){}
    public static void eventos(){}
    public static void estatisticas(){}
    
    public static void registo(){
        System.out.println("REGISTO");
    }
    
    
    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
                login();
                break;
                
            case 2:
                registo();
                break;
            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
}
