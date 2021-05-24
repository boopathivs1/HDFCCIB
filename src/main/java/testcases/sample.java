package testcases;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

import org.hamcrest.core.IsNull;

public class sample {
	
	private static String filename="";
	
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
				System.out.println(file.getName()+"actualname");
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
	
	public static void main(String[] args) {
		
		String M="";
		String actualdate="";
		 LocalDate currentdate = LocalDate.now();
		 int currentDay = currentdate.getDayOfMonth();
		 int month =currentdate.getMonthValue();
		 if(month <=9)
		 {
			M ="0"+month;
			 
		 }
		 System.out.println(M+currentDay);
		
		
		 
	}
	

}
