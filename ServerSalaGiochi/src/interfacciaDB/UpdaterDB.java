package interfacciaDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import costruttore.Registrazione;
import costruttore.Utente;
import costruttore.UtenteLogin;

public class UpdaterDB {
	// tutte le query di update del database

	private static ConnessioneDB  dbc = null;

	public static Boolean cercaUtente(Registrazione utente) throws SQLException{

		Boolean esiste=false;

		dbc = ConnessioneDB.getIstance();
		PreparedStatement ps = dbc.getPStatement(StatementDB.CercaUtente);
		ps.setString(1, utente.getNomeUtente());
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



	//cerca un utente e mi restituisce la tupla
	public static ResultSet cercaUtente(Utente utente) throws SQLException{

		dbc = ConnessioneDB.getIstance();
		PreparedStatement ps = dbc.getPStatement(StatementDB.CercaUtente);
		ps.setString(1, utente.getNomeUtente());
		System.out.println("eseguo la query di ricerca");
		ResultSet rs = ps.executeQuery(StatementDB.CercaUtente);

		return rs;
	}

	
	//cerca se esiste un utente e se la psw è corretta
	@SuppressWarnings("null")
	public static UtenteLogin cercaUtentePsw(Utente utente) throws SQLException{

		UtenteLogin utentelogin=null;

		dbc = ConnessioneDB.getIstance();
		PreparedStatement ps = dbc.getPStatement(StatementDB.takeClient);
		ps.setString(1, utente.getNomeUtente());
		ps.setString(2, utente.getPsw());
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

	
	//registra un utente
	
	public static void aggiungiUtente(Registrazione utente) throws SQLException{

		dbc = ConnessioneDB.getIstance();

		PreparedStatement ps=dbc.getPStatement(StatementDB.insertClient);
		ps.setString(1, utente.getNomeUtente());
		ps.setString(2, utente.getPsw());
		ps.setString(3, utente.getNome());
		ps.setString(4, utente.getCognome());

		ps.executeUpdate();

	}

	//aggiorna i punti di un utente
	
	public static void aggiornapunti(Utente utente, Integer puntidaaggiungere, Integer puntispesi) throws SQLException{

		ResultSet tupla=cercaUtente(utente);
		
		//da finire

	}
	
	
	//cerca i punti totali di una persona
	
	public static Integer prendipunti(Utente utente) throws SQLException{
		
		Integer puntitotali=null;
		dbc = ConnessioneDB.getIstance();
		PreparedStatement ps = dbc.getPStatement(StatementDB.CercaUtente);
		ps.setString(1, utente.getNomeUtente());
		try {
			System.out.println("eseguo la query di ricerca");
			ResultSet rs = ps.executeQuery(StatementDB.CercaUtente);
			while(rs.next()){
				puntitotali=rs.getInt("punti");
			}


		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}
		
		return puntitotali;
		
	}

}
