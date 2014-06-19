package serverencoder;

import tombola.Tabella;

public class ServerEncoderSchedeTombola {

	public static String schede(Integer credititotali){

		String stringafinale=null;

		stringafinale="OK#";
		for(Integer i=0;i<Tabella.schede.size();i++){
			for(Integer j=0;j<3;j++){
				for(Integer k=0;k<9;k++){
					stringafinale=stringafinale+Tabella.schede.get(i).getValoreSchedaUnico(i, j)+"#";
				}
			}
		}
		for(Integer i=0;i<4-Tabella.schede.size();i++){
			for(Integer k=0;k<27;k++){
				stringafinale=stringafinale+"0"+"#";
			}
		}
		stringafinale=stringafinale+credititotali+"\n";

		return stringafinale;
	}
}
