package serverencoder;

import rubaMazzo.AggiornamentoCarte;
import rubaMazzo.PartitaRubamazzo;

public class ServerEncoderRubamazzo {
	public static String recapcarte(AggiornamentoCarte aggiornamento, String nomeutente, Integer idpartita){

		String stringafinale=null;

		stringafinale="OK#";

		if(PartitaRubamazzo.Partite.get(idpartita).getUtente1().equalsIgnoreCase(nomeutente)){

			for(Integer i=0;i<aggiornamento.Carteinmano1.size();i++){
				stringafinale=stringafinale+aggiornamento.Carteinmano1.get(i).getVal()+"#";
				stringafinale=stringafinale+aggiornamento.Carteinmano1.get(i).getSeme()+"#";
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

		}
		
		
		if(PartitaRubamazzo.Partite.get(idpartita).getUtente2().equalsIgnoreCase(nomeutente)){

			for(Integer i=0;i<aggiornamento.Carteinmano2.size();i++){
				stringafinale=stringafinale+aggiornamento.Carteinmano2.get(i).getVal()+"#";
				stringafinale=stringafinale+aggiornamento.Carteinmano2.get(i).getSeme()+"#";
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

		}
		
		if(PartitaRubamazzo.Partite.get(idpartita).getUtente3().equalsIgnoreCase(nomeutente)){

			for(Integer i=0;i<aggiornamento.Carteinmano3.size();i++){
				stringafinale=stringafinale+aggiornamento.Carteinmano3.get(i).getVal()+"#";
				stringafinale=stringafinale+aggiornamento.Carteinmano3.get(i).getSeme()+"#";
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

		}
		
		if(PartitaRubamazzo.Partite.get(idpartita).getUtente4().equalsIgnoreCase(nomeutente)){

			for(Integer i=0;i<aggiornamento.Carteinmano4.size();i++){
				stringafinale=stringafinale+aggiornamento.Carteinmano4.get(i).getVal()+"#";
				stringafinale=stringafinale+aggiornamento.Carteinmano4.get(i).getSeme()+"#";
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

		}

		stringafinale=stringafinale+"\n";

		return stringafinale;
	}

}
