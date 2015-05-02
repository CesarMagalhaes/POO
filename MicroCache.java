/**
 * Classe MicroCache cont�m toda a informa��o relativa a uma micro-cache.
 * 
 * @author C�sar Magalh�es, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.util.ArrayList;


public class MicroCache{
	
	// Vari�veis de inst�ncia -----------------------------------------------------
	
	private ArrayList<String> registos;
	private boolean isActiva;

	
	//Construtores------------------------------------------------------------------
	
	public MicroCache(MicroCache mc){
		ArrayList<String> reg=mc.getRegistos();
		boolean isActiva=mc.getIsActiva();
	}
	
	
	public MicroCache(ArrayList<String> reg, boolean isActiva){
		this.registos=reg;
		this.isActiva=isActiva;
	}
	
	
	public MicroCache(){
		this.registos=new ArrayList<String>();
		this.isActiva= false;
	}
	
	
	// Geters e Seteres ------------------------------------------------------------
	
	public ArrayList<String> getRegistos() { return registos; }
	public boolean getIsActiva() { return isActiva; }

	public void setRegistos(ArrayList<String> registos) { this.registos = registos; }	
	public void setIsActiva(boolean isActiva) { this.isActiva = isActiva; }
	
   


}