package costruttore;

public class Registrazione{

	private static String Nome=null;
	private static String Cognome=null;
	private static String NomeUtente=null;
	private static String Psw=null;
	
	
	
	public void Registra(String nome,String cognome, String nomeutente, String psw) {
		this.Nome=nome;
		this.Cognome=cognome;
		this.NomeUtente=nomeutente;
		this.Psw=psw;
	}
	

	
	
	public static String getNome() {
		return Nome;
	}




	public static void setNome(String nome) {
		Nome = nome;
	}




	public static String getCognome() {
		return Cognome;
	}




	public static void setCognome(String cognome) {
		Cognome = cognome;
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