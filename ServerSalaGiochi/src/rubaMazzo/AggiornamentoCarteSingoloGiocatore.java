package rubaMazzo;

import java.util.ArrayList;

public class AggiornamentoCarteSingoloGiocatore {

	public ArrayList<Carta> Carteinmano=new ArrayList<Carta>();
	public ArrayList<Carta> Carteinbanco=new ArrayList<Carta>();
	public Carta Cartaincima1;
	public Carta Cartaincima2;
	public Carta Cartaincima3;
	public Carta Cartaincima4;
	public Integer Numerocarte1;
	public Integer Numerocarte2;
	public Integer Numerocarte3;
	public Integer Numerocarte4;

	public AggiornamentoCarteSingoloGiocatore( ArrayList<Carta> carteinmano, ArrayList<Carta> carteinbanco, Carta cartaincima1, Carta cartaincima2, Carta cartaincima3, Carta cartaincima4, Integer numerocarte1, Integer numerocarte2, Integer numerocarte3, Integer numerocarte4){
		this.Carteinmano=carteinmano;
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
