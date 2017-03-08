package bupt.zhang.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * 基础界面类
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


		// 重写update方法,先将窗体上的图形画在图片对象上，再一次性显示    
	
 
	Image ImageBuffer = null;  
	Graphics GraImage = null;  
	 @Override 
	public void update(Graphics g){     //覆盖update方法，截取默认的调用过程  
	    ImageBuffer = createImage(this.getWidth(), this.getHeight());   //创建图形缓冲区  
	    GraImage = ImageBuffer.getGraphics();       //获取图形缓冲区的图形上下文  
	    paint(GraImage);        //用paint方法中编写的绘图过程对图形缓冲区绘图  
	    GraImage.dispose();     //释放图形上下文资源  
	    g.drawImage(ImageBuffer, 0, 0, this);   //将图形缓冲区绘制到屏幕上  
	}  
	  
//	public void paint(Graphics g){      //在paint方法中实现绘图过程  
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
