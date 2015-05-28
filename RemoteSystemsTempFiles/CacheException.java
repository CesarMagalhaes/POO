package RemoteSystemsTempFiles;

import java.io.Serializable;

public class CacheException extends Exception implements Serializable {

	public CacheException ()
	{super();}
	
	public CacheException (String s)
	{
		super (s);
	}


}
