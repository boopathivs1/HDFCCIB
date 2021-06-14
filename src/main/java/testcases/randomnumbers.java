package testcases;

import java.util.Random;

public class randomnumbers {
//	public static void main(String[] args) {
//		getRandomNumString();
//	System.out.println(getRandomNumString());
//	}
	

		public static void main(String args[])   
		{   
		// Generating random numbers  
		  
		
		
		System.out.println(gettwoRandomNumber_range_String(10,999));  
	    // this will convert any number sequence into 6 character.
		}
		
		public static String gettwoRandomNumber_range_String(int a, int b) {
		    // It will generate 6 digit random Number.
		    // from 0 to 999999
		   
			 int min = a;
			    int max = b;

			    int num = (int) (Math.random() * (max - min + 1)) + min;
		
			    String s=Integer.toString(num);
			  	
			    String finalvalue=s.substring(1,2);
			
//		    Random rnd = new Random();
//		    int number = rnd.nextInt(99);
	//
//		    // this will convert any number sequence into 6 character.
		    return finalvalue;
		}

	
	
}