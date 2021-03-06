package interfacciaDB;

import java.sql.*;
import java.util.ArrayList;

import costruttore.Registrazione;
import costruttore.Utente;
import costruttore.UtenteLogin;

public class UpdaterDB {
	// tutte le query di update del database

	public static Boolean cercaUtente(Registrazione utente) throws SQLException{

		Boolean esiste=false;
		System.out.println("sono entrato in cercaUtente");
		//dbc = ConnessioneDB.getIstance();
		System.out.println("ho fatto l'istanza al db");
		PreparedStatement ps = ConnessioneDB.conn.prepareStatement(StatementDB.CercaUtente);
		System.out.println("nome utente: " +  utente.getNomeUtente());
		ps.setString(1, utente.getNomeUtente());
		try {
			System.out.println("eseguo la query di ricerca");
			ResultSet rs = ps.executeQuery();
			while(rs.next()==true){
				if( rs.getString("utente")!=null){
					esiste=true;
					System.out.println("HO TROVATO L'UTENTE");
				};
			}


		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}

		return esiste;
	}


	//cerca se esiste un utente e se la psw � corretta
	public static UtenteLogin cercaUtentePsw(Utente utente) throws SQLException{

		UtenteLogin utentelogin= new UtenteLogin();
		ResultSet rs=null;

		//	dbc = ConnessioneDB.getIstance();
		System.out.println("comincio la ricerca dell'utente");
		System.out.println("nome utente: "+utente.getNomeUtente());
		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.takeClient);
		ps.setString(1, utente.getNomeUtente());
		ps.setString(2, utente.getPsw());
		System.out.println("nome utente: "+utente.getNomeUtente());
		//ps.setString(2, utente.getPsw());

