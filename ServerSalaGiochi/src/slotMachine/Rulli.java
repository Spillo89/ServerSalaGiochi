package slotMachine;

import java.util.Random;

public class Rulli {
	
	private Random genera = new Random();
	private int val[] = null;
	private int punteggio = 0;
	
	
	// creo l'oggetto e inizializzo a 0 i valori
	public Rulli(){
		
		val = new int[3];
		for(int i=0; i < 3; i++)
			val[i] = 0;
		}
		
	public int[] GeneraSlot(){
		
		for(int i=0; i < 3; i++){
			val[i] = genera.nextInt(5)+1;
		}
		return val;
	}			
	
	public int[] getSlot(){
		return val;
	}
	
	public int getPremio(){
		
		int punti =0;
		
			// controllo se il primo numero è uguale al secondo
			if(val[0]==val[1]){
				// controllo se il secondo numero è uguale al terzo
				if(val[1]==val[2])
					//controllo se il numero estratto è il jackpot
					if(val[0]==1)
						punti = 100;
					else
						punti = 20;
			}
				// controllo se il primo numero è uguale al terzo
			else if (val[0]==val[2])
				punti = 10;
			else
				punti = 0;
		return punti;				
	}

}
