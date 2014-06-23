package serverdecoder;

import java.util.StringTokenizer;

import costruttore.Registrazione;

public class ServerDecoderRegistrazione {
	public static Registrazione decoderregistrazione(String stringainiziale){
		
		Registrazione utente=new Registrazione();
		System.out.println("sono in server decoder registrazione");
		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		System.out.println("la st è: "+ st);
		if(st.nextToken().equalsIgnoreCase("REGISTRAZIONE")){
			System.out.println("entro nell'if");
			utente.setNome(st.nextToken());
			System.out.println("ho registrato il nome " + utente.getNome());
			utente.setCognome(st.nextToken());
			System.out.println("ho registrato il cognome " + utente.getCognome());
			utente.setNomeUtente(st.nextToken());
			System.out.println("ho registrato il utente " + utente.getNomeUtente());
			utente.setPsw(st.nextToken());
			System.out.println("ho registrato il psw " + utente.getPsw());
		}
		System.out.println("ritorno il valore della registrazione");
		return utente;

	}


}
