import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;


public class GeocachingAdmin implements Serializable{
	
	
	//Vari�veis de Inst�ncia--------------------------------------------------------------------
	
	private HashMap<String, Utilizadores> listaDeUtilizadores; //lista dos utilizadores, que tem como chave o email
	private TreeSet<Evento> listaDeEventos;
	private HashMap<String, Cache> listaDeCaches; //lista das caches, que tem como chave a refer�ncia da cache
	
	
	//Construtores-------------------------------------------------------------------------------
	
	public GeocachingAdmin(){
		this.listaDeUtilizadores= new HashMap<String, Utilizadores>();
		this.listaDeEventos= new TreeSet<Evento>();
		this.listaDeCaches=new HashMap<String, Cache>();
	}
	
	public GeocachingAdmin(HashMap<String, Utilizadores> listaUtilizadores, TreeSet<Evento> listaEventos){
		this.listaDeUtilizadores= listaUtilizadores;
		this.listaDeEventos= listaEventos;
		addAdminLista(); // vai adicionar o administrador � lista
	}
	
	public GeocachingAdmin(GeocachingAdmin ga){
		HashMap<String, Utilizadores> lu= ga.getListaDeUtilizadores();
		TreeSet<Evento> le= ga.getListaDeEvento();
		addAdminLista();
	}
	

	//Geteres e Seteres----------------------------------------------------------------------------------- � preciso mudar
	
	public HashMap<String, Utilizadores> getListaDeUtilizadores() { return listaDeUtilizadores;	}
	public TreeSet<Evento> getListaDeEvento() { return listaDeEventos; }
	public HashMap<String, Cache> getListaDeCaches(){ return listaDeCaches; }

	public void setListaDeUtilizadores(	HashMap<String, Utilizadores> listaDeUtilizadores) { this.listaDeUtilizadores = listaDeUtilizadores; }
	public void setListaDeEventos(TreeSet<Evento> listaDeEventos) {	this.listaDeEventos = listaDeEventos; }
	public void setListaDeCaches(HashMap<String, Cache> listaDeCaches){ this.listaDeCaches=listaDeCaches; }
	
	

	//------------------------------------------------------------------------M�todos de Inst�ncia-------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Nota2: adicionar a excep�ao de n�o existir utilizador!!!!!!!!!!!!!!!!
	
	//M�todo que insere na lista de utilizadores o administrador
	public void addAdminLista(){
		if (!this.listaDeUtilizadores.containsKey("admin@geocaching.com")) {
			this.listaDeUtilizadores.put("admin", new Utilizadores('A',"admin", "admin@geocaching.com", "admin"));
		}
	}
	
	//M�todo que verifica se se trata do administrador (atrav�s do email)
	public boolean verificaAdmin(String email){
		if(email.equals("admin@geocaching.com")){
			return true;
		}else return false;
	}

	//M�todo que verifica se existe utilizador
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
	
	//M�todo em que se existir o utilizador valida ou n�o o login
	public boolean loginUtilizador(String username, String pass) throws UtilizadorException{	
		Utilizadores aux=this.listaDeUtilizadores.get(username);
		if((existeUtilizadorNome(username)) && (aux.getPassword()==pass)) return true;
		else return false;

	}
	
	//M�todo que adiciona utilizador
	public void addUtilizador(Utilizadores user) throws UtilizadorException{
		if(this.listaDeUtilizadores.containsKey(user.getEmail())){
			this.listaDeUtilizadores.put(user.getEmail(), user.clone()); //para adicionar a um HasMap � com put. adiciona a key e o value => HashMap<k, v>
		}
	}
	
	
	//M�todo que actualiza a informa��o de um utilizador
	public void actualizaUtilizador(Utilizadores user, char genero, String nome, String email, String pass, String morada, GregorianCalendar dataNasc) throws UtilizadorException{
		Utilizadores uti= this.listaDeUtilizadores.get(user.getEmail());
		if(this.listaDeUtilizadores.containsKey(user.getEmail())){
			uti.modificaUtilizador(genero, nome, email, pass, morada, dataNasc);
		}
		//actualizar lista de amigos
		//for(Utilizadores amigo: uti.getRedeAmigos()){
			//amigo.actualizaRedeAmigos(uti);
		//}
		//actualizar no hashmap as novas informa��es
		this.listaDeUtilizadores.put(uti.getEmail(), uti);
	}

	
	//M�todo que remove um utilizador
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
	
