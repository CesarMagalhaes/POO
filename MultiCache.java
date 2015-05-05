/**
 *Classe MultiCache vai ter toda a informa��o relativa a uma multi-cache. � definida � custa de uma cache (uma vez que possui toda a informa��o de uma cache),
 *de uma lista de caches (ArrayList<Caches> - caches necess�rias para determinar a cache final, podem ser caches de todos os tipos) e de uma micro-cache (a �ltima
 *cache tem de ser necess�riamente uma micro-cache).
 * 
 * @author C�sar Magalh�es, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.util.ArrayList;


public class MultiCache extends Cache {
	
	
	// Vari�veis de inst�ncia -----------------------------------------------------
	
	private Cache multi;
	private int totalCaches;
	private ArrayList<Cache> listaCaches;
	//private MicroCache micro; ->temos que pensar como aceder � micro (problemas de heran�a)
	
	
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
