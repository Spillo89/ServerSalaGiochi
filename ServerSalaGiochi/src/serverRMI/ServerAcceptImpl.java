package serverRMI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import commonsRMImulti.Client;
import commonsRMImulti.Server;
import commonsRMImulti.ServerAccept;

//import beans.InfoUtenti;

public class ServerAcceptImpl extends UnicastRemoteObject implements ServerAccept {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String url = "rmi://127.0.0.1/server";
	private static final String host = "127.0.0.1";
	private ArrayList<ServerImpl> clients = null;
	private ArrayList<String> clientNames = null;
	private Object lock = null; //Necessario per la sincronizzazione
	private Thread serverThread;
	//Costruttore di default
	public ServerAcceptImpl() throws RemoteException {
		clients = new ArrayList<ServerImpl>();
		clientNames = new ArrayList<String>();
		lock = new Object();
	}
	public static void main(String args[]) {
		try {
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new SecurityManager());
			ServerAccept stub = new ServerAcceptImpl();
			Registry registry = LocateRegistry.getRegistry(host);
			registry.rebind(url, stub);
			//Da asesso in poi posso accettare le connessioni
			System.out.println("Server ready");
			BufferedReader inputBuffer = new BufferedReader(new
					InputStreamReader(System.in));
			String input = null;
			Boolean continua = true;
			while(continua){
				System.out.println("Digitare Exit per uscire");
				input = inputBuffer.readLine();
				if(input.trim().equalsIgnoreCase("exit")){
					continua = false;
				}
			}
			inputBuffer.close();
			registry.unbind(url);
			System.out.println("server terminato");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*public Server login(String name, Client client) throws RemoteException {
		ServerImpl server = new ServerImpl(name, client, this);
		serverThread = new Thread(server);
		server.setThread(serverThread);
		synchronized (lock) {
			clients.add(server);
			clientNames.add(name);
		}
		serverThread.start();
		return (Server) server;
	}*/
	public void rimuovimi(ServerImpl serverForClient) {
		synchronized (lock) {
			clients.remove(serverForClient);
			clientNames.remove(serverForClient.getName());
		}
	}
	/*public InfoUtenti getInfoUtenti() {
		return new InfoUtenti(clientNames);
	}*/
}