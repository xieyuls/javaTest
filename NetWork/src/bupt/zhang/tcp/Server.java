package bupt.zhang.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		
		ServerSocket server=new ServerSocket(8888);
		Socket socket=server.accept();
		System.out.println("��һ���ͻ������ӵ��˷�����");
		String msg="��ӭʹ��!";
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		
	}
}
