package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class testcopyfiles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	try{	
//		File a=new File("C:/Users/Boopathi/Desktop/New folder (43)");
//		File b=new File("C:/Users/Boopathi/Desktop/New folder (47)");
//	File a = new File("E:/workspacegit/version 2/GitLabWorkSpace/Clayfin_Automation/HDFCWEB_CIB/testfiles");
//		File b = new File("E:/workspacegit/version 2/GitLabWorkSpace/Clayfin_Automation/HDFCWEB_CIB/CE/ENC 130721/cs/PICKDIR");
		File a = new File("E:/workspacegit/version 2/GitLabWorkSpace/Clayfin_Automation/HDFCWEB_CIB/testfiles");
	File b = new File("E:/workspacegit/version 2/GitLabWorkSpace/Clayfin_Automation/HDFCWEB_CIB/CE/ENC 130721/cs/PICKDIR");
	
		
copy(a,b);
		
	}
	catch (IOException e) {
		// TODO: handle exception
	}


	}
	private static void copy(File src, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            // buffer size 1K
            byte[] buf = new byte[1000000024];

            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } finally {
            is.close();
            os.close();
        }
    }


}
