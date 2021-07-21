package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class testfilecopy {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		File source = new File("E://workspacegit//version 2//GitLabWorkSpace//Clayfin_Automation//HDFCWEB_CIB//data//files//128RBI/");
		
		File dest = new File("E://workspacegit//version 2//GitLabWorkSpace//Clayfin_Automation//HDFCWEB_CIB//CE//ENC 130721//cs//PICKDIR");

		try {
		    FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	
	
	

}
