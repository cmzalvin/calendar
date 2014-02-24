package cmz.alvin.demo;

import java.util.*;

public class Demo {
	
	public static void main(String[] args) {
		CalendarBean cb=new CalendarBean();
		cb.setYear(2014);
		for(int i=1;i<=12;i++){
			cb.setMonth(i);
			String[]a=cb.getCalendar();
			System.out.println("2014年"+i+"月的日历表");
			char[] str="日一二三四五六".toCharArray();
			for(char c:str){
				System.out.printf("%4c",c);
			}
			for(int j=0;j<a.length;j++){
				if(j%7==0)
					System.out.println("");
				System.out.printf("%3s",a[j]);
			}
		}
		
	}
}
class CalendarBean{
	String []day;
	int year=2014,month=0;
	public void setYear(int year){
		this.year=year;
	}
	public void setMonth(int month){
		this.month=month;
	}
	public String []getCalendar(){
		String []a=new String[42];
		Calendar calendar=Calendar.getInstance();
		calendar.set(year,month-1,1);
		int week=calendar.get(Calendar.DAY_OF_WEEK)-1;
		int day=0;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			day=31;
		if(month==4||month==6||month==9||month==11)
			day=30;
		if(month==2){
			if((year%4==0&&year%100!=0)||(year%400==0))
				day=29;
			else
				day=28;
		}
		for(int i=0;i<week;i++)
			a[i]=" ";
		for(int i=week,n=1;i<week+day;i++){
			a[i]=String.valueOf(n);
			n++;
		}
		for(int i=week+day;i<a.length;i++)
			a[i]=" ";
		return a;
	}
}