package rubaMazzo;

import java.util.*;

public class Giocatore {

	private String user 		= null;
	private LinkedList mano 	= null;
	private ArrayList mazzetto 	= null;
	private Tavolo tavolo 		= new Tavolo();
	
	public Giocatore(String nome, Tavolo t){
		user 	= nome;
		tavolo 	= t;
	}
	
	public void AggiungiCarta(Carta c){
		mano.add(c);
	}
	
	private Carta CartaDaGiocare(){
		return (Carta)mano.removeFirst();
	}
	

}
