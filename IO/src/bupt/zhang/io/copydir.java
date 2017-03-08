package bupt.zhang.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 复制整个文件夹（包括里面的文件）
 * @author Xieyu
 *
 */
public class copydir {
	
	public static void main(String[] args) {
		File src=new File("E:/Work/iotest/src");
		File dest=new File("E:/Work/iotest/dest");
		CopyDir(src,dest);
		
	}
	public static void CopyDir(File src,File dest){
		if(src.isFile()){
			try {
				copyfile.CopyFile(src, dest);
			} catch (FileNotFoundException e) {
				System.out.println("文件找不到！！");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("输入输出有问题！！");
				e.printStackTrace();
			}
		}else if(src.isDirectory()){
//		1.确保目的地目录存在
			dest.mkdirs();
			for(File temp:src.listFiles()){
				CopyDir(temp,new File(dest,temp.getName()));
			}
		}
		
	}
}
