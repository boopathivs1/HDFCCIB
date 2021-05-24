package testcases;


	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.sound.sampled.Line;

	class Readspecific {
		public static String strAr[];
	    public static void main( String args[] ) {
	      int n =3; // The line number
	int a;  
	      try{
	        //String line = Files.readAllLines(Paths.get("C:/Users/Boopathi/Desktop/New folder (8)/RBAU0904.701")).get(n);
	        String line = Files.readAllLines(Paths.get("C:/Users/Boopathi/Desktop/New folder (8)/RBAU0904.701")).get(n);
	        System.out.println(line);
			   String strMain =line;
			   String[] arrSplit = strMain.split(",");
System.out.println(arrSplit[22].toString());
String date=arrSplit[22];
	System.out.println(date);    	  
//modifyFile("C:/Users/Boopathi/Desktop/New folder (8)/RBAU0904.701",date, "12/40/021");
	//modifyFile("C:/Users/Boopathi/Desktop/New folder (8)/ACHDBCR2ACHCR090421.600",date, "12/40/021");
	
	      } 
	      catch(IOException e){
	        System.out.println(e);
	      }
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
	