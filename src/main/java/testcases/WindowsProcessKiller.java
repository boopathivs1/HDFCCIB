<<<<<<< HEAD

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
		
		String cmd2 =  "cmd /c start cmd.exe /K \"cd Extra\\cs && startup.bat\"";
		
		String killCmd2 = "taskkill /f /im cmd /c";
		String fileName ="RBAU1707.741";
		String cmdChecksum =  "cmd /c start cmd.exe /K \"cd Extra\\cs && startup.bat\"";
		String cmdTelconEnc = "cmd /c start cmd.exe /K \"cd  Extra\\cs\\DROPDIR && myprog.exe "+fileName+" "+fileName+".e e\"";
		
		try {
			Runtime.getRuntime().exec(cmdChecksum);

			
	//		Runtime.getRuntime().exec(cmd3);

			Thread.sleep(2000);
			System.out.println("Sleep Expires...");
		//	Thread.sleep(2000);
	//	Runtime.getRuntime().exec(killCmd2);
		Thread.sleep(10000);
		//killer();
		Runtime.getRuntime().exec(cmdTelconEnc);
		Thread.sleep(10000);
		killer();
		
//		Runtime.getRuntime().exec(killCmd2);
		
		System.out.println("Horaaaa!!! cmd executed!!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

		
		
		public static void killer()
		{
		
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

=======
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
		
		String cmd2 =  "cmd /c start cmd.exe /K \"cd Extra\\cs && startup.bat\"";
		
		String killCmd2 = "taskkill /f /im cmd /c";
		String fileName ="RBAU1707.741";
		String cmdChecksum =  "cmd /c start cmd.exe /K \"cd Extra\\cs && startup.bat\"";
		String cmdTelconEnc = "cmd /c start cmd.exe /K \"cd  Extra\\cs\\DROPDIR && myprog.exe "+fileName+" "+fileName+".e e\"";
		
		try {
			Runtime.getRuntime().exec(cmdChecksum);

			
	//		Runtime.getRuntime().exec(cmd3);

			Thread.sleep(2000);
			System.out.println("Sleep Expires...");
		//	Thread.sleep(2000);
	//	Runtime.getRuntime().exec(killCmd2);
		Thread.sleep(10000);
		//killer();
		Runtime.getRuntime().exec(cmdTelconEnc);
		Thread.sleep(10000);
		killer();
		
//		Runtime.getRuntime().exec(killCmd2);
		
		System.out.println("Horaaaa!!! cmd executed!!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

		
		
		public static void killer()
		{
		
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
>>>>>>> branch 'master' of https://github.com/boopathivs1/HDFCCIB

}