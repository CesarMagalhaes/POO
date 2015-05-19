/**
 * Classe MicroCache cont�m toda a informa��o relativa a uma micro-cache.
 * 
 * @author C�sar Magalh�es, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.util.ArrayList;


public class MicroCache extends Cache{
	
	// Vari�veis de inst�ncia -----------------------------------------------------
	
	private Cache micro;

	
	//Construtores------------------------------------------------------------------
	
	public MicroCache(MicroCache mc){
		Cache micro=mc.getMicro();
	}
	
	
	public MicroCache(Cache micro){
		this.micro=micro;
	}
	
	
	public MicroCache(){
		this.micro=new Cache();
	}


	
	// Geters e Seteres ------------------------------------------------------------

	public Cache getMicro() { return micro; }

	public void setMicro(Cache micro) {	this.micro = micro;	}
	


	//Clone e toString-------------------------------------------------------------
	
	public MicroCache clone(){
		return new MicroCache(this);
	}


	public String toString() {
		return "MicroCache [micro=" + micro + "]";
	}
	
	
}