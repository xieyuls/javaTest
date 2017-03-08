package bupt.zhang.solar;

import java.awt.Color;
import java.awt.Graphics;

import bupt.zhang.util.GameUtil;

public class Planet extends Star{
//	行星需要围绕恒星运动，需要长轴，短轴，运动速度，角度，绕行恒星等属性。
	double longAxis;
	double shortAxis;
	double speed;
	double degree=0;
	double height,width;
	Star center;
	
	public Planet(String imgpath,double x,double y){
		super(imgpath,x,y);
	}
	
	public Planet(){
		
	}

	public Planet(Star center,String imgpath,double longAxis,
			double shortAxis, double speed) {
		super();
		this.center = center;
		this.x=center.x+center.width/2+longAxis;
		this.y=center.y+center.height/2;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.img=GameUtil.getImage(imgpath);
		height=img.getHeight(null);
		width=img.getWidth(null);
	}
	
	public void drawtrace(Graphics g){
		double ovalX,ovalY,ovalWidth,ovalHeight;
		ovalWidth=longAxis*2;
		ovalHeight=shortAxis*2;
		ovalX=(center.x+center.width/2)-longAxis;
		ovalY=(center.y+center.height/2)-shortAxis;
		Color c=g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX,(int)ovalY,(int)ovalWidth,(int)ovalHeight);
		g.setColor(c);
	}
	
	public void draw(Graphics g){
		super.draw(g);
		//drawtrace(g);
		g.drawImage(img,(int)x,(int)y,null);
		//沿椭圆轨道飞行
		x=center.x+center.width/2+longAxis*Math.cos(degree);
		y=center.y+center.height/2+shortAxis*Math.sin(degree);
		degree+=speed;
	}
	
    
}
