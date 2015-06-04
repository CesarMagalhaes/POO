/**
 * 
 * Classe abstrata Cache,tem a informação básica que uma cache vai ter, bem como o método que vê se uma cache foi visitada.
 * Esta classe vai servir para descrever as caches no geral.
 * 
 * @author César Magalhães, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;


public abstract class Cache implements Serializable{
	
	
	// Variáveis de instância -----------------------------------------------------------

	private String n_registo;
	private int latitude, longitude;
	private char pontocardeal;
	private ArrayList<String> registos;// nome dos utilizadores que visitaram a cache
	private int scoreCache;
	private String criador;
	private boolean isActiva;
	private String dificuldade;
	private GregorianCalendar dataCriacao;
	
	
	/**
<<<<<<< HEAD
	//Construtores---------------------------------------------------------------------- como é abstrata não tem
=======
	//Construtores---------------------------------------------------------------------- como � abstrata n�o tem
>>>>>>> origin/master
	
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
		GregorianCalendar data=c.getDataCriacao();
	}
	
	
	public Cache(String numregisto, int lat, int longi, char pcard, ArrayList<String> reg, int score, String criad, boolean isActiva, String dificuldade, GregorianCalendar data){
		this.n_registo=numregisto;
		this.latitude=lat;
		this.longitude=longi;
		this.pontocardeal=pcard;
		this.registos=reg;
		this.scoreCache=score;
		this.criador=criad;
		this.isActiva=isActiva;
		this.dificuldade=dificuldade;
		this.dataCriacao=data;
	}
	
	public Cache(String numregisto, String criad){
		this.n_registo=numregisto;
		this.criador=criad;
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
		this.dataCriacao=new GregorianCalendar();
	}
	*/
	
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
	public GregorianCalendar getDataCriacao(){ return dataCriacao; }
	
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
	public void setDataCriacao(GregorianCalendar data) { this.dataCriacao=data; }

	
	
	
	//---------------------------------------------------------------------Métodos de instância---------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
<<<<<<< HEAD
	/** Este método faz mais sentido estar no geocachingAdmin
	//Método que vai buscar uma cache passando-lhe o número de registo
	//Fazer a excepção para quando a cache não existe
=======
	/** Este m�todo faz mais sentido estar no geocachingAdmin
	//M�todo que vai buscar uma cache passando-lhe o n�mero de registo
	//Fazer a excep��o para quando a cache n�o existe
>>>>>>> origin/master
	public Cache getCacheReferencia(String n_registo) throws CacheException{
		if(!this.getRegistos().contains(n_registo)){
			throw new CacheException();
		}
		Cache cache= new Cache();
		if(this.getN_registo().contains(n_registo)){
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
	
*/
<<<<<<< HEAD
	//Método que, dado um utilizador, verifica se visitou a cache
=======
	//M�todo que, dado um utilizador, verifica se visitou a cache
>>>>>>> origin/master
	public boolean foiVisitada(Utilizadores user) throws UtilizadorException{
		if(this.registos.contains(user.getNome())) return true;
		else return false;
	}
	
<<<<<<< HEAD
=======
	//acrescentar m�todos que mostrem como as caches s�o visitadas
>>>>>>> origin/master
	
	//Clone e toString e compareTo -----------------------------------------------------------------
	
	/**public Cache clone(){
		return new Cache(this);
	}
	*/
	
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
