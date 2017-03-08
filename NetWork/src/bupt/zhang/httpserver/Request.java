package bupt.zhang.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
	private String method;  //���õķ���(post,get)
	private String url;    //��Դ
	private Map<String,List<String>> parameter;   //�洢��ȡ�����Ĳ���
	private String RequestInfo;     //��ȡ��������Request��Ϣ
	public static final String CLRF="\r\n"; 
	public static final String BLANK=" "; 
	
	public Request(){
		method="";
		url="";
		parameter=new HashMap<String,List<String>>();
		RequestInfo="";
	}
	
	public Request(InputStream is){
		this();
		byte[] info=new byte[20480];
		try {
			int len=is.read(info);
			RequestInfo=new String(info,0,len);
			getParameter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getParameter(){
		if(RequestInfo==null||RequestInfo.trim().equals("")){
			return;
		}
		//�ֽ�String��ȡ����ʽ���������
		String firstLine=RequestInfo.substring(0, RequestInfo.indexOf(CLRF));
		this.method=firstLine.substring(0, firstLine.indexOf("/")).trim();
		if(this.method.equals("GET")){
			url=firstLine.substring(firstLine.indexOf("/")+1, firstLine.indexOf("HTTP/")).trim();
			
		}
	}
}
