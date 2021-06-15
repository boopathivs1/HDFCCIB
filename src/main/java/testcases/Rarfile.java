package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Rarfile {
  public static void main(String[] a) throws Exception {
	  
	  String b="reports"+GetFuturedate(0);
	  System.out.println(b);
    zipFolder("E:/workspacegit/version 2/GitLabWorkSpace/Clayfin_Automation/HDFC_CIB/reports", "E:/workspacegit/version 2/GitLabWorkSpace/Clayfin_Automation/HDFC_CIB/"+b+".zip");

  
  }
  public static String GetFuturedate(int d)
	{
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	Date currentDate = new Date();
	  Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);
	c.add(Calendar.DATE, d); 
	 Date currentDatePlusOne = c.getTime();
	   // System.out.println(c.getTime());
	    String Futuredate=dateFormat.format(currentDatePlusOne);
	    int min = 10;
	    int max = 99;

	      int num = (int) (Math.random() * (max - min + 1)) + min;
	      System.out.println(num);

	    System.out.println(Futuredate);
	    
	    return Futuredate+num;

	}

  static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
    ZipOutputStream zip = null;
    FileOutputStream fileWriter = null;

    fileWriter = new FileOutputStream(destZipFile);
    zip = new ZipOutputStream(fileWriter);

    addFolderToZip("", srcFolder, zip);
    zip.flush();
    zip.close();
  }
  public static String GetFuturesdate(int d)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date currentDate = new Date();
	  Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);
	c.add(Calendar.DATE, d); 
	 Date currentDatePlusOne = c.getTime();
	   // System.out.println(c.getTime());
	    String Futuredate=dateFormat.format(currentDatePlusOne);
	    int min = 10;
	    int max = 99;

	      int num = (int) (Math.random() * (max - min + 1)) + min;
	      System.out.println(num);

	    System.out.println(Futuredate);
	    
	    return Futuredate+num;

	}

  static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
      throws Exception {

    File folder = new File(srcFile);
    if (folder.isDirectory()) {
      addFolderToZip(path, srcFile, zip);
    } else {
      byte[] buf = new byte[1024];
      int len;
      FileInputStream in = new FileInputStream(srcFile);
      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
      while ((len = in.read(buf)) > 0) {
        zip.write(buf, 0, len);
      }
    }
  }

  static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
      throws Exception {
    File folder = new File(srcFolder);

    for (String fileName : folder.list()) {
      if (path.equals("")) {
        addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
      } else {
        addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
      }
    }
  }
}