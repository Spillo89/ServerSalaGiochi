package rubaMazzo;

import java.util.ArrayList;

public class Carta {
	static final char COPPE 	= 'C';
	static final char BASTONI 	= 'B';
	static final char SPADE		= 'S';
	static final char DENARI	= 'D';
	
	int Val;
	char Seme;
	
	public Carta (int v, char s){
		Val = v;
		Seme = s;
	}
	
	public int getVal() {
		return Val;
	}

	public void setVal(int val) {
		Val = val;
	}

	public char getSeme() {
		return Seme;
	}

	public void setSeme(char seme) {
		Seme = seme;
	}

	public boolean cartaUguale (Carta c){
		return c.Val == Val;
	}
	
	 public boolean cartaUguale (ArrayList<Carta> listaCarte){
		 int somma = 0;
		 for(Carta c: listaCarte){
			 somma +=c.Val;
		 }
		 return somma==Val;
		 
	 }
	
	public String toString(){
		return ""+Seme+"#"+Val;
	}
}
