/*
 * Esta classe vai ter todas as estatíticasdo utilizador por mês! 
 * Estatísticas nos registos de nos diversos tipos de cache, participação em eventos..
 * */

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Estatisticas extends Evento{
	
	//Variàveis de instância------------------------------------------------
	
	private GregorianCalendar mes;
	private int totalCaches, totalEventos, totalPontos; //totalCaches-> nº total de caches encontradas; totalEventos-> nº total de eventos participados; totalPontos-> nº total pontos acumulados
	private ArrayList<Evento> eventos; //quais os eventos qu eparticipou
	private ArrayList<Cache> caches; //quais as caches que encontrou (tipos)
	
	//Construtores-----------------------------------------------------------
	
	public Estatisticas(){
		this.mes=GregorianCalendar.getMONTH();
		this.totalCaches=0;
		this.totalEventos=0;
		this.totalPontos=0;
		this.eventos=new ArrayList<Evento>();
		this.caches=new ArrayList<Cache>();
	}
	
	public Estatisticas(Estatisticas e){
		GregorianCalendar mesCalendar= e.getMes();
		int totalCaches= e.getTotalCaches();
		int totalEventos= e.getTotalEventos();
		int totalPontos= e.getTotalPontos();
		ArrayList<Evento> eventos= e.getEventos();
		ArrayList<Cache> caches= e.getCaches();
		
	}
	
	//Geteres e Seters-------------------------------------------------------
	
	public GregorianCalendar getMes() { return mes;	}
	public int getTotalCaches() { return totalCaches; }
	public int getTotalEventos() { return totalEventos;	}
	public int getTotalPontos() { return totalPontos; }
	
	public ArrayList<Evento> getEventos(){
		ArrayList<Evento> copia=new ArrayList<Evento>();
		Iterator<Evento> i= this.eventos.iterator();
		while(i.hasNext()){
			Evento aux=i.next();
			copia.add(aux.clone());
		}
		return copia;
	}
	//public ArrayList<Evento> getEventos() { return eventos;	}
	
	
	public ArrayList<Cache> getCaches(){
		ArrayList<Cache> copia=new ArrayList<Cache>();
		Iterator<Cache> i= this.caches.iterator();
		while(i.hasNext()){
			Cache aux=i.next();
			copia.add(aux.clone());
		}
		return copia;
	}
	//public ArrayList<Cache> getCaches() { return caches; }
	
	
	public void setMes(GregorianCalendar mes) { this.mes = mes;	}
	public void setTotalCaches(int totalCaches) { this.totalCaches = totalCaches; }	
	public void setTotalEventos(int totalEventos) {	this.totalEventos = totalEventos; }	
	public void setTotalPontos(int totalPontos) { this.totalPontos = totalPontos; }	
	public void setEventos(ArrayList<Evento> eventos) {	this.eventos = eventos;	}	
	public void setCaches(ArrayList<Cache> caches) { this.caches = caches; }

	
	//Clone e toString------------------------------------------------------------
	
	public Estatisticas clone(){
		return new Estatisticas(this);
	}

	public String toString() {
		return "Estatisticas [mes=" + mes + ", totalCaches=" + totalCaches
				+ ", totalEventos=" + totalEventos + ", totalPontos="
				+ totalPontos + ", eventos=" + eventos + ", caches=" + caches
				+ "]";
	}
	
	
}
