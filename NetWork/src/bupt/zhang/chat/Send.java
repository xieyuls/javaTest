package bupt.zhang.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

public class Send implements Runnable{
	private BufferedReader console;
	private DataOutputStream dos;
	private boolean isRunning=true;
	private String name;

	
	public Send(){
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Send(Socket client,String name){
		this();
		this.name=name;
		
		try {
			dos=new DataOutputStream(client.getOutputStream());
			dos.writeUTF("@"+this.name+":");
		} catch (IOException e) {
			isRunning=false;
			Util.CloseAll(dos,console);
		}
	}
	
	public String getMsgFromConsole(){
		String msg="";
		try {
			msg=console.readLine();
		} catch (IOException e) {
			isRunning=false;
			Util.CloseAll(dos,console);
		}
		return msg;
	}
	
	public void send(){
		String msg=getMsgFromConsole();
		if(msg!=null&&!msg.equals("")){
			try {
				dos.writeUTF(this.name+"		"+new Date(System.currentTimeMillis())+"\r\n"+msg);	
				dos.flush();
			} catch (IOException e) {
				isRunning=false;
				Util.CloseAll(dos,console);
			}
		}
	}
	
	@Override
	public void run() {
		while(isRunning){
			send();
		}	
	}
}
