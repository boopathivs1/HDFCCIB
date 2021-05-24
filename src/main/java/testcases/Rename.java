package testcases;
import java.io.File;



public class Rename {

	   public static void main(String[] args) { 
	      File oldfile = new File("C:/Users/Boopathi/Desktop/New folder (8)/ACHDBCR2ACHCR090421.600");
	      File newfile = new File("C:/Users/Boopathi/Desktop/New folder (8)/ACHDBCR2ACHCR090421.601");

	      if(oldfile.renameTo(newfile)) {
	         System.out.println("File name changed succesful");
	      } else {
	         System.out.println("Rename failed");
	      } 
	   }
	
}
