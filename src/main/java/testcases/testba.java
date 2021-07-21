package testcases;

public class testba {

	
		
		         // We are running "dir" and "ping" command on cmd
		      //   Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"dir && ping localhost\"");
		   //Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"dir && ipconfig\"");
					public static void main(String[] args) {
						// TODO Auto-generated method stub
						//String cmd1 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\cs && start startup.bat\"";
						String cmd2 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\cs && start startup.bat\"";
						String killCmd2 = "taskkill /f /im cmd /c";
						//String killCmd3 = "taskkill /f /im startup.bat";
						
						//String killCmd3 ="taskkill /f /im cmd /c";
						
						try {
							Runtime.getRuntime().exec(cmd2);
					Thread.sleep(2000);
							System.out.println("Sleep Expires...");
							Thread.sleep(2000);
						Runtime.getRuntime().exec(killCmd2);
						Thread.sleep(2000);
								
						
						Runtime.getRuntime().exec(killCmd2);
						
						System.out.println("Horaaaa!!! cmd executed!!!!!");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
					}
					
				           
				            
				
				}


