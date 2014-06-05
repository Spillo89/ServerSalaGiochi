package rubaMazzo;

import java.util.ArrayList;
import java.util.Iterator;


public class Tavolo {
	
	private ArrayList<Carta> carte=null;
	
	public Tavolo(){
		carte = new ArrayList<Carta>();
	}
	
	
	//aggiungo una carta al tavolo
	public void aggiungiCarta(Carta c){
		carte.add(c);
	}
	
	// rimuovo una carta dal tavolo
	public boolean rimuoviCarta(Carta c){
		return carte.remove(c);
	}
	
	public Carta prendiCarta(Carta c){
		Iterator iteratore = carte.iterator();
		while(iteratore.hasNext()){
			Carta c1=(Carta)iteratore.next();
			if(c1.cartaUguale(c))
				return c1;
		}
		return null;
	}
	
	public ArrayList<Carta> prendiCarte(Carta c,Tavolo carteTavolo){
		if(c.cartaUguale(carteTavolo.carte))
			return carteTavolo.carte;
		return null;
	}
}
