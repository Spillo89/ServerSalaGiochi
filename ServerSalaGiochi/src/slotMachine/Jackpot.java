package slotMachine;

public class Jackpot {
	private static Jackpot jk = null;
	private int valoreJk;
	
	
	private Jackpot(){
		valoreJk = 0;
	}
	
	public static Jackpot getIstance(){
		if(jk == null)
			jk = new Jackpot();
		return jk;
	}
	
	public int getValoreJK(){
		return valoreJk;
	}
	
	public void resetValoreJK(){
		valoreJk = 0;
	}
	
	public void addValoreJk(){
		valoreJk++;
	}
}
