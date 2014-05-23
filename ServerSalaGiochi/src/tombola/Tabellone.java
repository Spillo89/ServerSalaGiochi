package tombola;

import java.util.Random;

public class Tabellone {
	
	
	private int grigliaTot[][] = new int[9][10]; // griglia del tabellone
	Random estraggo = new Random(); 			 //estrattore del numero random
	int num_estratti = 0;
	
	public Tabellone(){							 // costruttore
		crea();
		num_estratti = 0;
	}
	
	public void reset(){  						// reset del tabellone
		crea();
		num_estratti = 0;
	}
	
	private void crea(){						// metodo per riempire il tabellone
		for(int riga=0; riga<9; riga++)
			for(int colonna=0; colonna<10; colonna++)
				grigliaTot[riga][colonna] = riga*10 + colonna + 1;
	}
	
	public int estrazione(){					// metodo di estrazione numero
		int estratto = 0;
		int decina = 0;
		int unita = 0;
		do {
			estratto = estraggo.nextInt(90);
			estratto = estratto + 1;
			unita 	 = estratto%10;
			decina	 = (estratto - unita)/10;
		}while(grigliaTot[decina][unita-1] == 0);
		grigliaTot[decina][unita-1] = 0;
		num_estratti = 0;
		return estratto;
	}
	
	public boolean fine(){
		if(num_estratti == 90)
			return true;
		else
			return false;
	}
	
	public int estraiColonna(int decina){		// metodo che riempie le colonne della casella
		int estratto = 0;
		int unita	 = 0;
		do{
			unita 		= estraggo.nextInt(10);
			estratto 	= grigliaTot[decina][unita];
		}while(grigliaTot[decina][unita] == 0);
		grigliaTot[decina][unita] = 0;
		return estratto;
	}
}
