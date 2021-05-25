package testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datanumber {
public static void main(String[] args) {
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	String expected = dateFormat.format(date);
	System.out.println(expected);
	

	
	
}
			
	}
	
	
	




