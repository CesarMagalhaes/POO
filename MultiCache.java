/**
 *Classe MultiCache vai ter toda a informação relativa a uma multi-cache. É definida à custa de uma cache (uma vez que possui toda a informação de uma cache),
 *de uma lista de caches (ArrayList<Caches> - caches necessárias para determinar a cache final, podem ser caches de todos os tipos) e de uma micro-cache (a última
 *cache tem de ser necessáriamente uma micro-cache).
 *
 *Uma multicache só foi vista, quando todas as caches da sua lista tiverem sido visitadas.
 * 
 * @author César Magalhães, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.util.ArrayList;
import java.util.Iterator;


public class MultiCache extends Cache {
	
	
	// Variàveis de instância -----------------------------------------------------
	
	private Cache multi;
	private int totalCaches;
	private ArrayList<String> listaCaches; //a lista com a referência das caches que constituem a multicache
	private String conteudo;
	//private MicroCache micro; ->temos que pensar como aceder à micro (problemas de herança)
	
	
	//Construtores-------------------------------------------------------------------
	
	public MultiCache(MultiCache mc){
		Cache multi=mc.getMulti();
		int totalCaches=mc.getTotalCaches();
		ArrayList<String> listaCaches=mc.getListaCaches();
		String conteudo=mc.getConteudo();
		//MicroCache micro=mc.getMicro();
	}
	
	
	public MultiCache(Cache multi, int totalCaches, ArrayList<String> listaCaches,  String conteudo){
		this.multi= multi;
		this.totalCaches= totalCaches;
		this.listaCaches= listaCaches;
		this.conteudo=conteudo;
	}
	
	public MultiCache(Cache multi, int totalCaches, String conteudo){
		this.multi= multi;
		this.totalCaches= totalCaches;
		this.conteudo=conteudo;
	}
	
	
	public MultiCache(){
		this.multi= new Cache();
		this.totalCaches= 0;
		this.listaCaches= new ArrayList<String>();
		this.conteudo= new String();
		//this.micro= new MicroCache();
	}
	
	//Geteres e Seteres---------------------------------------------------------------
	public Cache getMulti() { return multi;	}
	public int getTotalCaches() { return totalCaches; }
	public ArrayList<String> getListaCaches() { 
		ArrayList<String> copia=new ArrayList<String>();
		Iterator<String> i= this.listaCaches.iterator();
		while(i.hasNext()){
			String aux=i.next();
			copia.add(aux);
		}
		return copia;
	}
	public String getConteudo() { return conteudo; }
	//ver este get!!!!!!!!!!!!!
	//public MicroCache getMicro() { return micro; }
	
	
	public void setMulti(Cache multi) { this.multi = multi; }
	public void setTotalCaches(int totalCaches) { this.totalCaches = totalCaches; }	
	public void setListaCaches(ArrayList<Cache> listaCaches) {
		this.listaCaches=new ArrayList<String>();
		Iterator<String> i=this.listaCaches.iterator();
		while(i.hasNext()){
			String copia=i.next();
			this.listaCaches.add(copia);
		}
	}
	public void setConteudo(String conteudo) { this.conteudo=conteudo; }
	//public void setMicro(MicroCache micro) { this.micro = micro; }	

	//---------------------------------------------------------------------------Métodos de Instância----------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Método que verifica se o utilizador passou por todas as caches que constituem a multicache =>ACABAR!!!!!!!!!!!!!!!!!!!!!
	public boolean verificaMulti(Utilizadores user) throws UtilizadorException{
		ArrayList<String> cachesEncontradas= new ArrayList<String>();
		cachesEncontradas=user.getActividades();
		for(String cache: this.getListaCaches()){
			if(!cachesEncontradas.contains(cache)) return true;
		}
		return false;
	}
	
	//Clone e toString e compareTo---------------------------------------------------------------
	
	public MultiCache clone(){
		return new MultiCache(this);
	}


	public String toString() {
		StringBuilder s=new StringBuilder();
		s.append("------------------Multi-Cache--------------------");
		s.append("Número de registo: " +this.multi.getN_registo()+ "\n");
		s.append("Latitude: "+this.multi.getLatitude()+ "\n");
		s.append("Longitude: "+this.multi.getLongitude()+ "\n");
		s.append("Ponto Cardeal: " +this.multi.getPontocardeal()+"\n");
		s.append("Criador: " +this.multi.getCriador()+ "\n");
		s.append("Dificuldade: "+this.multi.getDificuldade()+"\n");
		s.append("Número total de caches que fazem parte da multi-cache: "+this.totalCaches+"\n");
		s.append("Conteúdo: "+this.conteudo+"\n");
		return s.toString();
	}

	
	public int compareTo(MultiCache mc){
		return mc.getN_registo().compareTo(this.getN_registo());
	}
	
	//Equals e hashCode-------------------------------------------------------------------------
	
	public boolean equals(Object obj){
		if(this==obj) return true;
		if ((obj==null)||(this.getClass()!=obj.getClass())) return false;
		else{
			MultiCache other=(MultiCache) obj;
			return(this.multi.getN_registo().equals(other.getN_registo())
					&& this.multi.getLatitude()==(other.getLatitude())
					&& this.multi.getLongitude()==(other.getLongitude())
					&& this.multi.getPontocardeal()==(other.getPontocardeal())
					&& this.multi.getScoreCache()==(other.getScoreCache())
					&& this.multi.getCriador().equals(other.getCriador())
					&& this.multi.getIsActiva()==(other.getIsActiva())
					&& this.multi.getDificuldade().equals(other.getDificuldade())
					&& this.totalCaches==(other.getTotalCaches())
					&& this.conteudo.equals(other.getConteudo()));
		}
	}
	
}
