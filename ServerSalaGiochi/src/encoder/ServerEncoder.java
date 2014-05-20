package encoder;

public class ServerEncoder {
	//produce le stringhe da inviare tramite il socket
	
	public static String unisci(String[] stringhe){
		
		String stringafinale = null;
		
		for(int i=0; i<stringhe.length; i++){
			if(stringhe.length==i+1){
				stringafinale=stringhe[i]; // se la stringa è l'ultima non inserisce il token
			}else{
				stringafinale=stringhe[i]+"£"; // £ token che divide le varie stringhe
		
			}
		}
		
		
		return stringafinale;
	}
}
