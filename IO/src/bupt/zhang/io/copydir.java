package bupt.zhang.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ���������ļ��У�����������ļ���
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
				System.out.println("�ļ��Ҳ�������");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("������������⣡��");
				e.printStackTrace();
			}
		}else if(src.isDirectory()){
//		1.ȷ��Ŀ�ĵ�Ŀ¼����
			dest.mkdirs();
			for(File temp:src.listFiles()){
				CopyDir(temp,new File(dest,temp.getName()));
			}
		}
		
	}
}
