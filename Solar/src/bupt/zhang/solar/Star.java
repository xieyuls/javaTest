package bupt.zhang.solar;

import java.awt.Graphics;
import java.awt.Image;

import bupt.zhang.util.GameUtil;

public class Star {
	Image img;
	double x,y;
	double width,height;
	
	public Star(String imgpath,double x,double y){
		this.img=GameUtil.getImage(imgpath);
		height=img.getHeight(null);
		width=img.getWidth(null);
		this.x=x;
		this.y=y;
	}
	
	public Star(String imgpath){
		this.img=GameUtil.getImage(imgpath);
	}
	
	public Star(){
		
	}
	
	public void draw(Graphics g){
		
		g.drawImage(img,(int)x,(int)y,null);
	}
}
