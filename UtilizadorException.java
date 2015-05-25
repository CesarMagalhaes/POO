/**
 * Classe que vai tratar os casos de excepção para os utilizadores.
 * @author Cï¿½sar Magalhï¿½es, Susana Mendes e Tiago Pereira  
 * @version Maio 2015
 */

import java.io.Serializable;

public class UtilizadorException extends Exception implements Serializable {

		public UtilizadorException ()
		{super();}
		
		public UtilizadorException (String s)
		{
			super (s);
		}

	
}
