package testcases;

import java.nio.file.SimpleFileVisitor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipOutputStream;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;

public class Comma {
  public static void main(String[] args) {
    // Source folder
    final String SOURCE_DIR = "E:/workspacegit/version 2/GitLabWorkSpace/Clayfin_Automation/HDFC_CIB/reports";
    // creating the name of the zipped archive
    
    String a=GetFuturesdate(0);
    System.out.println(a);
    String ZIP_DIR = SOURCE_DIR.concat(".zip");
    zipFolderStructure(SOURCE_DIR,ZIP_DIR);
    
    
    ////
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

  
  
	public static String GetFuturedate(int d)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date currentDate = new Date();
	  Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);
	c.add(Calendar.DATE, d); 
	 Date currentDatePlusOne = c.getTime();
	    
	    String Futuredate=dateFormat.format(currentDatePlusOne);

	    System.out.println(Futuredate);
	    
	    return Futuredate;

	}

  private static void zipFolderStructure(String sourceFolder, String zipFolder){
    // Creating a ZipOutputStream by wrapping a FileOutputStream
    try (FileOutputStream fos = new FileOutputStream(zipFolder); 
         ZipOutputStream zos = new ZipOutputStream(fos)) {
      Path sourcePath = Paths.get(sourceFolder);
      // Walk the tree structure using WalkFileTree method
      Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>(){
        @Override
        // Before visiting the directory create the directory in zip archive
        public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
          // Don't create dir for root folder as it is already created with .zip name 
          if(!sourcePath.equals(dir)){
            System.out.println("Directory- " + dir);
            zos.putNextEntry(new ZipEntry(sourcePath.relativize(dir).toString() + "/"));                  
            zos.closeEntry();    
          }
          return FileVisitResult.CONTINUE;
        }
        @Override
        // For each visited file add it to zip entry
        public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
          System.out.println("File Name- " + sourcePath.relativize(file).toString());
          zos.putNextEntry(new ZipEntry(sourcePath.relativize(file).toString()));
          Files.copy(file, zos);
          zos.closeEntry();
          return FileVisitResult.CONTINUE;
        }});
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}