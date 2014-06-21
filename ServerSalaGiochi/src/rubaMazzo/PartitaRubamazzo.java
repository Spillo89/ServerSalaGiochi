package rubaMazzo;

import java.util.ArrayList;

import costruttore.GiocatoreRubamazzo;

public class PartitaRubamazzo {

	Integer tempo=0;
	public static ArrayList<GiocatoreRubamazzo> Partite=new ArrayList<GiocatoreRubamazzo>();

	
	
	@SuppressWarnings("null")
	public Integer partitarubamazzo(String nomeutente) throws InterruptedException{


		GiocatoreRubamazzo giocatore = null;

		ArrayList<String> nomi = new ArrayList<String>();
		nomi.add(nomeutente);
		do{
			wait(500);
		}while(nomi.size()==2);

		do{
			tempo++;
			wait(500);
		}while(nomi.size()==4||tempo==60);

		giocatore.setUtente1(nomi.get(0));
		giocatore.setUtente2(nomi.get(1));
		if(nomi.size()>2){
			giocatore.setUtente3(nomi.get(2));
		}
		
		if(nomi.size()>3){
			giocatore.setUtente4(nomi.get(3));
		}
		
		
		giocatore.setIDPartita(Partite.size());
		giocatore.setRicavato(nomi.size()*20);


		nomi.clear();

		Partite.add(giocatore);
		
		tempo=0;
		
		return giocatore.getIDPartita();
	}

}
