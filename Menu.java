import java.util.Scanner;
import java.lang.String;
import java.lang.System;
import java.lang.Character;
import java.util.Random;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.ArrayList;

public class Menu {
    Utilizadores user = new Utilizadores();
    Cache cache;
    GeocachingAdmin geoadmin = new GeocachingAdmin();

    public static void menu(){
        System.out.println("\tGEOCACHING");
        System.out.println("1. LOGIN");
        System.out.println("2. REGISTO");
        System.out.println("0. SAIR");
        System.out.println("Opcao:");
    }

    public void login()throws UtilizadorException,CacheException{
        System.out.println("INTRODUZA E-MAIL:");
        Scanner mail = new Scanner(System.in);
        String email, password;
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
            else{
                System.out.println("DADOS ERRADOS.");
                dadoserrados();

            }
        }
    }

    public void registo()throws UtilizadorException{
        Utilizadores temp = new Utilizadores();
        String emailreg, passwordreg, nome, morada;
        char genero;
        GregorianCalendar dataNascimento;
        DateFormat formato = new SimpleDateFormat("dd-mm-yyyy");
        Date data = null;
        Scanner entrada = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);

        System.out.println("REGISTO");
        System.out.println("E-MAIL: ( servirá como username )");
        emailreg = entrada.nextLine();    
        temp.setEmail(emailreg);    

        System.out.println("PASSWORD:");
        passwordreg = entrada.nextLine();
        temp.setPassword(passwordreg);

        System.out.println("NOME:");
        nome = entrada.nextLine();
        temp.setNome(nome);

        System.out.println("GENERO: (M ou F)");
        genero = entrada2.next(".").charAt(0);
        temp.setGenero(genero);

        System.out.println("MORADA:");
        morada = entrada.nextLine();
        temp.setMorada(morada);

        System.out.println("DATA DE NASCIMENTO:");
        System.out.println("Ano(AAAA): ");int AAAA = entrada.nextInt();
        System.out.println("Mes(MM): ");int MM = entrada.nextInt();
        System.out.println("Dia(DD): ");int DD = entrada.nextInt();
        dataNascimento = new GregorianCalendar(DD,MM,AAAA);
        temp.setDataNascimento(dataNascimento);

        ArrayList<String> actividades = new ArrayList<String>();
        temp.setActividades(actividades);
        ArrayList<String> cachesinseridas = new ArrayList<String>();
        temp.setCachesInseridas(cachesinseridas);
        ArrayList<String> redeamigos = new ArrayList<String>();
        temp.setRedeAmigos(redeamigos);
        ArrayList<String> amigospendentes = new ArrayList<String>();
        temp.setAmigosPendentes(amigospendentes);
        geoadmin.addUtilizador(temp);
    }

    public void dadoserrados()throws UtilizadorException,CacheException{
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

    public void usermenu()throws UtilizadorException,CacheException{
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

    public void adminmenu()throws UtilizadorException, CacheException{
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

    public void cachemenu()throws UtilizadorException, CacheException{
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

    public void criarcache()throws UtilizadorException, CacheException{

        MicroCache cachetemp = new MicroCache();
        int dificuldade,n, latitude,longitude;
        char pontocardeal;
        Random rand = new Random();
        Scanner entrada = new Scanner(System.in);
        System.out.println("CRIAR CACHE");
        System.out.println("Introduza as coordenadas GPS:(latitude)");
        latitude = entrada.nextInt();
        cachetemp.setLatitude(latitude);
        System.out.println("Introduza as coordenadas GPS:(longitude)");
        longitude = entrada.nextInt();
        cachetemp.setLongitude(longitude);
        System.out.println("Introduza o ponto cardeal");
        pontocardeal = entrada.next("[a-zA-Z]").charAt(0);
        cachetemp.setPontocardeal(pontocardeal);

        GregorianCalendar data = new GregorianCalendar();
        n = rand.nextInt(1000) + 1;
        cachetemp.setN_registo(Integer.toString(n));
        cachetemp.setRegistos(null);
        cachetemp.setCriador(user.getNome());
        cachetemp.setIsActiva(true);
        cachetemp.setDataCriacao(data);
        cachetemp.setDificuldade("Sol");

        user.addCache(cachetemp);
    }

    public void desactivacacheuser()throws CacheException{
        System.out.println("Introduza a cache a desactivar:");
        String nregistocache;
        Scanner entrada = new Scanner(System.in);
        nregistocache = entrada.nextLine();
        user.desativaCache(geoadmin.getCacheReferencia(nregistocache));
    }

    public void descobrecache()throws CacheException{
        System.out.println("DESCOBRIR CACHE");
        System.out.println("INTRODUZIR A CACHE A SER DESCOBERTA:");
        String cachedescob;
        Scanner entrada = new Scanner(System.in);
        cachedescob = entrada.nextLine();
        user.addCacheDescoberta(geoadmin.getCacheReferencia(cachedescob));
        /*System.out.println("QUAIS ERAM AS CONDIÇOES CLIMATERICAS NO MOMENTO?");
        System.out.println("1. Sol");
        System.out.println("2. Chuva");
        System.out.println("3. Neve");
        System.out.println("4. Normal");}
        do{
        opcao = entrada.nextInt();

        switch(opcao){
        case 1:
        ();

        case 2:
        desactivacacheuser();

        case 3:
        descobrecache();

        default:
        System.out.println("Invalido.");
        }
        } while(opcao != 0);*/

    }    

    public void amigos()throws UtilizadorException{
        System.out.println("AMIGOS");
        Scanner entrada = new Scanner(System.in);
        int opcao;
        Utilizadores amigoadd = new Utilizadores();
        String nomependente;
        String nomeamigorem;
        String nomeamigoadd;
        System.out.println("1. ADICIONAR AMIGO");
        System.out.println("2. REMOVER AMIGO");
        System.out.println("3. ACEITAR PEDIDOS DE AMIZADE");
        System.out.println("4. REJEITAR PEDIDOS DE AMIZADE");
        System.out.println("0. SAIR");
        do{
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                System.out.println("Introduza o nome do amigo a adicionar:");
                nomeamigoadd = entrada.nextLine();
                amigoadd.setNome(nomeamigoadd);
                user.addAmigo(user.getAmigoNome(nomeamigoadd));

                case 2:
                System.out.println("Introduza o nome do amigo a remover:");
                nomeamigorem = entrada.nextLine();
                user.removeAmigo(nomeamigorem);

                case 3:
                user.getAmigosPendentes();
                System.out.println("Introduza o nome do amigo a aceitar:");
                nomependente = entrada.nextLine();
                user.addAmigoPendente(nomependente);

                case 4:
                user.getAmigosPendentes();
                System.out.println("Introduza o nome do amigo a rejeitar:");
                nomependente = entrada.nextLine();
                user.removeAmigoPendente(nomependente);

                case 0:
                System.exit(0);

                default:
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while(opcao != 0);}

    public static void eventos(){
        System.out.println("EVENTOS");
        System.out.println("FUNCIONALIDADE NAO IMPLEMENTADA.");
        menu();}

    public static void estatisticas(){
        System.out.println("ESTATISTICAS");
        System.out.println("FUNCIONALIDADE NAO IMPLEMENTADA.");
        menu();}

    public void actualizauser()throws UtilizadorException, CacheException{
        System.out.println("Introduza e-mail do utilizador a actualizar:");
        String usermail;
        Scanner entrada = new Scanner(System.in);
        usermail = entrada.nextLine();

        if(geoadmin.existeUtilizadorEmail(usermail)==false) {System.out.println("Utilizador não existe. \n Tente novamente");
            actualizauser();}

        System.out.println("Introduza os dados a actualizar do user"+usermail);                                            
        System.out.println("GENERO: (M ou F)");
        char generoup = entrada.next("[a-zA-Z]").charAt(0);

        System.out.println("NOME:");
        String nomeup = entrada.nextLine();

        System.out.println("PASSWORD:");
        String passwordup = entrada.nextLine();

        System.out.println("MORADA:");
        String moradaup = entrada.nextLine();

        System.out.println("DATA DE NASCIMENTO:");
        System.out.println("Ano(AAAA): ");int AAAA = entrada.nextInt();
        System.out.println("Mes(MM): ");int MM = entrada.nextInt();
        System.out.println("Dia(DD): ");int DD = entrada.nextInt();
        GregorianCalendar dataNascup = new GregorianCalendar(DD,MM,AAAA);

        //(Utilizadores user, char genero, String nome, String pass, String morada, GregorianCalendar dataNasc) 
        geoadmin.actualizaUtilizador(user,generoup,nomeup,passwordup,moradaup,dataNascup);
        System.out.println("User actualizado.");
        adminmenu();
    }

    public void removeuser()throws UtilizadorException, CacheException{
        System.out.println("Introduza e-mail do utilizador a remover:");
        String usermail;
        Scanner entrada = new Scanner(System.in);
        usermail = entrada.nextLine();
        geoadmin.removeUtilizador(usermail);
        System.out.println("Removido o utilizador com o mail: "+usermail);
        adminmenu();
    }

    public void desactivacacheadmin()throws UtilizadorException, CacheException{
        System.out.println("Introduza a cache a desactivar:");
        String nregistocache;
        Scanner entrada = new Scanner(System.in);
        nregistocache = entrada.nextLine();
        geoadmin.desativaCache(geoadmin.getCacheReferencia(nregistocache));

    }

    public void criaevento()throws UtilizadorException, CacheException{
        System.out.println("FUNCIONALIDADE NAO IMPLEMENTADA.");
        adminmenu();

    }

    public static void main(String[] args)throws UtilizadorException, CacheException {
        Menu m = new Menu();
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menu();
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                m.login();
                break;

                case 2:
                m.registo();
                break;

                case 0:
                System.exit(0);
                default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
}

