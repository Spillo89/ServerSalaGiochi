package serverencoder;

import costruttore.UtenteLogin;

public class ServerEncoderRegistrazione {
	
public static String registrazione(UtenteLogin utentelogin){
		
		String stringafinale=null;
		
		stringafinale="OK#";
		stringafinale=stringafinale+utentelogin.getNome()+"#";
		stringafinale=stringafinale+utentelogin.getCognome()+"#";
		stringafinale=stringafinale+utentelogin.getCrediti()+"#";
		stringafinale=stringafinale+utentelogin.getPosizione();
		stringafinale=stringafinale+"\n";
		
		
		return stringafinale;
	}

}
