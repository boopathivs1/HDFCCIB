package testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Futu_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(GetFuturedate(0));
	}
	public static String GetFuturedate(int d)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date currentDate = new Date();
	  Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);
	c.add(Calendar.DATE, d); 
	 Date currentDatePlusOne = c.getTime();
	   // System.out.println(c.getTime());
	    String Futuredate=dateFormat.format(currentDatePlusOne);
	    int min = 10;
	    int max = 99;

	      int num = (int) (Math.random() * (max - min + 1)) + min;
	      System.out.println(num);

	    System.out.println(Futuredate);
	    
	    return Futuredate+num;

	}
}
