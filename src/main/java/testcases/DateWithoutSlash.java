package testcases;

import java.time.LocalDate;

public class DateWithoutSlash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			
			String M="";
			String actualdate="";
	 LocalDate currentdate = LocalDate.now();
 int currentDay = currentdate.getDayOfMonth();
 int month =currentdate.getMonthValue();
 if(month <=9)
 {
				M ="0"+month;
 
 }
	 System.out.println(M+currentDay);
 
		}

	}

