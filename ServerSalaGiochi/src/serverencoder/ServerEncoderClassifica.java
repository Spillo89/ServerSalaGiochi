package serverencoder;

import costruttore.UtenteperClassifica;

public class ServerEncoderClassifica {

	
	public static String classifica(UtenteperClassifica[] utente){
		
		String stringafinale=null;
		
		stringafinale="OK#";
		for(Integer i=0;i<utente.length;i++){
			stringafinale=stringafinale+utente[i].getNomeUtente()+"#";
			stringafinale=stringafinale+String.valueOf(utente[i].getPunti())+"#";
			
		}
		stringafinale=stringafinale+"\n";
		
		
		return stringafinale;
	}
	
}
