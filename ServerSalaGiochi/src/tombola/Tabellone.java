package tombola;

import java.util.Random;

import costruttore.NumeroEstratto;

public class Tabellone {
	
	
	private static Casella grigliaTot[][];				 // griglia del tabellone
	static Random estraggo = new Random(); 			 //estrattore del numero random
	static int num_estratti = 0;
	
	public Tabellone(){							 // costruttore
		crea();
		num_estratti = 0;
	}
	
	public static void reset(){  						// reset del tabellone
		crea();
		num_estratti = 0;
	}
	
	private static void crea(){						// metodo per riempire il tabellone
		for(int riga=0; riga<9; riga++)
			for(int colonna=0; colonna<10; colonna++){
				grigliaTot[riga][colonna]= new Casella(riga*10 + colonna + 1, false);
			}
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
		}while(grigliaTot[decina][unita-1].getValore() == 0);
		grigliaTot[decina][unita-1].setValore(0);
		grigliaTot[decina][unita-1].setEstratto(true);
		num_estratti = 0;
		NumeroEstratto.setNumero(estratto);
		return estratto;
	}
	
	public boolean fine(){
		if(num_estratti == 90)
			return true;
		else
			return false;
	}
	
	public static int estraiColonna(int decina){		// metodo che riempie le colonne della casella
		int estratto = 0;
		int unita	 = 0;
		do{
			unita 		= estraggo.nextInt(10);
			estratto 	= grigliaTot[decina][unita].getValore();
		}while(grigliaTot[decina][unita].getValore() == 0);
		grigliaTot[decina][unita].setValore(0);
		grigliaTot[decina][unita-1].setEstratto(true);
		NumeroEstratto.setNumero(estratto);
		return estratto;
	}
}
