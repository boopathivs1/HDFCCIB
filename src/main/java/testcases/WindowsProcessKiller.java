package testcases;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WindowsProcessKiller {

	// command used to get list of running task
	private static final String TASKLIST = "tasklist";
	// command used to kill a task
	private static final String KILL = "taskkill /IM ";

	public boolean isProcessRunning(String serviceName) {

		try {
			Process pro = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				if (line.startsWith(serviceName)) {
					return true;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static void killProcess(String serviceName) {

		try {
			Runtime.getRuntime().exec(KILL + serviceName);
			System.out.println(serviceName+" killed successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		String cmd2 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\cs && start startup.bat\"";
//		String cmd3 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\cs\"";
String filename="CBDTBULK0709.331";

		
	
		String killCmd2 = "taskkill /f /im cmd /c";
		
		try {
			Runtime.getRuntime().exec(cmd2);

			
//			Runtime.getRuntime().exec(cmd3);

			Thread.sleep(2000);
			System.out.println("Sleep Expires...");
		//	Thread.sleep(2000);
	//	Runtime.getRuntime().exec(killCmd2);
		Thread.sleep(20000);
				
		
//		Runtime.getRuntime().exec(killCmd2);
		
		System.out.println("Horaaaa!!! cmd executed!!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		
		
		
		
		

		WindowsProcessKiller pKiller = new WindowsProcessKiller();

		// To kill a command prompt
		String processName = "cmd.exe";
		boolean isRunning = pKiller.isProcessRunning(processName);

		System.out.println("is " + processName + " running : " + isRunning);

		if (isRunning) {
			pKiller.killProcess(processName);
		}
		else {
			System.out.println("Not able to find the process : "+processName);
		}

	}

}