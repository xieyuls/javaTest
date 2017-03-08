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
 * ע�����
 * @author Xieyu
 *
 */

public class registerFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//�������
	registerpanel rp=new registerpanel();
	public registerFrame(){
		//���ý���Ļ�������
				setTitle("ע��");
				setSize(Constant.FrameWidth-20, Constant.FrameHeight);
				setLocationRelativeTo(null);
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
				setLayout(null);
				setResizable(false);	
				add(rp);
				rp.setBounds(0, 0, Constant.FrameWidth, Constant.FrameWidth);
				setVisible(true);
	}
	
	//��������������
	class registerpanel extends JPanel implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		//����������ϵ��������
		JButton finish=new JButton("���");	//��½��ť
		JButton cancel=new JButton("ȡ��");		//ע�ᰴť
		JTextField username=new JTextField();	//�û��������
		JPasswordField password1=new JPasswordField();	//���������1
		JPasswordField password2=new JPasswordField();	//���������2
		JTextField nickname=new JTextField();	//�û��������
		
		//��ǩ
		JLabel uname=new JLabel("�û���:");	
		JLabel pwd=new JLabel("��    ��:");
		JLabel nname=new JLabel("��    ��:");
		JLabel hint=new JLabel();     //������ʾ
		
				
		public registerpanel(){
			setLayout(null);
			//�����ȫ����ӽ������
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
			
			//��������������
			username.setBounds(110,20,200,25);
			password1.setBounds(110,50,200,25);
			password2.setBounds(110,80,200,25);
			nickname.setBounds(110, 110, 200, 25);
			
			//����finish��ť����
			finish.setBounds(120,140,80,25);
			finish.addActionListener(this);
			
			//����cancel��ť����
			cancel.setBounds(220,140,80,25);
			cancel.addActionListener(this);
			
			//���ñ�ǩ����
			uname.setBounds(60,20,50,25);
			pwd.setBounds(60,50,50,25);
			nname.setBounds(60, 110, 50, 25);
			hint.setBounds(110,170,200,25);
		}
		
		private void finishevent(){
			//1.��ȡ��������е�����
			String uname=username.getText();
			String pwd1=password1.getText();
			String pwd2=password2.getText();
			String nname=nickname.getText();
			
			//2.���ӵ����ݿ�
			
			
			//3.���м򵥵��߼��ж�,��ȷ�����ݵ���ȷ��
			if(nname.length()==0){
				hint.setText("����ǳƲ���Ϊ��");
			}
			else if(pwd1.length()==0||pwd2.length()==0){
				hint.setText("������벻��Ϊ��");
			}
			else if(uname.length()==0){
				hint.setText("����û�������Ϊ��");
			}
			else if(!pwd1.equals(pwd2)){
				hint.setText("���벻ƥ��,����������!");
			}
			else{
				hint.setText(new usermanager().register_check(uname));
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//����finish���¼�
			if(e.getSource()==finish){
				finishevent();
			}
			
			//����cancel���¼�
			if(e.getSource()==cancel){
				dispose();
				new loginFrame();
			}
			
		}
	}
	
}
