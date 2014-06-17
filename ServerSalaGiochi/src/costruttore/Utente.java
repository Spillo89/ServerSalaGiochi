package costruttore;

public class Utente {

	private static String NomeUtente=null;
	private static String Psw=null;
	
	
	
	public Utente(String nomeutente, String psw) {
		super();
		this.NomeUtente=nomeutente;
		this.Psw=psw;
	}
	
	public static void setNomeUtente(String nomeutente){
		NomeUtente=nomeutente;
	}
	
	public static String getNomeUtente(){
		return NomeUtente;
	}
	
	public static void setPsw(String psw){
		Psw=psw;
	}
	
	public static String getPsw(){
		return Psw;
	}

}
