/**
 * Classe Cache, que para alï¿½m de conter a informaï¿½ï¿½o que a MicroCache tem, vai conte informaï¿½ï¿½o adicional.
 * Esta classe vai servir para descrever as caches no geral.
 * 
 * @author Cï¿½sar Magalhï¿½es, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */


import java.util.ArrayList;
import java.util.Iterator;


public class Cache{
	
	
	// Variï¿½veis de instï¿½ncia -----------------------------------------------------------
	
	private String n_registo;
	private int latitude, longitude;
	private char pontocardeal;
	private ArrayList<String> registos;
	private int scoreCache;
	private String criador;
	private boolean isActiva;
	private String dificuldade;
	
	
	//Construtores----------------------------------------------------------------------
	
	public Cache(Cache c){
		String numregisto=c.getN_registo();
		int lat=c.getLatitude();
		int longi=c.getLongitude();
		char pcard=c.getPontocardeal();
		ArrayList<String> reg=c.getRegistos();
		int score=c.getScoreCache();
		String criad=c.getCriador();
		boolean isActiva=c.getIsActiva();
		String dificuldade=c.getDificuldade();
	}
	
	
	public Cache(String numregisto, int lat, int longi, char pcard, ArrayList<String> reg, int score, String criad, boolean isActiva, String dificuldade){
		this.n_registo=numregisto;
		this.latitude=lat;
		this.longitude=longi;
		this.pontocardeal=pcard;
		this.registos=reg;
		this.scoreCache=score;
		this.criador=criad;
		this.isActiva=isActiva;
		this.dificuldade=dificuldade;
	}
	
	public Cache(){
		this.n_registo=" ";
		this.latitude=0;
		this.longitude=0;
		this.pontocardeal=' ';
		this.registos=new ArrayList<String>();
		this.scoreCache=0;
		this.criador=new String();
		this.isActiva=true;
		this.dificuldade=new String();
	}
	
	// Geters e Seteres ----------------------------------------------------------------
	
	public String getN_registo() { return n_registo; }
	public int getLatitude() { return latitude;	}
	public int getLongitude() { return longitude; }
	public char getPontocardeal() { return pontocardeal; }
	public ArrayList<String> getRegistos(){
		ArrayList<String> copia= new ArrayList<String>();
		Iterator<String> i=this.registos.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux.clone());
		}
		return copia;
    }
	//public ArrayList<String> getRegistos() { return registos; }
	public int getScoreCache() { return scoreCache; }
	public String getCriador() { return criador; }
	public boolean getIsActiva(){ return isActiva; }
	public String getDificuldade() { return dificuldade; }
	
	public void setN_registo(String n_registo) { this.n_registo = n_registo; }
	public void setLatitude(int latitude) { this.latitude = latitude; }	
	public void setLongitude(int longitude) { this.longitude = longitude; }	
	public void setPontocardeal(char pontocardeal) { this.pontocardeal = pontocardeal; }	
	
	public void setRegistos(ArrayList<String> registos){
		this.actividades= new ArrayList<Cache>();
		Iterator<Cache> i= actividades.iterator();
		while(i.hasNext()){
			Cache copia= i.next();
			this.actividades.add(copia.clone());
		}
	}
	//public void setRegistos(ArrayList<String> registos) { this.registos = registos; }	
	public void setScoreCache(int scoreCache) { this.scoreCache = scoreCache; }	
	public void setCriador(String criador) { this.criador = criador; } 
	public void setIsActiva(boolean isActiva) { this.isActiva=isActiva; }
	public void setDificuldade(String dificuldade) { this.dificuldade=dificuldade; }


	
	
	
	//---------------------------------------------------------------------Mï¿½todos de instï¿½ncia---------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//Mï¿½todo que vai buscar uma cache passando-lhe o nï¿½mero de registo
	//Fazer a excepï¿½ï¿½o para quando a cache nï¿½o existe
	public Cache getCacheReferencia(String n_registo){
		Cache cache= new Cache();
		if(this.getN_registo()==n_registo){
			cache.setN_registo(this.n_registo);
			cache.setLatitude(this.latitude);
			cache.setLongitude(this.longitude);
			cache.setPontocardeal(this.pontocardeal);
			cache.setRegistos(this.registos);
			cache.setScoreCache(this.scoreCache);
			cache.setCriador(this.criador);
			cache.setIsActiva(this.isActiva);
			cache.setDificuldade(this.dificuldade);
		}
		return cache;
	}
	

	
	//Clone e toString-------------------------------------------------------------------------
	
	public Cache clone(){
		return new Cache(this);
	}
	
	
	public String toString() {
		StringBuilder s=new StringBuilder();
		s.appende("----------------Cache--------------------");
		a.appende("Número de registo: "+this.n_registo+"\n");
		
		return s.toString();
		return "Cache [n_registo=" + n_registo + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", pontocardeal=" + pontocardeal
				+ ", registos=" + registos + ", scoreCache=" + scoreCache
				+ ", criador=" + criador + ", isActiva=" + isActiva
				+ ", dificuldade=" + dificuldade + "]";
	}
	
	

}
