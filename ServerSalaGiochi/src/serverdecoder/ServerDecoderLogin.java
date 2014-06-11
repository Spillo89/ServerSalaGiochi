package serverdecoder;

import java.util.StringTokenizer;

import costruttore.Utente;
public class ServerDecoderLogin {
	public static void decoderlogin(String stringainiziale){

		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		if(st.nextToken().equalsIgnoreCase("LOGIN")){
			Utente.setNomeUtente(st.nextToken());
			Utente.setPsw(st.nextToken());
		}

	}
}
