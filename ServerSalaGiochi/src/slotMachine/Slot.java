package slotMachine;

import costruttore.SlotMachine;


public class Slot {
	
	private static Rulli r = null;
	private Jackpot j = null;
	
	
	public Slot (){
		r = new Rulli();
		j = Jackpot.getIstance();
	}
	
	// prendo i valori della combinazione
	
	@SuppressWarnings("null")
	public static SlotMachine calcolaCombinazione(){
		
		SlotMachine slotmachine=null;
		
		int[] combinazione = r.GeneraSlot();
		
		
		slotmachine.setValore1(String.valueOf(combinazione[0]));
		slotmachine.setValore2(String.valueOf(combinazione[1]));
		slotmachine.setValore3(String.valueOf(combinazione[2]));
		
		return slotmachine;
	}
	
	// prendo i risultati della vittoria/sconfitta
	public static String getPremio (){
		String vincita=null;
		if(r.getPremio() == 100){
			vincita="JACKPOT";
		} else if(r.getPremio()== 0){
			vincita="LOSE";
			
		} else if(r.getPremio() >0 && r.getPremio() <100){
			vincita="WIN";
		}
		return vincita;
	}
	
}
