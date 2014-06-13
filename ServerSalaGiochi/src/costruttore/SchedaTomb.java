package costruttore;

public class SchedaTomb {
	
	private static String ValoriScheda[][] = new String[3][9];

	
	
	public void risultatoslot(String valorischeda[][]) {
		
		this.ValoriScheda=valorischeda;
	}




	public static String[][] getValoriScheda() {
		return ValoriScheda;
	}


	public void setValoriScheda(String[][] valoriScheda) {
		ValoriScheda = valoriScheda;
	}
	
	public static String getValoreSchedaUnico(Integer i, Integer j){
		
		return ValoriScheda[i][j];
	}


}
