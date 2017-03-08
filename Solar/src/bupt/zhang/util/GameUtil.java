package bupt.zhang.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 工具类(封装一些工具方法，比如加载图片)
 * @author Xieyu
 *
 */
public class GameUtil {
	
	private GameUtil(){
		
	}
	
	public static Image getImage(String imagepath){
		URL u=GameUtil.class.getClassLoader().getResource(imagepath);
		BufferedImage img=null;
		try {
			img=ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
}
