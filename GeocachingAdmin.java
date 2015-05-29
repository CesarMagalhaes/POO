import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;


public class GeocachingAdmin implements Serializable{
	
	
	//Variàveis de Instância--------------------------------------------------------------------
	
	private HashMap<String, Utilizadores> listaDeUtilizadores; //lista dos utilizadores, que tem como chave o email
	private TreeSet<Evento> listaDeEventos;
	private HashMap<String, Cache> listaDeCaches; //lista das caches, que tem como chave a referência da cache
	
	
	//Construtores-------------------------------------------------------------------------------
	
	public GeocachingAdmin(){
		this.listaDeUtilizadores= new HashMap<String, Utilizadores>();
		this.listaDeEventos= new TreeSet<Evento>();
		this.listaDeCaches=new HashMap<String, Cache>();
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
	

	//Geteres e Seteres----------------------------------------------------------------------------------- é preciso mudar
	
	public HashMap<String, Utilizadores> getListaDeUtilizadores() { return listaDeUtilizadores;	}
	public TreeSet<Evento> getListaDeEvento() { return listaDeEventos; }
	public HashMap<String, Cache> getListaDeCaches(){ return listaDeCaches; }

	public void setListaDeUtilizadores(	HashMap<String, Utilizadores> listaDeUtilizadores) { this.listaDeUtilizadores = listaDeUtilizadores; }
	public void setListaDeEventos(TreeSet<Evento> listaDeEventos) {	this.listaDeEventos = listaDeEventos; }
	public void setListaDeCaches(HashMap<String, Cache> listaDeCaches){ this.listaDeCaches=listaDeCaches; }
	
	

	//------------------------------------------------------------------------Métodos de Instância-------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
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
	public boolean existeUtilizadorNome(String username) throws UtilizadorException {
			if (this.listaDeUtilizadores.containsKey(username)){
			return true;
		}else return false;
	}

	public boolean existeUtilizadorEmail(String email) throws UtilizadorException{
		if (this.listaDeUtilizadores.containsKey(email)){
			return true;
		}else return false;
	}
	
	//Método em que se existir o utilizador valida ou não o login
	public boolean loginUtilizador(String username, String pass) throws UtilizadorException{	
		Utilizadores aux=this.listaDeUtilizadores.get(username);
		if((existeUtilizadorNome(username)) && (aux.getPassword()==pass)) return true;
		else return false;

	}
	
	//Método que adiciona utilizador
	public void addUtilizador(Utilizadores user) throws UtilizadorException{
		if(this.listaDeUtilizadores.containsKey(user.getEmail())){
			this.listaDeUtilizadores.put(user.getEmail(), user.clone()); //para adicionar a um HasMap é com put. adiciona a key e o value => HashMap<k, v>
		}
	}
	
	
	//Método que actualiza a informação de um utilizador
	public void actualizaUtilizador(Utilizadores user, char genero, String nome, String email, String pass, String morada, GregorianCalendar dataNasc) throws UtilizadorException{
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
	public void removeUtilizador(String email) throws UtilizadorException{
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

	
	public Cache getCacheReferencia(String n_registo) throws CacheException{
		if(!listaDeCaches.containsKey(n_registo)){
			throw new CacheException();
		}
		if(listaDeCaches.containsKey(n_registo)){
			return listaDeCaches.get(n_registo);		
		}
		else return null;
	}
	
	//Método que devolve a lista de caches descobertas pelo utilizador
	public ArrayList<Cache> getListaCaches(String email) throws UtilizadorException{
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Cache> listaCaches=new ArrayList<Cache>();
		for(String cache: user.getActividades()){
			if(this.listaDeCaches.containsKey(cache)){
				listaCaches.add(getCacheReferencia(cache));//é preciso deveolver o clone do objecto
			}			
		}
		return listaCaches;
	}
			
/**		for(String cache: user.getActividades()){
			Cache c = new Cache();
			listaCaches.add(c.getCacheReferencia(cache));
		}		
		return listaCaches;
		//return user.getActividades();
	}
	*/

	//Método que devolve a lista de caches inseridas por um utilizador
	public ArrayList<Cache> getListaCachesInseridas(String email) throws UtilizadorException{
		Utilizadores user= this.listaDeUtilizadores.get(email);
		ArrayList<Cache> listaCaches=new ArrayList<Cache>();
		for(String cache: user.getCachesInseridas()){
			if(this.listaDeCaches.containsKey(cache)){
				listaCaches.add(getCacheReferencia(cache));//é preciso deveolver o clone do objecto
			}			
		}
		return listaCaches;
	}
	
	
	//Método que permite ao administrador desativaruma cache
	public void desativaCache(Cache c) throws CacheException{
		c.setIsActiva(false);
	}
	
	
	//Método que devolve a lista de amigos de um utilizador
	public ArrayList<Utilizadores> getRedeAmigos(String email) throws UtilizadorException{
		
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Utilizadores> redeAmigos=new ArrayList<Utilizadores>();
		for(String amigo: user.getRedeAmigos()){
			Utilizadores friend= new Utilizadores();
			redeAmigos.add(friend.getAmigoNome(amigo));
		}
		return redeAmigos;
	}
	
	
	//Método que remove um amigo da lista de amigos do utilizador
	public void removeAmigo(String email, String nome) throws UtilizadorException{ //vai receber o email de utilizador e o nome do amigo que vai remover
		Utilizadores user=this.listaDeUtilizadores.get(email);
		for(String amigo: user.getRedeAmigos()){
			if(amigo==nome) user.removeAmigo(amigo);
		}
	}
	
	
	//Método que devolve a lista de amigos pendentes
	public ArrayList<Utilizadores> getListaAmigosPendentes(String email) throws UtilizadorException{
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Utilizadores> listaAmigosPendentes= new ArrayList<Utilizadores>();
		for(String amigoPendente: user.getAmigosPendentes()){
			Utilizadores aux=new Utilizadores();
			listaAmigosPendentes.add(aux.getAmigoPendenteNome(amigoPendente));
		}
		return listaAmigosPendentes;
	}
	
	//Método que vai remover um utilizador da lista de amigos pendentes
	public void removeAmigoPendente(String email, String nome) throws UtilizadorException{ //vai receber o email de utilizador e o nome do amigo que vai remover
		Utilizadores user=this.listaDeUtilizadores.get(email);
		for(String amigo: user.getAmigosPendentes()){
			if(amigo==nome) user.removeAmigo(amigo);
		}
	}
	
	//Método que vai aceitar amigo pendente, respectivamente adicioná-lo à rede de amigos e removêlo d alista de amigos pendentes
	public void adicionaAmigo(String email, String nome) throws UtilizadorException{
		Utilizadores user= this.listaDeUtilizadores.get(email);
		Utilizadores amigo=new Utilizadores();
		for(String amigoPendente: user.getAmigosPendentes()){
			if(amigoPendente==nome){
				amigo=user.getAmigoPendenteNome(amigoPendente);
			}
		}
		user.addAmigo(amigo);
		user.removeAmigoPendente(nome);
	}
	

	/**
	 *Falta:
	 *Método que adiciona evento
	 *Método que consulta evento
	 *Método que devolve a lista de eventos
	 *Método que devolve os utilizadores que participaram num evento
	 *Método que devolve um evento dada uma data 
	 *Método que devolve a data em que determinado evento foi realizado
	 *
	 *métodos relativos às estatísticas
	 *
	 * */
	
}