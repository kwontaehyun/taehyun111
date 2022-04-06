package com.edu.api;

import java.util.Calendar;

public class CalendarExample {

	public static void createCalendar(int year, int month)
	{
		Calendar today = Calendar.getInstance();
		
		today.set(year, (month-1), 1);
		
		System.out.println("올해는 : " + today.get(Calendar.YEAR));
		System.out.println("이번달은 : " + (today.get(Calendar.MONTH) + 1));
		System.out.println("오늘은 : " + today.get(Calendar.DATE));
		System.out.println("요일정보 : " + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("마지막날의 정보: " + today.getActualMaximum(Calendar.DATE));
		
		int gapDay = today.get(Calendar.DAY_OF_WEEK);
		int lastDate = today.getActualMaximum(Calendar.DATE);
		
		
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr","Fri","Sat"};
		
		for(int i=0; i<days.length; i++)
		{
			System.out.print(days[i] + "	");
		}
		System.out.println();
		
		for(int i =1; i<gapDay; i++) {
			System.out.print("	"+ "");
		}
		
		
		for(int i=1; i<=lastDate; i++)
		{
			
			System.out.print(i + "	" );
			System.out.print(i + "	");
			
			if((i + gapDay -1) % 7 == 0)
				System.out.println();
		}
	}
	
	
	public static void main(String[] args) {

		int year = 2022;
		int month = 5;
		
		createCalendar(year, month);
		
		System.out.println("\nend of prog");
	}

}
