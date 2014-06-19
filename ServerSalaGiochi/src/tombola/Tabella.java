package tombola;

import java.util.ArrayList;
import java.util.Random;

import serverdecoder.ServerDecoderNSchede;
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
	
	public static Boolean vincita(String dichiarazione){
		Integer controllo=0;
		Integer controllotomb=0;
		
		
		for(int i=0;i<ServerDecoderNSchede.NumeroSchede;i++){
			for(int j=0;j<3;j++){
				for(int k=0;k<9;k++){
					Integer numero= Integer.parseInt(schede.get(i).getValoreSchedaUnico(j, k));
					
					Integer unità=(numero-1)%10;
					Integer decina=((numero-1)-unità)/10;
					
					if(Tabellone.grigliaTot[unità][decina].isEstratto()==true){
						controllo++;
						controllotomb++;
					};
					
					switch(dichiarazione){
					case"AMBO":
						if(controllo==2){
							return true;
						}
					case"TERNA":
						if(controllo==3){
							return true;
						}
					case"QUATERNA":
						if(controllo==4){
							return true;
						}
					case"CINQUINA":
						if(controllo==5){
							return true;
						}
					}
					
				}
				controllo=0;
				
				if(dichiarazione.equalsIgnoreCase("TOMBOLA")){
					if(controllotomb==15){
						return true;
					}
				}
			}
			
		}
		
		return false;
		
	}
	
}
