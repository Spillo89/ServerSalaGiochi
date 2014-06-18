package serverencoder;

import costruttore.SlotMachine;

public class ServerEncoderSlot {

	public static String slot(SlotMachine rulli, String risultato, Integer creditivinti, Integer credititotali){
		
		String stringafinale=null;
		
		stringafinale="OK#";
		
		stringafinale=stringafinale+rulli.getValore1()+"#";
		stringafinale=stringafinale+rulli.getValore2()+"#";
		stringafinale=stringafinale+rulli.getValore3()+"#";
		stringafinale=stringafinale+risultato+"#";
		stringafinale=stringafinale+creditivinti+"#";
		stringafinale=stringafinale+credititotali+"\n";
		
		return stringafinale;
	}
}
