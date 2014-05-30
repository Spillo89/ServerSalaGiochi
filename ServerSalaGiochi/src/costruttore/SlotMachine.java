package costruttore;

public class SlotMachine {
	
	private static String Valore1=null;
	private static String Valore2=null;
	private static String Valore3=null;
	private static String Risultato=null;
	private static String CreditiVinti=null;
	
	public void slotmachine ( String valore1, String valore2, String valore3){
		this.Valore1 = valore1;
		this.Valore2 = valore2;
		this.Valore3 = valore3;
		
	}
	
	public static String getValore1() {
		return Valore1;
	}

	public static void setValore1(String valore1) {
		Valore1 = valore1;
	}

	public static String getValore2() {
		return Valore2;
	}

	public static void setValore2(String valore2) {
		Valore2 = valore2;
	}

	public static String getValore3() {
		return Valore3;
	}

	public static void setValore3(String valore3) {
		Valore3 = valore3;
	}

	public static void setRisultato(String risultato){
		Risultato = risultato;
	}
	
	public static String getRisultato(){
		return Risultato;
	}
	
	public static void setCreditiVinti(String creditiVinti){
		CreditiVinti = creditiVinti;
	}
	
	public static String getCreditiVStringi(){
		return CreditiVinti;
	}
}
