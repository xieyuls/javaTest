package bupt.zhang.httpserver;

import java.io.Closeable;
import java.io.IOException;

public class Util {
	public  static void CloseAll(Closeable... io){
		for(Closeable temp:io){
			if(temp!=null){
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
