package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import rubaMazzo.PartitaRubamazzo;
import tombola.PartitaTombola;

public class SimpleThread extends Thread {

	public SimpleThread(Socket clientSocket, PartitaTombola partitatombola, PartitaRubamazzo partitarubamazzo) {
		// TODO Auto-generated constructor stub
		//Contiene il codice che eseguirà il thread

		PrintWriter writer = null; 
		BufferedReader reader = null;
		String[] NomePsw=null;
		try {
			//Inizializzo la scrittura sul socket 
			writer = new PrintWriter(clientSocket.getOutputStream(), true); 
			//Inizializzo la lettura dal socket 
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
			//Leggo una stringa dal socket 
			String stringa = reader.readLine(); 
			System.out.println("Ricevuta stringa: "+stringa);
			if(stringa.equalsIgnoreCase("exit")){
				try { reader.close(); } catch (IOException e) {e.printStackTrace();} 
				writer.close(); 
				if(!clientSocket.isClosed()){ 
					try {clientSocket.close(); } catch (IOException e) {e.printStackTrace();} 
				} 
			}
			NomePsw = ServerDecoder.dividi(stringa);
			if(NomePsw[2].equalsIgnoreCase("l")){
				
			}
			//Scrivo una stringa sul socket 
			writer.write(stringa); 
			writer.flush(); 
		} catch (IOException e) { 
			System.err.println("Errore di comunicazione."); 
		} finally { //Alla fine chiudo sempre il reader, il writer, il socket e il serverSocket 
			try { reader.close(); } catch (IOException e) {e.printStackTrace();}
			writer.close(); 
			if(!clientSocket.isClosed()){ 
				try {clientSocket.close(); } catch (IOException e) {e.printStackTrace();} 
			} 

		}
	}

}
