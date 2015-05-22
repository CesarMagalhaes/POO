/**
 * Classe Cache, que para al�m de conter a informa��o que a MicroCache tem, vai conte informa��o adicional.
 * Esta classe vai servir para descrever as caches no geral.
 * 
 * @author C�sar Magalh�es, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */


import java.util.ArrayList;
import java.util.Iterator;


public class Cache{
	
	
	// Vari�veis de inst�ncia -----------------------------------------------------------
	
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
	
	public Cache(String numregisto, int lat, int longi, char pcard, int score, String criad, boolean isActiva, String dificuldade){
		this.n_registo=numregisto;
		this.latitude=lat;
		this.longitude=longi;
		this.pontocardeal=pcard;
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
			copia.add(aux);
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
		this.registos= new ArrayList<String>();
		Iterator<String> i= registos.iterator();
		while(i.hasNext()){
			String copia= i.next();
			this.registos.add(copia);
		}
	}
	//public void setRegistos(ArrayList<String> registos) { this.registos = registos; }	
	public void setScoreCache(int scoreCache) { this.scoreCache = scoreCache; }	
	public void setCriador(String criador) { this.criador = criador; } 
	public void setIsActiva(boolean isActiva) { this.isActiva=isActiva; }
	public void setDificuldade(String dificuldade) { this.dificuldade=dificuldade; }


	
	
	
	//---------------------------------------------------------------------M�todos de inst�ncia---------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//M�todo que vai buscar uma cache passando-lhe o n�mero de registo
	//Fazer a excep��o para quando a cache n�o existe
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
	

	
	//Clone e toString e compareTo -----------------------------------------------------------------
	
	public Cache clone(){
		return new Cache(this);
	}
	
	
	public String toString() {
		StringBuilder s=new StringBuilder();
		s.append("----------------Cache--------------------");
		s.append("N�mero de registo: " +this.n_registo+ "\n");
		s.append("Latitude: "+this.latitude+ "\n");
		s.append("Longitude: "+this.longitude+ "\n");
		s.append("Ponto Cardeal: " +this.pontocardeal+"\n");
		s.append("Criador: " +this.criador+ "\n");
		s.append("Dificuldade: "+this.dificuldade+"\n");
		return s.toString();
	}

	
	public int compareTo(Cache c){
		return c.getN_registo().compareTo(this.n_registo);
	}
	
	//Equals e hashCode-------------------------------------------------------------------------
	
	public boolean equals(Object obj){
		if(this==obj) return true;
		if ((obj==null)||(this.getClass()!=obj.getClass())) return false;
		else{
			Cache other=(Cache) obj;
			return(this.n_registo.equals(other.getN_registo())
					&& this.latitude==(other.getLatitude())
					&& this.longitude==(other.getLongitude())
					&& this.pontocardeal==(other.getPontocardeal())
					&& this.scoreCache==(other.getScoreCache())
					&& this.criador.equals(other.getCriador())
					&& this.isActiva==(other.getIsActiva())
					&& this.dificuldade.equals(other.getDificuldade()));
		}
	}
	
	

}
