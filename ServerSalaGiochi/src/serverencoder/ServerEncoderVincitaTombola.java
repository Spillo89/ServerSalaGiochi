package serverencoder;

public class ServerEncoderVincitaTombola {
	
	public static String vinicitatombola(Integer creditivinti, String tipovincita){
		
		String stringafinale=null;
		
		stringafinale="OK#";
		stringafinale=stringafinale+creditivinti+"#";
		stringafinale=stringafinale+tipovincita+"\n";
		
		
		return stringafinale;
	}

}
