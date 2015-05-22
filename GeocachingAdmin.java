import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
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
	
	//NOTA: não sei se é preciso administrador!!!!!!
	//Nota2: adicionar a excepçao de não existir utilizador!!!!!!!!!!!!!!!!
	
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
	private boolean existeUtilizadorNome(String username){
		if (this.listaDeUtilizadores.containsKey(username)){
			return true;
		}else return false;
	}

	private boolean existeUtilizadorEmail(String email){
		if (this.listaDeUtilizadores.containsKey(email)){
			return true;
		}else return false;
	}
	
	//Método em que se existir o utilizador valida ou não o login
	public boolean loginUtilizador(String username, String password){
		return existeUtilizadorNome(username);

	}
	
	//Método que adiciona utilizador
	public void addUtilizador(Utilizadores user){
		if(this.listaDeUtilizadores.containsKey(user.getEmail())){
			this.listaDeUtilizadores.put(user.getEmail(), user.clone()); //para adicionar a um HasMap é com put
		}
	}
	
	
	//Método que actualiza a informação de um utilizador
	public void actualizaUtilizador(Utilizadores user, char genero, String nome, String email, String pass, String morada, GregorianCalendar dataNasc){
		Utilizadores uti= this.listaDeUtilizadores.get(user.getEmail());
		if(this.listaDeUtilizadores.containsKey(user.getEmail())){
			uti.modificaUtilizador(genero, nome, email, pass, morada, dataNasc);
		}
		//actualizar lista de amigos
		//for(Utilizadores amigo: uti.getRedeAmigos()){
			//amigo.actualizaRedeAmigos(uti);
		//}
		//actualizar no hashmap as novas informações
		this.listaDeUtilizadores.put(uti.getEmail(), uti);
	}

	
	//Método que remove um utilizador
	public void removeUtilizador(String email){
		if(this.listaDeUtilizadores.containsKey(email)){
			Utilizadores user= this.listaDeUtilizadores.get(email);
			//vai remover da rede de amigos o utilizador
			for(String usr: user.getRedeAmigos()){
				Utilizadores uti=this.listaDeUtilizadores.get(usr);
				uti.getRedeAmigos().remove(user.getNome());
			}
		}
		//vai remover o utilizador da lista de utilizadores
		this.listaDeUtilizadores.remove(email);
	}

	
	//Método que devolve a lista de caches descobertas pelo utilizador
	public ArrayList<Cache> getListaCaches(String email){
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Cache> listaCaches=new ArrayList<Cache>();
		for(String cache: user.getActividades()){
			Cache c = new Cache();
			listaCaches.add(c.getCacheReferencia(cache));
		}		
		return listaCaches;
		//return user.getActividades();
	}
	

	//Método que devolve a lista de caches inseridas por um utilizador
	public ArrayList<Cache> getListaCachesInseridas(String email){
		Utilizadores user= this.listaDeUtilizadores.get(email);
		return user.getActividades();
	}
	
	

	
}