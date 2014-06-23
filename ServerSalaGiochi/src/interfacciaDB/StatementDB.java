package interfacciaDB;

public class StatementDB {
	
	// tutte le query del database
	
	// inserire utente nel database
	static String insertClient = "INSERT INTO clienti " +
			"(utente, psw , nome, cognome, punti) " +
			"VALUES ( ?, ?, ?, ?,80 )";
	
	// recupero TUTTI I DATI di un utente dal database
	static String takeClient = "SELECT * FROM clienti WHERE utente = ? AND psw = ?";
	
	//recupero nome utente e psw
	
	static String CercaUtente = "SELECT utente , psw FROM clienti WHERE utente = ?";

	//aggiorna i punti di un giocatore
	
	static String AggiornaPunti = "UPDATE clienti SET" + "punti = ?"+"WHERE utente=?";
	
	
	// giocatore che fa una partita a rubamazzo
	
	static String partitaRb = "UPDATE clienti SET " +
			"punti = ?, " +
			"rb_giocata = ?, " +
			"WHERE utente = ? ";
	
	// giocatore che vince una partita a rubamazzo
	static String vincitaRb = "UPDATE clienti SET " +
			"punti = ?, " +
			"rb_vinta = ?, " +
			"WHERE utente = ? ";
	
	// giocatore che gioca a tombola i punti (ambo terno ecc) verranno sommati
	//e a fine partita ci sarà l'update
	static String partitaTomb = "UPDATE clienti SET " +
			"punti = ?, " +
			"tomb_giocata = ?, " +
			"WHERE utente = ?";
	
	/* giocatore che vince qualcosa a tombola (ambo terno ecc) verranno sommati
	   e a fine partita ci sarà l'update
	   se il giocatore ha + punti rispetto agli altri a fine partita, 
	   ha vinto la partita */
	static String vincitaTomb = "UPDATE clienti SET " +
			"punti = ?, " +
			"tomb_vinta = ?, " +
			"WHERE utente = ? ";
	
	// classifica punteggi
	static String classifica ="SELECT utente, punti FROM clienti" +
			"ORDER BY punti DESC ";
	
	// classifica punteggi
	static String classificagiorn ="SELECT utente, punti FROM classificagiorn" +
			"ORDER BY punti DESC ";
	
	//seleziona tutti i nomiutente e i punti della tabella clienti
	
	static String tuttoclassifica="SELECT utente, punti FROM clienti";
	
	//seleziona nomiutete e punti dalla classifica giornaliera
	
	static String tuttoclassificagiorn="SELECT utente, punti FROM classificagiorn";
	
}
