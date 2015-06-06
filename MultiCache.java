/**
 *Classe MultiCache vai ter toda a informa��o relativa a uma multi-cache. � definida � custa de uma cache (uma vez que possui toda a informa��o de uma cache),
 *de uma lista de caches (ArrayList<Caches> - caches necess�rias para determinar a cache final, podem ser caches de todos os tipos) e de uma micro-cache (a �ltima
 *cache tem de ser necess�riamente uma micro-cache).
 *
 *Uma multicache s� foi vista, quando todas as caches da sua lista tiverem sido visitadas.
 * 
 * @author C�sar Magalh�es, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.GregorianCalendar;

public class MultiCache extends Cache {
	
	
	// Vari�veis de inst�ncia -----------------------------------------------------
	
	private Cache multi;
	private int totalCaches;
	private ArrayList<String> listaCaches; //a lista com a refer�ncia das caches que constituem a multicache
	private String conteudo;
	
	
	
	//Construtores-------------------------------------------------------------------
	
	public MultiCache(MultiCache mc){
		Cache multi=mc.getMulti();
		int totalCaches=mc.getTotalCaches();
		ArrayList<String> listaCaches=mc.getListaCaches();
		String conteudo=mc.getConteudo();
		
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
		this.multi= new MultiCache();
		this.totalCaches= 0;
		this.listaCaches= new ArrayList<String>();
		this.conteudo= new String();

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
	

	//---------------------------------------------------------------------------M�todos de Inst�ncia----------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//M�todo que verifica se o utilizador passou por todas as caches que constituem a multicaches,apenas se passou por todas � ue visitou a multicache
	public boolean foiVisitada(Utilizadores user) throws UtilizadorException{
		HashMap<String, GregorianCalendar> cachesEncontradas= new HashMap<String, GregorianCalendar>();
		cachesEncontradas=user.getActividades();
		for(String cache: this.getListaCaches()){
			if(!cachesEncontradas.containsKey(cache)) return false;
		}
		return true;
	}
	
	//Clone e toString e compareTo---------------------------------------------------------------
	
	public MultiCache clone(){
		return new MultiCache(this);
	}


	public String toString() {
		StringBuilder s=new StringBuilder();
		s.append("------------------Multi-Cache--------------------");
		s.append("N�mero de registo: " +this.multi.getN_registo()+ "\n");
		s.append("Latitude: "+this.multi.getLatitude()+ "\n");
		s.append("Longitude: "+this.multi.getLongitude()+ "\n");
		s.append("Ponto Cardeal: " +this.multi.getPontocardeal()+"\n");
		s.append("Criador: " +this.multi.getCriador()+ "\n");
		s.append("Dificuldade: "+this.multi.getDificuldade()+"\n");
		s.append("N�mero total de caches que fazem parte da multi-cache: "+this.totalCaches+"\n");
		s.append("Conte�do: "+this.conteudo+"\n");
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
	
	
	public int hashCode() {
		return this.toString().hashCode();
	}
}
