package testcases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class getvalue {
	
	private static String filename;
//	 public static void main(String []args){
//		   String strMain = "Alpha, Beta, Delta, Gamma, Sigma";
//		    String[][] arrSplit = strMain.split(", ");
//		    for (int i=0; i < arrSplit.length; i++)
//		    {
//		      System.out.println(arrSplit[i][]);
//		    }
//		  }
//		}





public static String getfilename()
{
	
	String Folderpath="./data/files/26FTLA/";
	File folder = new File(Folderpath);
	File [] files = folder.listFiles();
	
	for(File file :files)
	{
		if(file.isFile())
		{
			filename=file.getName();
			//System.out.println(file.getName()+"actualname");
		}
	}
	return filename;
}



public static void main(String[] args) throws IOException {
	
	   {
		String rep;
		//String finalrep;
		
		String replaced;
		getfilename();
	   
	      FileReader f1=new FileReader("./data/files/26FTLA/"+filename+"");
BufferedReader br = new BufferedReader(f1);
String line;

while((line = br.readLine())!= null)
{
//	System.out.println(line);
	
	
	 String[] arrSplit = line.split("\n");
	 System.out.println(arrSplit[0]);
//	 for (int i=0; i < arrSplit.length; i++)
//		    {	      
//		 System.out.println(arrSplit[i]);
//		    }
//	 
			//System.out.println(finalrep);
	
}

	}
}
}