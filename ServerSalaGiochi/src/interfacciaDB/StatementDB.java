package interfacciaDB;

public class StatementDB {
	
	// tutte le query del database
	
	// inserire utente nel database
	static String instertClient = "INSERT INTO clienti " +
			"(utente, psw , punti) " +
			"VALUES ( ?, ?, 100 )";
	
	// recupero TUTTI I DATI di un utente dal database
	static String takeClient = "SELECT * FROM clienti WHERE utente = ? AND psw = ?";
	

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
			"ORDER BY punti DESCR ";
}
