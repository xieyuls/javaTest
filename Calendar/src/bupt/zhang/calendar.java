package bupt.zhang;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class calendar {
	public static void main(String[] args){
		System.out.print("请输入日期(xxxx-xx-xx):");
		Scanner sc=new Scanner(System.in);
		new calendar_print(sc.next());
	}

}

class calendar_print{
	public calendar_print(String str){
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=format.parse(str);
			Calendar calendar=new GregorianCalendar();
			
			calendar.setTime(date);
		//	calendar.add(Calendar.MONTH,1);
			int Day=calendar.get(Calendar.DAY_OF_MONTH); 
			calendar.set(Calendar.DATE,1);
			int MonthMax=calendar.getActualMaximum(Calendar.DATE);
			int Date_of_week=calendar.get(Calendar.DAY_OF_WEEK);
			for(int i=1;i<Date_of_week+MonthMax;i++){
				if(i<Date_of_week){
					System.out.print("\t");
					continue;
				}
				if(i%7==0){
					if(i-Date_of_week+1==Day){
						System.out.println(i-Date_of_week+1+"*");
					}
					else System.out.println(i-Date_of_week+1);
				}
				else{
					if(i-Date_of_week+1==Day&&i-Date_of_week+1<10){
						System.out.print(i-Date_of_week+1+"*"+"      ");
					}
					else if(i-Date_of_week+1==Day&&i-Date_of_week+1>=10){
						System.out.print(i-Date_of_week+1+"*"+"     ");
					}
					else System.out.print(i-Date_of_week+1+"\t");
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}