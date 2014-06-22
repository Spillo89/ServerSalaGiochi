package serverencoder;

import interfacciaDB.UpdaterDB;

import java.sql.SQLException;
import java.util.ArrayList;

import costruttore.Utente;

import rubaMazzo.PartitaRubamazzo;

public class ServerEncoderClassRuba {
	
	public static String classruba(ArrayList<String> classifica, Utente utente, Integer idpartita) throws SQLException{
		String stringafinale=null;
		
		stringafinale="CLASS#";
		
		stringafinale=stringafinale+classifica.get(0)+"#";
		stringafinale=stringafinale+classifica.get(1);
		
		if(classifica.size()>2){
			stringafinale=stringafinale+"#"+classifica.get(2);
		}
		
		if(classifica.size()>3){
			stringafinale=stringafinale+"#"+classifica.get(3);
		}
		
		if(classifica.get(0).equalsIgnoreCase(utente.getNomeUtente())){
			stringafinale=stringafinale+"#"+PartitaRubamazzo.Partite.get(idpartita).getRicavato();
			
			UpdaterDB.aggiornapunti(utente, PartitaRubamazzo.Partite.get(idpartita).getRicavato(), 20);
			
		}else{
			stringafinale=stringafinale+"#"+"0";
			
			UpdaterDB.aggiornapunti(utente, 0, 20);
		}
		
		
		stringafinale=stringafinale+"\n";
		
		
		
		
		
		return stringafinale;
	}

}
