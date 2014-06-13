package serverencoder;

public class ServerEncoderNEstratto {
	//produce le stringhe da inviare tramite il socket
	
	public static String n_estratto(){
		
		String stringafinale=null;
		
		stringafinale="OK#";
		stringafinale=stringafinale;//+numero estratto
		
		
		return stringafinale;
	}
}
