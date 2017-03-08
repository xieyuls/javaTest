package bupt.zhang.solar;

import java.awt.Graphics;

import bupt.zhang.util.GameUtil;

public class satellite extends Planet{

	public satellite(String imgpath,double x,double y){
		super(imgpath,x,y);
	}
	
	public satellite(Planet center,String imgpath,double longAxis,
			double shortAxis, double speed) {
		super();
		this.center = center;
		this.x=center.x+center.width/2+longAxis;
		this.y=center.y+center.height/2;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.img=GameUtil.getImage(imgpath);
	}
	
	public void draw(Graphics g){
		
		g.drawImage(img,(int)x,(int)y,null);
		//—ÿÕ÷‘≤πÏµ¿∑…––
		x=center.x+longAxis*Math.cos(degree);
		y=center.y+shortAxis*Math.sin(degree);
		degree+=speed;
	}
}
