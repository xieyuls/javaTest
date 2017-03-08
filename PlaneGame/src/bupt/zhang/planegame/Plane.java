package bupt.zhang.planegame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import bupt.zhang.util.GameUtil;

/**
 * 封装飞机的属性和方法
 * @author Xieyu
 *
 */

public class Plane extends GameObject{
    Image img;
	private boolean left,right,up,down;  //飞机移动的方向
	boolean alive=true;
	private int counter=8;
	
	
	public Plane(String imgpath,double x,double y,double speed){
		this.img=GameUtil.getImage(imgpath);
		this.x=x;
		this.y=y;
		this.speed=speed;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	
	public Plane(){
		
	}
	
	
	public void draw(Graphics g){
		if(alive)
			g.drawImage(img, (int)x,(int)y,null);
		else{
			if(counter>0){
				g.drawImage(GameUtil.getImage("images/爆炸.gif"),(int)x,(int)y,null);
				counter--;
			}
		}
			
		move();
	}
	
	public void move(){
		if(left){
			if(x>0)
				x-=speed;
			else
				x-=0;
		}
		if(right){
			if(x<800-img.getWidth(null))
				x+=speed;
			else
				x-=0;
		}
		if(up){
			if(y>0)
				y-=speed;
			else
				y-=0;
		}
		if(down){
			if(y<600-img.getHeight(null))
				y+=speed;
			else
				y+=0;
		}
	}
	
	public void adddirection(KeyEvent e){
		switch(e.getKeyCode()){
		case 37:
			left=true;
			break;
		case 38:
			up=true;
			break;
		case 39:
			right=true;
			break;
		case 40:
			down=true;
			break;
		default:
			break;
		}
	}
	
	public void deletedirection(KeyEvent e){
		switch(e.getKeyCode()){
		case 37:
			left=false;
			break;
		case 38:
			up=false;
			break;
		case 39:
			right=false;
			break;
		case 40:
			down=false;
			break;
		default:
			break;
		}
	}
	
	public void setAlive(boolean alive){
		this.alive=alive;
	}

}
