package bupt.zhang.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
	private String method;  //采用的方法(post,get)
	private String url;    //资源
	private Map<String,List<String>> parameter;   //存储提取出来的参数
	private String RequestInfo;     //读取到的整个Request信息
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
		//分解String获取请求方式和请求参数
		String firstLine=RequestInfo.substring(0, RequestInfo.indexOf(CLRF));
		this.method=firstLine.substring(0, firstLine.indexOf("/")).trim();
		if(this.method.equals("GET")){
			url=firstLine.substring(firstLine.indexOf("/")+1, firstLine.indexOf("HTTP/")).trim();
			
		}
	}
}
