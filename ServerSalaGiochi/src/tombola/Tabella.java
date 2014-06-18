package tombola;

import java.util.ArrayList;
import java.util.Random;
import costruttore.SchedaTomb;

/* oggetto che crea l'istanza tabella */


public class Tabella {

	/**
	 * @param args
	 */
	public static Casella tabella[][];
	public static ArrayList<SchedaTomb> schede= new ArrayList<SchedaTomb>();
	static Random rand = new Random();
	
	
	@SuppressWarnings("null")
	public static void tabella (){
		
		
		SchedaTomb scheda=null;
		Tabellone.reset();
		int estratto = 0;
		String schedatombola[][]=null;
		
		
		
		tabella = new Casella [3][9];
		// riempio la tabella con tutti i numeri, ordinati per decine
		for (int decina = 0; decina<9; decina ++){
			for(int j=0; j<3; j++){
				tabella[j][decina].setValore(Tabellone.estraiColonna(decina));
				tabella[j][estratto].setEstratto(false);
				System.out.println("numero riga :"+j+" colonna: "+decina+": --->"+tabella[j][decina]);
			}
		}
		
		// vado a cancellare 4 numeri per ogni riga, mettendoli a 0
			for(int i=0; i<3;i++){
				for(int j=0; j<4; j++){
					do{
						estratto = rand.nextInt(9);
					}while(tabella[i][estratto].getValore()==0);
					tabella[i][estratto].setValore(0);
					tabella[i][estratto].setEstratto(true);
				}
			Tabellone.reset();	
			}
			for(int i=0; i<3;i++){
				for(int j=0; j<9; j++){
					schedatombola[i][j]=tabella[i][j].toString();
				}
			}
			scheda.setValoriScheda(schedatombola);
			schede.add(scheda);
	}
	
	
	
	//resetta schede
	public void resetschede(){
		schede.clear();
	}
	
	
	
	
	public String prendiNumero (int riga, int colonna){
		return "" + tabella[riga][colonna].getValore();
	}
	
	
	
	
	// controllo se è presente il numero dentro la tabella
	public void controllaNumero(int num){
		
		for(int i=0; i<3;i++){
			for(int j=0; j<9; j++){
				if(tabella[i][j].getValore()== num){
					tabella[i][j].setEstratto(true);
				}
			}
		}
	}
	
	public String vincita(){
		Integer contanumero = 0, tombola=0;
		
		String vittoria = null;
		for(int i=0; i<3;i++){
			for(int j=0; j<9; j++){
				if(tabella[i][j].isEstratto()==true){
					contanumero++;
				}
				switch(contanumero){
					
				case 2: vittoria = "Ambo";
				
				case 3: vittoria = "Terno";
		
				case 4: vittoria = "Quaterna";
		
				case 5: vittoria = "Cinquina";

				default: vittoria = null;
				}
			}
			tombola	= tombola+contanumero;
			contanumero = 0;
		}
		if(tombola== 15)
			vittoria = "Tombola";
		return vittoria;
	}
}
