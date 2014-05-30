package slotMachine;

import costruttore.SlotMachine;


public class Slot {
	
	private Rulli r = null;
	private Jackpot j = null;
	
	
	public Slot (){
		r = new Rulli();
		j = Jackpot.getIstance();
	}
	
	// prendo i valori della combinazione
	
	public void calcolaCombinazione(){
		int[] combinazione = r.GeneraSlot();
		String output = null;
		SlotMachine.setValore1(String.valueOf(combinazione[0]));
		SlotMachine.setValore2(String.valueOf(combinazione[1]));
		SlotMachine.setValore3(String.valueOf(combinazione[2]));
	}
	
	// prendo i risultati della vittoria/sconfitta
	public void getPremio (){
		int premio = 0;
		
		if(r.getPremio() == 100){
			SlotMachine.setCreditiVinti(String.valueOf(100));
			SlotMachine.setRisultato("jackpot");
		} else if(r.getPremio()== 0){
			SlotMachine.setCreditiVinti(String.valueOf(0));
			SlotMachine.setRisultato("lose");
			
		} else if(r.getPremio() >0 && r.getPremio() <100){
			SlotMachine.setCreditiVinti(String.valueOf(r.getPremio()));
			SlotMachine.setRisultato("Win");
		}
	}
}
