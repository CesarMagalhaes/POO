import java.util.ArrayList;


/**
 * Escreva a descrição da classe Cache aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Cache extends MicroCache{
	
	
	// Vari�veis de inst�ncia -----------------------------------------------------------
	
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
		ArrayList<String> reg=c.getRegistos();
		int score=c.getScoreCache();
		String criad=c.getCriador();
	}
	
	
	public Cache(int numregisto, int lat, int longi, char pcard, ArrayList<String> reg, int score, String criad){
		this.n_registos=numregisto;
		this.latitude=lat;
		this.longitude=longi;
		this.pontocardeal=pcard;
		this.registos=reg;
		this.scoreCache=score;
		this.criador=criad;
	}
	
	public Cache(){
		this.n_registos=0;
		this.latitude=0;
		this.longitude=0;
		this.pontocardeal=' ';
		this.registos=null;
		this.scoreCache=0;
		this.criador="";
	}
	
	// Geters e Seteres ----------------------------------------------------------------
	
	public int getN_registos() {
		return n_registos;
	}
	public void setN_registos(int n_registos) {
		this.n_registos = n_registos;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public char getPontocardeal() {
		return pontocardeal;
	}
	public void setPontocardeal(char pontocardeal) {
		this.pontocardeal = pontocardeal;
	}
	public ArrayList<String> getRegistos() {
		return registos;
	}
	public void setRegistos(ArrayList<String> registos) {
		this.registos = registos;
	}
	public int getScoreCache() {
		return scoreCache;
	}
	public void setScoreCache(int scoreCache) {
		this.scoreCache = scoreCache;
	}
	public String getCriador() {
		return criador;
	}
	public void setCriador(String criador) {
		this.criador = criador;
	} 

	
	
}
