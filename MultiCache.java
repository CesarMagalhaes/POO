/**
 *Classe MultiCache vai ter toda a informação relativa a uma multi-cache. É definida à custa de uma cache (uma vez que possui toda a informação de uma cache),
 *de uma lista de caches (ArrayList<Caches> - caches necessárias para determinar a cache final, podem ser caches de todos os tipos) e de uma micro-cache (a última
 *cache tem de ser necessáriamente uma micro-cache).
 * 
 * @author César Magalhães, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.util.ArrayList;


public class MultiCache extends Cache {
	
	
	// Variàveis de instância -----------------------------------------------------
	
	private Cache multi;
	private int totalCaches;
	private ArrayList<Cache> listaCaches;
	//private MicroCache micro; ->temos que pensar como aceder à micro (problemas de herança)
	
	
	//Construtores-------------------------------------------------------------------
	
	public MultiCache(MultiCache mc){
		Cache multi=mc.getMulti();
		int totalCaches=mc.getTotalCaches();
		ArrayList<Cache> listaCaches=mc.getListaCaches();
		//MicroCache micro=mc.getMicro();
	}
	
	
	public MultiCache(Cache multi, int totalCaches, ArrayList<Cache> listaCaches, MicroCache micro){
		this.multi= multi;
		this.totalCaches= totalCaches;
		this.listaCaches= listaCaches;
		//this.micro= micro;
	}
	
	
	public MultiCache(){
		this.multi= new Cache();
		this.totalCaches= 0;
		this.listaCaches= new ArrayList<Cache>();
		//this.micro= new MicroCache();
	}
	
	//Geteres e Seteres---------------------------------------------------------------
	public Cache getMulti() { return multi;	}
	public int getTotalCaches() { return totalCaches; }
	public ArrayList<Cache> getListaCaches() { return listaCaches; }
	//ver este get!!!!!!!!!!!!!
	//public MicroCache getMicro() { return micro; }
	
	
	public void setMulti(Cache multi) { this.multi = multi; }
	public void setTotalCaches(int totalCaches) { this.totalCaches = totalCaches; }	
	public void setListaCaches(ArrayList<Cache> listaCaches) { this.listaCaches = listaCaches; }	
	//public void setMicro(MicroCache micro) { this.micro = micro; }	

	
	
   
 
}
