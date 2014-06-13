package serverencoder;

public class ServerEncoderPartecipanti {
	
public static String partecipanti(String[] utente){
		
		String stringafinale=null;
		
		stringafinale="OK#";
		for(Integer i=0;i<utente.length;i++){
			stringafinale=stringafinale+utente[i]+"#";			
		}
		stringafinale=stringafinale+"\n";
		
		
		return stringafinale;
	}

}
