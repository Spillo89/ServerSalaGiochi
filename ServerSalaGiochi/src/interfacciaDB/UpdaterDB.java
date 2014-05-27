package interfacciaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UpdaterDB {
	// tutte le query di update del database
	
	private static ConnessioneDB  dbc = null;
	
	public static String cercaUtente(String[] Nome) throws SQLException{
		
		String esiste=null;
		
		dbc = ConnessioneDB.getIstance();
		PreparedStatement ps = dbc.getPStatement(StatementDB.CercaUtente);
		ps.setString(1, Nome[1]);
		try {
			System.out.println("eseguo la query di ricerca");
			ResultSet rs = ps.executeQuery(StatementDB.CercaUtente);
			while(rs.next()){
				esiste = rs.getString("utente");
			}
			
			
		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}
		
		return esiste;
	}
	
	public static String[] cercaUtentePsw(String[] Nomepsw) throws SQLException{
		
		String[] dati=null;
		
		dbc = ConnessioneDB.getIstance();
		PreparedStatement ps = dbc.getPStatement(StatementDB.takeClient);
		ps.setString(1, Nomepsw[1]);
		ps.setString(2, Nomepsw[2]);
		try {
			System.out.println("eseguo la query ceh mi restituirà tutti i dati");
			ResultSet rs = ps.executeQuery(StatementDB.takeClient);
			if(rs!=null){
				while(rs.next()){
					dati[0]="OK";
					dati[1] = rs.getString("utente");
					dati[2] = rs.getString("psw");
					dati[3] = String(rs.getInt("punti"));
					
				}
			}
			
			
		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}
		return null;
	}

	private static String String(int int1) {
		// TODO Auto-generated method stub
		return null;
	}
}
