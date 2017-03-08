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
 * ʵ�������ҵĵ�½����
 * 
 * @author Xieyu
 *
 */

public class loginFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//1.�ڽ����Ͻ����������
	loginPanelU lpu=new loginPanelU();
	loginPanelD lpd=new loginPanelD();
	
	//2.������漰֮�ϵ���岼��
	public loginFrame(){
		//���ý���Ļ�������
		setTitle("ҹɫ������");
		setSize(Constant.FrameWidth, Constant.FrameHeight);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		setLayout(null);
		setResizable(false);	
		//�����������ӽ�������
		add(lpu);
		add(lpd);	
		//�������������
		lpu.setBounds(0, 0, Constant.FrameWidth, 150);
		lpu.setBackground(Color.DARK_GRAY);	
		//�������������
		lpd.setBounds(0, 150, Constant.FrameWidth, 180);
		//--------------------ȷ�������ȷ��ʾ,�þ�Ҫ���ں�-----------------------
		setVisible(true);
	}
	//3.�����һ������ϵ��������
	class loginPanelU extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public loginPanelU(){
			setLayout(null);
			JLabel name=new JLabel("ҹɫ������");
			Font mf = new Font("Dialog",1,30);
			name.setForeground(Color.white);
			name.setFont(mf);
			name.setBounds(130, Constant.FrameHeight/6, 200, 50);
			add(name);
		}
		
	}
	
	//4.����ڶ�������ϵ��������
	class loginPanelD extends JPanel implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		//����������ϵ��������
		JButton login=new JButton("��½");	//��½��ť
		JButton register=new JButton("ע��");		//ע�ᰴť
		JTextField username=new JTextField();	//�û��������
		JPasswordField password=new JPasswordField();	//���������

		public loginPanelD(){
			setLayout(null);
			//�����ȫ����ӽ������
			add(login);
			add(register);
			add(username);
			add(password);
			
			//��������������
			username.setBounds(110,20,200,25);
			password.setBounds(110,50,200,25);
			
			//����login��ť����
			login.setBounds(120,80,80,25);
			login.addActionListener(this);
			
			//����register��ť����
			register.setBounds(220,80,80,25);
			register.addActionListener(this);
		}
		
		//�����¼�����
		@Override
		public void actionPerformed(ActionEvent e) {
			//�����½��ť�¼�
			if(e.getSource()==login){
				String name=username.getText();
				String pwd=password.getText();
				usermanager user=new usermanager();
				user.login_check(name, pwd);
			}
			
			//����ע�ᰴť�¼�
			if(e.getSource()==register){
				dispose();
				new registerFrame();
			}
		}
	}
		
		
		
		
}
