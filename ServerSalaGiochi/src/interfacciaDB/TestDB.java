package interfacciaDB;

public class TestDB {
	
	private static ConnessioneDB dbc = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		dbc = ConnessioneDB.getIstance();
		//dbc.closeDB();
		
		// TODO Auto-generated method stub

	}

}
