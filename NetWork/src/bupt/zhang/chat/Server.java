package bupt.zhang.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server {
	private List<Mychannel> list=new ArrayList<Mychannel>();
	public static void main(String[] args) throws IOException {
		new Server().start();
	}
	
	public void start() throws IOException{
		ServerSocket server=new ServerSocket(9999);
		while(true){
			Socket client=server.accept();
			Mychannel mc=new Mychannel(client);
			list.add(mc);
			new Thread(mc).start();
		}
	}
	
	//����ͨ���߳���,��ʵ�ֶ��߳̿������콻��
	private class Mychannel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning=true;
		//���캯��ʹIO����ȡ��������Socket�е�����
		public Mychannel(Socket client){
			try {
				dis=new DataInputStream(client.getInputStream());
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				
				isRunning=false;
				Util.CloseAll(dis,dos);
				list.remove(this);
			}
		}
		//�������ݶ�ȡģ��
		private String receive(){
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				
				isRunning=false;
				Util.CloseAll(dis);
				list.remove(this);
			}
			return msg;
		}
		
		//�������ݷ���ģ��
		private void send(String msg){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning=false;
				Util.CloseAll(dos);
				list.remove(this);
			}
		}
		
		private void sendOthers(){
			
			String msg=this.receive();
			if(msg.startsWith("@")&&msg.endsWith(":")){
				for(Mychannel temp:list){
					if(temp==this){
						continue;
					}
					temp.send(msg.substring(1, msg.indexOf(":"))+"������������");
				}
				return;
			}
			if(msg==null||msg.equals("")){
				return;
			}
			for(Mychannel temp:list){
				if(temp==this){
					continue;
				}
				temp.send(msg);
			}
		}
		
		@Override
		public void run() {
			while(isRunning){
				sendOthers();
			}
			
		}
	}
	
}
