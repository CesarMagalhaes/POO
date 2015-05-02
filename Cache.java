/**
 * Classe Cache, que para além de conter a informação que a MicroCache tem, vai conte informação adicional.
 * Esta classe vai servir para descrever as caches no geral.
 * 
 * @author César Magalhães, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */


import java.util.ArrayList;


public class Cache extends MicroCache{
	
	
	// Variáveis de instância -----------------------------------------------------------
	
	private int n_registos;
	private int latitude, longitude;
	private char pontocardeal;
	private ArrayList<String> registos;
	private int scoreCache;
	private String criador;
	
	
	//Construtores----------------------------------------------------------------------
	
	public Cache(Cache c){
		int numregisto=c.getN_registos();
		int lat=c.getLatitude();
		int longi=c.getLongitude();
		char pcard=c.getPontocardeal();
	//	ArrayList<String> reg=c.getRegistos();
		int score=c.getScoreCache();
		String criad=c.getCriador();
	}
	
	
	public Cache(int numregisto, int lat, int longi, char pcard, ArrayList<String> reg, int score, String criad){
		this.n_registos=numregisto;
		this.latitude=lat;
		this.longitude=longi;
		this.pontocardeal=pcard;
	//	this.registos=reg;
		this.scoreCache=score;
		this.criador=criad;
	}
	
	public Cache(){
		this.n_registos=0;
		this.latitude=0;
		this.longitude=0;
		this.pontocardeal=' ';
	//	this.registos=new ArrayList<String>();
		this.scoreCache=0;
		this.criador=new String();
	}
	
	// Geters e Seteres ----------------------------------------------------------------
	
	public int getN_registos() { return n_registos; }
	public int getLatitude() { return latitude;	}
	public int getLongitude() { return longitude; }
	public char getPontocardeal() { return pontocardeal; }
	//public ArrayList<String> getRegistos() { return registos; }
	public int getScoreCache() { return scoreCache; }
	public String getCriador() { return criador; }
	
	public void setN_registos(int n_registos) { this.n_registos = n_registos; }
	public void setLatitude(int latitude) { this.latitude = latitude; }	
	public void setLongitude(int longitude) { this.longitude = longitude; }	
	public void setPontocardeal(char pontocardeal) { this.pontocardeal = pontocardeal; }	
	//public void setRegistos(ArrayList<String> registos) { this.registos = registos; }	
	public void setScoreCache(int scoreCache) { this.scoreCache = scoreCache; }	
	public void setCriador(String criador) { this.criador = criador; } 

	
	
}
