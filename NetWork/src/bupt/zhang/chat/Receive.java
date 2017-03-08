package bupt.zhang.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	private DataInputStream dis;
	private boolean isRunning=true;	
	public Receive(Socket client){
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			isRunning=false;
			Util.CloseAll(dis);
		}
	}
	
	public String receive(){
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			isRunning=false;
			Util.CloseAll(dis);
		}
		return msg;
	}
	
	@Override
	public void run() {
		while(isRunning){
			System.out.println(receive());
		}
	}
}
