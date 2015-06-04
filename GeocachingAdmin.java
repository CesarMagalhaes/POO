import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;


public class GeocachingAdmin implements Serializable{
	
	
	
	
	private HashMap<String, Utilizadores> listaDeUtilizadores; 
	private TreeSet<Evento> listaDeEventos;
	private HashMap<String, Cache> listaDeCaches; 
	
	
	
	
	public GeocachingAdmin(){
		this.listaDeUtilizadores= new HashMap<String, Utilizadores>();
		this.listaDeEventos= new TreeSet<Evento>();
		this.listaDeCaches=new HashMap<String, Cache>();
	}
	
	public GeocachingAdmin(HashMap<String, Utilizadores> listaUtilizadores, TreeSet<Evento> listaEventos){
		this.listaDeUtilizadores= listaUtilizadores;
		this.listaDeEventos= listaEventos;
		addAdminLista(); 
	}
	
	public GeocachingAdmin(GeocachingAdmin ga){
		HashMap<String, Utilizadores> lu= ga.getListaDeUtilizadores();
		TreeSet<Evento> le= ga.getListaDeEvento();
		addAdminLista();
	}
	

	
	
	public HashMap<String, Utilizadores> getListaDeUtilizadores() { return listaDeUtilizadores;	}
	public TreeSet<Evento> getListaDeEvento() { return listaDeEventos; }
	public HashMap<String, Cache> getListaDeCaches(){ return listaDeCaches; }

	public void setListaDeUtilizadores(	HashMap<String, Utilizadores> listaDeUtilizadores) { this.listaDeUtilizadores = listaDeUtilizadores; }
	public void setListaDeEventos(TreeSet<Evento> listaDeEventos) {	this.listaDeEventos = listaDeEventos; }
	public void setListaDeCaches(HashMap<String, Cache> listaDeCaches){ this.listaDeCaches=listaDeCaches; }
	
	

	
	
	
	
	
	
	public void addAdminLista(){
		if (!this.listaDeUtilizadores.containsKey("admin@geocaching.com")) {
			this.listaDeUtilizadores.put("admin", new Utilizadores('A',"admin", "admin@geocaching.com", "admin"));
		}
	}
	
	
	public boolean verificaAdmin(String email){
		if(email.equals("admin@geocaching.com")){
			return true;
		}else return false;
	}

	
	public boolean existeUtilizadorNome(String username) throws UtilizadorException {
		if (!this.listaDeUtilizadores.containsValue(username)){
			throw new UtilizadorException("Utilizador n„o existe!!");
		}
		if (this.listaDeUtilizadores.containsKey(username)){
			return true;
		}else return false;
	}

	public boolean existeUtilizadorEmail(String email) throws UtilizadorException{
		if (!this.listaDeUtilizadores.containsKey(email)){
			throw new UtilizadorException("Utilizador n„o existe!!");
		}
		if (this.listaDeUtilizadores.containsKey(email)){
			return true;
		}else return false;
	}
	
	
	public boolean loginUtilizador(String username, String pass) throws UtilizadorException{
		Utilizadores aux=this.listaDeUtilizadores.get(username);
		if((existeUtilizadorNome(username)) && (aux.getPassword()==pass)) return true;
		else {
			if((existeUtilizadorNome(username))==false){throw new UtilizadorException("Login inv·lido. Username n„o existe!");}
			if(aux.getPassword()!=pass){throw new UtilizadorException("Login inv·lido. Password incorreta!");}
			return false; 
		}

	}
	
	
	public void addUtilizador(Utilizadores user) throws UtilizadorException{
		if(this.listaDeUtilizadores.containsKey(user.getEmail())){
			throw new UtilizadorException("Utilizador j· exite!");
		}
		if(!this.listaDeUtilizadores.containsKey(user.getEmail())){
			this.listaDeUtilizadores.put(user.getEmail(), user.clone()); 
		}
	}
	
	
	
	public void actualizaUtilizador(Utilizadores user, char genero, String nome, String pass, String morada, GregorianCalendar dataNasc) throws UtilizadorException{
		Utilizadores uti= this.listaDeUtilizadores.get(user.getEmail());
		if(this.listaDeUtilizadores.containsKey(user.getEmail())){
			uti.modificaUtilizador(genero, nome, pass, morada, dataNasc);
		}
		
		
			
		
		
		this.listaDeUtilizadores.put(uti.getEmail(), uti);
	}

	
	
	public void removeUtilizador(String email) throws UtilizadorException{
		if(!this.listaDeUtilizadores.containsKey(email)){
			throw new UtilizadorException("O utilizador qu equer remover n„o existe!");
		}
		if(this.listaDeUtilizadores.containsKey(email)){
			Utilizadores user= this.listaDeUtilizadores.get(email);
			
			for(String usr: user.getRedeAmigos()){
				Utilizadores uti=this.listaDeUtilizadores.get(usr);
				uti.getRedeAmigos().remove(user.getNome());
			}
		}
		
		this.listaDeUtilizadores.remove(email);
	}

	
	
