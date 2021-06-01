package testcases;

import java.time.LocalDate;

public class DateWithoutSlash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			
			String M="";
			String D="";
			String actualdate="";
	 LocalDate currentdate = LocalDate.now();
 int currentDay = currentdate.getDayOfMonth();
 int month =currentdate.getMonthValue();
 if(month <=9 && currentDay<=9)
 {
				M ="0"+month;
				D="0"+currentDay;
				actualdate= M+D;
				System.out.println(actualdate);
 
 }
 else
 {
	 System.out.println(actualdate);

 }
 
	 
 
		}

	}

