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
		this.misterio=new Cache();
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
	
	
	//Clone e toString-----------------------------------------------------------
	
	public CacheMisterio clone(){
		return new CacheMisterio(this);
	}


	public String toString() {
		return "CacheMisterio [misterio=" + misterio + ", puzzle=" + puzzle
				+ ", conteudo=" + conteudo + "]";
	}
	
	
	
}