	public Cache getCacheReferencia(String n_registo) throws CacheException{
		if(!listaDeCaches.containsKey(n_registo)){
			throw new CacheException("A cache n„o existe!");
		}
		if(listaDeCaches.containsKey(n_registo)){
			return listaDeCaches.get(n_registo);		
		}
		else return null;
	}
	
	
	public ArrayList<Cache> getListaCaches(String email) throws UtilizadorException, CacheException{
		if(!listaDeUtilizadores.containsKey(email)){
			throw new UtilizadorException("O utilizador n„o existe!");
		}
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Cache> listaCaches=new ArrayList<Cache>();
		for (String cache : user.getActividades().keySet()){		 //ver se isto d� para fazer assim
			if(this.listaDeCaches.containsKey(cache)){
				listaCaches.add(getCacheReferencia(cache));
			}
			else{ throw new CacheException("A cache n„o existe");}  
		
		}
		return listaCaches;
	}
			
	
	
	public boolean visitouCache(Utilizadores user, Cache c) throws UtilizadorException, CacheException{ 
		if(!listaDeUtilizadores.containsKey(user.getEmail())){
			throw new UtilizadorException("O utilizador n„o existe!");
		}
		if(!listaDeCaches.containsKey(c.getN_registo())){
			throw new CacheException("A cache n„o existe!");
		}
		if(c.foiVisitada(user)) return true;
		else return false;
	}
	
	


	
	public ArrayList<Cache> getListaCachesInseridas(String email) throws UtilizadorException, CacheException{
		if(!listaDeUtilizadores.containsKey(email)){
			throw new UtilizadorException("O utilizador n„o existe!");
		}
		Utilizadores user= this.listaDeUtilizadores.get(email);
		ArrayList<Cache> listaCaches=new ArrayList<Cache>();
		for(String cache: user.getCachesInseridas().keySet()){
			if(this.listaDeCaches.containsKey(cache)){
				listaCaches.add(getCacheReferencia(cache));
			}			
		}
		return listaCaches;
	}
	
	
	
	public void desativaCache(Cache c) throws CacheException{
		c.setIsActiva(false);
	}
	
	
	
	public ArrayList<Utilizadores> getRedeAmigos(String email) throws UtilizadorException{
		if(!listaDeUtilizadores.containsKey(email)){
			throw new UtilizadorException("O utilizador n„o existe!");
		}
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Utilizadores> redeAmigos=new ArrayList<Utilizadores>();
		for(String amigo: user.getRedeAmigos()){
			Utilizadores friend= new Utilizadores();
			redeAmigos.add(friend.getAmigoNome(amigo));
		}
		return redeAmigos;
	}
	
	
	
	public void removeAmigo(String email, String nome) throws UtilizadorException{ 
		if(!listaDeUtilizadores.containsKey(email)){
			throw new UtilizadorException("O utilizador n„o existe!");
		}
		Utilizadores user=this.listaDeUtilizadores.get(email);
		for(String amigo: user.getRedeAmigos()){
			if(amigo==nome) user.removeAmigo(amigo);
		}
	}
	
	
	
	public ArrayList<Utilizadores> getListaAmigosPendentes(String email) throws UtilizadorException{
		if(!listaDeUtilizadores.containsKey(email)){
			throw new UtilizadorException("O utilizador n„o existe!");
		}
		Utilizadores user=this.listaDeUtilizadores.get(email);
		ArrayList<Utilizadores> listaAmigosPendentes= new ArrayList<Utilizadores>();
		for(String amigoPendente: user.getAmigosPendentes()){
			Utilizadores aux=new Utilizadores();
			listaAmigosPendentes.add(aux.getAmigoPendenteNome(amigoPendente));
		}
		return listaAmigosPendentes;
	}
	
	
	public void removeAmigoPendente(String email, String nome) throws UtilizadorException{ 
		if(!listaDeUtilizadores.containsKey(email)){
			throw new UtilizadorException("O utilizador n„o existe!"); 
		}
		Utilizadores user=this.listaDeUtilizadores.get(email);
		if(!listaDeUtilizadores.containsValue(user.getAmigoPendenteNome(nome))){
			throw new UtilizadorException("O utilizador que quer remover n„o existe!");
		}
		for(String amigo: user.getAmigosPendentes()){
			if(amigo==nome) user.removeAmigo(amigo);
		}
	}
	
	
	public void adicionaAmigo(String email, String nome) throws UtilizadorException{
		if(!listaDeUtilizadores.containsKey(email)){
			throw new UtilizadorException("O utilizador n„o existe!"); 
		}
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
	

	
	
}