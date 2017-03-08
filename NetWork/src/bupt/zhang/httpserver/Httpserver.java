package bupt.zhang.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/*
 * ��װ�������������
 * 
 */
public class Httpserver {
	
	public static void main(String[] args) {
		new Httpserver().Creatserver();
	}
	
	private ServerSocket server;
	private Socket client;
	//1.��һ��,����������
	public void Creatserver(){
		try {
			server=new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			System.out.println("��������������");
		}
	}
	
	//2.�ڶ���,��ȡ�ͻ���
	private void receive(){
		try {
			client=server.accept();
			//3.������,������������ȡ�ͻ��˷��͵���Ϣ
			StringBuilder info=new StringBuilder();
			byte[] car=new byte[1024];
			int length=client.getInputStream().read(car);
			String msg=new String(car,0,length);
			info.append(msg);
			System.out.println(info.toString());
			
			//��Ӧ
			Response res=new Response(client.getOutputStream());
			res.println("<html><head><title>����һ����Ӧ</title></head>");
			res.println("<body>hello!!!!!!!</body></html>");
			res.pushToClient(200);
		} catch (IOException e) {
			System.out.println("��ȡ�ͻ��˳���");
		}
	}
	
	public void stop(){
		try {
			server.close();
		} catch (IOException e) {
			System.out.println("�������رմ���");
		}
	}
}
