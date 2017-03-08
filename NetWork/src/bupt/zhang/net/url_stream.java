package bupt.zhang.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class url_stream {
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		URL url=new URL("http://www.baidu.com");
		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter wr=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
		String msg=null;
		while((msg=br.readLine())!=null){
			wr.append(msg);
			wr.newLine();
		}
		wr.flush();
		wr.close();
		br.close();
	}
}
