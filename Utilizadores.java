/**
 * Classe Utilizadores vai conter toda a informação sobre os utilizadores.
 * 
 * @author César Magalhães, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.util.GregorianCalendar;
import java.util.ArrayList;


public class Utilizadores extends Cache{
   
	// Variáveis de instância -----------------------------------------------------------
	
	private char genero;
    private String nome, email, password, morada; //email é a chave do utilizador
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
	public ArrayList<Cache> getActividades() { return actividades; }
	public ArrayList<Cache> getCachesInseridas(){ return cachesInseridas; }
	public ArrayList<Utilizadores> getRedeAmigos() { return redeAmigos; }
	
	public void setGenero(char genero) { this.genero = genero; }
	public void setNome(String nome) { this.nome = nome; }	
	public void setEmail(String email) { this.email = email; }	
	public void setPassword(String password) { this.password = password; }	
	public void setMorada(String morada) { this.morada = morada; }	
	public void setDataNascimento(GregorianCalendar dataNascimento) { this.dataNascimento = dataNascimento; }	
	public void setActividades(ArrayList<Cache> actividades) { this.actividades = actividades; }
	public void setCachesInseridas(ArrayList<Cache> cachesInseridas) { this.cachesInseridas=cachesInseridas; }
	public void setRedeAmigos(ArrayList<Utilizadores> redeAmigos) { this.redeAmigos = redeAmigos; }
	
	
	//Clone e toString---------------------------------------------------------------------------------
	
	public Utilizadores clone(){
		return new Utilizadores(this);
	}


	public String toString() {
		return	"Utilizadores [genero=" + genero + ", nome=" + nome + ", email="
				+ email + ", password=" + password + ", morada=" + morada
				+ ", dataNascimento=" + dataNascimento + ", actividades="
				+ actividades + ", cachesInseridas=" + cachesInseridas
				+ ", redeAmigos=" + redeAmigos + "]";
	}


	//Equals e hascode--------------------------------------------------------------------------------
	
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilizadores other = (Utilizadores) obj;
		if (actividades == null) {
			if (other.actividades != null)
				return false;
		} else if (!actividades.equals(other.actividades))
			return false;
		if (cachesInseridas == null) {
			if (other.cachesInseridas != null)
				return false;
		} else if (!cachesInseridas.equals(other.cachesInseridas))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (genero != other.genero)
			return false;
		if (morada == null) {
			if (other.morada != null)
				return false;
		} else if (!morada.equals(other.morada))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (redeAmigos == null) {
			if (other.redeAmigos != null)
				return false;
		} else if (!redeAmigos.equals(other.redeAmigos))
			return false;
		return true;
	}
	
	
	
	
	
	
	

    
    }