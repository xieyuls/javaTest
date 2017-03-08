package bupt.zhang.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/*
 * 封装服务器主体程序
 * 
 */
public class Httpserver {
	
	public static void main(String[] args) {
		new Httpserver().Creatserver();
	}
	
	private ServerSocket server;
	private Socket client;
	//1.第一步,建立服务器
	public void Creatserver(){
		try {
			server=new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			System.out.println("服务器建立出错");
		}
	}
	
	//2.第二步,读取客户端
	private void receive(){
		try {
			client=server.accept();
			//3.第三步,建立输入流读取客户端发送的信息
			StringBuilder info=new StringBuilder();
			byte[] car=new byte[1024];
			int length=client.getInputStream().read(car);
			String msg=new String(car,0,length);
			info.append(msg);
			System.out.println(info.toString());
			
			//响应
			Response res=new Response(client.getOutputStream());
			res.println("<html><head><title>这是一个响应</title></head>");
			res.println("<body>hello!!!!!!!</body></html>");
			res.pushToClient(200);
		} catch (IOException e) {
			System.out.println("读取客户端出错");
		}
	}
	
	public void stop(){
		try {
			server.close();
		} catch (IOException e) {
			System.out.println("服务器关闭错误");
		}
	}
}
