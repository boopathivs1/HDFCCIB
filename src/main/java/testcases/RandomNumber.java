package testcases;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
	    int min = 1;
	    int max = 9999;

//	      int num = (int) (Math.random() * (max - min + 1)) + min;
//	      String expected = String.valueOf(num).substring(2);
//	      System.out.println(expected);
	    
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
//	   # return String.format("%02d", number);
	    System.out.println(String.format("%2d", number));
	  }}
