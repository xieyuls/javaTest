package bupt.zhang.chat;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;




public class ChatFrame extends JFrame{
	
	public static void main(String[] args) {
		new ChatFrame().setFrame();
	}
	MyPanel jp1;
	MyPanel_toolbar jp2;
	public void setFrame(){
		setTitle("聊天室");
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		setLayout(null);
		setResizable(false);	
		jp1=new MyPanel();
		jp1.setBounds(0,0,600,600);
		jp1.setBackground(Color.CYAN);
		jp1.setVisible(true);
		jp2=new MyPanel_toolbar();
		jp2.setBounds(600,0,200,600);
		jp2.setBackground(Color.PINK);
		jp2.setVisible(true);
		add(jp1);
		add(jp2);
	}
	
	//该面板负责建立聊天对话框和聊天输入框
	private class MyPanel extends JPanel{
		public void setPanel(){
			setLayout(null);
		}
	}
	
	//该面板负责显示在线状态以及按钮设置
	private class MyPanel_toolbar extends JPanel{
		public void setPanel(){
			
		}
	}

}
	