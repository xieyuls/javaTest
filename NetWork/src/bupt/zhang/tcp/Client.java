package bupt.zhang.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket("localhost",8888);
		DataInputStream dos=new DataInputStream(client.getInputStream());
		System.out.println(dos.readUTF());
	}
}
