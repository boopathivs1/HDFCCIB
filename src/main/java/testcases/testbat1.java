package testcases;

public class testbat1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        { 
         // We are running "dir" and "ping" command on cmd
      //   Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"dir && ping localhost\"");
		   //Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"dir && ipconfig\"");
			  // Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"dir && D:\\CE\\ENC 130721\\cs\\DROPDIR\\myprog.exe CBDTBULK0709.331 CBDTBULK0709.331.e e\"");
				        
			   Runtime.getRuntime().exec("cmd /k start D://CE//New folder//ENC 130721//cs//startup.bat");
			   
	//	   Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"ipconfig");
		   
			   
			   
        
        
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
	}

}
