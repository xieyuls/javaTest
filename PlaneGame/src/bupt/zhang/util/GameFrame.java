package bupt.zhang.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * ����������
 * @author Xieyu
 *
 */
public class GameFrame extends Frame {
	
	
	public void creatframe(){
		setSize(Constant.WIDTH,Constant.HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
			System.exit(0);
			}
		});
		new PaintThread().start();
		

	}


		// ��дupdate����,�Ƚ������ϵ�ͼ�λ���ͼƬ�����ϣ���һ������ʾ    
	
 
	Image ImageBuffer = null;  
	Graphics GraImage = null;  
	 @Override 
	public void update(Graphics g){     //����update��������ȡĬ�ϵĵ��ù���  
	    ImageBuffer = createImage(this.getWidth(), this.getHeight());   //����ͼ�λ�����  
	    GraImage = ImageBuffer.getGraphics();       //��ȡͼ�λ�������ͼ��������  
	    paint(GraImage);        //��paint�����б�д�Ļ�ͼ���̶�ͼ�λ�������ͼ  
	    GraImage.dispose();     //�ͷ�ͼ����������Դ  
	    g.drawImage(ImageBuffer, 0, 0, this);   //��ͼ�λ��������Ƶ���Ļ��  
	}  
	  
//	public void paint(Graphics g){      //��paint������ʵ�ֻ�ͼ����  
//	    g.drawLine(0, 0, 100, 100);  
//	}  
	
	
class PaintThread extends Thread{

	public void run(){
		while(true){
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
	

}
