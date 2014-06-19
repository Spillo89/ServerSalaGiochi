package costruttore;

public class GiocatoreTombola {
	
private String Utente1=null;
private String Utente2=null;
private Integer IDPartita=null;
private String VincitaChiamata=null;
private Integer UltimoNEstratto=null;
private Boolean Avvenuta=false;
private Integer Ricavato=0;
	
	public void estrazione(String utente1, String utente2,Integer idpartita, String vincitachiamata, Integer ultimonestratto, Boolean avvenuta, Integer ricavato){
		this.Utente1=utente1;
		this.Utente2=utente2;
		this.IDPartita=idpartita;
		this.VincitaChiamata=vincitachiamata;
		this.UltimoNEstratto=ultimonestratto;
		this.Avvenuta=avvenuta;
		this.Ricavato=ricavato;
	}

	public Integer getRicavato() {
		return Ricavato;
	}

	public void setRicavato(Integer ricavato) {
		Ricavato = ricavato;
	}

	public Boolean getAvvenuta() {
		return Avvenuta;
	}

	public void setAvvenuta(Boolean avvenuta) {
		Avvenuta = avvenuta;
	}

	public Integer getUltimoNEstratto() {
		return UltimoNEstratto;
	}

	public void setUltimoNEstratto(Integer ultimoNEstratto) {
		UltimoNEstratto = ultimoNEstratto;
	}

	public String getVincitaChiamata() {
		return VincitaChiamata;
	}

	public void setVincitaChiamata(String vincitaChiamata) {
		VincitaChiamata = vincitaChiamata;
	}

	public  String getUtente1() {
		return Utente1;
	}

	public  void setUtente1(String utente1) {
		Utente1 = utente1;
	}

	public String getUtente2() {
		return Utente2;
	}

	public void setUtente2(String utente2) {
		Utente2 = utente2;
	}

	public  Integer getIDPartita() {
		return IDPartita;
	}

	public void setIDPartita(Integer iDPartita) {
		IDPartita = iDPartita;
	}

}
