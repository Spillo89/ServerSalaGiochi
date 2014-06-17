package rubaMazzo;

import java.util.ArrayList;

public class AggiornamentoCarte {

	 ArrayList<Carta> Carteinmano1=new ArrayList<Carta>();
	 ArrayList<Carta> Carteinmano2=new ArrayList<Carta>();
	 ArrayList<Carta> Carteinmano3=new ArrayList<Carta>();
	 ArrayList<Carta> Carteinmano4=new ArrayList<Carta>();
	 ArrayList<Carta> Carteinbanco=new ArrayList<Carta>();
	 Carta Cartaincima1;
	Carta Cartaincima2;
	 Carta Cartaincima3;
	 Carta Cartaincima4;
	 Integer Numerocarte1;
	Integer Numerocarte2;
	 Integer Numerocarte3;
	 Integer Numerocarte4;
	
	public AggiornamentoCarte(ArrayList<Carta> carteinmano1, ArrayList<Carta> carteinmano2, ArrayList<Carta> carteinmano3, ArrayList<Carta> carteinmano4, ArrayList<Carta> carteinbanco, Carta cartaincima1, Carta cartaincima2, Carta cartaincima3, Carta cartaincima4, Integer numerocarte1, Integer numerocarte2, Integer numerocarte3, Integer numerocarte4){
		
		this.Carteinmano1=carteinmano1;
		this.Carteinmano2=carteinmano2;
		this.Carteinmano3=carteinmano3;
		this.Carteinmano4=carteinmano4;
		this.Carteinbanco=carteinbanco;
		this.Cartaincima1=cartaincima1;
		this.Cartaincima2=cartaincima2;
		this.Cartaincima3=cartaincima3;
		this.Cartaincima4=cartaincima4;
		this.Numerocarte1=numerocarte1;
		this.Numerocarte2=numerocarte2;
		this.Numerocarte3=numerocarte3;
		this.Numerocarte4=numerocarte4;

	}
}
