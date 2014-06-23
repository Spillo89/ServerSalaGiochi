package socket;

import interfacciaDB.UpdaterDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import costruttore.Registrazione;
import costruttore.SlotMachine;
import costruttore.Utente;
import costruttore.UtenteLogin;

import rubaMazzo.CalcolaVincitore;
import rubaMazzo.Carta;
import rubaMazzo.ComposizioneMazzo;
import rubaMazzo.ControllaMossa;
import rubaMazzo.DistribuzioneCarte;
import rubaMazzo.PartitaRubamazzo;
import rubaMazzo.PescaCarta;
import serverdecoder.ServerDecoderLogin;
import serverdecoder.ServerDecoderNSchede;
import serverdecoder.ServerDecoderRegistrazione;
import serverdecoder.ServerDecoderRubamazzo;
import serverdecoder.ServerDecoderVincitaTomb;
import serverencoder.ServerEncoderClassRuba;
import serverencoder.ServerEncoderClassifica;
import serverencoder.ServerEncoderLogin;
import serverencoder.ServerEncoderNEstratto;
import serverencoder.ServerEncoderNoCrediti;
import serverencoder.ServerEncoderPartecipanti;
import serverencoder.ServerEncoderRegistrazione;
import serverencoder.ServerEncoderRubamazzo;
import serverencoder.ServerEncoderSchedeTombola;
import serverencoder.ServerEncoderSlot;
import serverencoder.ServerEncoderVincitaTombola;
import slotMachine.Slot;
import tombola.PartitaTombola;
import tombola.Tabella;
import tombola.Tabellone;

public class SimpleThread extends Thread {

	String parolachiave=null;

	public SimpleThread(Socket clientSocket, PartitaTombola partitatombola, PartitaRubamazzo partitarubamazzo) throws SQLException, InterruptedException {
		// TODO Auto-generated constructor stub
		//Contiene il codice che eseguirà il thread

		PrintWriter writer = null; 
		BufferedReader reader = null;
		String dainviare=null;
		String stringa=null;
		Registrazione utenteregistrazione=null;
		Utente utente= new Utente(null,null);
		SlotMachine combinazioneslot=null;
		UtenteLogin utentelogin=new UtenteLogin();
		Integer credititotali=null;
		Integer creditivinti=null;
		Integer creditispesi=null;

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
				System.out.println("st= "+ st);
				switch(st.nextToken()){
				case "LOGIN": 
					utente=ServerDecoderLogin.decoderlogin(stringa);
					parolachiave="LOGIN";
				case "REGISTRAZIONE": 
					System.out.println("sono nel case della registrazione");
					utenteregistrazione=ServerDecoderRegistrazione.decoderregistrazione(stringa);
					System.out.println("sono uscito dal server decoder registrazione");
					parolachiave="REGISTRAZIONE";
				}
				Boolean esiste=null;
				
				switch(parolachiave){
				case"REGISTRAZIONE":
					System.out.println("sono nello switch di registrazione, cerco l'utente");
					esiste=UpdaterDB.cercaUtente(utenteregistrazione);
					System.out.println("ho cercato l'utente " +esiste);
					if(esiste==true){
						parolachiave="REGISTRAZIONEKO";
					}else{
						System.out.println("inizio la registrazione");
						UpdaterDB.aggiungiUtente(utenteregistrazione);
						
						parolachiave="REGISTRAZIONEOK";				
					}
					break;
				case"LOGIN":
					System.out.println("a caso entro nel login");
					utentelogin=UpdaterDB.cercaUtentePsw(utente);
					if(utentelogin!=null){
						parolachiave="LOGINOK";
					}else{
						parolachiave="LOGINKO";
						//aggiornare la data dell'ultimo login
					}
				break;
				}
				
				//controllare in caso di login se l'utente esiste nel db(se si imposto parolachiave="LOGINOK" in caso contrario imposto parolachiave="LOGINKO"), controllare in caso di registrazione se il nome utente è già presente nel db e se sono presenti tuti i dati richiesti se no aggiungere tutto(in caso che sia tutto giusto parolachiave="REGISTRAZIONEOK" altrimenti parolachiave="REGISTRAZIONEKO")

				switch(parolachiave){
				case"LOGINOK": 

					//prendo tutti i dati dal DB

					utentelogin.setPosizione(UpdaterDB.posizioneClassifica(utente));
					utentelogin.setNome(UpdaterDB.prendinomi(utente));
					utentelogin.setCognome(UpdaterDB.prendicognomi(utente));
					utentelogin.setCrediti(UpdaterDB.prendipunti(utente));
					utentelogin.setUltimoLogin(UpdaterDB.prendiultimologin(utente));

					dainviare=ServerEncoderLogin.login(utentelogin);

					writer.write(dainviare);
					writer.flush(); 

				case"LOGINKO":

					dainviare="KO#le credenziali inserite non sono corrette\n";

					writer.write(dainviare);
					writer.flush(); 

				case"REGISTRAZIONEOK":

					//salvo i dari che mi servono in utetnelogin dal DB
					System.out.println("sono in registrazione OK");
					utente.setNomeUtente(utenteregistrazione.getNomeUtente());
					System.out.println("ho fatto get nome");
					utente.setPsw(utenteregistrazione.getPsw());
					System.out.println("ho fatto get psw");
					utentelogin.setPosizione(UpdaterDB.posizioneClassifica(utente));
					System.out.println("ho fatto get posizione classifica");
					utentelogin.setNome(UpdaterDB.prendinomi(utente));
					System.out.println("ho fatto prendinomi");
					utentelogin.setCognome(UpdaterDB.prendicognomi(utente));
					System.out.println("ho fatto prendicognomi");
					utentelogin.setCrediti(UpdaterDB.prendipunti(utente));
					System.out.println("ho fatto prendipunti");

					dainviare=ServerEncoderRegistrazione.registrazione(utentelogin);

					writer.write(dainviare);
					writer.flush(); 

				case"REGISTRAZIONEKO":

					dainviare="KO#il nomeutente è già presente o le credenziali non sono complete\n";

					writer.write(dainviare);
					writer.flush();
				}

			}while(parolachiave.equalsIgnoreCase("LOGINKO")||parolachiave.equalsIgnoreCase("REGISTRAZIONEKO"));



