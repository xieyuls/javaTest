package bupt.zhang.net;

import java.net.MalformedURLException;
import java.net.URL;

public class url_test {
	public static void main(String[] args) throws MalformedURLException {
		URL url=new URL("http://www.baidu.com:80/index.html?uname=xieyuls");
		System.out.println("Э��:"+url.getProtocol());
		System.out.println("����:"+url.getHost());
		System.out.println("�˿�:"+url.getPort());
		System.out.println("��Դ:"+url.getFile());
		System.out.println("����:"+url.getQuery());
		
	}
}
