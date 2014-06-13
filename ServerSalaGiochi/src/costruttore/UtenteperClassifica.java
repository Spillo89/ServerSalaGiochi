package costruttore;

public class UtenteperClassifica {
	
	static String NomeUtente=null;
	static Integer Punti=null;
	
	@SuppressWarnings("static-access")
	public void utente(String nomeutente, Integer punti){
		this.NomeUtente=nomeutente;
		this.Punti=punti;
	}

	public String getNomeUtente() {
		return NomeUtente;
	}

	public static void setNomeUtente(String nomeUtente) {
		NomeUtente = nomeUtente;
	}

	public Integer getPunti() {
		return Punti;
	}

	public static void setPunti(Integer punti) {
		Punti = punti;
	}

}
