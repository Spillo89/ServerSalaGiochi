package serverencoder;

import rubaMazzo.PartitaRubamazzo;

public class ServerEncoderPartecipanti {

	public static String partecipanti(Integer idpartita){

		String stringafinale=null;

		stringafinale="OK#";
		stringafinale=stringafinale+PartitaRubamazzo.Partite.get(idpartita).getUtente1()+"#";
		stringafinale=stringafinale+PartitaRubamazzo.Partite.get(idpartita).getUtente2();
		if(!PartitaRubamazzo.Partite.get(idpartita).getUtente3().equalsIgnoreCase(null)){
			stringafinale=stringafinale+"#"+PartitaRubamazzo.Partite.get(idpartita).getUtente3();
		}
		if(!PartitaRubamazzo.Partite.get(idpartita).getUtente4().equalsIgnoreCase(null)){
			stringafinale=stringafinale+"#"+PartitaRubamazzo.Partite.get(idpartita).getUtente4();
		}
		stringafinale=stringafinale+"\n";


		return stringafinale;
	}

}
