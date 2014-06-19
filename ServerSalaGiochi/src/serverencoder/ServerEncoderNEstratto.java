package serverencoder;

public class ServerEncoderNEstratto {
	//produce le stringhe da inviare tramite il socket

	public static String n_estratto(Integer n_estratto){

		String stringafinale=null;
		if(n_estratto!=null){
			stringafinale="OK#";
			stringafinale=stringafinale+n_estratto+"\n";//+numero estratto
		}
		else{
			stringafinale="OK#sono finiti i numeri\n";
		}
		return stringafinale;
	}
}
