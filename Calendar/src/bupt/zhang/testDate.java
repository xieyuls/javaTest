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
				System.out.println("֪����\t"+date);
				switch(k){
				case 0:
					System.out.println("������?");
					break;
				case 1:
					System.out.println("�ѵ�����һ���˰���");
					break;
				case 2:
					System.out.println("�����İ�");
					break;
				case 3:
					System.out.println("������ѽ��");
					break;
				case 4:
					System.out.println("���и�������");
					break;
				case 5:
					System.out.println("����Ⱥ�����ҵ�С�ţ�");
					break;
				default:
					System.out.println("��");	
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
