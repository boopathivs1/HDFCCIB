package testcases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.hamcrest.core.IsNull;

public class sample {
	
	private static String filename="";
	
	private static String finalrep;
	private static String fword;
	
//	public static void main(String[] args)
//	{
//		String reference ="Payment initiated successfully and pending for Authorization -FT104057658728";
//		
//		String finalvalue="";
//		String expected="";
//		for(int i=0; i<reference.length();i++)
//		{
//			char  c = reference.charAt(i);
//			
//			if(Character.isDigit(c))
//			{
//				finalvalue=finalvalue+c;
//				System.out.println(expected);
//			}
//	}
//		expected="FT"+finalvalue;
//		
//		System.out.println(expected);
//	}
//	
	
	
	 
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
//		
//	public static void main(String[] args) {
//		
//		getfilename();
//		File oldfile = new File("./data/files/26FTLA/"+filename+"");
//		
//		File newfile = new File("./data/files/26FTLA/RBAU2105.180");
//		if (oldfile.renameTo(newfile))
//		{
//			System.out.println(newfile.getName()+"renamed sucess");
//		}
//		
//		
//	}
	
//	public static void main(String[] args) {
//		
//		String M="";
//		String actualdate="";
//		 LocalDate currentdate = LocalDate.now();
//		 int currentDay = currentdate.getDayOfMonth();
//		 int month =currentdate.getMonthValue();
//		 if(month <=9)
//		 {
//			M ="0"+month;
//			 
//		 }
//		 System.out.println(M+currentDay);
//			 
//	}
//	
	
	//public static String GetReplaceWord() throws IOException 
	public static String  GetReplacevalue() throws IOException {
		
	
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
	//System.out.println(line);
	
	rep = line.replaceAll(",","");  
	finalrep = rep .replaceAll("\\s","");
	
	//System.out.println(finalrep);
	
}
//System.out.println(finalrep);
fword = finalrep.substring(267,277);
//replaced = finalrep.replace(fword, "24/05/2021");

//System.out.println(fword);


f1.close();
br.close();
//return fword;
	     
	   }
	return fword;
	}



	
	
	public static void main(String[] args) throws IOException {
		
		getfilename();
		FileReader f1=new FileReader("./data/files/26FTLA/"+filename+"");
		BufferedReader br = new BufferedReader(f1);
		String line;
		String Finalvalue;
		String rep;
		String frep;

		System.out.println(filename+ "file");
		while((line = br.readLine())!= null)
		{
			
			//System.out.println(line);
			GetReplacevalue();
			//System.out.println(GetReplacevalue());
			//System.out.println(fword+"actual value");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String expected = dateFormat.format(date);
			rep = line.replaceAll(fword,expected);
			System.out.println(rep);
			 
			//System.out.println(rep);
			
			//System.out.println(finalrep);
			
		}
		f1.close();
		br.close();
		
		
		
	}
	}

	

	
	
		
	

			
				    	
