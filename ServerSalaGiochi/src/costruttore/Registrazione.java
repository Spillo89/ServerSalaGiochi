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
	

	
	
	public String getNome() {
		return Nome;
	}




	public void setNome(String nome) {
		Nome = nome;
	}




	public String getCognome() {
		return Cognome;
	}




	public void setCognome(String cognome) {
		Cognome = cognome;
	}




	public void setNomeUtente(String nomeutente){
		NomeUtente=nomeutente;
	}
	
	public String getNomeUtente(){
		return NomeUtente;
	}
	
	public void setPsw(String psw){
		Psw=psw;
	}
	
	public String getPsw(){
		return Psw;
	}

}