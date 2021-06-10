package testcases;

import java.util.Random;

public class randomnumbers {
	public static void main(String[] args) {
		getRandomNumString();
	System.out.println(getRandomNumString());
	}
	

	public static String getRandomNumString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
		 int min = 1;
		    int max = 9999999;

		      int num = (int) (Math.random() * (max - min + 1)) + min;
		      String expected = String.valueOf(num).substring(2);
		      System.out.println(expected.length()-2);
		    
	    // this will convert any number sequence into 6 character.
	    return expected;
	}
	
}