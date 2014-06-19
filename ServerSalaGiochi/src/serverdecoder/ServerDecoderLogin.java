package serverdecoder;

import java.util.StringTokenizer;

import costruttore.Utente;
public class ServerDecoderLogin {
	@SuppressWarnings("null")
	public static Utente decoderlogin(String stringainiziale){
		Utente utente=null;
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		if(st.nextToken().equalsIgnoreCase("LOGIN")){
			utente.setNomeUtente(st.nextToken());
			utente.setPsw(st.nextToken());
		}
		
		return utente;

	}
}
