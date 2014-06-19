package rubaMazzo;

import java.util.ArrayList;

public class PosizioneGiocatore {

	@SuppressWarnings("null")
	public static AggiornamentoCarteSingoloGiocatore controlla(AggiornamentoCarte aggiornamento, ArrayList<String> nomigiocanti, String giocatore){
		
		AggiornamentoCarteSingoloGiocatore agg=null;
		Integer i=0;
		Boolean soddisfatto=false;
		while(soddisfatto==false){
			if(nomigiocanti.get(i).equalsIgnoreCase(giocatore)){
				soddisfatto=true;
			}
			else{
				i++;
			}
		}
		
		switch (i){
			case 0: 
				agg.Carteinmano=aggiornamento.Carteinmano1;
				agg.Carteinbanco=aggiornamento.Carteinbanco;
				agg.Cartaincima1=aggiornamento.Cartaincima1;
				agg.Cartaincima2=aggiornamento.Cartaincima2;
				agg.Cartaincima3=aggiornamento.Cartaincima3;
				agg.Cartaincima4=aggiornamento.Cartaincima4;
				agg.Numerocarte1=aggiornamento.Numerocarte1;
				agg.Numerocarte2=aggiornamento.Numerocarte2;
				agg.Numerocarte3=aggiornamento.Numerocarte3;
				agg.Numerocarte4=aggiornamento.Numerocarte4;
				
			case 1: 
				agg.Carteinmano=aggiornamento.Carteinmano2;
				agg.Carteinbanco=aggiornamento.Carteinbanco;
				agg.Cartaincima1=aggiornamento.Cartaincima1;
				agg.Cartaincima2=aggiornamento.Cartaincima2;
				agg.Cartaincima3=aggiornamento.Cartaincima3;
				agg.Cartaincima4=aggiornamento.Cartaincima4;
				agg.Numerocarte1=aggiornamento.Numerocarte1;
				agg.Numerocarte2=aggiornamento.Numerocarte2;
				agg.Numerocarte3=aggiornamento.Numerocarte3;
				agg.Numerocarte4=aggiornamento.Numerocarte4;
				
			case 2: 
				agg.Carteinmano=aggiornamento.Carteinmano2;
				agg.Carteinbanco=aggiornamento.Carteinbanco;
				agg.Cartaincima1=aggiornamento.Cartaincima1;
				agg.Cartaincima2=aggiornamento.Cartaincima2;
				agg.Cartaincima3=aggiornamento.Cartaincima3;
				agg.Cartaincima4=aggiornamento.Cartaincima4;
				agg.Numerocarte1=aggiornamento.Numerocarte1;
				agg.Numerocarte2=aggiornamento.Numerocarte2;
				agg.Numerocarte3=aggiornamento.Numerocarte3;
				agg.Numerocarte4=aggiornamento.Numerocarte4;
				
			case 3: 
				agg.Carteinmano=aggiornamento.Carteinmano2;
				agg.Carteinbanco=aggiornamento.Carteinbanco;
				agg.Cartaincima1=aggiornamento.Cartaincima1;
				agg.Cartaincima2=aggiornamento.Cartaincima2;
				agg.Cartaincima3=aggiornamento.Cartaincima3;
				agg.Cartaincima4=aggiornamento.Cartaincima4;
				agg.Numerocarte1=aggiornamento.Numerocarte1;
				agg.Numerocarte2=aggiornamento.Numerocarte2;
				agg.Numerocarte3=aggiornamento.Numerocarte3;
				agg.Numerocarte4=aggiornamento.Numerocarte4;
				
		}
		
		
		
		return agg;
		
	}

}
