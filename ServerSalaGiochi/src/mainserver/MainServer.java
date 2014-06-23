package mainserver;

import java.io.IOException;
import java.sql.SQLException;

import socket.SimpleServer;
import interfacciaDB.ConnessioneDB;

public class MainServer {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, SQLException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("fin qui ci arrivo");
		
		
		// apro la connessione al DB
		ConnessioneDB.dbc = new ConnessioneDB();
		
		System.out.println("connessione fatta");
		//faccio partire il socket
		
		SimpleServer connessioneSocket = new SimpleServer();
		connessioneSocket.connettiti();
		System.out.println("connessione soket fatta");
		//chiudo la connessione al DB
		
		// connessioneDB.closeDB();
	}

}
