package bupt.zhang.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client01 {
	private static String name;
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.print("�����������ǳ�:");
		Scanner input=new Scanner(System.in);
		name=input.next();
		Socket client=new Socket("localhost",9999);
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();	
		System.out.println("��ӭ������������!");
	}
}
