/**
 * Classe Utilizadores vai conter toda a informaÃ§Ã£oo sobre os utilizadores. Assim como os mÃ©todos que permitem ao utilizador adicionar, remover e actualizar amigos da rede de amigos,
 * criar caches ou desativar caches (as caches sÃ³ podem ser desativadas pelo criador), bem como descobrir caches, adicionando estas Ã  sua lista de caches descobertas.
 * 
 * @author CÃ©sar MagalhÃ£es, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Iterator;


public class Utilizadores{
   
	// Variï¿½veis de instÃ¢ncia -----------------------------------------------------------
	
	//notas: se as cache tem score, o utilizador havia de totar tipo uma pontuaï¿½ï¿½o total!!!
	private char genero;
    private String nome, email, password, morada; //email ï¿½ a chave do utilizador
    private GregorianCalendar dataNascimento;
    private ArrayList<String> actividades; // a lista de com a referênciacaches das caches que o utilizador descobriu
    private ArrayList<String> cachesInseridas; // a lista com a referência das caches que o utilizador inseriu
	private ArrayList<String> redeAmigos; //a lista com o nome dos amigos
	private ArrayList<String> amigosPendentes; //lista com o nome dos amigos que o utilizador ainda não aceitou na sua rede de amigos
	
	
	//Construtores-----------------------------------------------------------------------
	
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
	
	// Geters e Seters ------------------------------------------------------------------
	
	public char getGenero() { return genero; }
	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public String getMorada() { return morada; }
	public GregorianCalendar getDataNascimento() { return dataNascimento; }
	
	//Devolva todas as referências das caches descobertas pelo utilizador
	public ArrayList<String> getActividades(){
		ArrayList<String> copia= new ArrayList<String>();
		Iterator<String> i=this.actividades.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}
	
	//Devolve todas as caches inseridas pelo utilizador
	public ArrayList<String> getCachesInseridas(){
		ArrayList<String> copia= new ArrayList<String>();
		Iterator<String> i=this.cachesInseridas.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}

	
	//Devolve todos os amigos do utilizador -rede de amigos
	public ArrayList<String> getRedeAmigos(){
		ArrayList<String> copia=new ArrayList<String>();
		Iterator<String> i= this.redeAmigos.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}
	
	//Devolve todos os amigos que ainda não foram adicionados à rede de amigos
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
	
	
	//---------------------------------------------------------------------MÃ©todos de intÃ¢ncia----------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//Notas:
	//MÃ©todo que vai inserir Ã  lista de caches criadas pelo utilizador a referência da nova cache criada 
	//ver como se compara se a cache jÃ¡ tinha sido inserida => trata-se com uma excepção
	public void addCache(Cache c) throws CacheException{
		if(this.cachesInseridas.contains(c.getN_registo())){ //caso o utilizador esteja a adicionar uma cache criada que já exista
			throw new CacheException("A cache que quer inserir já existe!");
		}
		if(!this.cachesInseridas.contains(c.getN_registo())){
			this.cachesInseridas.add(c.getN_registo());
		}
	}
	
	
	//MÃ©todo que permite ao utilizador desativar uma cache criada por ele. Nota: se a cache nÃ£o foi criada pelo utilizador este nï¿½Ã£o a poderÃ¡ eliminar!
	//Assim, se a cache estiver na lista de caches inseridas pelo utilizador, basta passar a variÃ¡vel isActiva para falso. 
	public void desativaCache(Cache c) throws CacheException{
		if(!this.cachesInseridas.contains(c.getN_registo())){// caso o utilizador queira desativar uma cache que não exista
			throw new CacheException("A cache que quer desativar não existe!");
		}
		if(this.cachesInseridas.contains(c.getN_registo())){ 
			c.setIsActiva(false);
		}
	}
	
	//MÃ¡todo que vai adicionar um amigo (Nome deste) Ã  rede de amigos
	public void addAmigo(Utilizadores amigo) throws UtilizadorException{
		if (this.redeAmigos.contains(amigo.getEmail())) { //caso o utilizador queira adicionar um amigo que já exista
			throw new UtilizadorException("O utilizador que quer adicionar já existe!");
		}
		if(!this.redeAmigos.contains(amigo.getNome())){
			this.redeAmigos.add(amigo.getNome());
			amigo.addAmigo(this); //o utilizdor adicionou um amigo Ã  sua rede, logo este Ã© adicionado Ã  rede desse amigo
		}
	}
	
	//MÃ©todo que vai inserir na lista de caches descobertas mais uma referência de uma cache
	//ver como se compara se a cache jÃ¡ tinha sido inserida=> Trata-se com excepções
	public void addCacheDescoberta(Cache c) throws CacheException{
		if(this.cachesInseridas.contains(c.getN_registo())){// caso o utilizador queira adicionar às caches descobertas uma cache que já tenha encontrado
			throw new CacheException("A cache que pretende adicionar já foi descoberta!");
		}
		if(!this.actividades.contains(c.getN_registo())){
			this.actividades.add(c.getN_registo());
		}
		
	}
	
	
	/*
	//MÃ©todo que vai actualizar a rede e amigos, isto Ã©, se ouver alguma alteraÃ§Ã£o na informaÃ§Ã£o de um amigo, na rede (ArrayList), a info deste serÃ¡ substituida pela nova
		public void actualizaRedeAmigos(Utilizadores user){
			Utilizadores uti=new Utilizadores();
			boolean found=false;
			for(Utilizadores utilizador: this.redeAmigos){
				if(utilizador.getEmail().equals(user.getEmail())){
					uti=utilizador;
					found=true;
				}
			}
			if(found){
				this.redeAmigos.remove(uti);
				this.redeAmigos.add(user);
			}
		}
	*/
	
	//MÃ©todo que vai remover um amigo da rede de amigos, dado o nome do amigo que se quer remover
	public void removeAmigo(String amigo) throws UtilizadorException{
		if (!this.redeAmigos.contains(amigo)){ //caso o utilizador queira remover um amigo que não exista na sua rede
			throw new UtilizadorException("O utilizador que quer remover não existe!");
		}
		if(this.redeAmigos.contains(amigo)){
			this.redeAmigos.remove(amigo);
		}
	}
	
	
	//Método que actualiza a informação do utilizador
	public void modificaUtilizador(char genero, String nome, String email, String pass, String morada, GregorianCalendar dataNasc){
		this.genero=genero;
		this.nome=nome;
		this.email=email;
		this.password=pass;
		this.morada=morada;
		this.dataNascimento=dataNasc;
	}
	
	
	
	//Método que vai buscar um amigo pelo nome
	public Utilizadores getAmigoNome(String nome) throws UtilizadorException{
		if (!this.redeAmigos.contains(nome)) { //caso o utilizador queira consultar um amigo que não existe
			throw new UtilizadorException("O utilizador que quer não existe!");
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
	
	//Método que vai buscar um amigo pendente pelo nome
	public Utilizadores getAmigoPendenteNome(String nome) throws UtilizadorException{
		if(!this.amigosPendentes.contains(nome)){//caso o utilizador queira consultar um amigo pendende que não exista
			throw new UtilizadorException("O utilizador que quer não existe!");
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

	//MÃ©todo que vai remover um amigo da lista de amigos pendentes, dado o nome do amigo que se quer remover
		public void removeAmigoPendente(String amigo) throws UtilizadorException{
			if(this.amigosPendentes.contains(amigo)){
				this.amigosPendentes.remove(amigo);
			}else{
				throw new UtilizadorException("O utilizador que quer remover não existe!");//caso o utilizador queira remover um amigo pendente que não exista
			}
		}

	//Método que vai adicionar um amigo à lista de amigos pendentes
		public void addAmigoPendente(String nome) throws UtilizadorException{
			if(this.amigosPendentes.contains(nome)){
				throw new UtilizadorException("O utilizador que quer adicionar já existe!");//caso queira adicionar um amigo à lista de amigos pendentes que já exista
			}else{
				this.amigosPendentes.add(nome);
			}
		}
		

		
		
	//MÃ©todo que vai permitir ao utilizador consultar o histÃ³rico (EstatÃ­sticas)
	//public String consultaHistorico(){
		
	//}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Clone e toString e compareTo------------------------------------------------------------------------
	
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
		
	
	//Como comparaÃ§Ã£o estamos a considererar o email
	public int compareTo(Utilizadores u) {
		return u.getEmail().compareTo(this.getEmail());
	}
	
	
	//Equals e hascode--------------------------------------------------------------------------------
	//Este Ã© o gerado automÃ¡ticamente!!! alterer!!!!
	
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