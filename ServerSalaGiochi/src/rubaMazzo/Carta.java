package rubaMazzo;

import java.util.ArrayList;

public class Carta {
	static final char COPPE 	= 'C';
	static final char BASTONI 	= 'B';
	static final char SPADE		= 'S';
	static final char DENARI	= 'D';
	
	Integer Val;
	String Seme;
	
	public Carta (Integer v, String s){
		Val = v;
		Seme = s;
	}
	
	public Integer getVal() {
		return Val;
	}

	public void setVal(int val) {
		Val = val;
	}

	public String getSeme() {
		return Seme;
	}

	public void setSeme(String string) {
		Seme = string;
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
