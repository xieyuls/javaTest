package bupt.zhang;

import java.util.Scanner;

public class ChessBoard {
	Object[][] chessboard = new Object[20][20];
	
//初始化棋盘	
	public void init(){
		for(int i=0;i<chessboard.length;i++)
			for(int j=0;j<chessboard.length;j++){
				if(i==0) chessboard[i][j]=j;
				else if(j==0) chessboard[i][j]=i;
				else chessboard[i][j]=".";
		}
	}

//显示棋盘
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

//将棋子放置到棋盘x,y位置	
	public void play(int x,int y,String color){
//		if(chessboard[x][y]==".") {
			chessboard[x][y]=color;
//		}
//		else{
//			System.out.println("该位置已经有棋子,请重新选择位置");
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
//			System.out.print("是否开始新的一局？(y/n)");
//			once=sc.next();
		}
		System.out.println("再见，欢迎您下次再来挑战！");
		return;
	}
}
