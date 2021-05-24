package testcases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reada {

	 public static void main( String args[] ) {
	      int n = 40; // The line number
	      String line;
	      try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Boopathi/Desktop/New folder (5)/a.txt"))) {
	          for (int i = 0; i < n; i++)
	              br.readLine();
	          line = br.readLine();
	          System.out.println(line);
	      }
	      catch(IOException e){
	        System.out.println(e);
	      }
	    }
	}