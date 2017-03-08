package bupt.zhang.util;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	public static void main(String[] args) {
		new MyFrame().creatframe();
	}
	
	public void creatframe(){
		setSize(Constant.WIDTH,Constant.HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}

