package testcases;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
	    int min = 10;
	    int max = 99;

	      int num = (int) (Math.random() * (max - min + 1)) + min;
	      System.out.println(num);
	  }}
