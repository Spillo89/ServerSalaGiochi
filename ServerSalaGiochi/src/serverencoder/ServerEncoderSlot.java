package serverencoder;

public class ServerEncoderSlot {

	public static String slot(String rullo1, String rullo2, String rullo3, String risultato, Integer creditivinti, Integer credititotali){
		
		String stringafinale=null;
		
		stringafinale="OK#";
		
		stringafinale=stringafinale+rullo1+"#";
		stringafinale=stringafinale+rullo2+"#";
		stringafinale=stringafinale+rullo3+"#";
		stringafinale=stringafinale+risultato+"#";
		stringafinale=stringafinale+creditivinti+"#";
		stringafinale=stringafinale+credititotali+"\n";
		
		return stringafinale;
	}
}
