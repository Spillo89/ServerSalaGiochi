package costruttore;

public class UtenteLogin{

	private static String Nome=null;
	private static String Cognome=null;
	private static Integer Crediti=null;
	private static String UltimoLogin=null;
	private static Integer Posizione=null;
	
	
	
	@SuppressWarnings("static-access")
	public void utentelogin(String nome,String cognome, Integer crediti, String data, Integer posizione) {
		this.Nome=nome;
		this.Cognome=cognome;
		this.Crediti=crediti;
		this.UltimoLogin=data;
		this.Posizione=posizione;
	}
	

	
	
	public Integer getCrediti() {
		return Crediti;
	}




	public void setCrediti(Integer crediti) {
		Crediti = crediti;
	}




	public String getUltimoLogin() {
		return UltimoLogin;
	}




	public void setUltimoLogin(String string) {
		UltimoLogin = string;
	}




	public  Integer getPosizione() {
		return Posizione;
	}




	public void setPosizione(Integer posizione) {
		Posizione = posizione;
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

}