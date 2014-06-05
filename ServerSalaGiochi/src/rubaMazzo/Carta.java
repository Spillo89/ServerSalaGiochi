package rubaMazzo;

import java.util.ArrayList;

public class Carta {
	static final char COPPE 	= 'C';
	static final char BASTONI 	= 'B';
	static final char SPADE		= 'S';
	static final char DENARI	= 'D';
	
	int val;
	char seme;
	
	public Carta (int v, char s){
		val = v;
		seme = s;
	}
	
	public boolean cartaUguale (Carta c){
		return c.val == val;
	}
	
	 public boolean cartaUguale (ArrayList<Carta> listaCarte){
		 int somma = 0;
		 for(Carta c: listaCarte){
			 somma +=c.val;
		 }
		 return somma==val;
		 
	 }
	
	public String toString(){
		return ""+seme+val;
	}
}
