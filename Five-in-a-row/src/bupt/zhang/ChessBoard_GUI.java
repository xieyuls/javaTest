package bupt.zhang;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class ChessBoard_GUI {
	MyFrame my;
	Play p=new Play();
	public ChessBoard_GUI(){
		my=new MyFrame();
	}	


class MyFrame extends JFrame{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public MyFrame(){
		CreatMyFrame();
	}
	
	public void DisPose(){
		this.dispose();
	}
	
	JButton jb_b;
	JButton jb_w;
	MyPanel jp1;
	MyPanel_chess jp2;
	public void CreatMyFrame(){
		setTitle("五子棋游戏");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		//Container contentPane =new Container(); 
		setLayout(null);
		setResizable(false);	
		jp1=new MyPanel();
		jp1.setBounds(100,100,800,500);
		jp1.setBackground(Color.CYAN);
		jp1.setVisible(true);
		jp2=new MyPanel_chess();
		jp2.setBounds(100,0,800,100);
		jp2.setBackground(Color.PINK);
		jp2.setVisible(true);
		add(jp1);
		add(jp2);
		setVisible(true);
		
	}
	
}
	JButton jb_b;
	JButton jb_w;
	Color colorBefore;
class MyPanel_chess extends JPanel implements ActionListener{
	ImageIcon icon_w=new ImageIcon("white.jpg"); 
	ImageIcon icon_b=new ImageIcon("black.jpg"); 
	public MyPanel_chess(){
		setLayout(null);
		jb_b=new JButton(icon_b);   
		jb_b.setBounds(100, 10, 70, 80);
		jb_w=new JButton(icon_w);
		jb_w.setBounds(600, 10, 70, 80);
		add(jb_b);
		add(jb_w);
		colorBefore = jb_b.getBackground();
		jb_b.setBackground(Color.GREEN);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

class MyPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CircleButton[] jb=new CircleButton[19*19+1];
	public MyPanel(){
		CreatJpanel();
	}
	public void CreatJpanel(){
		GridLayout gridLayout = new GridLayout(19, 19, 5, 5);
		setLayout(gridLayout);		
		for(int i=1;i<=19*19;i++){
			jb[i] = new CircleButton();	
			jb[i].setBackground(Color.ORANGE);
			add(jb[i]);
			jb[i].addActionListener(this);
		}
	}
	
	JButton jb1;
	JButton jb2;
	JDialog  jd;
	public void CreatJDialog(String str1,String str2){
		jd= new JDialog ();
		jd.setVisible(true);
		jd.setSize(210, 150);
		jd.setLayout(null);
		jd.setLocationRelativeTo(null);
		
		JLabel jl1=new JLabel(str1);
		jl1.setBounds(40, 10, 150, 30);
		JLabel jl2=new JLabel(str2);
		jl2.setBounds(50, 30, 150, 30);
		jb1=new JButton("是");
		jb1.setBounds(40, 60, 50, 50);
		jb2=new JButton("否");
		jb2.setBounds(100, 60, 50, 50);
		     
		jd.add(jl1);
		jd.add(jl2);
		jd.add(jb1);
		jd.add(jb2);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}
	
	
//判断输赢
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb1){
			jd.dispose();
			my.dispose();
			p=new Play();
			my=new MyFrame(); 
			if(p.player_white==true) {
				jb_w.setBackground(Color.GREEN);
				jb_b.setBackground(colorBefore);
			}
			else{
				jb_b.setBackground(Color.GREEN);
				jb_w.setBackground(colorBefore);
			}
			
		}
		if (e.getSource() == jb2){
			System.exit(0);
		}
		
		for(int i=1;i<=19;i++)
			for(int j=1;j<=19;j++){
		        if (e.getSource() == jb[(i-1)*19+j]) {
		        	if(p.player_white==true) {
		        		jb[(i-1)*19+j].setBackground(Color.WHITE);
		        		jb_b.setBackground(Color.GREEN);
		        		jb_w.setBackground(colorBefore);
		        		p.Player(i,j);
		        		if(p.winner==1){
		        			CreatJDialog("恭喜白棋获得胜利！","是否重来一局？");
		        		}
		        		
		        	}
		        	else{
		        		jb[(i-1)*19+j].setBackground(Color.BLACK);
		        		jb_w.setBackground(Color.GREEN);
		        		jb_b.setBackground(colorBefore);
		        		p.Player(i,j);
		        		if(p.winner==1){
		        			CreatJDialog("恭喜黑棋获得胜利！","是否重来一局？");
		        		}		
		        	}
		        }
		}
		
	}
}
}