			//comincio la scelta del gioco o della classifica da giocare o da visualizzare




			stringa = reader.readLine(); 
			System.out.println("Ricevuta stringa: "+stringa);


			StringTokenizer st = new StringTokenizer(stringa, "#");
			switch(st.nextToken()){
			case "SLOT":
				if(UpdaterDB.prendipunti(utente)>10){
					combinazioneslot=Slot.calcolaCombinazione();
					creditivinti=Slot.getPunti();
					credititotali=UpdaterDB.prendipunti(utente);
					String risultato=Slot.getPremio();
					dainviare=ServerEncoderSlot.slot(combinazioneslot, risultato, creditivinti, credititotali);
					UpdaterDB.aggiornapunti(utente, creditivinti, creditispesi);


				}else{
					UpdaterDB.aggiornapunti(utente, 0, creditispesi);
					dainviare=ServerEncoderNoCrediti.nocrediti(UpdaterDB.prendipunti(utente));
				}
			case "TOMBOLA":
				if(UpdaterDB.prendipunti(utente)>100){
					creditispesi=ServerDecoderNSchede.NumeroSchede*20;

					//entro nella sala d'attesa

					partitatombola.partitatombola(utente.getNomeUtente(), ServerDecoderNSchede.NumeroSchede);

					UpdaterDB.aggiornapunti(utente, 0, creditispesi);

					for(int i=0;i<ServerDecoderNSchede.NumeroSchede;i++){
						Tabella.tabella();
					}
					credititotali=UpdaterDB.prendipunti(utente);
					dainviare=ServerEncoderSchedeTombola.schede(credititotali);
					writer.write(dainviare);
					writer.flush();

					while(!ServerDecoderVincitaTomb.VincitaTombola.equalsIgnoreCase("TOMBOLA")){

						stringa = reader.readLine();

						st = new StringTokenizer(stringa, "#");


						switch(st.nextToken()){

						case "ESTRAZIONE":

							Integer estratto=null;

							for(Integer i=0;i<PartitaTombola.Partite.size();i++){
								if(PartitaTombola.Partite.get(i).getUtente1().equalsIgnoreCase(utente.getNomeUtente())||PartitaTombola.Partite.get(i).getUtente2().equalsIgnoreCase(utente.getNomeUtente())){
									if(PartitaTombola.Partite.get(i).getAvvenuta()==false){
										Tabellone.estrazione(utente);
									}

								}

							}

							for(Integer i=0;i<PartitaTombola.Partite.size();i++){
								if(PartitaTombola.Partite.get(i).getUtente1().equalsIgnoreCase(utente.getNomeUtente())||PartitaTombola.Partite.get(i).getUtente2().equalsIgnoreCase(utente.getNomeUtente())){
									estratto=PartitaTombola.Partite.get(i).getUltimoNEstratto();

								}

							}

							dainviare=ServerEncoderNEstratto.n_estratto(estratto);


							for(Integer i=0;i<PartitaTombola.Partite.size();i++){
								if(PartitaTombola.Partite.get(i).getUtente1().equalsIgnoreCase(utente.getNomeUtente())||PartitaTombola.Partite.get(i).getUtente2().equalsIgnoreCase(utente.getNomeUtente())){
									PartitaTombola.Partite.get(i).setAvvenuta(false);

								}

							}

							writer.write(dainviare);
							writer.flush();

						case "VINCITATOMBOLA":

							ServerDecoderVincitaTomb.decodervincita(stringa);

							Boolean vero = Tabella.vincita(ServerDecoderVincitaTomb.VincitaTombola);

							if(vero==true){
								for(Integer i=0;i<PartitaTombola.Partite.size();i++){
									if(PartitaTombola.Partite.get(i).getUtente1().equalsIgnoreCase(utente.getNomeUtente())||PartitaTombola.Partite.get(i).getUtente2().equalsIgnoreCase(utente.getNomeUtente())){
										switch(ServerDecoderVincitaTomb.VincitaTombola){
										case"AMBO":
											switch(PartitaTombola.Partite.get(i).getVincitaChiamata()){
											case "AMBO":
												dainviare="KO#la vincita è già stata chiamata\n";

											case "TERNO":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un terno\n";
											case "QUATERNA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un quaterna\n";
											case "CINQUINA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un cinquina\n";
											case "TOMBOLA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un tombola\n";
											default: 
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());

												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);


											}
										case"TERNO":
											switch(PartitaTombola.Partite.get(i).getVincitaChiamata()){
											case "AMBO":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);
											case "TERNO":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un terno\n";
											case "QUATERNA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un quaterna\n";

											case "CINQUINA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un cinquina\n";

											case "TOMBOLA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un tombola\n";

											default: 
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);


											}
										case"QUATERNA":
											switch(PartitaTombola.Partite.get(i).getVincitaChiamata()){
											case "AMBO":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);

											case "TERNO":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);

											case "QUATERNA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un quaterna\n";

											case "CINQUINA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un cinquina\n";

											case "TOMBOLA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un tombola\n";

											default: 
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);


											}
										case"CINQUINA":
											switch(PartitaTombola.Partite.get(i).getVincitaChiamata()){
											case "AMBO":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);

											case "TERNO":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);

