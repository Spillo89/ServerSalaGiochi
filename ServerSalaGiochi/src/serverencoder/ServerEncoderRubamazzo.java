package serverencoder;

import rubaMazzo.AggiornamentoCarteSingoloGiocatore;

public class ServerEncoderRubamazzo {
	public static String recapcarte(AggiornamentoCarteSingoloGiocatore aggiornamento){

		String stringafinale=null;

		stringafinale="OK#";
		for(Integer i=0;i<aggiornamento.Carteinmano.size();i++){
			stringafinale=stringafinale+aggiornamento.Carteinmano.get(i).getVal()+"#";
			stringafinale=stringafinale+aggiornamento.Carteinmano.get(i).getSeme()+"#";
		}
		stringafinale=stringafinale+"CARTEINMANO#";
		for(Integer i=0;i<aggiornamento.Carteinbanco.size();i++){
			stringafinale=stringafinale+aggiornamento.Carteinbanco.get(i).getVal()+"#";
			stringafinale=stringafinale+aggiornamento.Carteinbanco.get(i).getSeme()+"#";
		}
		stringafinale=stringafinale+"CARTEINBANCO#";
		

		stringafinale=stringafinale+aggiornamento.Cartaincima1.getVal()+"#";
		stringafinale=stringafinale+aggiornamento.Cartaincima1.getSeme()+"#";
		stringafinale=stringafinale+aggiornamento.Numerocarte1+"#";
		
		stringafinale=stringafinale+aggiornamento.Cartaincima2.getVal()+"#";
		stringafinale=stringafinale+aggiornamento.Cartaincima2.getSeme()+"#";
		stringafinale=stringafinale+aggiornamento.Numerocarte2+"#";
		
		if(aggiornamento.Cartaincima3.getClass()!=null){
			stringafinale=stringafinale+aggiornamento.Cartaincima3.getVal()+"#";
			stringafinale=stringafinale+aggiornamento.Cartaincima3.getSeme()+"#";
			stringafinale=stringafinale+aggiornamento.Numerocarte3+"#";
		}
		if(aggiornamento.Cartaincima3.getClass()!=null){
			stringafinale=stringafinale+aggiornamento.Cartaincima4.getVal()+"#";
			stringafinale=stringafinale+aggiornamento.Cartaincima4.getSeme()+"#";
			stringafinale=stringafinale+aggiornamento.Numerocarte4+"#";
		}
		
		stringafinale=stringafinale+"\n";
				
		return stringafinale;
	}

}
