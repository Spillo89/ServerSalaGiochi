package serverencoder;

import tombola.Tabella;

public class ServerEncoderSchedeTombola {

	public static String schede(Integer credititotali){

		String stringafinale=null;

		stringafinale="OK#";
		for(Integer i=0;i<4;i++){
			for(Integer j=0;j<3;j++){
				for(Integer k=0;k<9;k++){
					stringafinale=Tabella.schede.get(i).getValoreSchedaUnico(i, j)+"#";
				}
			}
		}
		stringafinale=stringafinale+credititotali+"\n";

		return stringafinale;
	}
}