	//M�todo que devolve a lista de caches descobertas pelo utilizador
	public ArrayList<Cache> getListaCaches(String email) throws UtilizadorException{
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Cache> listaCaches=new ArrayList<Cache>();
		for(String cache: user.getActividades()){
			if(this.listaDeCaches.containsKey(cache)){
				listaCaches.add(getCacheReferencia(cache));//� preciso deveolver o clone do objecto
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

	//M�todo que devolve a lista de caches inseridas por um utilizador
	public ArrayList<Cache> getListaCachesInseridas(String email) throws UtilizadorException{
		Utilizadores user= this.listaDeUtilizadores.get(email);
		ArrayList<Cache> listaCaches=new ArrayList<Cache>();
		for(String cache: user.getCachesInseridas()){
			if(this.listaDeCaches.containsKey(cache)){
				listaCaches.add(getCacheReferencia(cache));//� preciso deveolver o clone do objecto
			}			
		}
		return listaCaches;
	}
	
	
	//M�todo que permite ao administrador desativaruma cache
	public void desativaCache(Cache c) throws CacheException{
		c.setIsActiva(false);
	}
	
	
	//M�todo que devolve a lista de amigos de um utilizador
	public ArrayList<Utilizadores> getRedeAmigos(String email) throws UtilizadorException{
		
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Utilizadores> redeAmigos=new ArrayList<Utilizadores>();
		for(String amigo: user.getRedeAmigos()){
			Utilizadores friend= new Utilizadores();
			redeAmigos.add(friend.getAmigoNome(amigo));
		}
		return redeAmigos;
	}
	
	
	//M�todo que remove um amigo da lista de amigos do utilizador
	public void removeAmigo(String email, String nome) throws UtilizadorException{ //vai receber o email de utilizador e o nome do amigo que vai remover
		Utilizadores user=this.listaDeUtilizadores.get(email);
		for(String amigo: user.getRedeAmigos()){
			if(amigo==nome) user.removeAmigo(amigo);
		}
	}
	
	
	//M�todo que devolve a lista de amigos pendentes
	public ArrayList<Utilizadores> getListaAmigosPendentes(String email) throws UtilizadorException{
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Utilizadores> listaAmigosPendentes= new ArrayList<Utilizadores>();
		for(String amigoPendente: user.getAmigosPendentes()){
			Utilizadores aux=new Utilizadores();
			listaAmigosPendentes.add(aux.getAmigoPendenteNome(amigoPendente));
		}
		return listaAmigosPendentes;
	}
	
	//M�todo que vai remover um utilizador da lista de amigos pendentes
	public void removeAmigoPendente(String email, String nome) throws UtilizadorException{ //vai receber o email de utilizador e o nome do amigo que vai remover
		Utilizadores user=this.listaDeUtilizadores.get(email);
		for(String amigo: user.getAmigosPendentes()){
			if(amigo==nome) user.removeAmigo(amigo);
		}
	}
	
	//M�todo que vai aceitar amigo pendente, respectivamente adicion�-lo � rede de amigos e remov�lo d alista de amigos pendentes
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
	 *M�todo que adiciona evento
	 *M�todo que consulta evento
	 *M�todo que devolve a lista de eventos
	 *M�todo que devolve os utilizadores que participaram num evento
	 *M�todo que devolve um evento dada uma data 
	 *M�todo que devolve a data em que determinado evento foi realizado
	 *
	 *m�todos relativos �s estat�sticas
	 *
	 * */
	
}