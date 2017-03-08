package bupt.zhang.httpserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

/*
 * ��װ�������Կͻ��˵Ļظ�
 * 
 */
public class Response {
	private static final String BLANK=" ";
	private static final String CLRF="\r\n";
	private int len;
	private StringBuilder context;
	private StringBuilder headinfo;
	private BufferedWriter bw;
	
	public Response(){
		context=new StringBuilder();
		headinfo=new StringBuilder();
		len=0;
	}
	
	public Response(OutputStream os){
		this();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	
	//��������
	public Response print(String msg){
		context.append(msg);
		len+=msg.getBytes().length;
		return this;
	}
	//��������
	public Response println(String msg){
		context.append(msg).append(CLRF);
		len+=(msg+CLRF).getBytes().length;
		return this;
	}
	
	//��װresopnse��ͷ����Ϣ
	public void Headinfo(int code){
		
		//1.HTTPЭ��,״̬,��ʾ��Ϣ
		headinfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch(code){
			case 200:
				headinfo.append("OK");
				break;
			case 404:
				headinfo.append("NOT FOUND");
				break;
			case 500:
				headinfo.append("SERVER ERROR");
				break;
			default:
				break;
		}
		headinfo.append(CLRF);
		//2.ͷ����Ϣ
		headinfo.append("Server:localhost:8888/0.0.1").append(CLRF);
		headinfo.append("Date:").append(new Date()).append(CLRF);
		headinfo.append("Content-type:text/html;charset=GBK").append(CLRF);
		headinfo.append("Content-length:").append(len).append(CLRF);
		headinfo.append(CLRF);
	}
	
	//���ظ���Ϣ���ͳ�ȥ
	public void pushToClient(int code) throws IOException{
		//����ͷ��Ϣ
		Headinfo(code);
		bw.append(headinfo.toString());
		bw.append(context.toString());
		bw.flush();	
	}
	
	public void close(){
		Util.CloseAll(bw);
	}
}
