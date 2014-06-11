package serverdecoder;

import java.util.StringTokenizer;

import costruttore.Registrazione;

public class ServerDecoderRegistrazione {
	public static void decoderregistrazione(String stringainiziale){

		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		if(st.nextToken().equalsIgnoreCase("REGISTRAZIONE")){
			Registrazione.setNome(st.nextToken());
			Registrazione.setCognome(st.nextToken());
			Registrazione.setNomeUtente(st.nextToken());
			Registrazione.setPsw(st.nextToken());
		}

	}


}
