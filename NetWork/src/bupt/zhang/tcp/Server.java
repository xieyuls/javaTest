package bupt.zhang.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		
		ServerSocket server=new ServerSocket(8888);
		Socket socket=server.accept();
		System.out.println("有一个客户端连接到了服务器");
		String msg="欢迎使用!";
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		
	}
}
