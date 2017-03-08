package bupt.zhang.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import bupt.zhang.db.usermanager;
import bupt.zhang.util.Constant;

/**
 * 实现聊天室的登陆界面
 * 
 * @author Xieyu
 *
 */

public class loginFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//1.在界面上建立两个面板
	loginPanelU lpu=new loginPanelU();
	loginPanelD lpd=new loginPanelD();
	
	//2.定义界面及之上的面板布局
	public loginFrame(){
		//设置界面的基本属性
		setTitle("夜色聊天室");
		setSize(Constant.FrameWidth, Constant.FrameHeight);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		setLayout(null);
		setResizable(false);	
		//将两个面板添加进窗体中
		add(lpu);
		add(lpd);	
		//设置上面板属性
		lpu.setBounds(0, 0, Constant.FrameWidth, 150);
		lpu.setBackground(Color.DARK_GRAY);	
		//设置下面板属性
		lpd.setBounds(0, 150, Constant.FrameWidth, 180);
		//--------------------确保组件正确显示,该句要放在后-----------------------
		setVisible(true);
	}
	//3.定义第一个面板上的组件布局
	class loginPanelU extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public loginPanelU(){
			setLayout(null);
			JLabel name=new JLabel("夜色聊天室");
			Font mf = new Font("Dialog",1,30);
			name.setForeground(Color.white);
			name.setFont(mf);
			name.setBounds(130, Constant.FrameHeight/6, 200, 50);
			add(name);
		}
		
	}
	
	//4.定义第二个面板上的组件布局
	class loginPanelD extends JPanel implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		//申明该面板上的组件对象
		JButton login=new JButton("登陆");	//登陆按钮
		JButton register=new JButton("注册");		//注册按钮
		JTextField username=new JTextField();	//用户名输入框
		JPasswordField password=new JPasswordField();	//密码输入框

		public loginPanelD(){
			setLayout(null);
			//将组件全部添加进该面板
			add(login);
			add(register);
			add(username);
			add(password);
			
			//设置输入框的属性
			username.setBounds(110,20,200,25);
			password.setBounds(110,50,200,25);
			
			//设置login按钮属性
			login.setBounds(120,80,80,25);
			login.addActionListener(this);
			
			//设置register按钮属性
			register.setBounds(220,80,80,25);
			register.addActionListener(this);
		}
		
		//定义事件处理
		@Override
		public void actionPerformed(ActionEvent e) {
			//定义登陆按钮事件
			if(e.getSource()==login){
				String name=username.getText();
				String pwd=password.getText();
				usermanager user=new usermanager();
				user.login_check(name, pwd);
			}
			
			//定义注册按钮事件
			if(e.getSource()==register){
				dispose();
				new registerFrame();
			}
		}
	}
		
		
		
		
}
