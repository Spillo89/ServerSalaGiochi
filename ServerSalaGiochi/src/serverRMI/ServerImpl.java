package serverRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import commonsRMI.Callback;
import commonsRMI.Server;
import commonsRMImulti.Client;

import beans.InfoUtenti;

public class ServerImpl extends UnicastRemoteObject implements Server, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Client client;
	private ServerAcceptImpl server = null;
	private Thread serverThread;
	//Costruttore invocato dal server gestore dell’accept
	public ServerImpl(String name, Client client, ServerAcceptImpl server) throws RemoteException {
		this.name = name;
		this.server = server;
		this.client = client;
		System.out.println("Thread creato per "+name);
	}
	public void run() {
		try {
			int i = 0;
			while(true){
				Thread.sleep(2000);
				i++;
				client.attivoDa(name+": Attivo da "+(i*2)+" secondi");
			}
		} catch (InterruptedException e) {
			System.out.println(name+": Interrup ricevuto. Chiudo il processo");
		} catch (RemoteException e) {
			System.err.println(name+": Errore di comunicazione con client");
		}
		server.rimuovimi(this);
	}
	public void termina() throws RemoteException {
		System.out.println(name+": Ricevuto interrupt su "+serverThread);
		serverThread.interrupt();
	}
	public InfoUtenti getInfoUtenti() throws RemoteException {
		return server.getInfoUtenti();
	}
	public void setThread(Thread serverThread) {
		this.serverThread=serverThread;
	}
	public String getName(){
		return name;
	}
	@Override
	public String sayHello(Callback clientIntance) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}