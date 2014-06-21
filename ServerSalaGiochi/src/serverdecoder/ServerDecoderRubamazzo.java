package serverdecoder;

import java.util.StringTokenizer;

import rubaMazzo.Carta;

public class ServerDecoderRubamazzo {

@SuppressWarnings("null")
public static Carta decoderruba(String stringainiziale){
		
		Carta cartagiocata=null;

		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		if(st.nextToken().equalsIgnoreCase("RUBAMAZZO")){
			cartagiocata.setVal(Integer.parseInt(st.nextToken()));
			cartagiocata.setSeme(st.nextToken());
		}
		return cartagiocata;

	}
}
