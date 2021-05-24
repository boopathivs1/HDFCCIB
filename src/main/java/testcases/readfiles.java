package testcases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class readfiles {
public static String a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File folder = new File("C:/Users/Boopathi/Desktop/New folder (22)/data/files/34b_ACH_Pay_Credit");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  a= listOfFiles[i].getName();
		    System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}

		System.out.println(a);
//		 File oldName =
//		         new File("C:/Users/Boopathi/Desktop/New folder (22)/data/files/34b_ACH_Pay_Credit/ACHDBCR2ACHCR090421.600");
//		        File newName = 
//		         new File("C:/Users/Boopathi/Desktop/New folder (22)/data/files/34b_ACH_Pay_Credit/GeeksforGeeks.txt");
//		  
		        File oldfile = new File("C:/Users/Boopathi/Desktop/New folder (22)/data/files/34b_ACH_Pay_Credit/"+a+"");
			      File newfile = new File("C:/Users/Boopathi/Desktop/New folder (22)/data/files/34b_ACH_Pay_Credit/ACHDBCR2ACHCR090421.611");

			      if(oldfile.renameTo(newfile)) {
			         System.out.println("File name changed succesful");
			      } else {
			         System.out.println("Rename failed");
			      } 
			      
			      modifyFile("C:/Users/Boopathi/Desktop/New folder (22)/data/files/34b_ACH_Pay_Credit/ACHDBCR2ACHCR090421.611", "1233000000000000000000000200120052021", "1233000000000000000000000200120052022");
			      modifyFile("C:/Users/Boopathi/Desktop/New folder (22)/data/files/34b_ACH_Pay_Credit/ACHDBCR2ACHCR090421.611", "UMRN1421245634575481", "UMRN1421245634575482");
			      
			      
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
    }
}
