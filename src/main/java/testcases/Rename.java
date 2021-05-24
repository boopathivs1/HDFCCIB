package testcases;
import java.io.File;



public class Rename {

	   public static void main(String[] args) { 
	      File oldfile = new File("C:/Users/Boopathi/Desktop/New folder (22)/data/files/34b_ACH_Pay_Credit/ACHDBCR2ACHCR090421.602");
	      File newfile = new File("C:/Users/Boopathi/Desktop/New folder (22)/data/files/34b_ACH_Pay_Credit/ACHDBCR2ACHCR090421.604");

	      if(oldfile.renameTo(newfile)) {
	         System.out.println("File name changed succesful");
	      } else {
	         System.out.println("Rename failed");
	      } 
	   }
	
}
