package Multiplayer;


import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

 
public class Server {


	public ServerSocket server=null;
	public Socket socketClient=null;
	
	int porta =6666;
	 
	DataInputStream in;
	DataOutputStream out;
	
	
	
	public void Comunica()
	{
		try {
			String letto=in.readLine();
			String risposta=letto.toUpperCase();
			 out.writeBytes(risposta+"\n" );
			socketClient.close();
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Socket attendi()
	{
		try {
		
			
			server = new ServerSocket(6666);
			socketClient=server.accept();
			server.close();
			
			
			in= new DataInputStream(socketClient.getInputStream());
			out = new DataOutputStream(socketClient.getOutputStream());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socketClient;
	}
	
	public static void main (String[]Args)
	{
		Server s = new Server();
		s.attendi();
		s.Comunica();
	}
	
	
	
	
}
