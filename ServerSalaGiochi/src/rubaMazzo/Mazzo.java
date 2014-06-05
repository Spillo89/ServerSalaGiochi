package rubaMazzo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Mazzo {
	
	private LinkedList<Carta> carte=null;
	// creo il mazzo
	Mazzo(){
		for(int i=0; i<40; i++){
			carte.add(new Carta(i,Carta.BASTONI));
			carte.add(new Carta(i,Carta.SPADE));
			carte.add(new Carta(i,Carta.DENARI));
			carte.add(new Carta(i,Carta.SPADE));
			
		}
	}
	
	// mescolo il mazzo
	public void mescola(){
		Random rand = new Random();
		int numeroCarte = carte.size();
		for(int i=0; i<numeroCarte; i++){
			int posizione = rand.nextInt(numeroCarte);
			carte.addLast(carte.remove(posizione));
			carte.addFirst(carte.remove(posizione));
		}
	}
	
	public Carta prossimaCarta(){
		assert (carte.size()>0): "mazzo vuoto";
		return (Carta)carte.removeFirst();
	}
}
