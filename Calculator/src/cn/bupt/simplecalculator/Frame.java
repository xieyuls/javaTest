package cn.bupt.simplecalculator;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame {
	
	public static void main(String[] args){
	new jframe();

	}

}

class jframe extends JFrame {
	private static final long serialVersionUID = 1L;
	public  jframe(){
		setTitle("计算器");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380,300);
		setLocationRelativeTo(null); 
		setLayout(null);
		setResizable(false);
		jpanel jp1=new jpanel();
		getContentPane().add(jp1);
		jp1.setBounds(0,0,380,300);  
	}
	
}

class jpanel extends JPanel{
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	String[] str={"0","1","2","3","4","5","6","7","8","9","+","-","*","/","=","c","√","sin","cos","^2","tan"};
	JButton[] jb=new JButton[str.length];
	JTextField jt1 = new JTextField("0");
	JDialog jd=new JDialog();
	String signflag=null;
	int i;
	double num=0;
	double sum=0;
	double mid=0;
	double Numbs=0;
	boolean lastisnum=false;
	boolean isfirstdigit=true;
	boolean lastisequal=false;
	boolean lastissign=false;

	public jpanel(){

		setLayout(null);
		add(jt1);
	
    for(i=0;i<str.length;i++){
        jb[i] = new JButton(str[i]);
       add(jb[i]);
    }
        jt1.setHorizontalAlignment(JTextField.RIGHT);
        jt1.setEditable(false);
        jt1.setBackground(Color.white);
		jt1.setBounds(20, 10, 330, 30);
		jb[0].setBounds(20,200,50,50);  //     0
		jb[1].setBounds(20,50,50,50);    //    1
		jb[2].setBounds(70,50,50,50);     //   2
		jb[3].setBounds(120,50,50,50);     //  3
		jb[4].setBounds(20,100,50,50);     //  4
		jb[5].setBounds(70,100,50,50);      // 5
		jb[6].setBounds(120,100,50,50);     // 6
		jb[7].setBounds(20,150,50,50);      // 7
		jb[8].setBounds(70,150,50,50);      // 8
		jb[9].setBounds(120,150,50,50);     // 9
		jb[10].setBounds(170,100,60,50);    // +
		jb[11].setBounds(230,100,60,50);   //  -
		jb[12].setBounds(170,150,60,50);    // *
		jb[13].setBounds(230,150,60,50);  //   /
		jb[14].setBounds(70,200,100,50); //   =  
		jb[15].setBounds(170,50,180,50);   //  c		
		jb[16].setBounds(290,100,60,50);   //  √
		jb[17].setBounds(170,200,60,50);	// sin	
		jb[18].setBounds(230,200,60,50);    // cos
		jb[19].setBounds(290,150,60,50);	// ^2	
		jb[20].setBounds(290,200,60,50);    // tan
		method();

   }
	

	
	public void method(){
		jb[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=0;
				if(lastisnum==true){
					num=mid*10+0;
				}
				if(lastisequal==true){
					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
				
			}
		});
	
