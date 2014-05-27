package utente;

public class Registrazione{

	private static String Azione=null;
	private static String NomeUtente=null;
	private static String Psw=null;
	
	
	
	public void Registra(String azione, String nomeutente, String psw) {
		this.Azione=azione;
		this.NomeUtente=nomeutente;
		this.Psw=psw;
	}
	
	public static void setAzione(String azione){
		Azione=azione;
	}
	
	public String getAzione(){
		return Azione;
	}
	
	
	public static void setNomeUtente(String nomeutente){
		NomeUtente=nomeutente;
	}
	
	public String getNomeUtente(){
		return NomeUtente;
	}
	
	public static void setPsw(String psw){
		Psw=psw;
	}
	
	public String getPsw(){
		return Psw;
	}

}