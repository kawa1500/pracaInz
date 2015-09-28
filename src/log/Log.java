package log;

public class Log {
	
	public static void logKomunikat(String komunikat, boolean isError)
	{
		if(isError)System.err.println(komunikat);
		else System.out.println(komunikat);
	}
	
	
}
