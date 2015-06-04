
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Estatisticas{
	
	
	
	private GregorianCalendar mes;
	private int totalCaches, totalEventos, totalPontos; 
	private ArrayList<Evento> eventos; 
	private ArrayList<Cache> caches; 
	
	
	
	public Estatisticas(){
		this.mes=new GregorianCalendar();
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
	
	
	
	public ArrayList<Cache> getCaches(){
		ArrayList<Cache> copia=new ArrayList<Cache>();
		Iterator<Cache> i= this.caches.iterator();
		while(i.hasNext()){
			Cache aux=i.next();
			copia.add(aux.clone());
		}
		return copia;
	}
	
	
	
	public void setMes(GregorianCalendar mes) { this.mes = mes;	}
	public void setTotalCaches(int totalCaches) { this.totalCaches = totalCaches; }	
	public void setTotalEventos(int totalEventos) {	this.totalEventos = totalEventos; }	
	public void setTotalPontos(int totalPontos) { this.totalPontos = totalPontos; }	
	public void setEventos(ArrayList<Evento> eventos) {	this.eventos = eventos;	}	
	public void setCaches(ArrayList<Cache> caches) { this.caches = caches; }

	
	
	
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
