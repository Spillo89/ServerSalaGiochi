package serverdecoder;

import java.util.StringTokenizer;

import costruttore.*;
public class ServerDecoder {
	public static void dividi(String stringainiziale){

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
				
		};
		

	}
}
