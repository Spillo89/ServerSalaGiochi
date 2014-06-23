package serverdecoder;

import java.util.StringTokenizer;

import costruttore.Utente;
public class ServerDecoderLogin {
	public static Utente decoderlogin(String stringainiziale){
		Utente utente=new Utente(null, null);
		
		System.out.println("la stringa in decoder login è: "+stringainiziale);
		
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		
		System.out.println("ho fatto il tokenizer");
		
		if(st.nextToken().equalsIgnoreCase("LOGIN")){
			utente.setNomeUtente(st.nextToken());
			utente.setPsw(st.nextToken());
		}
		
		return utente;

	}
}
