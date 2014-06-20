package serverencoder;

import java.util.ArrayList;

public class ServerEncoderClassifica {

	
	public static String classifica(ArrayList<String> nomi, ArrayList<Integer> punti){
		
		String stringafinale=null;
		
		stringafinale="OK#";
		for(Integer i=0;i<nomi.size();i++){
			stringafinale=stringafinale+nomi.get(i)+"#";
			stringafinale=stringafinale+String.valueOf(punti.get(i))+"#";
			
		}
		stringafinale=stringafinale+"\n";
		
		
		return stringafinale;
	}
	
}
