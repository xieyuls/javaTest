package bupt.zhang;

import java.util.Scanner;

public class ChessBoard {
	Object[][] chessboard = new Object[20][20];
	
//��ʼ������	
	public void init(){
		for(int i=0;i<chessboard.length;i++)
			for(int j=0;j<chessboard.length;j++){
				if(i==0) chessboard[i][j]=j;
				else if(j==0) chessboard[i][j]=i;
				else chessboard[i][j]=".";
		}
	}

//��ʾ����
	public void display(){
		for(int i=0;i<chessboard.length;i++){
			for(int j=0;j<chessboard.length;j++){
				if(i<10&&j==0) System.out.print(" "+chessboard[i][j]+"    ");
				else if(j>=10&&i!=0) System.out.print(chessboard[i][j]+"     ");
				else System.out.print(chessboard[i][j]+"    ");
			}
			System.out.println();
		}
	}

//�����ӷ��õ�����x,yλ��	
	public void play(int x,int y,String color){
//		if(chessboard[x][y]==".") {
			chessboard[x][y]=color;
//		}
//		else{
//			System.out.println("��λ���Ѿ�������,������ѡ��λ��");
//		}
	}
	
	public static void main(String[] args){
		ChessBoard_GUI cbg=new ChessBoard_GUI();
		ChessBoard cb = new ChessBoard();
		String once="y";
		while(once.equals("y")){		
			cb.init();
//			cb.display();
			//Play p=new Play();
			//p.Player();
//			Scanner sc=new Scanner(System.in);
//			System.out.print("�Ƿ�ʼ�µ�һ�֣�(y/n)");
//			once=sc.next();
		}
		System.out.println("�ټ�����ӭ���´�������ս��");
		return;
	}
}
