package mainserver;

import socket.SimpleServer;
import interfacciaDB.ConnessioneDB;

public class MainServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// apro la connessione al DB
		ConnessioneDB connessioneDB = new ConnessioneDB();
		
		//faccio partire il socket
		
		SimpleServer connessioneSocket = new SimpleServer();
		
		//chiudo la connessione al DB
		
		connessioneDB.closeDB();
	}

}