											case "QUATERNA":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);

											case "CINQUINA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un cinquina\n";

											case "TOMBOLA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un tombola\n";

											default: 
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);


											}
										case"TOMBOLA":
											switch(PartitaTombola.Partite.get(i).getVincitaChiamata()){
											case "AMBO":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);

											case "TERNO":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);

											case "QUATERNA":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);

											case "CINQUINA":
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);

											case "TOMBOLA":
												dainviare="KO#la vincita chiamata è troppo bassa, c'è già stato un tombola\n";

											default: 
												PartitaTombola.Partite.get(i).setVincitaChiamata(ServerDecoderVincitaTomb.VincitaTombola);

												creditivinti=Tabellone.quantovinci(ServerDecoderVincitaTomb.VincitaTombola, PartitaTombola.Partite.get(i).getRicavato());
												UpdaterDB.aggiornapunti(utente, creditivinti, 0);

												dainviare=ServerEncoderVincitaTombola.vinicitatombola(creditivinti, ServerDecoderVincitaTomb.VincitaTombola);


											}
										}

									}

								}

							}else{
								dainviare="KO#falsa dichiarazione\n";
							}

							writer.write(dainviare);
							writer.flush();



						}
					}
					ServerDecoderVincitaTomb.VincitaTombola=null;

					partitatombola.cancellapartitafinita(utente.getNomeUtente());

				}else{
					dainviare=ServerEncoderNoCrediti.nocrediti(UpdaterDB.prendipunti(utente));
				}

			case "RUBAMAZZO":
				if(UpdaterDB.prendipunti(utente)>200){
					Integer idpartita=partitarubamazzo.partitarubamazzo(utente.getNomeUtente());

					PartitaRubamazzo.Partite.get(idpartita).setMazzo(ComposizioneMazzo.componi());

					PartitaRubamazzo.Partite.get(idpartita).setSituazione(DistribuzioneCarte.maziere(idpartita));

					dainviare=ServerEncoderPartecipanti.partecipanti(idpartita);

					writer.write(dainviare);
					writer.flush();


					while(PartitaRubamazzo.Partite.get(idpartita).getMazzo().size()==0){

						stringa = reader.readLine(); 
						System.out.println("Ricevuta stringa: "+stringa);

						st = new StringTokenizer(stringa, "#");

						if(st.nextToken().equalsIgnoreCase("AGGIORNAMENTO")){

							dainviare=ServerEncoderRubamazzo.recapcarte(PartitaRubamazzo.Partite.get(idpartita).getSituazione(), utente.getNomeUtente(), idpartita);

						}

						if(st.nextToken().equalsIgnoreCase("RUBAMAZZO")){

							Carta cartagiocata=ServerDecoderRubamazzo.decoderruba(stringa);

							PartitaRubamazzo.Partite.get(idpartita).setSituazione(ControllaMossa.controlla(PartitaRubamazzo.Partite.get(idpartita).getSituazione(), cartagiocata, utente.getNomeUtente(), idpartita));

							PescaCarta.pescacarta(idpartita, utente.getNomeUtente());

							dainviare=ServerEncoderRubamazzo.recapcarte(PartitaRubamazzo.Partite.get(idpartita).getSituazione(), utente.getNomeUtente(), idpartita);

						}

						writer.write(dainviare);
						writer.flush();


					}

					while(PartitaRubamazzo.Partite.get(idpartita).getSituazione().Carteinmano1.size()>0||PartitaRubamazzo.Partite.get(idpartita).getSituazione().Carteinmano2.size()>0||PartitaRubamazzo.Partite.get(idpartita).getSituazione().Carteinmano3.size()>0||PartitaRubamazzo.Partite.get(idpartita).getSituazione().Carteinmano4.size()>0){
						stringa = reader.readLine(); 
						System.out.println("Ricevuta stringa: "+stringa);


						st = new StringTokenizer(stringa, "#");

						if(st.nextToken().equalsIgnoreCase("AGGIORNAMENTO")){

							dainviare=ServerEncoderRubamazzo.recapcarte(PartitaRubamazzo.Partite.get(idpartita).getSituazione(), utente.getNomeUtente(), idpartita);

						}

						if(st.nextToken().equalsIgnoreCase("RUBAMAZZO")){

							Carta cartagiocata=ServerDecoderRubamazzo.decoderruba(stringa);

							PartitaRubamazzo.Partite.get(idpartita).setSituazione(ControllaMossa.controlla(PartitaRubamazzo.Partite.get(idpartita).getSituazione(), cartagiocata, utente.getNomeUtente(), idpartita));

							dainviare=ServerEncoderRubamazzo.recapcarte(PartitaRubamazzo.Partite.get(idpartita).getSituazione(), utente.getNomeUtente(), idpartita);

						}

						writer.write(dainviare);
						writer.flush();

					}
					
					ArrayList<String> classificaruba=CalcolaVincitore.calcola(idpartita);
					
					dainviare=ServerEncoderClassRuba.classruba(classificaruba, utente, idpartita);
					
					writer.write(dainviare);
					writer.flush();
					

				}else{
					dainviare=ServerEncoderNoCrediti.nocrediti(UpdaterDB.prendipunti(utente));
				}


			case "CLASSIFICAGLOBALE":

				ArrayList<String> nomiclassifica=UpdaterDB.classificaGlobale();
				ArrayList<Integer> punticlassifica=UpdaterDB.classificaGlobalePunti();

				dainviare=ServerEncoderClassifica.classifica(nomiclassifica, punticlassifica);

				writer.write(dainviare);
				writer.flush();

			case "CLASSIFICAGIORNALIERA":

				nomiclassifica=UpdaterDB.classificaGlobaleGiorn();
				punticlassifica=UpdaterDB.classificaGlobalePuntiGiorn();

				dainviare=ServerEncoderClassifica.classifica(nomiclassifica, punticlassifica);

				writer.write(dainviare);
				writer.flush();
			}




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
