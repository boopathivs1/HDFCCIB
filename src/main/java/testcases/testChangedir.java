package testcases;

import java.io.File;
import java.io.IOException;

public class testChangedir {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		try {
           
            
			Runtime.getRuntime().exec("cmd.exe /c start cmd /k \" D:/CE/New folder/ENC 130721/cs/startup.bat\"");
 
		
		
		} catch (IOException ex) {
        }	
	}
}