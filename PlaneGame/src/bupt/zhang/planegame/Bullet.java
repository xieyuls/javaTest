package bupt.zhang.planegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import bupt.zhang.util.Constant;
import bupt.zhang.util.GameUtil;


/**
 * 封装子弹的属性和方法
 * @author Xieyu
 *
 */
public class Bullet extends GameObject{

	double degree;  //子弹飞行的角度

	
	public Bullet(double speed){
	//	this.img=GameUtil.getImage(imgpath);
		this.speed=speed;
		this.x=Constant.WIDTH/2;
		this.y=Constant.HEIGHT/2;
		this.degree=Math.random()*Math.PI*2;
		this.width=8;
		this.height=8;
		
	}
	
	public Bullet(String imgpath,double x,double y,double speed){
		this.x=x;
		this.y=y;
		this.speed=speed;
		this.degree=Math.random()*Math.PI*2;
		this.width=8;
		this.height=8;
	}
	
	public Bullet(){
		this.speed=10;
		this.x=Constant.WIDTH/2;
		this.y=Constant.HEIGHT/2;
		this.degree=Math.random()*Math.PI*2;
		this.width=8;
		this.height=8;
	}
	
	public void move(){
		if(x<0||x>Constant.WIDTH-8){
			degree=Math.PI-degree;
		}
		if(y<0||y>Constant.HEIGHT-8){
			degree=-degree;
		}
	}
	
	public void draw(Graphics g){
	//	g.drawImage(img, (int)x, (int)y, null);
		Color c=g.getColor();
		g.setColor(Color.orange);
		g.fillOval((int)x,(int)y,8,8);
		move();
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		g.setColor(c);
	}

}
