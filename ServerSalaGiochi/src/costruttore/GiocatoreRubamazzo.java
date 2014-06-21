package costruttore;

import java.util.ArrayList;

import rubaMazzo.AggiornamentoCarte;
import rubaMazzo.Carta;

public class GiocatoreRubamazzo {
	
	String Utente1=null;
	String Utente2=null;
	String Utente3=null;
	String Utente4=null;
	Integer IDPartita=null;
	Integer Ricavato=null;
	AggiornamentoCarte Situazione=null;
	ArrayList<Carta> Mazzo =new ArrayList<Carta>();
	
	
	public void giocatorerubamazzo(String utente1, String utente2, String utente3, String utente4, Integer idpartita, Integer ricavato, AggiornamentoCarte situazione, ArrayList<Carta> mazzo){
		this.Utente1=utente1;
		this.Utente2=utente2;
		this.Utente3=utente3;
		this.Utente4=utente4;
		this.IDPartita=idpartita;
		this.Ricavato=ricavato;
		this.Situazione=situazione;
		this.Mazzo=mazzo;
	}


	public ArrayList<Carta> getMazzo() {
		return Mazzo;
	}


	public void setMazzo(ArrayList<Carta> mazzo) {
		Mazzo = mazzo;
	}


	public String getUtente1() {
		return Utente1;
	}


	public void setUtente1(String utente1) {
		Utente1 = utente1;
	}


	public String getUtente2() {
		return Utente2;
	}


	public void setUtente2(String utente2) {
		Utente2 = utente2;
	}


	public String getUtente3() {
		return Utente3;
	}


	public void setUtente3(String utente3) {
		Utente3 = utente3;
	}


	public String getUtente4() {
		return Utente4;
	}


	public void setUtente4(String utente4) {
		Utente4 = utente4;
	}


	public Integer getIDPartita() {
		return IDPartita;
	}


	public void setIDPartita(Integer iDPartita) {
		IDPartita = iDPartita;
	}


	public Integer getRicavato() {
		return Ricavato;
	}


	public void setRicavato(Integer ricavato) {
		Ricavato = ricavato;
	}


	public AggiornamentoCarte getSituazione() {
		return Situazione;
	}


	public void setSituazione(AggiornamentoCarte situazione) {
		Situazione = situazione;
	}
	

}
