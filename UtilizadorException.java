/**
 * Classe que vai tratar os casos de excep��o para os utilizadores.
 * @author C�sar Magalh�es, Susana Mendes e Tiago Pereira  
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
