package serverencoder;

import costruttore.UtenteLogin;

public class ServerEncoderLogin {
	
public static String login(UtenteLogin utentelogin){
		
		String stringafinale=null;
		
		stringafinale="OK#";
		stringafinale=stringafinale+utentelogin.getNome()+"#";
		stringafinale=stringafinale+utentelogin.getCognome()+"#";
		stringafinale=stringafinale+utentelogin.getCrediti()+"#";
		stringafinale=stringafinale+utentelogin.getUltimoLogin()+"#";
		stringafinale=stringafinale+utentelogin.getPosizione();
		stringafinale=stringafinale+"\n";
		
		
		return stringafinale;
	}

}
