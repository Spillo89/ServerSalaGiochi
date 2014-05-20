package interfacciaDB;

public class StatementDB {
	
	// tutte le query del database
	
	// inserire utente nel database
	static String instertClient = "INSERT INTO clienti " +
			"(user, psw , punti) " +
			"VALUES ( ?, ?, 100, )";
	
	// recupero utente dal database
	static String takeClient = "SELECT * FROM clienti WHERE user = ? AND psw = ?";
	
	// giocatore che fa una partita alla slot
	
	static String partitaSlot = "UPDATE clienti SET " +
			"punti = ?, " +
			"slot_giocata = ?, " +
			"WHERE user = ? ";
	
	
	// giocatore che fa una partita a rubamazzo
	
	static String partitaRb = "UPDATE clienti SET " +
			"punti = ?, " +
			"rb_giocata = ?, " +
			"WHERE user = ? ";
	
	// giocatore che vince una partita a rubamazzo
	static String vincitaRb = "UPDATE clienti SET " +
			"punti = ?, " +
			"rb_vinta = ?, " +
			"WHERE user = ? ";
}
