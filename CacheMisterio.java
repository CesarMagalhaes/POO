import java.util.ArrayList;

/**
 * Classe 
 * 
 * @author César Magalhães, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */
public class CacheMisterio extends Cache {
	
	// Variáveis de instância ----------------------------------------------------
	private Cache misterio;
	private String puzzle;
	private String conteudo;
	
	
	//Construtores----------------------------------------------------------------

	public CacheMisterio(CacheMisterio cm){
		Cache misterio=cm.getMisterio();
		String puzzle=cm.getPuzzle();
		String conteudo=cm.getConteudo();
	}
	
	public CacheMisterio(Cache m, String puzzel, String conteudo){
		this.misterio=m;
		this.puzzle=puzzle;
		this.conteudo=conteudo;
	}
	
	public CacheMisterio(){
		this.misterio=new CacheMisterio();
		this.puzzle=new String();
		this.conteudo=new String();
	}
	
	
	//Geters e Seters------------------------------------------------------------

	public Cache getMisterio() { return misterio; }
	public String getPuzzle() { return puzzle; }
	public String getConteudo() { return conteudo; }
	
	
	public void setMisterio(Cache misterio) { this.misterio = misterio;	}
	public void setPuzzle(String puzzle) { this.puzzle = puzzle; }	
	public void setConteudo(String conteudo) { this.conteudo = conteudo; }

	
	
	//----------------------------------------------------------------------------Métodos de INstância---------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Método que, dado um utilizador, verifica se visitou a cache
		public boolean foiVisitada(Utilizadores user) throws UtilizadorException{
			if(misterio.getRegistos().contains(user.getNome())) return true;
			else return false;
		}
	
	//Clone, toString e compareTo ---------------------------------------------------
	
	public CacheMisterio clone(){
		return new CacheMisterio(this);
	}


	public String toString() {
		StringBuilder s= new StringBuilder();
		s.append("------------------Cache Mistério--------------------");
		s.append("Número de registo: "+this.misterio.getN_registo()+"\n");
		s.append("Latitude: "+this.misterio.getLatitude()+"\n");
		s.append("Longitude: "+this.misterio.getLongitude()+"\n");
		s.append("PontoCardeal: "+this.misterio.getPontocardeal()+"\n");
		s.append("Criador: "+this.misterio.getCriador()+"\n");
		s.append("Dificuldade: "+this.misterio.getDificuldade()+"\n");
		s.append("Puzzle: "+this.puzzle+"\n");
		s.append("Conteudo: "+this.conteudo+"\n");
		return s.toString();
	}
	
	public int compareTo(CacheMisterio cm){
		return cm.getN_registo().compareTo(this.getN_registo());
	}
	
	
	//Equals e HashCode------------------------------------------------------------
	
	public boolean equals(Object obj){
		if(this==obj) return true;
		if ((obj==null)||(this.getClass()!=obj.getClass())) return false;
		else{
			CacheMisterio other=(CacheMisterio) obj;
			return(this.misterio.getN_registo().equals(other.getN_registo())
					&& this.misterio.getLatitude()==(other.getLatitude())
					&& this.misterio.getLongitude()==(other.getLongitude())
					&& this.misterio.getPontocardeal()==(other.getPontocardeal())
					&& this.misterio.getScoreCache()==(other.getScoreCache())
					&& this.misterio.getCriador().equals(other.getCriador())
					&& this.misterio.getIsActiva()==(other.getIsActiva())
					&& this.misterio.getDificuldade().equals(other.getDificuldade())
					&& this.puzzle.equals(other.getPuzzle())
					&& this.conteudo.equals(other.getConteudo()));			
		}
	}

	public int hashCode() {
		return this.toString().hashCode();
	}
	
}
