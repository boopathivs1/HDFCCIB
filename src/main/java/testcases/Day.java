package testcases;

import java.time.LocalDate;

public class Day {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String D="";
		String actualdate="";
	LocalDate currentdate = LocalDate.now();
	int currentDay = 10;
System.out.println(currentDay);
if(currentDay <=9)
{
		D ="0"+currentDay;

}
else{
	D=Integer.toString(currentDay);

}


System.out.println(D);

	
	}

}
