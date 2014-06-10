package tombola;

public class Casella {
	
	int valore;
	boolean estratto;
	
	public Casella(int v, boolean estr){
		valore=v;
		estratto=estr;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public boolean isEstratto() {
		return estratto;
	}

	public void setEstratto(boolean estratto) {
		this.estratto = estratto;
	}
	public String toString(){
		return ""+valore+"#"+estratto;
	}
	
	
}
