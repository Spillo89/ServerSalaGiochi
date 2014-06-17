package socket;

import java.io.*; 
import java.net.*; 
import java.sql.SQLException;

import rubaMazzo.PartitaRubamazzo;
import tombola.PartitaTombola;
 
public class SimpleServer { 
 //Porta del socket 
	private static final int port = 4445; 
 
	public static void connettiti() throws IOException, SQLException { 
//Dichiaro le variabili per il ServerSocket e il Socket 
		ServerSocket serverSocket = null; 
		Socket clientSocket = null; 
		

		//istanzio le stanze per le partite condivise
		PartitaTombola partitatombola = new PartitaTombola();
		PartitaRubamazzo partitarubamazzo = new PartitaRubamazzo();
		
		
		
		try { 
			serverSocket = new ServerSocket(port); //Inizializzo il socket 
			while(true){ 
				 clientSocket = serverSocket.accept(); 
				 SimpleThread thread = new SimpleThread(clientSocket, partitatombola, partitarubamazzo);
				 thread.start();
			}
		} catch (IOException e) { 
			System.err.println("Non posso fare listen sulla porta: "+port); 
			System.exit(1); 
		}

	} 
}