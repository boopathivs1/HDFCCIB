package testcases;


	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.sound.sampled.Line;

	class Readspecificspaces {
		public static String strAr[];
	    public static void main( String args[] ) {
	      int n =0; // The line number
	int a;  
	      try{
	        //String line = Files.readAllLines(Paths.get("C:/Users/Boopathi/Desktop/New folder (8)/RBAU0904.701")).get(n);
	        String line = Files.readAllLines(Paths.get("C:/Users/Boopathi/Desktop/New folder (3)/ACHDBCR2ACHCR010621.653")).get(n);
	        

	        
	    	  System.out.println(line);
			   String strMain =line;
			   String[] arrSplit = strMain.split("\\s+");
//System.out.println(arrSplit[3].toString());
String date=arrSplit[4].toString();
	System.out.println(date);
	
	String f=date.substring(0,34);
	
	String fa=date.substring(36,61);
	
System.out.println(f);	
System.out.println(fa);	

System.out.println(GetTodayDate());

String b=f+GetTodayDate();
System.out.println(b);

//modifyFile("C:/Users/Boopathi/Desktop/New folder (8)/RBAU0904.701",date, "12/40/021");
//modifyFile("C:/Users/Boopathi/Desktop/New folder (26)/ACHDBCR2ACHDB270521.420",date,b);










//String lines = Files.readAllLines(Paths.get("C:/Users/Boopathi/Desktop/New folder (3)/ACHDBCR2ACHCR010621.653")).get(n);
//
//
//
//
//
//
//System.out.println(lines);
// String str =lines;
//
//
//
//String[] arr = str.split("\\s+");
////System.out.println(arrSplit[3].toString());
//String dat=arr[10].toString();
//System.out.println(dat);
//
//String fs=dat.substring(0,35);
//System.out.println(fs);	
////System.out.println(GetTodayDate());
////
////String bk=fh+GetTodayDate();
////System.out.println(bk);
////
////
////modifyFile("C:/Users/Boopathi/Desktop/New folder (26)/ACHDBCR2ACHDB270521.420",dat,bk);








	      } 
	      catch(IOException e){
	        System.out.println(e);
	      }
	    }

	
	    public static String GetTodayDate()
		{
			String M="";
			String Fromdate="";
			 LocalDate currentdate = LocalDate.now();
			 int currentDay = currentdate.getDayOfMonth();
			 int month =currentdate.getMonthValue();
			 int year = currentdate.getYear();
			 if(month <=9)
			 {
				M ="0"+month;
				 
			 }
			 return Fromdate =currentDay+M+year;
		}	
	  
	    static void modifyFile(String filePath, String oldString, String newString)
	    {
	        File fileToBeModified = new File(filePath);
	         
	        String oldContent = "";
	         
	        BufferedReader reader = null;
	         
	        FileWriter writer = null;
	         
	        try
	        {
	            reader = new BufferedReader(new FileReader(fileToBeModified));
	             
	            //Reading all the lines of input text file into oldContent
	             
	            String line = reader.readLine();
	             
	            while (line != null) 
	            {
	                oldContent = oldContent + line + System.lineSeparator();
	                 
	                line = reader.readLine();
	            }
	             
	            //Replacing oldString with newString in the oldContent
	             
	            String newContent = oldContent.replaceAll(oldString, newString);
	             
	            //Rewriting the input text file with newContent
	             
	            writer = new FileWriter(fileToBeModified);
	             
	            writer.write(newContent);
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                //Closing the resources
	                 
	                reader.close();
	                 
	                writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }

	    
	    
	    }}    
	