		try {
			System.out.println("eseguo la query ceh mi restituir� tutti i dati");

			rs = ps.executeQuery();

			System.out.println("ho dichiarato rs");

			while(rs.next()){
				System.out.println("sono nel while di carcautentepsw");

				String stnome=rs.getString("utente");

				System.out.println("stnome= "+stnome);

				String stpsw=rs.getString("psw");

				System.out.println("stpsw= "+stpsw);

				//if(stnome!=null && stpsw!=null){

				System.out.println("sono nell'if di carcautentepsw");

				utentelogin.setNome(rs.getString("nome"));

				System.out.println("nome: "+rs.getString("nome"));

				utentelogin.setCognome(rs.getString("cognome"));

				System.out.println("cognome: "+rs.getString("cognome"));

				utentelogin.setCrediti(Integer.parseInt(rs.getString("punti")));

				System.out.println("punti: "+rs.getString("punti"));

				utentelogin.setPosizione(posizioneClassifica(utente));

				System.out.println("posizione= "+utentelogin.getPosizione());

				utentelogin.setUltimoLogin(rs.getString("ultimo_login"));

				System.out.println("data= "+utentelogin.getUltimoLogin());

				//}

			}

			System.out.println("sono fuori dal while");

		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}
		System.out.println("sto returnando");
		return utentelogin;
	}


	//registra un utente

	public static void aggiungiUtente(Registrazione utente) throws SQLException{

		//	dbc = ConnessioneDB.getIstance();
		System.out.println("sono dentro al aggiungiUtente");
		PreparedStatement ps= ConnessioneDB.conn.prepareStatement(StatementDB.insertClient);
		ps.setString(1, utente.getNomeUtente());
		System.out.println("nome utente: "+ utente.getNomeUtente());
		ps.setString(2, utente.getPsw());
		System.out.println("psw: "+ utente.getPsw());
		ps.setString(3, utente.getNome());
		System.out.println("nome: "+ utente.getNome());
		ps.setString(4, utente.getCognome());
		System.out.println("cognome: "+ utente.getCognome());
		ps.executeUpdate();

	}

	//aggiorna i punti di un utente

	public static void aggiornapunti(Utente utente, Integer puntidaaggiungere, Integer puntispesi) throws SQLException{

		Integer punti=puntidaaggiungere+puntispesi;

		//	dbc = ConnessioneDB.getIstance();
		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.AggiornaPunti);
		ps.setInt(1, punti);
		ps.setString(2, utente.getNomeUtente());

		System.out.println("eseguo la query di aggiornamento punti");
		ps.executeQuery();


	}


	//cerca i punti totali di una persona

	public static Integer prendipunti(Utente utente) throws SQLException{

		Integer puntitotali=null;
		//	dbc = ConnessioneDB.getIstance();
		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.CercaUtente);
		ps.setString(1, utente.getNomeUtente());
		try {
			System.out.println("eseguo la query di ricerca");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				puntitotali=rs.getInt("punti");
			}


		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}

		return puntitotali;

	}

	//ordina la classifica

	public static void ordinaClassifica() throws SQLException{

		//	dbc = ConnessioneDB.getIstance();
		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.classifica);

		System.out.println("eseguo la query di ordinamento classifica");

		ps.executeQuery();

	}

	//cerca la posizione di un giocatore in classifica

	public static Integer posizioneClassifica(Utente utente) throws SQLException{

		//	dbc = ConnessioneDB.getIstance();
		String nomeacaso=null;
		Integer i=0;

		ResultSet rs=null;
		System.out.println("sto per ordinare la classifica");
		ordinaClassifica();
		System.out.println("ho ordinato la classifica");
		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.tuttoclassifica);
		System.out.println("sto per eseguire la query");
		rs = ps.executeQuery();
		System.out.println("eseguita");
		System.out.println("nome utente nella posizioneclassifica: "+ utente.getNomeUtente());
		rs.next();

		do{
			nomeacaso=rs.getString("utente");
			i++;
		}while(!nomeacaso.equalsIgnoreCase(utente.getNomeUtente())&& rs.next());

		return i;

	}


	public static String prendinomi(Utente utente) throws SQLException{

		String nomi=null;
		//	dbc = ConnessioneDB.getIstance();
		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.CercaUtente);
		ps.setString(1, utente.getNomeUtente());
		try {
			System.out.println("eseguo la query di ricerca");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				nomi=rs.getString("nome");
			}


		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}

		return nomi;

	}

	public static String prendicognomi(Utente utente) throws SQLException{

		String cognomi=null;
		//		dbc = ConnessioneDB.getIstance();
		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.CercaUtente);
		ps.setString(1, utente.getNomeUtente());
		try {
			System.out.println("eseguo la query di ricerca");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cognomi=rs.getString("cognome");
			}


		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}

		return cognomi;

	}


	public static String prendiultimologin(Utente utente) throws SQLException{

		String login=null;
		//	dbc = ConnessioneDB.getIstance();
		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.CercaUtente);
		ps.setString(1, utente.getNomeUtente());

		try {
			System.out.println("eseguo la query di ricerca");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				login=rs.getString("ultimo_login");
			}


		}catch (SQLException e) {
			System.out.println("errore");
			e.printStackTrace();
		}

		return login;

	}

	public static ArrayList<String> classificaGlobale() throws SQLException{

		ArrayList<String> classifica = new ArrayList<String>();

		//	dbc = ConnessioneDB.getIstance();

		Integer i=0;

		ResultSet rs=null;

		ordinaClassifica();

		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.tuttoclassifica);

		rs = ps.executeQuery();

		while(rs.next()||i<10){

			classifica.add(rs.getString("utente"));

		}

		return classifica;

	}




	public static ArrayList<Integer> classificaGlobalePunti() throws SQLException{

		ArrayList<Integer> classifica = new ArrayList<Integer>();

		//	dbc = ConnessioneDB.getIstance();

		Integer i=0;

		ResultSet rs=null;

		ordinaClassifica();

		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.tuttoclassifica);

		rs = ps.executeQuery();

		while(rs.next()||i<10){

			classifica.add(rs.getInt("punti"));

		}

		return classifica;

	}

	public static void ordinaClassificaGiorn() throws SQLException{

		//	dbc = ConnessioneDB.getIstance();
		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.classifica);

		System.out.println("eseguo la query di ordinamento classifica");

		ps.executeQuery();

	}

	public static ArrayList<String> classificaGlobaleGiorn() throws SQLException{

		ArrayList<String> classifica = new ArrayList<String>();

		//	dbc = ConnessioneDB.getIstance();

		Integer i=0;

		ResultSet rs=null;

		ordinaClassificaGiorn();

		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.tuttoclassificagiorn);

		rs = ps.executeQuery();

		while(rs.next()||i<10){

			classifica.add(rs.getString("utente"));

		}

		return classifica;

	}

	public static ArrayList<Integer> classificaGlobalePuntiGiorn() throws SQLException{

		ArrayList<Integer> classifica = new ArrayList<Integer>();

		// dbc = ConnessioneDB.getIstance();

		Integer i=0;

		ResultSet rs=null;

		ordinaClassificaGiorn();

		PreparedStatement ps =  ConnessioneDB.conn.prepareStatement(StatementDB.tuttoclassificagiorn);

		rs = ps.executeQuery();

		while(rs.next()||i<10){

			classifica.add(rs.getInt("punti"));

		}

		return classifica;

	}


}
