package tombola;

import java.util.Random;

import costruttore.Utente;

public class Tabellone {
	
	
	public static Casella grigliaTot[][];				 // griglia del tabellone
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
	
	public static void estrazione(Utente utente){					// metodo di estrazione numero
		int estratto = 0;
		int decina = 0;
		int unita = 0;
		do {
			estratto = estraggo.nextInt(90);
			estratto = estratto + 1;
			unita 	 = estratto%10;
			decina	 = (estratto - unita)/10;
			if(unita == 0){
				unita = 10;
				decina --;
			}
		}while(grigliaTot[decina][unita-1].isEstratto());
		grigliaTot[decina][unita-1].setEstratto(true);
		num_estratti ++;
		
		Boolean finisce=fine();
		
		for(Integer i=0;i<PartitaTombola.Partite.size();i++){
			if(PartitaTombola.Partite.get(i).getUtente1().equalsIgnoreCase(utente.getNomeUtente())||PartitaTombola.Partite.get(i).getUtente2().equalsIgnoreCase(utente.getNomeUtente())){
			
				if(finisce==false){
				
					PartitaTombola.Partite.get(i).setUltimoNEstratto(estratto);
					PartitaTombola.Partite.get(i).setAvvenuta(true);
					System.out.println("il numero estratto è stato salvato nell'array delle partite");
				}
				else{
					PartitaTombola.Partite.get(i).setUltimoNEstratto(null);
					System.out.println("il numero estratto è stato salvato nell'array delle partite");
					num_estratti=0;
				}
			
			}
				
		}
	}
	
	public static boolean fine(){
		if(num_estratti == 90)
			return true;
		else
			return false;
	}
	
	public static Integer estraiColonna(int decina){		// metodo che riempie le colonne della casella
		Integer estratto = 0;
		Integer unita	 = 0;
		do{
			unita 		= estraggo.nextInt(10);
			estratto 	= grigliaTot[decina][unita].getValore();
		}while(grigliaTot[decina][unita].getValore() == 0);
		grigliaTot[decina][unita].setValore(0);
		grigliaTot[decina][unita-1].setEstratto(true);
		return estratto;
	}
	
	public static Integer quantovinci(String tipovincita, Integer totpunti){
		
		Integer puntivinti=null;
		
		switch(tipovincita){
		case"AMBO":	
			puntivinti=(totpunti*5)/100;
		case"TERNO":
			puntivinti=(totpunti*10)/100;
		case"QUANTERNA":
			puntivinti=(totpunti*15)/100;
		case"CINQUINA":
			puntivinti=(totpunti*20)/100;
		case"TOMBOLA":
			puntivinti=(totpunti*50)/100;
		}
		
		return puntivinti;
	};
	
}
