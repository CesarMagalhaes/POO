
import java.util.ArrayList;


public class MicroCache extends Cache{
	
	
	
	private Cache micro;

	
	//Construtores------------------------------------------------------------------
	
	public MicroCache(MicroCache mc){
		Cache micro=mc.getMicro();
	}
	
	
	public MicroCache(Cache micro){
		this.micro=micro;
	}
	
	
	public MicroCache(){
		this.micro=new MicroCache();
	}


	
	// Geters e Seteres ------------------------------------------------------------

	public Cache getMicro() { return micro; }

	public void setMicro(Cache micro) {	this.micro = micro;	}
	

		public boolean foiVisitada(Utilizadores user) throws UtilizadorException{
			if(micro.getRegistos().contains(user.getNome())) return true;
			else return false;
		}

	//Clone e toString-------------------------------------------------------------
	
	public MicroCache clone(){
		return new MicroCache(this);
	}


	public String toString() {
		StringBuilder s=new StringBuilder();
		s.append("---------------Micro Cache--------------------");
		s.append("N�ero de registo: "+this.micro.getN_registo()+"\n");
		s.append("Latitude: "+this.micro.getLatitude()+"\n");
		s.append("Longitude: "+this.micro.getLongitude()+"\n");
		s.append("Ponto Cardeal: "+this.micro.getPontocardeal()+"\n");
		s.append("Criador: "+this.micro.getCriador()+"\n");
		s.append("Dificuladade: "+this.micro.getDificuldade()+"\n");
		return s.toString();
	}
	
	public int compareTo(MicroCache mc){
		return mc.getN_registo().compareTo(this.getN_registo());
	}

	
	//Equals e hashCode-------------------------------------------------------------------------
	
	public boolean equals(Object obj){
		if(this==obj) return true;
		if ((obj==null)||(this.getClass()!=obj.getClass())) return false;
		else{
			MicroCache other=(MicroCache) obj;
			return(this.micro.getN_registo().equals(other.getN_registo())
					&& this.micro.getLatitude()==(other.getLatitude())
					&& this.micro.getLongitude()==(other.getLongitude())
					&& this.micro.getPontocardeal()==(other.getPontocardeal())
					&& this.micro.getScoreCache()==(other.getScoreCache())
					&& this.micro.getCriador().equals(other.getCriador())
					&& this.micro.getIsActiva()==(other.getIsActiva())
					&& this.micro.getDificuldade().equals(other.getDificuldade()));
		}
	}
	
	public int hashCode() {
		return this.toString().hashCode();
	}
	
}