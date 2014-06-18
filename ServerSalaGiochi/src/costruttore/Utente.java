package costruttore;

public class Utente {

	private String NomeUtente=null;
	private String Psw=null;



	public Utente(String nomeutente, String psw) {
		super();
		this.NomeUtente=nomeutente;
		this.Psw=psw;
	}

	public  void setNomeUtente(String nomeutente){
		NomeUtente=nomeutente;
	}

	public String getNomeUtente(){
		return NomeUtente;
	}

	public void setPsw(String psw){
		Psw=psw;
	}

	public  String getPsw(){
		return Psw;
	}

}
