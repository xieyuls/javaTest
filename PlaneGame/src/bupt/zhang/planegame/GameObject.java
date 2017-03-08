package bupt.zhang.planegame;

import java.awt.Rectangle;

/**
 * 封装游戏物体的共同属性和方法
 * @author Xieyu
 *
 */
public class GameObject {
	double x,y;  //在地图上的坐标位置
	double speed;  //飞行的速度
	double width,height; //获取宽度和高度

//获取矩形信息，用以进行碰撞检测
	
	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y, (int)width,(int)height);
	}
}
