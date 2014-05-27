package serverdecoder;

import java.util.StringTokenizer;

import utente.Registrazione;
import utente.Utente;

public class ServerDecoder {
	public static void dividi(String stringainiziale){
		int i=0;

		StringTokenizer st = new StringTokenizer(stringainiziale, "#");
		switch (st.nextToken())
		{
			case "LOGIN":
				Utente.setNomeUtente(st.nextToken());
				Utente.setPsw(st.nextToken());
			case "REGISTRAZIONE":
				Registrazione.setAzione("Registra");
				Registrazione.setNomeUtente(st.nextToken());
				Registrazione.setPsw(st.nextToken());
			case 
				
		};
		
		
		

	     while (st.hasMoreTokens()) {
	    	st.nextToken();
	    	}

	}
}
