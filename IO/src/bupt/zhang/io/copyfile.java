package bupt.zhang.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class copyfile {
	
	public static void main(String[] args) {
		File src=new File("E:/Work/iotest/test.txt");
		File dest=new File("E:/Work/iotest/test1.txt");
		try {
			CopyFile(src,dest);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void CopyFile(File src,File dest) throws FileNotFoundException,IOException{
		InputStream is=null;
		OutputStream os=null;
		if(!src.isFile()){
			throw new FileNotFoundException("文件不存在");
		}
		int len;
		is=new FileInputStream(src);
		os=new FileOutputStream(dest);
		byte[] car=new byte[1024];
		while(-1!=(len=is.read(car))){
			os.write(car,0,len);
		}
		os.flush();
		os.close();
		is.close();
	}
}

