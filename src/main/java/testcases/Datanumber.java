package testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Datanumber {
public static void main(String[] args) {

	GetFuturedate(2);
}

public static String GetFuturedate(int d)
{
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
Date currentDate = new Date();
  Calendar c = Calendar.getInstance();
    c.setTime(currentDate);
c.add(Calendar.DATE, d); 
 Date currentDatePlusOne = c.getTime();
    
    String Futuredate=dateFormat.format(currentDatePlusOne);

    System.out.println(Futuredate);
    
    return Futuredate;

}

			
	}
	
	
	




