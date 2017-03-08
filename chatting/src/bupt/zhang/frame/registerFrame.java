package bupt.zhang.frame;

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
 * 
 * 注册界面
 * @author Xieyu
 *
 */

public class registerFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//创建面板
	registerpanel rp=new registerpanel();
	public registerFrame(){
		//设置界面的基本属性
				setTitle("注册");
				setSize(Constant.FrameWidth-20, Constant.FrameHeight);
				setLocationRelativeTo(null);
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
				setLayout(null);
				setResizable(false);	
				add(rp);
				rp.setBounds(0, 0, Constant.FrameWidth, Constant.FrameWidth);
				setVisible(true);
	}
	
	//定义面板组件布局
	class registerpanel extends JPanel implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		//申明该面板上的组件对象
		JButton finish=new JButton("完成");	//登陆按钮
		JButton cancel=new JButton("取消");		//注册按钮
		JTextField username=new JTextField();	//用户名输入框
		JPasswordField password1=new JPasswordField();	//密码输入框1
		JPasswordField password2=new JPasswordField();	//密码输入框2
		JTextField nickname=new JTextField();	//用户名输入框
		
		//标签
		JLabel uname=new JLabel("用户名:");	
		JLabel pwd=new JLabel("密    码:");
		JLabel nname=new JLabel("昵    称:");
		JLabel hint=new JLabel();     //进行提示
		
				
		public registerpanel(){
			setLayout(null);
			//将组件全部添加进该面板
			add(finish);
			add(cancel);
			add(username);
			add(password1);
			add(password2);
			add(nickname);
			add(uname);
			add(pwd);
			add(nname);
			add(hint);
			
			//设置输入框的属性
			username.setBounds(110,20,200,25);
			password1.setBounds(110,50,200,25);
			password2.setBounds(110,80,200,25);
			nickname.setBounds(110, 110, 200, 25);
			
			//设置finish按钮属性
			finish.setBounds(120,140,80,25);
			finish.addActionListener(this);
			
			//设置cancel按钮属性
			cancel.setBounds(220,140,80,25);
			cancel.addActionListener(this);
			
			//设置标签属性
			uname.setBounds(60,20,50,25);
			pwd.setBounds(60,50,50,25);
			nname.setBounds(60, 110, 50, 25);
			hint.setBounds(110,170,200,25);
		}
		
		private void finishevent(){
			//1.提取出输入框中的数据
			String uname=username.getText();
			String pwd1=password1.getText();
			String pwd2=password2.getText();
			String nname=nickname.getText();
			
			//2.连接到数据库
			
			
			//3.进行简单的逻辑判断,以确保数据的正确性
			if(nname.length()==0){
				hint.setText("你的昵称不能为空");
			}
			else if(pwd1.length()==0||pwd2.length()==0){
				hint.setText("你的密码不能为空");
			}
			else if(uname.length()==0){
				hint.setText("你的用户名不能为空");
			}
			else if(!pwd1.equals(pwd2)){
				hint.setText("密码不匹配,请重新输入!");
			}
			else{
				hint.setText(new usermanager().register_check(uname));
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//处理finish的事件
			if(e.getSource()==finish){
				finishevent();
			}
			
			//处理cancel的事件
			if(e.getSource()==cancel){
				dispose();
				new loginFrame();
			}
			
		}
	}
	
}
