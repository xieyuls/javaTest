package bupt.zhang;

import java.awt.Color;
import java.util.Scanner;

public class Play {
	ChessBoard cb;
	Scanner sc;
	boolean player_white;
	boolean player_black;
	int x,y;
	String color;
	int winner;
	String onceagain;
//初始化游戏参数	
	public Play(){
		cb =new ChessBoard();
		sc=new Scanner(System.in);
		cb.init();
		player_white=false;
		x=0;
		y=0;
		winner=0;
		onceagain=null;
	}

//改变winner值
	public void SetWinner(int Win){
		winner=Win;
	}
	
//判断输赢	
	public void win(int x,int y,int counter,String color){
		int x1=x-1;
		int y1=y-1;
		int flagUp=0;
		int flagDown=0;
		int flagLeft=0;
		int flagRight=0;
		int flagUp_RX=0;
		int flagDown_RX=0;
		int flagUp_LX=0;
		int flagDown_LX=0;
//	    上下方向判断
		while(x1!=0&&cb.chessboard[x1][y]==color){
			x1--;
			counter++;
		}
		if(cb.chessboard[x1][y]==".") flagUp=1;
		x1=x+1;
		while(x1!=20&&cb.chessboard[x1][y]==color){
			x1++;
			counter++;
		}
		if(cb.chessboard[x1][y]==".") flagDown=1;
		if(flagDown==1&&flagUp==1&&counter==4){
			SetWinner(1);
//			if(color=="w"){
//				System.out.println("恭喜白棋获胜！");
//			}
//			else{
//				System.out.println("恭喜黑棋获胜！");
//			}
			return;
		}
		if(counter==5){
			SetWinner(1);
//			if(color=="w"){
//				System.out.println("恭喜白棋获胜！");
//			}
//			else{
//				System.out.println("恭喜黑棋获胜！");
//			}
			return;
		}
		counter=1;
		//左右方向判断
		while(y1!=0&&cb.chessboard[x][y1]==color){
			y1--;
			counter++;
		}
		if(cb.chessboard[x][y1]==".") flagLeft=1;
		y1=y+1;
		while(x1!=20&&cb.chessboard[x][y1]==color){
			y1++;
			counter++;
		}
		if(cb.chessboard[x][y1]==".") flagRight=1;
		if(flagRight==1&&flagLeft==1&&counter==4){
			SetWinner(1);
//			if(color=="w"){
//				System.out.println("恭喜白棋获胜！");
//			}
//			else{
//				System.out.println("恭喜黑棋获胜！");
//			}
			return;
		}
		if(counter==5){
			SetWinner(1);
//			if(color=="w"){
//				System.out.println("恭喜白棋获胜！");
//			}
//			else{
//				System.out.println("恭喜黑棋获胜！");
//			}
			return;
		}
	 counter=1;	
//	    左斜方向判断
		x1=x-1;
		y1=y-1;
		while(x1!=0&&y1!=0&&cb.chessboard[x1][y1]==color){
			x1--;
			y1--;
			counter++;
		}
		if(cb.chessboard[x1][y1]==".") flagUp_LX=1;
		x1=x+1;
		y1=y+1;
		while(x1!=20&&y1!=20&&cb.chessboard[x1][y1]==color){
			x1++;
			y1++;
			counter++;
		}
		if(cb.chessboard[x1][y1]==".") flagDown_LX=1;
		if(flagDown_LX==1&&flagUp_LX==1&&counter==4){
			SetWinner(1);
//			if(color=="w"){
//				System.out.println("恭喜白棋获胜！");
//				
//			}
//			else{
//				System.out.println("恭喜黑棋获胜！");
//			}
			return;
		}
		if(counter==5){
			SetWinner(1);
//			if(color=="w"){
//				System.out.println("恭喜白棋获胜！");
//			}
//			else{
//				System.out.println("恭喜黑棋获胜！");
//			}
			return;
		}
	   counter=1; 
//	          右斜方向判断
		x1=x-1;
		y1=y+1;
		while(x1!=0&&y1!=20&&cb.chessboard[x1][y1]==color){
			x1--;
			y1++;
			counter++;
		}
		if(cb.chessboard[x1][y1]==".") flagUp_RX=1;
		x1=x+1;
		y1=y-1;
		while(x1!=20&&y1!=0&&cb.chessboard[x1][y1]==color){
			x1++;
			y1--;
			counter++;
		}
		if(cb.chessboard[x1][y1]==".") flagDown_RX=1;
		if(flagDown_RX==1&&flagUp_RX==1&&counter==4){
			SetWinner(1);
//			if(color=="w"){
//				System.out.println("恭喜白棋获胜！");
//			}
//			else{
//				System.out.println("恭喜黑棋获胜！");
//			}
			return;
		}
		if(counter==5){
			SetWinner(1);
//			if(color=="w"){
//				System.out.println("恭喜白棋获胜！");
//			}
//			else{
//				System.out.println("恭喜黑棋获胜！");
//			}
			return;
		}
	}
	
	
	
	public void who_is_the_first(){
		System.out.print("白棋先还是黑棋先？(w/b):");
		String first=sc.next();
		if(first.equals("w")) player_white=true;
		else if(first.equals("b")) player_white=false;
		else{
			System.out.println("请输入w or b!");
			who_is_the_first();
			return;
		}
		return;
	}
	
//玩家操作过程	
	public void Player(int i,int j){
//		if(onceagain==null){
//			who_is_the_first();
//			onceagain=" ";
//		}
		if(player_white==true){
//			System.out.print("请白棋选手选择下棋位置(x y)：");
			player_white=false;
			color="w";
		}
		else{
//			System.out.print("请黑棋选手选择下棋位置(x y)：");
			player_white=true;
			color="b";
		}
//		x=i;
//		y=j;
//		if(x<=0||x>=20||y<=0||y>=20){
//			System.out.println("你输入的位置是不合法的，请重新输入(1-19)!");
//			if(color=="w") player_white=true;
//			else player_white=false;
//			Player();
//			return;
//		}
//		if(cb.chessboard[x][y]!="."){
//			System.out.println("你输入的位置已经有棋子了，请重新输入位置(1-19)");
//			if(color=="w") player_white=true;
//			else player_white=false;
//			Player();
//			return;
//		}
		cb.play(i, j, color);	
//		cb.display();
		win(i, j, 1,color);
////		while(winner==0){
//				Player(i,j);
//		}	
		
	}
}
