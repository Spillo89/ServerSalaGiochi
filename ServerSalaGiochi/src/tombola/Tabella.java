package tombola;

import java.util.ArrayList;
import java.util.Random;
import costruttore.SchedaTomb;

/* oggetto che crea l'istanza tabella */


public class Tabella {

	/**
	 * @param args
	 */
	public String tabella[][];
	public ArrayList<SchedaTomb> schede= new ArrayList<SchedaTomb>();
	Random rand = new Random();
	public SchedaTomb Tabella (Tabellone tab){
		SchedaTomb scheda=null;
		tab.reset();
		int estratto = 0;
		tabella = new String [3][9];
		// riempio la tabella con tutti i numeri, ordinati per decine
		for (int decina = 0; decina<9; decina ++){
			for(int j=0; j<3; j++){
				tabella[j][decina] = String.valueOf(tab.estraiColonna(decina));
				System.out.println("numero riga :"+j+" colonna: "+decina+": --->"+tabella[j][decina]);
			}
		}
		
		// vado a cancellare 4 numeri per ogni riga, mettendoli a 0
			for(int i=0; i<3;i++){
				for(int j=0; j<4; j++){
					do{
						estratto = rand.nextInt(9);
					}while(tabella[i][estratto].equalsIgnoreCase("0"));
					tabella[i][estratto] = "0";
				}
			tab.reset();	
			}
			scheda.setValoriScheda(tabella);
			return scheda;
	}
	
	public String prendiNumero (int riga, int colonna){
		return tabella[riga][colonna];
	}
}
