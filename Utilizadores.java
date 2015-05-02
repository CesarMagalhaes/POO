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
    private String nome, email, password, morada;
    private GregorianCalendar dataNascimento;
    private ArrayList<Cache> actividades;
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
		ArrayList<Utilizadores> redeAmigos=u.getRedeAmigos();
	}
	
	
	public Utilizadores(char genero, String nome, String email, String pass, String morada, GregorianCalendar dataNasc, ArrayList<Cache> actividades, ArrayList<Utilizadores> redeAmigos){
		this.genero= genero;
		this.nome= nome;
		this.email= email;
		this.password= pass;
		this.morada= morada;
		this.dataNascimento= dataNasc;
		this.actividades= actividades;
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
	public ArrayList<Utilizadores> getRedeAmigos() { return redeAmigos; }
	
	public void setGenero(char genero) { this.genero = genero; }
	public void setNome(String nome) { this.nome = nome; }	
	public void setEmail(String email) { this.email = email; }	
	public void setPassword(String password) { this.password = password; }	
	public void setMorada(String morada) { this.morada = morada; }	
	public void setDataNascimento(GregorianCalendar dataNascimento) { this.dataNascimento = dataNascimento; }	
	public void setActividades(ArrayList<Cache> actividades) { this.actividades = actividades; }	
	public void setRedeAmigos(ArrayList<Utilizadores> redeAmigos) { this.redeAmigos = redeAmigos; }
	
	

	
	

    
    }