
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Iterator;


public class Utilizadores{
   
	
	
	
	private char genero;
    private String nome, email, password, morada; 
    private GregorianCalendar dataNascimento;
    private ArrayList<String> actividades; 
    private ArrayList<String> cachesInseridas; 
	private ArrayList<String> redeAmigos; 
	private ArrayList<String> amigosPendentes; 
	
	
	
	
	public Utilizadores(Utilizadores u){
		char genero=u.getGenero();
		String nome=u.getNome();
		String email=u.getEmail();
		String pass=u.getPassword();
		String morada=u.getMorada();
		GregorianCalendar dataNasc=u.getDataNascimento();
		ArrayList<String> actividades=u.getActividades();
		ArrayList<String> cachesInseridas=u.getCachesInseridas();
		ArrayList<String> redeAmigos=u.getRedeAmigos();
		ArrayList<String> amigosPendentes=u.getAmigosPendentes();
	}
	
	
	public Utilizadores(char genero, String nome, String email, String pass, String morada, GregorianCalendar dataNasc){
		this.genero= genero;
		this.nome= nome;
		this.email= email;
		this.password= pass;
		this.morada= morada;
		this.dataNascimento= dataNasc;
	}
		
	
	public Utilizadores(char genero, String nome, String email, String pass){
		this.genero= genero;
		this.nome= nome;
		this.email= email;
		this.password= pass;
	}
	
	public Utilizadores(char genero, String nome, ArrayList<String> actividades){;
		this.genero=genero;
		this.nome= nome;
		this.actividades=actividades;
	}
	
	public Utilizadores(){
		this.genero= ' ';
		this.nome= new String();
		this.email= new String();
		this.password= new String();
		this.morada= new String();
		this.dataNascimento= new GregorianCalendar();
		this.actividades= new ArrayList<String>();
		this.cachesInseridas= new ArrayList<String>();
		this.redeAmigos= new ArrayList<String>();
		this.amigosPendentes= new ArrayList<String>();
	}
	
	
	
	public char getGenero() { return genero; }
	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public String getMorada() { return morada; }
	public GregorianCalendar getDataNascimento() { return dataNascimento; }
	
	
	public ArrayList<String> getActividades(){
		ArrayList<String> copia= new ArrayList<String>();
		Iterator<String> i=this.actividades.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}
	
	
	public ArrayList<String> getCachesInseridas(){
		ArrayList<String> copia= new ArrayList<String>();
		Iterator<String> i=this.cachesInseridas.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}

	
	
	public ArrayList<String> getRedeAmigos(){
		ArrayList<String> copia=new ArrayList<String>();
		Iterator<String> i= this.redeAmigos.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}
	
	
	public ArrayList<String> getAmigosPendentes(){
		ArrayList<String> copia=new ArrayList<String>();
		Iterator<String> i=this.amigosPendentes.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}
	
	
	public void setGenero(char genero) { this.genero = genero; }
	public void setNome(String nome) { this.nome = nome; }	
	public void setEmail(String email) { this.email = email; }	
	public void setPassword(String password) { this.password = password; }	
	public void setMorada(String morada) { this.morada = morada; }	
	public void setDataNascimento(GregorianCalendar dataNascimento) { this.dataNascimento = dataNascimento; }	
	
	public void setActividades(ArrayList<String> actividades){
		this.actividades= new ArrayList<String>();
		Iterator<String> i= actividades.iterator();
		while(i.hasNext()){
			String copia= i.next();
			this.actividades.add(copia);
		}
	}
	
	public void setCachesInseridas(ArrayList<String> cachesInseridas){
		this.cachesInseridas=new ArrayList<String>();
		Iterator<String> i= cachesInseridas.iterator();
		while(i.hasNext()){
			String copia= i.next();
			this.cachesInseridas.add(copia);
		}
	}
	
	public void setRedeAmigos(ArrayList<String> redeAmigos){
		this.redeAmigos= new ArrayList<String>();
		Iterator<String> i= redeAmigos.iterator();
		while(i.hasNext()){
			String copia= i.next();
			this.redeAmigos.add(copia);
		}
	}
	
	public void setAmigosPendentes(ArrayList<String> amigosPendentes){
		this.amigosPendentes=new ArrayList<String>();
		Iterator<String> i=amigosPendentes.iterator();
		while(i.hasNext()){
			String copia=i.next();
			this.amigosPendentes.add(copia);
		}
	}
	
	
	
	
	
	
	
	
	
	public void addCache(Cache c) throws CacheException{
		if(this.cachesInseridas.contains(c.getN_registo())){ 
			throw new CacheException("A cache que quer inserir n„o existe! ");
		}
		if(!this.cachesInseridas.contains(c.getN_registo())){


		}
	}
	
	
	
	
	public void desativaCache(Cache c) throws CacheException{
		if(!this.cachesInseridas.contains(c.getN_registo())){
			throw new CacheException("A cache que quer desativar n„o existe!");
		}
		if(this.cachesInseridas.contains(c.getN_registo())){ 
			c.setIsActiva(false);
		}
	}
	

	
	
