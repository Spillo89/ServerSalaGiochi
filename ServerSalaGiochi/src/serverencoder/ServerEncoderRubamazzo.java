package serverencoder;

import rubaMazzo.Carta;
import tombola.Tabella;

public class ServerEncoderRubamazzo {
	public static String recapcarte(Carta[] carteinmano, Carta[] carteinbanco, Carta cartaincima1, Carta cartaincima2, Carta cartaincima3, Carta cartaincima4, Integer numerodicarte1, Integer numerodicarte2, Integer numerodicarte3, Integer numerodicarte4){

		String stringafinale=null;

		stringafinale="OK#";
		for(Integer i=0;i<carteinmano.length;i++){
			stringafinale=stringafinale+carteinmano[i].getVal()+"#";
			stringafinale=stringafinale+carteinmano[i].getSeme()+"#";
		}
		for(Integer i=0;i<carteinbanco.length;i++){
			stringafinale=stringafinale+carteinbanco[i].getVal()+"#";
			stringafinale=stringafinale+carteinbanco[i].getSeme()+"#";
		}
		

		stringafinale=stringafinale+cartaincima1.getVal()+"#";
		stringafinale=stringafinale+cartaincima1.getSeme()+"#";
		stringafinale=stringafinale+numerodicarte1+"#";
		
		stringafinale=stringafinale+cartaincima2.getVal()+"#";
		stringafinale=stringafinale+cartaincima2.getSeme()+"#";
		stringafinale=stringafinale+numerodicarte2;
		
		if(cartaincima3!=null){
			stringafinale="#"+stringafinale+cartaincima3.getVal()+"#";
			stringafinale=stringafinale+cartaincima3.getSeme()+"#";
			stringafinale=stringafinale+numerodicarte3;
		}
		if(cartaincima4!=null){
			stringafinale="#"+stringafinale+cartaincima4.getVal()+"#";
			stringafinale=stringafinale+cartaincima4.getSeme()+"#";
			stringafinale=stringafinale+numerodicarte4;
		}
		
		stringafinale=stringafinale+"\n";
				
		return stringafinale;
	}

}
