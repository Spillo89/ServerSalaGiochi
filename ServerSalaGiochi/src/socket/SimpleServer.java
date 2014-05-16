package socket;

import java.io.*; 
import java.net.*; 
 
public class SimpleServer { 
 //Porta del socket 
	private static final int port = 4445; 
 
	public static void main(String[] args) throws IOException { 
//Dichiaro le variabili per il ServerSocket e il Socket 
		ServerSocket serverSocket = null; 
		Socket clientSocket = null; 
		try { 
			serverSocket = new ServerSocket(port); //Inizializzo il socket 
			while(true){ 
				 clientSocket = serverSocket.accept(); 
				 SimpleThread thread = new SimpleThread(clientSocket);
				 thread.start();
			}
		} catch (IOException e) { 
			System.err.println("Non posso fare listen sulla porta: "+port); 
			System.exit(1); 
		}

	} 
}