	public void addAmigo(Utilizadores amigo) throws UtilizadorException{
		if (this.redeAmigos.contains(amigo.getEmail())) { 
			throw new UtilizadorException("O utilizador que quer adicionar j· existe!");
		}
		if(!this.redeAmigos.contains(amigo.getNome())){
			this.redeAmigos.add(amigo.getNome());
			amigo.addAmigo(this); 
		}
	}
	
	
	
	public void addCacheDescoberta(Cache c) throws CacheException{
		if(this.cachesInseridas.contains(c.getN_registo())){
			throw new CacheException("A cache que pretende adicionar j· foi descoberta!");
		}
		if(!this.actividades.contains(c.getN_registo())){
			this.actividades.add(c.getN_registo());
		}
		
	}
	
	
	
	
	
	public void removeAmigo(String amigo) throws UtilizadorException{
		if (!this.redeAmigos.contains(amigo)){ 
			throw new UtilizadorException("O utilizador que quer remover n„o existe!");
		}
		if(this.redeAmigos.contains(amigo)){
			this.redeAmigos.remove(amigo);
		}
	}
	
	
	
	public void modificaUtilizador(char genero, String nome, String pass, String morada, GregorianCalendar dataNasc){
		this.genero=genero;
		this.nome=nome;
		this.password=pass;
		this.morada=morada;
		this.dataNascimento=dataNasc;
	}
	
	
	
	
	public Utilizadores getAmigoNome(String nome) throws UtilizadorException{
		if (!this.redeAmigos.contains(nome)) { 
			throw new UtilizadorException("O utilizador que quer n„o existe!");
		}
		Utilizadores amigo=new Utilizadores();
		for(String friend: this.getRedeAmigos()){
			if(friend==nome){
				amigo.setGenero(this.genero);
				amigo.setNome(this.nome);
				amigo.setActividades(this.actividades);

			}
		}
		return amigo;
	}
	
	
	public Utilizadores getAmigoPendenteNome(String nome) throws UtilizadorException{
		if(!this.amigosPendentes.contains(nome)){
			throw new UtilizadorException("O utilizador que quer n„o existe!");
		}
		Utilizadores amigo=new Utilizadores();
		for(String friend: this.getAmigosPendentes()){
			if(friend==nome){
				amigo.setGenero(this.genero);
				amigo.setNome(this.nome);
				amigo.setActividades(this.actividades);

			}
		}
		return amigo;
	}

	
		public void removeAmigoPendente(String amigo) throws UtilizadorException{
			if(this.amigosPendentes.contains(amigo)){
				this.amigosPendentes.remove(amigo);
			}else{
				throw new UtilizadorException("O utilizador que quer remover n„o existe!");
			}
		}

	
		public void addAmigoPendente(String nome) throws UtilizadorException{
			if(this.amigosPendentes.contains(nome)){
				throw new UtilizadorException("O utilizador que quer adicionar j· existe!");
			}else{
				this.amigosPendentes.add(nome);
			}
		}
		

		
		
	
	
		
	
	
	
	
	
	
	
	
	public Utilizadores clone(){
		return new Utilizadores(this);
	}


	public String toString() {
		StringBuilder s= new StringBuilder();
		s.append("----------------Utilizador-----------------------");
		s.append("Nome: "+this.nome+ "\n");
		s.append("Email: "+ this.email+ "\n");
		s.append("Genero: "+this.genero+ "\n");
		s.append("Data de Nascimento: "+this.dataNascimento+"\n");
		s.append("Morada: "+this.morada+"\n");
		return s.toString();
	}	
		
	
	
	public int compareTo(Utilizadores u) {
		return u.getEmail().compareTo(this.getEmail());
	}
	
	
	
	
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actividades == null) ? 0 : actividades.hashCode());
		result = prime * result
				+ ((cachesInseridas == null) ? 0 : cachesInseridas.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + genero;
		result = prime * result + ((morada == null) ? 0 : morada.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((redeAmigos == null) ? 0 : redeAmigos.hashCode());
		return result;
	}


	

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null)|| (this.getClass() != obj.getClass()))
			return false;
		else{
			Utilizadores other = (Utilizadores) obj;
			return (this.dataNascimento.equals(other.getDataNascimento()) 
					&& this.email.equals(other.getEmail())
					&& this.genero==(other.getGenero())
					&& this.morada.equals(other.getMorada())
					&& this.nome.equals(other.getNome())
					&& this.password.equals(other.getPassword()));
		}
	}
	

    
    }