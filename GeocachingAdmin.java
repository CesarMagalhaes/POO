import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TreeSet;


public class GeocachingAdmin implements Serializable{
	
	
	//Variàveis de Instância--------------------------------------------------------------------
	
	private HashMap<String, Utilizadores> listaDeUtilizadores;
	private TreeSet<Evento> listaDeEventos;
	
	
	//Construtores-------------------------------------------------------------------------------
	
	public GeocachingAdmin(){
		this.listaDeUtilizadores= new HashMap<String, Utilizadores>();
		this.listaDeEventos= new TreeSet<Evento>();
	}
	
	public GeocachingAdmin(HashMap<String, Utilizadores> listaUtilizadores, TreeSet<Evento> listaEventos){
		this.listaDeUtilizadores= listaUtilizadores;
		this.listaDeEventos= listaEventos;
		addAdminLista(); // vai adicionar o administrador à lista
	}
	
	public GeocachingAdmin(GeocachingAdmin ga){
		HashMap<String, Utilizadores> lu= ga.getListaDeUtilizadores();
		TreeSet<Evento> le= ga.getListaDeEvento();
		addAdminLista();
	}
	

	//Geteres e Seteres-----------------------------------------------------------------------------------
	
	public HashMap<String, Utilizadores> getListaDeUtilizadores() { return listaDeUtilizadores;	}
	public TreeSet<Evento> getListaDeEvento() { return listaDeEventos; }

	public void setListaDeUtilizadores(	HashMap<String, Utilizadores> listaDeUtilizadores) { this.listaDeUtilizadores = listaDeUtilizadores; }
	public void setListaDeEventos(TreeSet<Evento> listaDeEventos) {	this.listaDeEventos = listaDeEventos; }
	

	//------------------------------------------------------------------------Métodos de Instância-------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//Método que insere na lista de utilizadores o administrador
	public void addAdminLista(){
		if (!this.listaDeUtilizadores.containsKey("admin@geocaching.com")) {
			this.listaDeUtilizadores.put("admin", new Utilizadores('A',"admin", "admin@geocaching.com", "admin"));
		}
	}
	
	//Método que verifica se se trata do administrador (através do email)
	public boolean verificaAdmin(String email){
		if(email.equals("admin@geocaching.com")){
			return true;
		}else return false;
	}

	//Método que verifica se existe utilizador
	private boolean existeUtilizador(String email, String password){
		boolean found= false;
		for(Utilizadores user: this.listaDeUtilizadores){
			if((user.getEmail()==email) && (user.getPassword()==password)) found=true;				
		}
		return false;
	}
	
	
	//Método em que se existir o utilizador valida ou não o login
	public boolean loginUtilizador(String user, String password){
		return existeUtilizador(user, password);

	}

	
}