package interfacciaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import costruttore.Registrazione;
import costruttore.Utente;
import costruttore.UtenteLogin;

public class UpdaterDB {
	// tutte le query di update del database
	
	private static ConnessioneDB  dbc = null;
	
	public static Boolean cercaUtente() throws SQLException{
		
		Boolean esiste=false;
		
		dbc = ConnessioneDB.getIstance();
		PreparedStatement ps = dbc.getPStatement(StatementDB.CercaUtente);
		ps.setString(1, Registrazione.getNomeUtente());
		try {
			System.out.println("eseguo la query di ricerca");
			ResultSet rs = ps.executeQuery(StatementDB.CercaUtente);
			while(rs.next()){
				if( rs.getString("utente")!=null){
					esiste=true;
				};
			}
			
			
		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}
		
		return esiste;
	}
	
	@SuppressWarnings("null")
	public static UtenteLogin cercaUtentePsw() throws SQLException{
		
		 UtenteLogin utentelogin=null;
		
		dbc = ConnessioneDB.getIstance();
		PreparedStatement ps = dbc.getPStatement(StatementDB.takeClient);
		ps.setString(1, Utente.getNomeUtente());
		ps.setString(2, Utente.getPsw());
		try {
			System.out.println("eseguo la query ceh mi restituirà tutti i dati");
			ResultSet rs = ps.executeQuery(StatementDB.takeClient);
			if(rs!=null){
				while(rs.next()){
					if(rs.getString("utente")!=null && rs.getString("psw")!=null){
						utentelogin.setNome(rs.getString("nome"));
						utentelogin.setCognome(rs.getString("cognome"));
						utentelogin.setCrediti(Integer.parseInt(rs.getString("punti")));
						utentelogin.setPosizione(Integer.parseInt(rs.getString("posizione")));
						utentelogin.setUltimoLogin(rs.getString("ultimoaccesso"));
						
					}
					
				}
			}
			
			
		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}
		return utentelogin;
	}
}
