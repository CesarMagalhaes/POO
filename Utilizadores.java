
/**
 * Classe Utilizadores vai conter toda a informaçãoo sobre os utilizadores. Assim como os métodos que permitem ao utilizador adicionar, remover e actualizar amigos da rede de amigos,
 * criar caches ou desativar caches (as caches só podem ser desativadas pelo criador), bem como descobrir caches, adicionando estas à sua lista de caches descobertas, entre outros.
 * 
 * @author César Magalhães, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */


import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Utilizadores{
   

	// Variáveis de instância -----------------------------------------------------------
	
	//notas: se as cache tem score, o utilizador havia de totar tipo uma pontuao total!!!

	
	
	

	private char genero;
    private String nome, email, password, morada; 
    private GregorianCalendar dataNascimento;
    private HashMap<String, GregorianCalendar> actividades; // a lista de com a referênciacaches das caches que o utilizador descobriu e a data em que foram descobertas
    private HashMap<String, GregorianCalendar> cachesInseridas; // a lista com a refer�ncia das caches que o utilizador criou e a data em foram criadas
	private ArrayList<String> redeAmigos; //a lista com o nome dos amigos
	private ArrayList<String> amigosPendentes; //lista com o nome dos amigos que o utilizador ainda n�o aceitou na sua rede de amigos

	
	
	public Utilizadores(Utilizadores u){
		char genero=u.getGenero();
		String nome=u.getNome();
		String email=u.getEmail();
		String pass=u.getPassword();
		String morada=u.getMorada();
		GregorianCalendar dataNasc=u.getDataNascimento();
		HashMap<String, GregorianCalendar> actividades=u.getActividades();
		HashMap<String, GregorianCalendar> cachesInseridas=u.getCachesInseridas();
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
	
	public Utilizadores(char genero, String nome, HashMap<String, GregorianCalendar> actividades){;
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
		this.actividades= new HashMap<String, GregorianCalendar>();
		this.cachesInseridas= new HashMap<String, GregorianCalendar>();
		this.redeAmigos= new ArrayList<String>();
		this.amigosPendentes= new ArrayList<String>();
	}
	
	
	
	public char getGenero() { return genero; }
	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public String getMorada() { return morada; }
	public GregorianCalendar getDataNascimento() { return dataNascimento; }
	

	//Devolva todas as refer�ncias das caches descobertas pelo utilizador
	public HashMap<String, GregorianCalendar> getActividades(){ return actividades; }
		
		/**HashMap<String, GregorianCalendar> copia= new HashMap<String, GregorianCalendar>();
=======
	
	public ArrayList<String> getActividades(){
		ArrayList<String> copia= new ArrayList<String>();
>>>>>>> origin/master
		Iterator<String> i=this.actividades.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}
<<<<<<< HEAD
	*/
	//Devolve todas as caches inseridas pelo utilizador
	public HashMap<String, GregorianCalendar> getCachesInseridas(){ return cachesInseridas; }
		
		/**ArrayList<String> copia= new ArrayList<String>();
=======
	
	
	public ArrayList<String> getCachesInseridas(){
		ArrayList<String> copia= new ArrayList<String>();
>>>>>>> origin/master
		Iterator<String> i=this.cachesInseridas.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}
*/
	
	
	public ArrayList<String> getRedeAmigos(){
		ArrayList<String> copia=new ArrayList<String>();
		Iterator<String> i= this.redeAmigos.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}
	

	//Devolve todos os amigos que ainda n�o foram adicionados � rede de amigos
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
	
	public void setActividades(HashMap<String, GregorianCalendar> actividades){ this.actividades=actividades; }
		
		/**this.actividades= new ArrayList<String>();
		Iterator<String> i= actividades.iterator();
		while(i.hasNext()){
			String copia= i.next();
			this.actividades.add(copia);
		}
	}*/
	
	public void setCachesInseridas(HashMap<String, GregorianCalendar> cachesInseridas){ this.cachesInseridas=cachesInseridas; }
		
		/**this.cachesInseridas=new ArrayList<String>();
		Iterator<String> i= cachesInseridas.iterator();
		while(i.hasNext()){
			String copia= i.next();
			this.cachesInseridas.add(copia);
		}
	}
	*/
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
	
	
	
	

	//Notas:
	//Método que vai inserir à lista de caches criadas pelo utilizador a refer�ncia da nova cache criada 
	//ver como se compara se a cache já tinha sido inserida => trata-se com uma excep��o
	public void addCache(Cache c, GregorianCalendar data) throws CacheException{
		if(this.cachesInseridas.containsKey(c.getN_registo())){ //caso o utilizador esteja a adicionar uma cache criada que j� exista
			throw new CacheException("A cache que quer inserir j� existe! ");
		}
		if(!this.cachesInseridas.containsKey(c.getN_registo())){
			this.cachesInseridas.put(c.getN_registo(), data);
		}
	}
	
	
	
	
	public void desativaCache(Cache c) throws CacheException{
		if(!this.cachesInseridas.containsKey(c.getN_registo())){// caso o utilizador queira desativar uma cache que n�o exista
			throw new CacheException("A cache que quer desativar n�o existe!");
		}
		if(this.cachesInseridas.containsKey(c.getN_registo())){ 
			c.setIsActiva(false);
		}
	}
	

	
	
	public void addAmigo(Utilizadores amigo) throws UtilizadorException{
		if (this.redeAmigos.contains(amigo.getEmail())) { //caso o utilizador queira adicionar um amigo que j� exista
			throw new UtilizadorException("O utilizador que quer adicionar j� existe!");
		}
		if(!this.redeAmigos.contains(amigo.getNome())){
			this.redeAmigos.add(amigo.getNome());
			amigo.addAmigo(this); 
		}
	}
	

	//Método que vai inserir na lista de caches descobertas mais uma refer�ncia de uma cache
	//ver como se compara se a cache já tinha sido inserida=> Trata-se com excep��es
	public void addCacheDescoberta(Cache c, GregorianCalendar data) throws CacheException{
		if(this.cachesInseridas.containsKey(c.getN_registo())){// caso o utilizador queira adicionar �s caches descobertas uma cache que j� tenha encontrado
			throw new CacheException("A cache que pretende adicionar j� foi descoberta!");
		}
		if(!this.actividades.containsKey(c.getN_registo())){
			this.actividades.put(c.getN_registo(), data);
		}
		
	}
	
	
	
	
	
	public void removeAmigo(String amigo) throws UtilizadorException{
		if (!this.redeAmigos.contains(amigo)){ //caso o utilizador queira remover um amigo que n�o exista na sua rede
			throw new UtilizadorException("O utilizador que quer remover n�o existe!");
		}
		if(this.redeAmigos.contains(amigo)){
			this.redeAmigos.remove(amigo);
		}
	}
	
	
	//M�todo que actualiza a informa��o do utilizador
	public void modificaUtilizador(char genero, String nome, String pass, String morada, GregorianCalendar dataNasc){
		this.genero=genero;
		this.nome=nome;
		this.password=pass;
		this.morada=morada;
		this.dataNascimento=dataNasc;
	}
	
	

	//M�todo que vai buscar um amigo pelo nome
	public Utilizadores getAmigoNome(String nome) throws UtilizadorException{
		if (!this.redeAmigos.contains(nome)) { //caso o utilizador queira consultar um amigo que n�o existe
			throw new UtilizadorException("O utilizador que quer n�o existe!");
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
	

	//M�todo que vai buscar um amigo pendente pelo nome
	public Utilizadores getAmigoPendenteNome(String nome) throws UtilizadorException{
		if(!this.amigosPendentes.contains(nome)){//caso o utilizador queira consultar um amigo pendende que n�o exista
			throw new UtilizadorException("O utilizador que quer n�o existe!");
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
				throw new UtilizadorException("O utilizador que quer remover n�o existe!");//caso o utilizador queira remover um amigo pendente que n�o exista
			}
		}

		
	//M�todo que vai adicionar um amigo � lista de amigos pendentes
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