		jb[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=1;
				if(lastisnum==true){
					num=mid*10+1;
				}
				if(lastisequal==true){
					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
			}
		});
		jb[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=2;
				if(lastisnum==true){
					num=mid*10+2;
				}
				if(lastisequal==true){
					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
			}
		});
		jb[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=3;
			
				if(lastisnum==true){
					num=mid*10+3;
				}	
				if(lastisequal==true){

					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
			}
		});
		jb[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=4;
				
				if(lastisnum==true){
					num=mid*10+4;
				}
				if(lastisequal==true){
					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
			}
		});
		jb[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=5;
			
				if(lastisnum==true){
					num=mid*10+5;
				}	
				if(lastisequal==true){
					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
			}
		});
		jb[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=6;
			
				if(lastisnum==true){
					num=mid*10+6;
				}	
				if(lastisequal==true){
					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
			}
		});
		jb[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=7;
				
				if(lastisnum==true){
					num=mid*10+7;
				}
				if(lastisequal==true){
					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
			}
		});
		jb[8].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=8;
				
				if(lastisnum==true){
					num=mid*10+8;
				}
				if(lastisequal==true){
					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
			}
		});
		jb[9].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=9;
				if(lastisnum==true){
					num=mid*10+9;
				}
				if(lastisequal==true){
					lastisequal=false;
					isfirstdigit=true;
					signflag=null;
				}
				mid=num;
				lastisnum=true;
				jt1.setText(String.valueOf(num));
			}
		});
		jb[10].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lastisequal=false;
				lastisnum=false;
				signflag="+";
				Numbs=num;
			

			}
		});
		jb[11].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lastisequal=false;
				lastisnum=false;
				signflag="-";
				Numbs=num;
			

			}
		});
		jb[12].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lastisequal=false;
				lastisnum=false;
				signflag="*";
				Numbs=num;
			

			}
		});
		jb[13].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lastisequal=false;
				lastisnum=false;
				signflag="/";
				Numbs=num;
			

			}
		});
		jb[16].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lastisequal=false;
				lastisnum=false;
				signflag="√";
				Numbs=num;
			

			}
		});
		jb[17].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lastisequal=false;
				lastisnum=false;
				signflag="sin";
				Numbs=num;
			

			}
		});
		jb[18].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lastisequal=false;
				lastisnum=false;
				signflag="cos";
				Numbs=num;
			

			}
		});
		jb[19].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lastisequal=false;
				lastisnum=false;
				signflag="^2";
				Numbs=num;
			

			}
		});
		jb[20].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				lastisequal=false;
				lastisnum=false;
				signflag="tan";
				Numbs=num;
			

			}
		});
		jb[14].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
               lastisnum=false;
               lastissign=false;
               if(signflag=="+"){
            	   if(isfirstdigit==true) sum=Numbs+num;
            	   else sum=sum+num;
            	   isfirstdigit=false;
               }
               if(signflag=="-"){
            	   if(isfirstdigit==true) sum=Numbs-num;
            	   else sum=sum-num;
            	   isfirstdigit=false;
               }
               if(signflag=="*"){
            	   if(isfirstdigit==true) sum=Numbs*num;
            	   else sum=sum*num;
            	   isfirstdigit=false;
               }
               if(signflag=="/"){
            	   if(num!=0){
            		   if(isfirstdigit==true) sum=Numbs/num;
            		   else sum=sum/num;
            	   }
            	   else JOptionPane.showMessageDialog(jd, "除数不能为0!", "错误",JOptionPane.WARNING_MESSAGE);  
            	   isfirstdigit=false;
               }
               if(signflag=="√"){
            	   if(Numbs>=0){
            		   if(isfirstdigit==true) sum=Math.sqrt(Numbs);   
            		   else sum=Math.sqrt(sum); 
            	   }
            	   else JOptionPane.showMessageDialog(jd, "根号内的数不能小于0", "错误",JOptionPane.WARNING_MESSAGE);  
            	   isfirstdigit=false;
               }
               if(signflag=="sin"){ 
            		   if(isfirstdigit==true) sum=Math.sin(Numbs*Math.PI/180);   
            		   else sum=Math.sin(sum*Math.PI/180); 
            	   isfirstdigit=false;
               }
               if(signflag=="cos"){ 
        		   if(isfirstdigit==true) sum=Math.cos(Numbs*Math.PI/180);   
        		   else sum=Math.cos(sum*Math.PI/180); 
        	   isfirstdigit=false;
               }
               if(signflag=="^2"){ 
        		   if(isfirstdigit==true) sum=Numbs*Numbs;   
        		   else sum=sum*sum; 
        	   isfirstdigit=false;
               }
               if(signflag=="tan"){ 
        		   if(isfirstdigit==true) sum=Math.tan(Numbs*Math.PI/180);   
        		   else sum=Math.sin(sum*Math.PI/180); 
        	   isfirstdigit=false;
               }
               if(signflag==null){
            	   sum=num;
               }
               lastisequal=true;
               jt1.setText(String.valueOf(sum));

			}
		});
		jb[15].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				num=0;
				sum=0;
				mid=0;
				Numbs=0;
				lastisnum=false;
				isfirstdigit=true;
				lastisequal=false;
				lastissign=false;	
				signflag=null;
				jt1.setText(String.valueOf(0));				
			}
		});
	}
	

}


