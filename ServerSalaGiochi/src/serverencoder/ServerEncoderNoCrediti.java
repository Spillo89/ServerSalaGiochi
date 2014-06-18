package serverencoder;

public class ServerEncoderNoCrediti {
	
	public static String nocrediti(Integer crediti){
		
		String stringafinale=null;
		
		stringafinale="KO#";
		
		stringafinale=stringafinale+crediti+"\n";
		
		
		return stringafinale;
		
	}

}
