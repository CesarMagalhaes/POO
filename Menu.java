import java.util.Scanner;
import java.lang.String;
import java.lang.System;
import java.lang.Character;

/**
 * Escreva a descrição da classe Interface aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Menu {

    private Utilizadores user;
    private Cache cache;
    private GeocachingAdmin geoadmin;
    private String email; 
    private String password;
    
    public static void menu(){
        System.out.println("\tGEOCACHING");
        System.out.println("1. LOGIN");
        System.out.println("2. REGISTO");
        System.out.println("0. SAIR");
        System.out.println("Opcao:");
    }

    public static void login(){
        System.out.println("INTRODUZA E-MAIL:");
        Scanner mail = new Scanner(System.in);
        email = mail.nextLine();
        System.out.println("PASSWORD:");
        Scanner pass = new Scanner(System.in);
        password = pass.nextLine();
        if((geoadmin.verificaAdmin(email)== true) && (geoadmin.loginUtilizador(email,password)==true)){
            System.out.println("É ADMIN.");
            adminmenu();}
        else {
            if(geoadmin.loginUtilizador(email,password)==true){
                System.out.println("EXISTE USER");
                usermenu();
            }
            else{System.out.println("DADOS ERRADOS.");
                dadoserrados();
            }
        }
    }

    public static void registo(){
        Utilizadores temp;
        String emailreg, passwordreg, nome, morada;
        char genero;
        GregorianCalendar dataNascimento;
        Scanner entrada = new Scanner(System.in);

        System.out.println("REGISTO");
        System.out.println("E-MAIL: ( servirá como username )");
        emailreg = entrada.nextInt();    
        temp.setEmail(emailreg);    

        System.out.println("PASSWORD:");
        passwordreg = entrada.nextInt();
        temp.setPassword(passwordreg);

        System.out.println("NOME:");
        nome = entrada.nextInt();
        temp.setNome(nome);

        System.out.println("GENERO: (M ou F)");
        genero = entrada.nextInt();
        temp.setGenero(genero);

        System.out.println("MORADA:");
        morada = entrada.nextInt();
        temp.setMorada(morada);

        System.out.println("DATA DE NASCIMENTO: (DD/MM/AAAA)");
        dataNascimento = entrada.nextInt();
        temp.setDataNascimento(dataNascimento);

        temp.setActividades();
        temp.setCachesInseridas();
        temp.setRedeAmigos();
        temp.setAmigosPendentes();
        geoadmin.addUtilizador(temp);
    }

    public static void dadoserrados(){
        int opcao;
        Scanner nextopcao = new Scanner(System.in);

        do{
            menu();
            opcao = nextopcao.nextInt();

            switch(opcao){

                case 1:
                login();
                break;

                case 2:
                registo();
                break;

                case 0:
                System.exit(0);

            }
        }while(opcao != 0);
    }

    public static void user(){
                
       System.out.println("USER MENU");
        System.out.println("1. Cache");
        System.out.println("2. Amigos");
        System.out.println("3. Eventos");
        System.out.println("4. Estatisticas");
        System.out.println("0. Sair");
        System.out.println("Opcao:");}
    public static void usermenu(){
        int opcao;
        Scanner nextopcao = new Scanner(System.in);

        do{
            usermenu();
            opcao = nextopcao.nextInt();

            switch(opcao){
                case 1:
                cachemenu();
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

                case 0:
                System.exit(0);

                default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }

     public static void admin(){
        System.out.println("ADMIN MENU");
        System.out.println("1. Actualizar User");
        System.out.println("2. Remover User");
        System.out.println("3. Desactivar Cache");
        System.out.println("4. Criar Evento:");
        System.out.println("0. Sair");
    }
    public static void adminmenu(){
        int opcao;
        Scanner nextopcao = new Scanner(System.in);

        do{
            adminmenu();
            opcao = nextopcao.nextInt();

            switch(opcao){
                case 1:
                actualizauser();
                break;

                case 2:
                removeuser();
                break;

                case 3:
                desactivacacheadmin();
                break;

                case 4:
                criaevento();
                break;

                case 0:
                System.exit(0);

                default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }

    public static void cache(){
        System.out.println("CACHE MENU");
        System.out.println("1. Criar cache");
        System.out.println("2. Desactivar cache");
        System.out.println("3. Descobrir cache");
        System.out.println("0. Sair");}
    public static void cachemenu(){
        int opcao;
        Scanner nextopcao = new Scanner(System.in);

        do{
            cachemenu();
            opcao = nextopcao.nextInt();

            switch(opcao){
                case 1:
                criarcache();
                break;

                case 2:
                desactivacacheuser();
                break;

                case 3:
                descobrecache();
                break;

                case 0:
                System.exit(0);

                default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }    

    public static void criarcache(){
        Date date = new Date();
        Cache cachetemp;
        int dificuldade;
        Scanner dif = new Scanner(System.in);
        System.out.println("CRIAR CACHE");
        System.out.println("Introduza as coordenadas GPS:(latitude,longitude)");
        cachetemp.setLatitude();
        cachetemp.setLongitude();
        cachetemp.setPontoCardeal();
        System.out.println("Introduza a dificuldade da cache:");
        dificuldade = dif.nextInt();
        cachetemp.setDificuldade(dificuldade);
        
        cachetemp.setN_registo("");
        cachetemp.setRegistos("");
        cachetemp.setCriador(user.getNome());
        cachetemp.setIsActiva(true);
        cachetemp.setDataCriacao(date);
        
        user.addCache();
        System.out.println("FUNCIONALIDADE NAO IMPLEMENTADA.");
        menu();}
    
    public static void desactivacacheuser(){
        System.out.println("Introduza a cache a desactivar:");
        int cache;
        Scanner entrada = new Scanner(System.in);
        cache = entrada.nextInt();
        user.desativaCache(cache);
    }

    public static void descobrecache(){
        System.out.println("DESCOBRIR CACHE");
        System.out.println("FUNCIONALIDADE NAO IMPLEMENTADA.");
        menu();}    
        
        
        
        
    public static void amigos(){
        System.out.println("AMIGOS");
        System.out.println("FUNCIONALIDADE NAO IMPLEMENTADA.");
        menu();}

    public static void eventos(){
        System.out.println("EVENTOS");
        System.out.println("FUNCIONALIDADE NAO IMPLEMENTADA.");
        menu();}

    public static void estatisticas(){
        System.out.println("ESTATISTICAS");
        System.out.println("FUNCIONALIDADE NAO IMPLEMENTADA.");
        menu();}

    public static void actualizauser(){
        System.out.println("Introduza e-mail do utilizador a actualizar:");
        int usermail;
        Scanner entrada = new Scanner(System.in);
        usermail = entrada.nextInt();

        if(geoadmin.existeUtilizadorEmail(usermail)==false) {System.out.println("Utilizador não existe. \n Tente novamente");
            actualizauser();}

        System.out.println("Introduza os dados a actualizar do user"+usermail);                                            
        System.out.println("GENERO: (M ou F)");
        generoup = entrada.nextInt();

        System.out.println("NOME:");
        nomeup = entrada.nextInt();

        System.out.println("PASSWORD:");
        passwordup = entrada.nextInt();

        System.out.println("MORADA:");
        moradaup = entrada.nextInt();

        System.out.println("DATA DE NASCIMENTO: (DD/MM/AAAA)");
        dataNascup = entrada.nextInt();

        geoadmin.actualizaUtilizador(generoup,nomeup,usermail,passup,moradaup,dataNascup);
        System.out.println("User actualizado.");
        adminmenu();
    }

    public static void removeuser(){
        System.out.println("Introduza e-mail do utilizador a remover:");
        int usermail;
        Scanner entrada = new Scanner(System.in);
        usermail = entrada.nextInt();
        geoadmin.removeUtilizador(usermail);
        System.out.println("Removido o utilizador com o mail: "+usermail);
        adminmenu();
    }

    public static void desactivacacheadmin(){
        System.out.println("Introduza a cache a desactivar:");
        int cache;
        Scanner entrada = new Scanner(System.in);
        cache = entrada.nextInt();
        geoadmin.desactivaCache(cache);

    }

    public static void criaevento(){
        System.out.println("FUNCIONALIDADE NAO IMPLEMENTADA.");
        adminmenu();

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

                case 0:
                System.exit(0);
                default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
}
