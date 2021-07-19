package testcases;

import java.io.File;
import java.io.IOException;

public class testbatDIR {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		try {
            String[] command = {"cmd.exe", "/C", "Start", "D:/CE/New folder/ENC 130721/cs/startup.bat"};
           // String[] command = {"cmd.exe", "/K", "Start", "E:/Workspaceclayfin/burgan/Vayana Automation Framework/Jars/StartHub.bat"};
            
            
            
            Process p =  Runtime.getRuntime().exec(command);           
       
            
            Thread.sleep(10000);
            
  //s          String[] commandstop = {"cmd.exe", "/C", "exit", "E:/Workspaceclayfin/burgan/Vayana Automation Framework/Jars/StartHub.bat"};
            // String[] command = {"cmd.exe", "/K", "Start", "E:/Workspaceclayfin/burgan/Vayana Automation Framework/Jars/StartHub.bat"};
             
             
//            Runtime.getRuntime().exec("cmd /c start closeCMD.bat");

System.out.println("test");
            Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;

     
            
            
            
            
            
		
		
		} catch (IOException ex) {
        }	
	}
}