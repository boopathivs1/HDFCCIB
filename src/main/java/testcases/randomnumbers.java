package testcases;

import java.util.Random;

public class randomnumbers {
	public static void main(String[] args) {
		getRandomNumberString();
	System.out.println(getRandomNumberString());
	}
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(99);

	    // this will convert any number sequence into 6 character.
	    return String.format("%02d", number);
	}}