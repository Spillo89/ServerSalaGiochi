package costruttore;

import java.sql.Date;

public class UtenteLogin{

	private static String Nome=null;
	private static String Cognome=null;
	private static Integer Crediti=null;
	private static Date UltimoLogin=null;
	private static Integer Posizione=null;
	
	
	
	@SuppressWarnings("static-access")
	public void utentelogin(String nome,String cognome, Integer crediti, Date data, Integer posizione) {
		this.Nome=nome;
		this.Cognome=cognome;
		this.Crediti=crediti;
		this.UltimoLogin=data;
		this.Posizione=posizione;
	}
	

	
	
	public Integer getCrediti() {
		return Crediti;
	}




	public static void setCrediti(Integer crediti) {
		Crediti = crediti;
	}




	public Date getUltimoLogin() {
		return UltimoLogin;
	}




	public static void setUltimoLogin(Date ultimoLogin) {
		UltimoLogin = ultimoLogin;
	}




	public  Integer getPosizione() {
		return Posizione;
	}




	public static void setPosizione(Integer posizione) {
		Posizione = posizione;
	}




	public String getNome() {
		return Nome;
	}




	public static void setNome(String nome) {
		Nome = nome;
	}




	public String getCognome() {
		return Cognome;
	}




	public static void setCognome(String cognome) {
		Cognome = cognome;
	}

}