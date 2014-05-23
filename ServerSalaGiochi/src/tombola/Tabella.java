package tombola;

import java.util.Random;

/* oggetto che crea l'istanza tabella */


public class Tabella {

	/**
	 * @param args
	 */
	public int tabella[][];
	Random rand = new Random();
	public Tabella (Tabellone tab){
		tab.reset();
		int estratto = 0;
		tabella = new int [3][9];
		for (int decina = 0; decina<9; decina ++)
			for(int j=0; j<3; j++){
				tabella[j][decina] = tab.estraiColonna(decina);
				System.out.println("numero riga :"+j+" colonna: "+decina+": --->"+tabella[j][decina]);
			}
			for(int i=0; i<3;i++){
				for(int j=0; j<4; j++){
					do{
						estratto = rand.nextInt(9);
					}while(tabella[i][estratto] == 0);
					tabella[i][estratto] = 0;
				}
			tab.reset();	
			}
	}
	
	public int prendiNumero (int riga, int colonna){
		return tabella[riga][colonna];
	}
}
