package bupt.zhang.planegame;

import java.awt.Rectangle;

/**
 * ��װ��Ϸ����Ĺ�ͬ���Ժͷ���
 * @author Xieyu
 *
 */
public class GameObject {
	double x,y;  //�ڵ�ͼ�ϵ�����λ��
	double speed;  //���е��ٶ�
	double width,height; //��ȡ��Ⱥ͸߶�

//��ȡ������Ϣ�����Խ�����ײ���
	
	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y, (int)width,(int)height);
	}
}
