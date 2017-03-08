package bupt.zhang.solar;

import java.awt.Graphics;
import java.awt.Image;

import bupt.zhang.util.Constant;
import bupt.zhang.util.GameFrame;
import bupt.zhang.util.GameUtil;


public class solarFrame extends GameFrame{
	Image img=GameUtil.getImage("images/bg2.png");
	Star Sun=new Star("images/Sun.png",Constant.WIDTH/2,Constant.HEIGHT/2);
	Planet Mercury=new Planet(Sun,"images/ˮ��.png",30,30,0.1);
	Planet Venus=new Planet(Sun,"images/����.png",50,50,0.05);
	Planet earth=new Planet(Sun,"images/����.png",75,75,0.01);
	Planet Mars=new Planet(Sun,"images/����.png",100,100,0.008);
	Planet Jupiter=new Planet(Sun,"images/ľ��.png",150,150,0.003);
	Planet Saturn=new Planet(Sun,"images/����.png",200,200,0.001);
	Planet Uranus=new Planet(Sun,"images/������.png",300,300,0.0009);
	Planet Neptune=new Planet(Sun,"images/������.png",325,325,0.0006);
	satellite moon=new satellite(earth,"images/����.png",15,15,0.01);
	
	
	public void paint(Graphics g){
		
		g.drawImage(img, 0, 0, null);
		Sun.draw(g);
		Mercury.draw(g);
		Venus.draw(g);
		earth.draw(g);		
		Mars.draw(g);
		Jupiter.draw(g);
		Saturn.draw(g);
		Uranus.draw(g);
		Neptune.draw(g);
		moon.draw(g);

		//earth.draw(g);
	}
	
	public static void main(String[] args) {
		new solarFrame().creatframe();
	}
}
