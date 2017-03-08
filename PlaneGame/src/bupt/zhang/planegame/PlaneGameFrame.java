package bupt.zhang.planegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import bupt.zhang.util.Constant;
import bupt.zhang.util.GameFrame;
import bupt.zhang.util.GameUtil;

public class PlaneGameFrame extends GameFrame{
	Image bg=GameUtil.getImage("images/bg.png");
	Plane player=new Plane("images/player.png",Constant.WIDTH/2,Constant.HEIGHT/6,10);
    ArrayList bulletlist=new ArrayList();
	long begintime=System.currentTimeMillis();  //��Ϸ��ʼʱ��
	double time;    //���ֵ�ʱ��
	
	public void paint(Graphics g){
		Font f=new Font("����",Font.BOLD,50);
		Color c=g.getColor();
		g.drawImage(bg, 0, 0, null);
		player.draw(g);
		player.move();
		for(int i=0;i<bulletlist.size();i++){
			Bullet b=(Bullet)bulletlist.get(i);
			b.draw(g);
			boolean impact=player.getRect().intersects(b.getRect());
			
			if(impact){
				player.setAlive(false);			
				if(time==0)	{
					time=(System.currentTimeMillis()-begintime);
					time=time/1000;
				}
			}
		}	
		if(!player.alive){
				g.setColor(Color.white);
				g.setFont(f);
				g.drawString("Game Over",280, 200);
				g.drawString("���ʱ��:"+time+"��", 210, 300);
				if(time<10){
					g.drawString("���Ǹ�����",260, 400);
				}
				else if(time>10){
					g.drawString("���ֲ���",260, 400);
				}
			}
			g.setColor(c);
		
	}
	
	public void creatframe(){
		super.creatframe();
		setResizable(false);
		setTitle("�Ǹߴ�ͼ��100�룡  version:1.0");
		for(int i=0;i<20;i++){
			Bullet b=new Bullet(8);
			bulletlist.add(b);
		}
		
		addKeyListener(new KeyMonitor());
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().creatframe();
	}
	
class KeyMonitor extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		player.adddirection(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.deletedirection(e);
	}
	
}
}
