package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.List;


public class Client {

	
	private static ObjectOutputStream out;
	boolean isNovice;
	private String addr,port;
	public Client(String address, String portNo, boolean isNovice){
		this.isNovice=isNovice;
		addr=address;
		port=portNo;
	}
	public static void main(String[] args) throws URISyntaxException {
		//Client c=new Client("localhost","7676",true);
		//c.start();
		System.out.println(Client.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
	}
	private ObjectInputStream in;
	public  boolean start() {
		boolean res=false;
		try {
			s=new Socket(addr,Integer.parseInt(port));
			
			//in=new ObjectInputStream(s.getInputStream());
			out=new ObjectOutputStream(s.getOutputStream());
			//System.out.println(in.readObject());
			res=true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	private Socket s;
	public List<?> getQueList(){
					try {
						return (List<?>) in.readObject();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		return null;

	}
	public void stop(){
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void storeScore(String username,int score) {
	
		Message msg=new Message(username, score,Message.SCORE,isNovice);
		try {
			out.writeObject(msg);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
