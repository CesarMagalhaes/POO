import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Teste implements Serializable{
	
	public static void main(String[] args){
		
		GeocachingAdmin geo= new GeocachingAdmin();
		Utilizadores user= new Utilizadores();
		
		Utilizadores u1= new Utilizadores('M', "Rui", "111@gmail.com", "123");
		Utilizadores u2= new Utilizadores('F', "Ana", "222@gmail.com", "1234");
		Cache c1= new Cache("a1", 10, 10, 'N', 20, "Rui", true, "cenas");
		
			
		geo.adicionaAmigo("111@gmail.com", "Ana");
		geo.adicionaAmigo("111@gmail.com", "Ana");
		u2.addCache(c1);
		
		System.out.println("lista de caches: " +geo.getListaCaches("222@gmail.com"));
	}
		
}

		