package socket;

import interfacciaDB.UpdaterDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.StringTokenizer;

import costruttore.UtenteLogin;

import rubaMazzo.PartitaRubamazzo;
import serverdecoder.ServerDecoderLogin;
import serverdecoder.ServerDecoderRegistrazione;
import serverencoder.ServerEncoderLogin;
import serverencoder.ServerEncoderRegistrazione;
import tombola.PartitaTombola;

public class SimpleThread extends Thread {

	String parolachiave=null;

	public SimpleThread(Socket clientSocket, PartitaTombola partitatombola, PartitaRubamazzo partitarubamazzo) throws SQLException {
		// TODO Auto-generated constructor stub
		//Contiene il codice che eseguirà il thread

		PrintWriter writer = null; 
		BufferedReader reader = null;
		String dainviare=null;
		String stringa=null;

		try {
			//Inizializzo la scrittura sul socket 
			writer = new PrintWriter(clientSocket.getOutputStream(), true); 
			//Inizializzo la lettura dal socket 
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 





			do{
				//Leggo una stringa dal socket 
				stringa = reader.readLine(); 
				System.out.println("Ricevuta stringa: "+stringa);
				if(stringa.equalsIgnoreCase("exit")){
					try { reader.close(); } catch (IOException e) {e.printStackTrace();} 
					writer.close(); 
					if(!clientSocket.isClosed()){ 
						try {clientSocket.close(); } catch (IOException e) {e.printStackTrace();} 
					} 
				}
				StringTokenizer st = new StringTokenizer(stringa, "#");
				switch(st.nextToken()){
					case "LOGIN": 
						ServerDecoderLogin.decoderlogin(stringa);
					case "REGISTRAZIONE": 
						ServerDecoderRegistrazione.decoderregistrazione(stringa);				
				}
				Boolean esiste=null;
				switch(parolachiave){
					case"REGISTRAZIONE":
						esiste=UpdaterDB.cercaUtente();
						if(esiste==true){
							parolachiave="REGISTRAZIONEKO";
						}else{
							parolachiave="REGISTRAZIONEOK";
						}
					case"LOGIN":
						UtenteLogin utentelogin=UpdaterDB.cercaUtentePsw();
						if(utentelogin!=null){
							parolachiave="LOGINOK";
						}else{
							parolachiave="LOGINKO";
						}
				}
				//controllare in caso di login se l'utente esiste nel db(se si imposto parolachiave="LOGINOK" in caso contrario imposto parolachiave="LOGINKO"), controllare in caso di registrazione se il nome utente è già presente nel db e se sono presenti tuti i dati richiesti se no aggiungere tutto(in caso che sia tutto giusto parolachiave="REGISTRAZIONEOK" altrimenti parolachiave="REGISTRAZIONEKO")

				switch(parolachiave){
					case"LOGINOK": 
						UtenteLogin utentelogin=null;
						//salvo i dati che mi servono in utentelogin
						dainviare=ServerEncoderLogin.login(utentelogin);
						writer.write(dainviare);
						writer.flush(); 

					case"LOGINKO":
						dainviare="KO#le credenziali inserite non sono corrette\n";
						writer.write(dainviare);
						writer.flush(); 
					case"REGISTRAZIONEOK":
						UtenteLogin utenteregistrazione=null;
						//salvo i dari che mi servono in utetnelogin
						dainviare=ServerEncoderRegistrazione.registrazione(utenteregistrazione);
						writer.write(dainviare);
						writer.flush(); 
					case"REGISTRAZIONEKO":
						dainviare="KO#il nomeutente è già presente o le credenziali non sono complete\n";
						writer.write(dainviare);
						writer.flush(); 
				}
				
			}while(parolachiave.equalsIgnoreCase("LOGINKO")||parolachiave.equalsIgnoreCase("REGISTRAZIONEKO"));

			
			
			
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
