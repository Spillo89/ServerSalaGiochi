package tombola;

import java.util.ArrayList;

import costruttore.GiocatoreTombola;

public class PartitaTombola {
	
	public static ArrayList<GiocatoreTombola> Partite=new ArrayList<GiocatoreTombola>();

	@SuppressWarnings("null")
	public void partitatombola(String nomeutente, Integer ncartelle) throws InterruptedException{

		GiocatoreTombola giocatore=null;
		
		ArrayList<String> nomi = new ArrayList<String>();
		ArrayList<Integer> ncart=new ArrayList<Integer>();
			nomi.add(nomeutente);
			ncart.add(ncartelle);
		do{
			wait(500);
		}while(nomi.size()==2);
		
		giocatore.setUtente1(nomi.get(0));
		giocatore.setUtente2(nomi.get(1));
		giocatore.setIDPartita(Partite.size());
		giocatore.setRicavato((ncart.get(0)*20)+(ncart.get(1)*20));
		
		
		nomi.clear();
		ncart.clear();
		
		Partite.add(giocatore);
	}


}
