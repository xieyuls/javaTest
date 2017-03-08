package bupt.zhang;


import java.util.Date;
import java.util.Random;


public class testDate {
	public static void main(String[] args){
		Random rand=new Random();		
		Date date;
		int i=1;
		while(i==1){
			try {
				int k=rand.nextInt(5);
				date=new Date(System.currentTimeMillis());
				System.out.println("知北游\t"+date);
				switch(k){
				case 0:
					System.out.println("有人吗?");
					break;
				case 1:
					System.out.println("难道就我一个人啊！");
					break;
				case 2:
					System.out.println("好无聊啊");
					break;
				case 3:
					System.out.println("快来人呀！");
					break;
				case 4:
					System.out.println("我有个大新闻");
					break;
				case 5:
					System.out.println("整个群都是我的小号？");
					break;
				default:
					System.out.println("唉");	
				}
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		
	}
}
