package costruttore;

public class SlotMachine {
	
	private String Valore1=null;
	private String Valore2=null;
	private String Valore3=null;
	
	public void slotmachine ( String valore1, String valore2, String valore3){
		this.Valore1 = valore1;
		this.Valore2 = valore2;
		this.Valore3 = valore3;
		
	}
	
	public String getValore1() {
		return Valore1;
	}

	public void setValore1(String valore1) {
		Valore1 = valore1;
	}

	public String getValore2() {
		return Valore2;
	}

	public void setValore2(String valore2) {
		Valore2 = valore2;
	}

	public String getValore3() {
		return Valore3;
	}

	public void setValore3(String valore3) {
		Valore3 = valore3;
	}
}
