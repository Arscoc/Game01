package Multiplayer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.WritableByteChannel;

public class Client {

	Socket mioSocket=null;
	
	int porta =6666;
	 
	DataInputStream in;
	DataOutputStream out;
	
	BufferedReader tastiera;
	
	public void Comunica()
	{
		
		
		
		try {
			tastiera=new BufferedReader(new InputStreamReader(System.in));
			String messaggio=tastiera.readLine();
			out.writeBytes(messaggio + "\n");
			String ricevuta = in.readLine();
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Socket connetti()
	{
		try {
			Socket mioSocket =new Socket(InetAddress.getLocalHost(), porta);
			in= new DataInputStream(mioSocket.getInputStream());
			out = new DataOutputStream(mioSocket.getOutputStream());
			
		
		
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mioSocket;
	}
	
	public static void main (String[]Args)
	{
		Client c = new Client();
		c.connetti();
		c.Comunica();
	}
	
	
}
