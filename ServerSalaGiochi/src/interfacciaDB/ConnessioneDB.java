package interfacciaDB;

import java.sql.*;

public class ConnessioneDB {

	/**
	 * @param args
	 */
	private static Connection conn = null;
	private static ConnessioneDB  dbc = null;
	private String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private String URL = "jdbc:derby:databasedir", USER = "user", PASS = "pass" ;

	private ConnessioneDB (){

		try{
			Class.forName(DRIVER).newInstance();
			System.out.println("connessione..");
			conn = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("connessione stabilita");
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

	public static ConnessioneDB getIstance(){
		if(dbc == null){
			dbc = new ConnessioneDB();
		}
		return dbc;
	}
	public Statement getStatement (){
		Statement st = null;
		try{
			st = conn.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return st;
	}

	public PreparedStatement getPStatement (String s){
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(s);
			System.out.println("statement creato con la connessione");
		}catch(SQLException e){
			System.out.println("errore\n");
			e.printStackTrace();
		}
		return ps;
	}

	public void closeDB(){
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
