package serverdecoder;

import java.util.StringTokenizer;

import costruttore.Registrazione;

public class ServerDecoderRegistrazione {
	@SuppressWarnings("null")
	public static Registrazione decoderregistrazione(String stringainiziale){
		
		Registrazione utente=null;

		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		if(st.nextToken().equalsIgnoreCase("REGISTRAZIONE")){
			utente.setNome(st.nextToken());
			utente.setCognome(st.nextToken());
			utente.setNomeUtente(st.nextToken());
			utente.setPsw(st.nextToken());
		}
		return utente;

	}


}
