package testcases;

import java.util.Calendar;
import java.util.Date;

public class GetTomorwdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar calendar = Calendar.getInstance();
	    
	    // get a date to represent "today"
	    Date today = calendar.getTime();
	    System.out.println("today:    " + today);
	 
	    // add one day to the date/calendar
	    calendar.add(Calendar.DAY_OF_YEAR, 1);
	    
	    // now get "tomorrow"
	    Date tomorrow = calendar.getTime();

	    // print out tomorrow's date
	    System.out.println("tomorrow: " + tomorrow);
	}

}
