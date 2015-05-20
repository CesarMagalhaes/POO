/**
 * Classe Utilizadores vai conter toda a informa��o sobre os utilizadores. Assim como os m�todos que permitem ao utilizador adicionar, remover e actualizar amigos da rede de amigos,
 * criar caches ou desativar caches (as caches s� podem ser desativadas pelo criador), bem como descobrir caches, adicionando estas � sua lista de caches descobertas.
 * 
 * @author C�sar Magalh�es, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Iterator;


public class Utilizadores extends Cache{
   
	// Vari�veis de inst�ncia -----------------------------------------------------------
	
	
	//notas: se as cache stem score, o utilizador havia de totar tipo uma pontua��o total!!!
	private char genero;
    private String nome, email, password, morada; //email � a chave do utilizador
    private GregorianCalendar dataNascimento;
    private ArrayList<Cache> actividades; // a lista de caches que o utilizador descobriu
    private ArrayList<Cache> cachesInseridas; // a lista das caches que o utilizador inseriu
	private ArrayList<Utilizadores> redeAmigos;
	
	
	//Construtores-----------------------------------------------------------------------
	
	public Utilizadores(Utilizadores u){
		char genero=u.getGenero();
		String nome=u.getNome();
		String email=u.getEmail();
		String pass=u.getPassword();
		String morada=u.getMorada();
		GregorianCalendar dataNasc=u.getDataNascimento();
		ArrayList<Cache> actividades=u.getActividades();
		ArrayList<Cache> cachesInseridasArrayList=u.getCachesInseridas();
		ArrayList<Utilizadores> redeAmigos=u.getRedeAmigos();
	}
	
	
	public Utilizadores(char genero, String nome, String email, String pass, String morada, GregorianCalendar dataNasc, ArrayList<Cache> actividades, ArrayList<Cache> cachesInseridas, ArrayList<Utilizadores> redeAmigos){
		this.genero= genero;
		this.nome= nome;
		this.email= email;
		this.password= pass;
		this.morada= morada;
		this.dataNascimento= dataNasc;
		this.actividades= actividades;
		this.cachesInseridas=cachesInseridas;
		this.redeAmigos= redeAmigos;
	}
		
	public Utilizadores(String nome, String email, String morada){;
		this.nome= nome;
		this.email= email;
		this.morada= morada;
	}
	
	public Utilizadores(){
		this.genero= ' ';
		this.nome= new String();
		this.email= new String();
		this.password= new String();
		this.morada= new String();
		this.dataNascimento= new GregorianCalendar();
		this.actividades= new ArrayList<Cache>();
		this.cachesInseridas= new ArrayList<Cache>();
		this.redeAmigos= new ArrayList<Utilizadores>();
	}
	
	// Geters e Seters ------------------------------------------------------------------
	
	public char getGenero() { return genero; }
	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public String getMorada() { return morada; }
	public GregorianCalendar getDataNascimento() { return dataNascimento; }
	//Devolva todas as caches descobertas pelo utilizador
	public ArrayList<Cache> getActividades(){
		ArrayList<Cache> copia= new ArrayList<Cache>();
		Iterator<Cache> i=this.actividades.iterator();
		while(i.hasNext()){
			Cache aux=i.next();
			copia.add(aux.clone());
		}
		return copia;
	}
	//public ArrayList<Cache> getActividades() { return actividades; }
	
	//Devolve todas as caches inseridas pelo utilizador
	public ArrayList<Cache> getCachesInseridas(){
		ArrayList<Cache> copia= new ArrayList<Cache>();
		Iterator<Cache> i=this.cachesInseridas.iterator();
		while(i.hasNext()){
			Cache aux=i.next();
			copia.add(aux.clone());
		}
		return copia;
	}
	//public ArrayList<Cache> getCachesInseridas(){ return cachesInseridas; }
	
	//Devolve todos os amigos do utilizador -rede de amigos
	public ArrayList<Utilizadores> getRedeAmigos(){
		ArrayList<Utilizadores> copia=new ArrayList<Utilizadores>();
		Iterator<Utilizadores> i= this.redeAmigos.iterator();
		while(i.hasNext()){
			Utilizadores aux=i.next();
			copia.add(aux.clone());
		}
		return copia;
	}
	//public ArrayList<Utilizadores> getRedeAmigos() { return redeAmigos; }
	
	public void setGenero(char genero) { this.genero = genero; }
	public void setNome(String nome) { this.nome = nome; }	
	public void setEmail(String email) { this.email = email; }	
	public void setPassword(String password) { this.password = password; }	
	public void setMorada(String morada) { this.morada = morada; }	
	public void setDataNascimento(GregorianCalendar dataNascimento) { this.dataNascimento = dataNascimento; }	
	
	public void setActividades(ArrayList<Cache> actividades){
		this.actividades= new ArrayList<Cache>();
		Iterator<Cache> i= actividades.iterator();
		while(i.hasNext()){
			Cache copia= i.next();
			this.actividades.add(copia.clone());
		}
	}
	//public void setActividades(ArrayList<Cache> actividades) { this.actividades = actividades; }
	
	public void setCachesInseridas(ArrayList<Cache> cachesInseridas){
		this.cachesInseridas=new ArrayList<Cache>();
		Iterator<Cache> i= cachesInseridas.iterator();
		while(i.hasNext()){
			Cache copia= i.next();
			this.cachesInseridas.add(copia.clone());
		}
	}
	//public void setCachesInseridas(ArrayList<Cache> cachesInseridas) { this.cachesInseridas=cachesInseridas; }
	
	public void setRedeAmigos(ArrayList<Utilizadores> redeAmigos){
		this.redeAmigos= new ArrayList<Utilizadores>();
		Iterator<Utilizadores> i= redeAmigos.iterator();
		while(i.hasNext()){
			Utilizadores copia= i.next();
			this.redeAmigos.add(copia.clone());
		}
	}
	//public void setRedeAmigos(ArrayList<Utilizadores> redeAmigos) { this.redeAmigos = redeAmigos; }
	

	
	
	//---------------------------------------------------------------------M�todos de int�ncia----------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//M�todp que vai inserir � lista de caches criadas pelo utilizador uma noca cache caso esta n�o tenha sido j� criada
	//ver como se compara se a cache j� tinha sido inserida
	public void addCache(Cache c){
		if(!this.cachesInseridas.contains(c)){
			this.cachesInseridas.add(c.clone());
		}
	}
	
	
	//M�todo que permite ao utilizador desativar uma cache criada por ele. Nota: se a cache n�o foi criada pelo utilizador este n�o a poder� eliminar!
	//Assim, se a cache estiver na lista de caches inseridas pelo utilizador, basta passar a vari�vel isActiva para falso. 
	public void desativaCache(Cache c){
		if(this.cachesInseridas.contains(c)){
			c.setIsActiva(false);
		}
	}
	
	//M�todo que vai adicionar um amigo � rede de amigos, caso este n�o se encontre j� na rede de amigos
	public void addAmigo(Utilizadores amigo){
		if(!this.redeAmigos.contains(amigo)){
			this.redeAmigos.add(amigo.clone());
			amigo.addAmigo(this); //o utilizdor adicionou um amigo � sua rede, logo este � adicionado � rede desse amigo
		}
	}
	
	//M�todo que vai inserir na lista de caches descobertas mais uma cache, caso esta ainda n�o tenha sido descoberta pelo utilizador
	//ver como se compara se a cache j� tinha sido inserida
	public void addCacheDescoberta(Cache c){
		if(!this.actividades.contains(c)){
			this.actividades.add(c.clone());
		}
		
	}
	
	
	//M�todo que vai actualizar a rede e amigos, isto �, se ouver alguma altera��o na informa��o de um amigo, na rede (ArrayList), a info deste ser� substituida pela nova
	public void ActualizarRedeAmigos(Utilizadores amigo) {
		Utilizadores aux = new Utilizadores();
		boolean found = false;
		for (Utilizadores user : this.redeAmigos) {
			if (user.getEmail().equals(amigo.getEmail())) {
				aux = user;
				found = true;
			}
		}
		if (found) {
			this.redeAmigos.remove(aux);
			this.redeAmigos.add(amigo);

		}
	}

	
	//M�todo que vai remover um amigo da rede de amigos
	public void removeAmigo(Utilizadores amigo){
		if(this.redeAmigos.contains(amigo)){
			this.redeAmigos.remove(amigo);
		}
	}
	
	
	//M�todo que vai permitir ao utilizador consultar o hist�rico (Estat�sticas)
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
		
	
	//Como compara��o estamos a considererar o email
	public int compareTo(Utilizadores u) {
		return u.getEmail().compareTo(this.getEmail());
	}
	
	
	//Equals e hascode--------------------------------------------------------------------------------
	//Este � o gerado autom�ticamente!!! alterer!!!!
	
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