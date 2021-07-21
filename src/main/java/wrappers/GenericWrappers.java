

package wrappers;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//import org.eclipse.jetty.io.UncheckedPrintWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;

import testcases.WindowsProcessKiller;
import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {
	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;String url2;
	public String environment="https://";
	public static String Simulator="";
	public static String SimulatorFileName="";
	public List<String>Bznme=new ArrayList<String>();
    public static String getrefnumer=null;
    public static String datatag=null;
    public static String fileurl=null;
    public String StatementBalanceAmount;
    public String finalBalanceAmount;
    public static int futuredate=2;
    public static int currentdate=0;
    
    public static int todaydate=0;
    
    
    public static String only_Checksum_Pick_Path=null;
    public static String Only_Check_SumDROPDIR=null;
    public static String generic_enc_old_clearfiles=null;
    public static String generic_enc_old_encfiles=null;
    
    public static String generic_enc_new_clearfiles=null;
    public static String generic_enc_new_encfiles=null;
    
    
    
    public static String SIrefnumer=null;
    public static String SIpayDate=null;
    public static boolean frameStatus;
    public static String SkippedCount=null;
	public  static Logger log = Logger.getRootLogger();
	public static String parentwindow;
    public static String randomdata1=null;
    public String otpcode="777777";
    public static String deAssigncorporateid=null;
    public static String datasheet=null;
    public static String AuthUsername=null;
    public static List<String> statuscheck=null;

    public static String Authotp=null;
	public static Boolean LogoutStatus=null;
	public static String usertype=null;
	public static String Template= null;
	
	public static int Graceperiod=2;
	public static int F=2;
	
	public static final String TASKLIST = "tasklist";
	// command used to kill a task
	public static final String KILL = "taskkill /IM ";

	
	
	
	public GenericWrappers() {
		
		Properties prop = new Properties();
		//
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
			datasheet = prop.getProperty("AjmanTestData");
			Simulator = prop.getProperty("SimulatorUrl");
			fileurl = prop.getProperty("filepath");
			
			Authotp = prop.getProperty("Authorizeotp");
			only_Checksum_Pick_Path = prop.getProperty("OnlyCheckSumPickDIR");
			
			
			Only_Check_SumDROPDIR=prop.getProperty("OnlyCheckSumDROPDIR");
			
			generic_enc_old_clearfiles=prop.getProperty("genericenc_clear_old");
			generic_enc_old_encfiles=prop.getProperty("genericenc_encfile_old");
			
			
			generic_enc_new_clearfiles=prop.getProperty("genericenc_clear_new");
					generic_enc_new_encfiles=prop.getProperty("genericenc_encfile_new");
		    
		    

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		}
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
	

	
	public void copy_file(String sourcepath,String Destinationpath) throws InterruptedException{

		File source = new File(sourcepath);
		File dest = new File(Destinationpath);

		
		
//		File source = new File("E:\\workspacegit\\version 2\\GitLabWorkSpace\\Clayfin_Automation\\HDFCWEB_CIB\\testfiles");
	//	File dest = new File("E:\\workspacegit\\version 2\\GitLabWorkSpace\\Clayfin_Automation\\HDFCWEB_CIB\\CE\\ENC 130721\\cs\\PICKDIR");
		try {
		    FileUtils.copyDirectory(source, dest);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	
	
	//	Thread.sleep(20000);
	}
	
	
	public void Start_bat_Execution(){
		
		String cmd2 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\cs && start startup.bat\"";
//		String cmd3 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\cs\"";
//String filename="CBDTBULK0709.331";

		
	
		String killCmd2 = "taskkill /f /im cmd /c";
		
		try {
			Runtime.getRuntime().exec(cmd2);

			
//			Runtime.getRuntime().exec(cmd3);

		//	Thread.sleep(2000);
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

		
		
		
	}

	
	
	
	
	
	
	public void Start_bat_generic_enc_old(){
		
		String cmd2 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\GenericEncryption_Client && start encryptdaemon.bat\"";
//		String cmd3 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\cs\"";
//String filename="CBDTBULK0709.331";

		try {
			Runtime.getRuntime().exec(cmd2);

			
			System.out.println("Sleep Expires...");
		Thread.sleep(20000);
				
		
		
		System.out.println("Horaaaa!!! cmd executed!!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		
		
		
	}

	
	
	public void Start_bat_generic_enc_new(){
		
		String cmd2 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\NewGenericEncryption_Client && start encryptdaemon.bat\"";
//		String cmd3 =  "cmd /c start cmd.exe /K \"cd CE\\ENC 130721\\cs\"";
//String filename="CBDTBULK0709.331";

		try {
			Runtime.getRuntime().exec(cmd2);

			
			System.out.println("Sleep Expires...");
		Thread.sleep(20000);
				
		
		
		System.out.println("Horaaaa!!! cmd executed!!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		
		
		
	}

	
	
public void service_killer(){
	
//	WindowsProcessKiller pKiller = new WindowsProcessKiller();

	// To kill a command prompt
	String processName = "cmd.exe";
	boolean isRunning =isProcessRunning(processName);

	System.out.println("is " + processName + " running : " + isRunning);

	if (isRunning) {
		killProcess(processName);
	}
	else {
		System.out.println("Not able to find the process : "+processName);
	}
}
	
	
	



	
	
	
	
	
	
	
	
	
	public static String randomStringGeneration() throws InterruptedException {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
	randomdata1 = sb.toString();
		
	
		
		return randomdata1;

	}
	
	public String substring_value(int a,int b,String value){
		String files=value.substring(a,b);
		return files;		
	}
	
	
	
	
	public String filename_final(String a,String randomnumber,String filepath){
String file_format="";
	String file=dateMonth()+"."+a+randomnumber;
	//System.out.println(ranNumber);	
	System.out.println(file);
	System.out.println("************");
	System.out.println(filepath+file);
	System.out.println("************");
	file_format=filepath+file;
	return file_format;		
}

	public String filename_final_year(String a,String randomnumber,String filepath){
String file_format="";
	String file=dateMonth()+21+"."+a+randomnumber;
	//System.out.println(ranNumber);	
	System.out.println(file);
	System.out.println("************");
	System.out.println(filepath+file);
	System.out.println("************");
	file_format=filepath+file;
	return file_format;		
}	
	
	
	public void readywithtime(String xpathVal) throws InterruptedException{
		for(int i=1;i<180;i++){
			
			 JavascriptExecutor js = (JavascriptExecutor)driver;		
		     String loadstate = js.executeScript("return document.readyState").toString();
		     System.out.println(loadstate);
		        
		   
	if (loadstate.contains("complete")){
	Thread.sleep(1000);
	break;
	}
	else{
	Thread.sleep(1000);
	}	}

	}

	public void readytimes() throws InterruptedException{
	
		try{
		for(int i=1;i<50;i++){
			
			 JavascriptExecutor js = (JavascriptExecutor)driver;		
		     String loadstate = js.executeScript("return document.readyState").toString();
		     
		        
	if (loadstate.contains("complete")){
	Thread.sleep(1000);
	break;
	}
	else{
	Thread.sleep(1000);




	//break;
	}	}}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void readystate(){
		
		try{
	WebDriverWait wait;
	  wait = new WebDriverWait(driver,60);
//wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")); 
	  wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")); 
	
		}
		catch(Exception e){
		}}

	public void jqueryload() throws InterruptedException{
try{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	int count =0;
	if((Boolean)js.executeScript("return window.jQuery != undefined"))
	{
		while(!(Boolean) js.executeScript("return jQuery.active == 0"))
		{ 

			Thread.sleep(1000); 
			if(count>80) 
				break;
			count++;
			} 
		}
}
catch(Exception e){
	
}
	
	}	
	public static String gettwoRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	   
		 int min = 10;
		    int max = 99;

		    int num = (int) (Math.random() * (max - min + 1)) + min;
	
		    String s=Integer.toString(num);
		  	
		
//	    Random rnd = new Random();
//	    int number = rnd.nextInt(99);
//
//	    // this will convert any number sequence into 6 character.
	    return s;
	}

	
	public static String gettwoRandomNumber_range_String(int a, int b) {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	   
		 int min = a;
		    int max = b;

		    int num = (int) (Math.random() * (max - min + 1)) + min;
	
		    String s=Integer.toString(num);
		  	
		
//	    Random rnd = new Random();
//	    int number = rnd.nextInt(99);
//
//	    // this will convert any number sequence into 6 character.
	    return s;
	}

	
	public static String gettwoRandomNumber_range() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	   
		  Random rnd = new Random();
		    int number = rnd.nextInt(1000000);

		    // this will convert any number sequence into 6 character.
//		   # return String.format("%02d", number);
		    String expected= String.format("%2d", number);
		    
		    String finalvalue =expected.substring(expected.length() - 2);
		   // System.out.println(String.format("%2d", number));
		  	
		
//	    Random rnd = new Random();
//	    int number = rnd.nextInt(99);
//
//	    // this will convert any number sequence into 6 character.
	    return finalvalue;
	}

	
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	
	public static String getRandomNumString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
		 int min = 1;
		    int max = 99999999;

		      int num = (int) (Math.random() * (max - min + 1)) + min;
		      String expected = String.valueOf(num).substring(2);
		      System.out.println(expected);
		    
	    // this will convert any number sequence into 6 character.
	    return expected;
	}
	
	
	public void verifyTextMatchlistByXpath(String xpath,String Status){
		//waitForElement(xpath, 30);
	
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}

		WebDriverWait wait;
		try{
		List<String>a1=new ArrayList<String>();
		Thread.sleep(8000);
	 wait= new WebDriverWait(driver, 60);
List<WebElement> elem=driver.findElements(By.xpath(xpath));


Thread.sleep(6000);
for (int i = 0; i <elem.size(); i++) {
	String elestatus=elem.get(i).getText();
if(elestatus.equalsIgnoreCase(Status)){
}
else{
	throw new RuntimeException("list has not matched");
	
}
}
reportStep("Status has matched in this List", "Pass");
		}
catch (Exception e) {
	reportStep( ""+Status+"has not matched in List", "Fail");
	}
}

	
	
	
	
	
	
	
	
	public void verifyTextlistcontainXpath(String xpath,String Status){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		WebDriverWait wait;
		
		
		try{
			Thread.sleep(3000);
			  	wait= new WebDriverWait(driver, 60);
			List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	 for(int i=0;i<element.size();i++){
			String arrval=element.get(i).getText();
			
		   }
	
	
	
	int j=0;
	   for(int i=0;i<element.size();i++){
		String arrval=element.get(i).getText();
	
		if((arrval).equalsIgnoreCase(Status)){
			   j=1;
		   }
	   }
	        
	     
if(j==1){
	reportStep(Status+" has matched in this List", "PASS");
}else{
	reportStep(Status+" has not matched in this List", "FAIL");

}
   		}
		
		catch (Exception e) {
	    	reportStep(Status+" has not matched in this List", "FAIL");
		}
}
	
	
	public void verifyTextlistnotcontainXpath(String xpath,String Status){
		try{
			  		WebDriverWait wait= new WebDriverWait(driver, 60);
			List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	 for(int i=0;i<element.size();i++){
			String arrval=element.get(i).getText();
		
		   }
	
	
	int j=0;
	   for(int i=0;i<element.size();i++){
		String arrval=element.get(i).getText();
	
		if((arrval).equalsIgnoreCase(Status)){
			   j=1;
		   }
	   }
	        
	       
if(j==0){
	reportStep(Status+" has not matched in this List", "PASS");
}else{
//	reportStep(Status+" has matched in this List", "FAIL");
throw new RuntimeException();
}
   		}
		
		catch (Exception e) {
	    	reportStep(Status+" has matched in this List", "FAIL");
		}
}
	
	
	public void verifyTextsizecontainslistByXpath(String xpath,int Status){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 60);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(15000);

int a=element.size();

if(a==Status){
	
reportStep(Status+" has matched in this List", "PASS");

}
else{
	throw new RuntimeException(Status+" has not matched in this list" );	
}
		}
catch (Exception e) {
	reportStep(Status+" has not matched in this list","FAIL");
	}
}
	
	
	
	
	
	
	
	
	public void verifyTextcontainslistByXpath(String xpath,String Status){
		
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 60);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(15000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();

		a1.add(cate);
	}
		Thread.sleep(5000);

if(a1.contains(Status)){
	
reportStep(Status+" Reference number has matched in this List", "PASS");

}
else{
	throw new RuntimeException(Status+"Reference number has not matched in this list" );	
}
		}
catch (Exception e) {
	reportStep(""+e+ "", "FAIL");
	}
}
	
	
	
	
	
	public void verifytextmatches(String a ,String b){
if(a.equalsIgnoreCase(b)) {
	reportStep(a+"Matches with the value "+b, "PASS");
	
}
	else {
		reportStep(a+"does not Matches withe value "+b, "FAIL");
	}
	}
	public void verifyNottextmatches(String a ,String b){
		if(!a.equalsIgnoreCase(b)) {
			reportStep(a+"not Matches with the value "+b, "PASS");
			
		}
			else {
				reportStep(a+" Matches withe value "+b, "FAIL");
			}
			}

	public void StatusUpdate(String msg,String status) {
		try{
			if("PASS".equalsIgnoreCase(status))
			{
				reportStep(msg, "PASS");
			}
			else {
				reportStep(msg, "FAIL");
			}
					}
		catch (Exception e) {
			reportStep("Element not found", "FAIL");
		}
	}
	public void del() throws IOException{
		try{	
		FileUtils.cleanDirectory(new File("./reports"));
		}catch(Exception ie){
			
		}
		}

	
	
	
	
	
	
	
	
	
	public void verifyTextcontainslistandSetuserid(String xpath,String Status){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 80);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(4000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();

		a1.add(cate);
	}	
		Thread.sleep(4000);
				
if(a1.contains(Status)){

	AuthUsername=Status;
	
reportStep(Status+"  has matched in this List", "Pass");

}
else{
	throw new RuntimeException(Status+" has not matched in this list" );	
}
		}
catch (Exception e) {
	reportStep(""+e+ "", "Fail");
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}
	public void navigate(String url) {
		try {
			 url2=environment+url;
			System.err.println(url2);
			driver.navigate().to(url2);
		/*	for (int i = 0; i<5; i++) {
				Thread.sleep(1000);
			}*/
			reportStep("Now the page has landed with this url"+url2, "PASS");
		
		}
		catch (NoSuchWindowException e) {
			reportStep("Window was unfortunately closed"+url2, "FAIL");
		}
		catch (TimeoutException e) {
			reportStep("Timeout Exception has occured"+url2, "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Now the page has not landed with this url"+url2, "FAIL");
		}
	}
	
	
	public void verifyTextContainsByXpathexplictwaitalert(String xpath, String text) throws InterruptedException{
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String sText = element.getText();
			
						if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}}

		catch (Exception e) {		
				reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	public void enterBycssXpathExplict(String xpathVal, String mobileNo) {
		try{
		
			Thread.sleep(6000);
			
			WebDriverWait wait = new WebDriverWait(driver,20);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(xpathVal)));
					element.sendKeys(mobileNo);
			
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
			catch (Exception e) {
		
				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}

public void clicklistByxpathExplicitwaitindex(String xpathValue,int i) {
	try {
		readywithtime(xpathValue);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try {
		WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	//List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	myIput.get(i).click();		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
		catch (Exception e) {
		
			reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
}
	public String Data(String data) throws InterruptedException {
	Random r = new Random();
	int Low = 1;
	int High = 5;
	int R = r.nextInt(High-Low) + Low;			
//alphabit	
	String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";		
	int character=(int)(Math.random()*26);	
	
	String s=alphabet.substring(character, character+1);	
	
	String bizname=data+s;
	Bznme.add(bizname);
return bizname;
	}
	
	

	
	
	
	
	
	
	public void verifyElementtwoelementpresentByXpathExplicitwait(String xpath,String xpaths,String validmsg,String errorvalid){
		try {
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			//String sText = element.getText();
			if (element1.isDisplayed()&&element2.isDisplayed()){
				reportStep(validmsg+xpath, "PASS");
			}else{
				reportStep(errorvalid +xpath, "FAIL");
			}
		}
		catch (Exception e) {
			reportStep(errorvalid+xpath, "FAIL");

		}
	}
	
	public void verifyTextcontainsurls( String url,String text){
		try {
				if (url.contains(text)){
				reportStep("The text: "+url+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+url+" did not match with the value :"+text, "FAIL");
			}
		}
		catch (Exception e) {
			reportStep("The :"+text+" could not be Matched.", "FAIL");
		}
	}
	
	
	
	public Boolean VerifyElementpresentreturn(String xpath) {
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			wait = new WebDriverWait(driver,40);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//		WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
			
			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
		
	
	
	
	
public Boolean VerifyWaitElementpresentreturn(String xpath) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
		
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			wait = new WebDriverWait(driver,60);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//		WebElement e  =driver.findElement(By.xpath(xpath));
		if(e.isDisplayed())
		{
			B=true;
		
	//		reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
	
	
	
	public Boolean VerifyElementWARNreturn(String xpath) {
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		Boolean B=false;
		WebDriverWait wait;
		try{
			Thread.sleep(2000);

			wait = new WebDriverWait(driver,60);
			WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	//WebElement e  =driver.findElement(By.xpath(xpath));
		
		
		if(e.isDisplayed())
		{

			B=true;
			
			reportStep("The element with xpath: "+xpath+" is present.", "PASS");
return B;
		}
		
		else {
		
			//reportStep("The element with id: "+xpath+" is not present .", "PASS");
		}
		
		}
	catch (Exception e) {
		// TODO: handle exception
	

	}
		return B;
	}
	
	
	
	
	
	public void pageRefresh( ){
		try {
				driver.navigate().refresh();
				reportStep("Page has refresh sucessfully", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has refresh sucessfully", "FAIL");
		}
	}
	
	
	
	
	public void verifybyAttributescontainsxpathvalidinvalid(String xpath, String attributes ,String compText,String validmsg,String errorvalid) throws InterruptedException {
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		try{
			Thread.sleep(3000);
			String sText = driver.findElementByXPath(xpath).getAttribute(attributes);
	
			if (sText.contains(compText)){
				
				reportStep(sText+ "contains the value  "+ validmsg, "PASS");
			}else{
				
				
				
				reportStep(sText+ "does not contains the value  " +errorvalid, "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
	}


	public void verifyTextnotPresentCONTAINSByXpath(String xpath, String text){
		try {
			
			
			
			String sText = driver.findElement(By.xpath(xpath)).getText();

			if (sText.contains(text)){
				reportStep(text,"FAIL");	
			}
	

			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
			
			
			
		
	}


	public void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void unloadObjects() {
		prop = null;
	}

	

	public void invokeApp(String browser) throws IOException {
						invokeApp(browser,false);
			}

	
	 

	
	public void invokeApp(String browser, boolean bRemote) {
		try {
//sabb	
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
//	//	dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ChromeOptions capability = new ChromeOptions();
	//	capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//	capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		//	capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 
			 //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			capability.setAcceptInsecureCerts(true);
			 
			 //Creating instance of Chrome driver by passing reference of ChromeOptions object
			// WebDriver driver = new ChromeDriver(capability);
			 
		
			// this is for grid run
			if(bRemote)
				driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
				else{ // this is for local run
				if(browser.equalsIgnoreCase("chrome")){
					//System.setProperty("webdriver.chrome.driver", "./drivers/chromedrivers.exe");

					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

					//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver85.exe");

					driver = new ChromeDriver(capability);
			
				}else{
						System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
			
				}
			}
		
			/*
			Dimension dime= new Dimension(3560,2680); 
			driver.manage().window().setSize(dime);
			
			*/
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);



driver.manage().window().maximize();
			

			url2=environment+sUrl;
  		  			Thread.sleep(1000);			
//			getnewurl();
//  			Thread.sleep(2000);
//  			getnewurl();
//  		  	
			primaryWindowHandle = driver.getWindowHandle();		
			reportStep("The browser:" + browser + " launched successfully", "PASS");

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}


	
	
		
	
	public void pageloadtimeOut(){
try{
driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); 
	
reportStep("page has been loading", "PASS");
}
catch (Exception e) {
	reportStep("page has  not beenloading", "FAIL");
}
	}
			

public ArrayList<WebElement>arraylisting(String xpath)    {

ArrayList<WebElement>li=(ArrayList<WebElement>) driver.findElements(By.xpath(xpath));
return(li);
}
	
	
	
	
	public void pageScrollup() {
		try{
			JavascriptExecutor jse = driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	public void pageScroll() {
		try {
			readytimes();
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		try{
	JavascriptExecutor jse = driver;
	jse.executeScript("window.scrollBy(0,700)", "");
	Thread.sleep(3000);
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	
	
public void clickJswait(String xpath){
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	WebDriverWait wait;
	try{
		Thread.sleep(2000);
		
wait = new WebDriverWait(driver,180);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", element);

reportStep("The element with xpath: "+xpath+" is clicked.", "PASS");

	}


catch (Exception e) {

	reportStep("The element with xpath: "+xpath+" is clicked.", "FAIL");

}	
}

public void clickJs(String xpath){
	
	if(frameStatus){
		
		defaultcontent();
		waitTillSpinnerDisappear(driver);
		locateFrame("icanvas");	
	}	
	else{
		waitTillSpinnerDisappear(driver);
	}
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	
	try{
		Thread.sleep(2000);
WebElement element=driver.findElement(By.xpath(xpath));

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", element);

reportStep("The element with xpath: "+xpath+" is clicked.", "PASS");

	}


catch (Exception e) {

	reportStep("The element with xpath: "+xpath+" could not be clicked.", "FAIL");

}	
}



public void clickJsWaitLess(String xpath){
	
	
	try{
		Thread.sleep(2000);
WebElement element=driver.findElement(By.xpath(xpath));

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", element);

reportStep("The element with xpath: "+xpath+" is clicked.", "PASS");

	}


catch (Exception e) {

	reportStep("The element with xpath: "+xpath+" could not be clicked.", "FAIL");

}	
}




	public void scrolltoelementJs(String xpathtext){
		try {
			readywithtime(xpathtext);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
try{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Thread.sleep(2000);
	WebElement Element = driver.findElement(By.xpath(xpathtext));

	js.executeScript("arguments[0].scrollIntoView();", Element);

	

reportStep("Scroll to element: "+xpathtext+" is clicked.", "PASS");
	
	
	
	}
catch (Exception e) {

	reportStep("Unable to scroll to this element: "+xpathtext+".", "FAIL");

}
	}	
	public void MouseHoverByXpathExplict(String xpathVal) {
		try {
			readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		WebDriverWait wait;
//		waitForElement(xpathVal,60);
		try{
			Thread.sleep(2000);
			Actions actions = new Actions(driver);

			WebElement element = driver.findElement(By.xpath(xpathVal));

		    // waits until Home link is visible on the web page

		  wait = new WebDriverWait(driver, 60);
		    wait.until(ExpectedConditions.elementToBeClickable(element));
		    actions.moveToElement(element).perform();


	reportStep("The Mousehover with xpath: "+xpathVal+" is clicked.", "PASS");

		}
		
		catch (Exception e) {
			reportStep("The mousehover could not performed with this xpath: "+xpathVal+" .Because Element not found Exception has occured", "FAIL");
		}

		
	}

	
	public void pageScroll1400(String xpath) {
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		try{
			 JavascriptExecutor js = (JavascriptExecutor) driver;

			 WebElement Element = driver.findElement(By.xpath(xpath));

			        //This will scroll the page till the element is found		
			        js.executeScript("arguments[0].scrollIntoView();", Element);

	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	
	
	public void pageScroll400() {
		try{
	JavascriptExecutor jse = driver;
	jse.executeScript("window.scrollBy(0,400)", "");
	reportStep("Page has sucessfully scrolled", "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not sucessfully scrolled", "FAIL");
		}
	}
	
	
	
	public void openwindow() {
		try{
	
	if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("window.open();");
        }
	reportStep("New window has opened", "PASS");

		}
		catch (Exception e) {
			reportStep("New window has not opened", "FAIL");
		}
	}
	
	public void windowhandless(int j) {
		try{
	
	
	
	
	Set<String> childwindow=driver.getWindowHandles();
	childwindow=driver.getWindowHandles();
    String[] individualHandle = new String[childwindow.size()];
    Iterator<String> it = childwindow.iterator();
    int i =0;
    while(it.hasNext())
    {
        individualHandle[i] = (String) it.next();
        i++;
    }

driver.switchTo().window(individualHandle[j]);
	
	

reportStep("New window has opened", "PASS");

	
		}
		catch (Exception e) {
			reportStep("New window has not opened", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	

	public void geturl(String url) {
		try{
	
		driver.get(url);
		driver.get(url);
		
	reportStep("Page has landed on " +url, "PASS");

		}
		catch (Exception e) {
			reportStep("Page has not landed on " +url, "FAIL");
		}
	}
	

	
	public void navigateback() {
		
	try {
		driver.navigate().back();
		reportStep("Page has navigated back sucessfully", "PASS");

	}
		catch (Exception e) {
		}
		
	}
	
	/*
	public void clickByXpathExplict(String xpathVal) {
		WebDriverWait wait;
		try{
		
			Thread.sleep(2000);

wait = new WebDriverWait(driver,80);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));


element.click();
			reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		}
	}
	
	*/
	
	public  void waitForElement(String objectName,int timeout) 
	{
		try{
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

		for(int i=1;i<=timeout;i++)
		{
			
		try{

			
		Boolean a=VerifyWaitElementpresentreturn(objectName);
if(a){
break;
}
		}
		catch(InvalidSelectorException e)
		{
			
			
			waitTimeForException(1);
		}
		catch(StaleElementReferenceException e)
		{
			waitTimeForException(1);
		}
		catch(NoSuchElementException e)
		{

			waitTimeForException(1);
		}
		catch(ElementNotVisibleException e){
			waitTimeForException(1);
		}
		catch(UnreachableBrowserException e)
		{
			
		}
		catch(WebDriverException e){
			
			waitTimeForException(1);
		}
		
		if(i==timeout)
		{
		}
		}
		}
		catch(Exception e)
		{
//			stepFailed(e.toString());
		}
		finally
		{
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
			
  }


public void waitTimeForException(int sec)
	{
		try{
			Thread.sleep(sec*1000);
		}
		catch(Exception e)
		{
		}
	}
	
	
public void MouseHoverXpathExplict(String xpathVal) {
	try {
		readywithtime(xpathVal);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	WebDriverWait wait;
//	waitForElement(xpathVal,60);
	try{
		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		WebElement element = driver.findElement(By.xpath(xpathVal));

	    // waits until Home link is visible on the web page

	  wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    actions.moveToElement(element).perform();


reportStep("The Mousehover with xpath: "+xpathVal+" is clicked.", "PASS");

	}
	
	catch (Exception e) {
		reportStep("The mousehover could not performed with this xpath: "+xpathVal+" .Because Element not found Exception has occured", "FAIL");
	}

	
}




public void verifyPageSourceText(String text) {
	try {
//		readywithtime(xpathVal);
	//readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
Boolean a=driver.getPageSource().contains(text);

booleanResult(a, "Transaction cut off time has been elapsed for the day"  +text);
}


public void pageloading() {
	try {
		readytimes();
	readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}

}

public static boolean waitTillSpinnerDisappear(WebDriver driver)
//public static boolean waitTillSpinnerDisappear(WebDriver driver, By by)
{		
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
	fWait.withTimeout(120, TimeUnit.SECONDS);
	fWait.pollingEvery(250, TimeUnit.MILLISECONDS);
	fWait.ignoring(NoSuchElementException.class);
	
	Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() 
	{
		
		@Override
		public Boolean apply(WebDriver driver) {
			//WebElement element = driver.findElement(by);
			WebElement element =driver.findElement(By.xpath(".//div[@id='loading'][contains(@style,'none')]"));
		//	System.out.println(element.getCssValue("display"));			
			
			if(element.getCssValue("display").equalsIgnoreCase("none")){
				return true;}
			
			return false;
		}
	};
	
	
	return fWait.until(func);
}











public void statusVerify(String Status){
	switch(Status){  
	//Case statements  
	case "A":reportStep(Status+ " Status has been displaying" ,"PASS"); 
	break;  
	case "U": reportStep(Status+ " Status has been displaying and E (or) R Status has not been displaying" ,"WARN"); 
	break;  
	case "C": reportStep(Status+ " Status has been displaying and E (or) R Status has not been displaying" ,"WARN");   
	break;  
	case "UP":reportStep(Status+ " Status has been displaying  and E (or) R Status has not been displaying" ,"WARN"); 
	break;
	case "E":reportStep(Status+ " Status has been displaying","PASS");
	break;
	case "R": reportStep(Status+ " Status has been displaying" ,"PASS");
	break;
	case "Q": reportStep(Status+ " Status has been displaying" ,"FAIL");
	break;  
	case "VP": reportStep(Status+ " Status has been displaying" ,"PASS");
	break; 
	case "P": reportStep(Status+ " Status has been displaying" ,"PASS");
	break;
	case "Z": reportStep(Status+ " Status has been displaying" ,"FAIL");
	break;
	case "J": reportStep(Status+ " Status has been displaying" ,"FAIL");
	break;
	//Default case statement  
	
	default:System.out.println(Status);
		reportStep(Status+ " Status has displaying", "WARN");  
	}	
}
	

public static String getfilename(String location)
{
String 	filename = null;
	String Folderpath=location;
	File folder = new File(Folderpath);
	File [] files = folder.listFiles();
	
	for(File file :files)
	{
		if(file.isFile())
		{
			filename=file.getName();
			System.out.println(file.getName()+"actualname");
		}
	}
	return filename;
}



public String getfilename_one(String filename)
{
	String filename1;

	String file1=fileurl+filename;
	filename1=getfilename(file1);

	
	
	return filename1;
}


public String renamed_filename_one(String filesname1,int a,int b,String serial_startnumber)
{
	String finalfilenaming;

String filename2=filesname1.substring(a,b);			
String ranNumber=gettwoRandomNumberString();
finalfilenaming=filename_final(serial_startnumber,ranNumber, filename2);
//System.out.println(finalfilenaming);

return finalfilenaming;
}




public String filename_substring(String filesname2,int a,int b)
{
	String finalfilenaming;

	finalfilenaming=filesname2.substring(a,b);			


return finalfilenaming;
}



public String renamed_filename_year(String filesname1,int a,int b,String serial_startnumber)
{
	String finalfilenaming;

String filename2=filesname1.substring(a,b);			
String ranNumber=gettwoRandomNumberString();
finalfilenaming=filename_final_year(serial_startnumber,ranNumber, filename2);
//System.out.println(finalfilenaming);

return finalfilenaming;
}


public void convention(String actualname,String Renamed_file_name){

File oldfile = new File(actualname);
File newfile = new File(Renamed_file_name);

if(oldfile.renameTo(newfile)) {
   System.out.println("File name changed succesful");
} else {
   System.out.println("Rename failed");
} 
}




public String getfilesName_Location(String location)

{
	String aname = null;



File folder = new File(location);
File[] listOfFiles = folder.listFiles();

for (int i = 0; i < listOfFiles.length; i++) {
  if (listOfFiles[i].isFile()) {
	  aname= listOfFiles[i].getName();
    System.out.println("File " + listOfFiles[i].getName());
  } 
}

return aname;


}








public void clickByXpathExplict(String xpathVal){
//		if(frameStatus){
//			
//			defaultcontent();
//			waitTillSpinnerDisappear(driver);
//			locateFrame("icanvas");	
//		}	
//		else{
//			waitTillSpinnerDisappear(driver);
//		}
		try {
//	readywithtime(xpathVal);
	//	readystate();
			jqueryload();
		} catch (InterruptedException e1) {
	}
//		
		
		
		WebDriverWait wait;
		//waitForElement(xpathVal,2);
		try{
		
			Thread.sleep(1000);

			WebElement element = driver.findElement(By.xpath(xpathVal));

		    // waits until Home link is visible on the web page

		  wait = new WebDriverWait(driver,50);
		    wait.until(ExpectedConditions.elementToBeClickable(element));

element.click();
			reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		}
	}
	
	
	
public void clickByXpathExplict_clear(String xpathVal){
	try {
		jqueryload();
	} catch (InterruptedException e1) {
}
//	
	
	
	WebDriverWait wait;
	//waitForElement(xpathVal,2);
	try{
	
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath(xpathVal));

	    // waits until Home link is visible on the web page

	  wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
element.clear();
//element.click();
		reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
	} 	
	catch (Exception e) {
		reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
	}
}
	
public void clickByXpath_Explict(String xpathVal){
	try {
		jqueryload();
	} catch (InterruptedException e1) {
}
//	
	
	
	WebDriverWait wait;
	//waitForElement(xpathVal,2);
	try{
	
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath(xpathVal));

	    // waits until Home link is visible on the web page

	  wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
//element.clear();
element.click();
		reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
	} 	
	catch (Exception e) {
		reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
	}
}

public void clickByXpathExplictWithouScreenShot(String xpathVal){
//	if(frameStatus){
//		
//		defaultcontent();
//		waitTillSpinnerDisappear(driver);
//		locateFrame("icanvas");	
//	}	
//	else{
//		waitTillSpinnerDisappear(driver);
//	}
	try {
//readywithtime(xpathVal);
//	readystate();
		jqueryload();
	} catch (InterruptedException e1) {
}
//	
	
	
	WebDriverWait wait;
	//waitForElement(xpathVal,2);
	try{
	
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath(xpathVal));

	    // waits until Home link is visible on the web page

	  wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.elementToBeClickable(element));

element.click();
		reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS",false);
	} 	
	catch (Exception e) {
		reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
	}
}


	
	
	
	
	
	
	
	public String regvalue(String Accno){
		String Accnumber = null;
		try{
	String userAccNo= Accno;   
	userAccNo = userAccNo.replaceAll("[^a-zA-Z0-9]", " ");  
	Accnumber = userAccNo .replaceAll("\\s","");
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		return Accnumber;
	}
	public void clickByXpathwait(String xpathVal) {
if(frameStatus){
			
			defaultcontent();
			waitTillSpinnerDisappear(driver);
			locateFrame("icanvas");	
		}	
		else{
			waitTillSpinnerDisappear(driver);
		}
		WebDriverWait wait;
		try{
		
			
wait = new WebDriverWait(driver,60);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));


element.click();
			reportStep("The element with xpath: "+xpathVal+" is clicked.", "PASS");
		} 	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }
	
	
	
	
	
	
	
	
	
	
	
	public void doubleclickByXpathExplict(String xpathVal) {
		try{
	
			Actions action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver,20);
			//WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			
			action.doubleClick(element).perform();
			
		
		} 
		
		
			
	
		//catch (TimeoutException e) {
			//reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		//}
		
		
		catch (Exception e) {
		
		
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because Element not found Exception has occured", "FAIL");
		}
	}
	public void topFrames() throws InterruptedException{
	locateFrameByXpath(".//frame[@name='top']");
	
	}	
	
	public void topEPIPCSFrames() throws InterruptedException{
		locateFrameByXpath(".//frame[@name='top_EPI']");
		
		}	
	
	public void LeftMenuFrames() throws InterruptedException{
		locateFrameByXpath(".//frame[@name='menu']");
		
		}
	
	public void contentFrames() throws InterruptedException{
		locateFrameByXpath(".//frame[@name='content']");
		
		}
	
	public void authrecFrames() throws InterruptedException{
		locateFrameByXpath(".//iframe[@id='summaryDetailsFrameid']");
		
//		locateFrame("summaryDetailsFrameid");
		//locateFrameByXpath(".//iframe[@name='summaryDetailsFrame']");
		
		 
		
		}
	
	
	
	
	public void locateFrameByXpath(String framename) throws InterruptedException {
		
		try{
			jqueryload();
			Thread.sleep(2000);
			WebElement e=driver.findElement(By.xpath(framename));
			
			driver.switchTo().frame(e);
//			frameStatus=true;
			reportStep("Frame has located", "PASS");
		} 
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}	
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
	}
	
	
	
	
	
	public void locateFrame(String framename) {
		try{
			Thread.sleep(2000);
			
			driver.switchTo().frame(framename);
			frameStatus=true;
			reportStep("Frame has located", "PASS");
		} 
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}	
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
	}
	
	
	
	public void locateFrameById(String xpath) {
		try{
			WebElement iframeElement = driver.findElement(By.id(xpath));
			driver.switchTo().frame(iframeElement);
			
			reportStep("Frame has located", "PASS");
		} 
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}	
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
	}
	
	
	
	public void defaultcontent_without_load() {

		try{
			driver.switchTo().defaultContent();
			frameStatus=false;
			
			reportStep("Now switched to default content", "PASS");
		} 
		
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}
		
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
		
		
	}	
	
	public void defaultcontent() {
		try {
//			readywithtime(xpathVal);
//readytimes();
	//		readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}

		try{
			driver.switchTo().defaultContent();
			frameStatus=false;
			reportStep("Now switched to default content", "PASS");
		} 
		
		catch (NoSuchFrameException e) {
			reportStep("no such frame exception", "FAIL");
		}
		
		catch (Exception e) {
			reportStep(e.getMessage(), "Fail");
		}
		
		
		
	}
	
	
	
	
	public void verifyElementpresentByXpathExplicitwait(String xpath){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,70);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			//String sText = element.getText();
			if (element.isDisplayed()){
				reportStep("Element is Displayed with xpath "+xpath, "PASS");
			}else{
				reportStep("Element is not Displayed with xpath " +xpath, "FAIL");
			}
		}
		
		catch (Exception e) {
			reportStep("Element is not Displayed with xpath " +xpath, "FAIL");

		}
	}
	
	public void belliconFail(String xpath){
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			//String sText = element.getText();
			if (element.isDisplayed()){
				reportStep("Element is Displayed with xpath "+xpath, "PASS");
			}else{
				throw new RuntimeException("bell icon not display Reference number");
			}
		}
		
		catch (Exception e) {
		//	clickByXpathExplict(prop.getProperty("click.buttonclosepopup.xpath"));
			reportStep("Bell icon not display Reference number "+xpath, "FAIL");
			
		}
	}
	
	
	
	
	
	

	
	
	
	public void verifyElementpresentByXpathExplicitw(String xpath){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			//String sText = element.getText();
			if (element.isDisplayed()){
			reportStep("Element is Displayed with xpath "+xpath, "PASS");
			}else{
				reportStep("Element is not Displayed with xpath " +xpath, "FAIL");
			}
		}
		
		catch (Exception e) {
			//reportStep("Unknown Exception has occured", "FAIL");

		}
	}


	
public void loadendtimecalc(String xpath,String loadmsg) throws InterruptedException {
	int loadtime = 0;
	long servicestart=  System.currentTimeMillis();	
	//for(int k=0;k<=50;k++){
		Thread.sleep(500);
	
	//VerifyElementPresent(xpath);
	verifyElementpresentByXpathExplicitw(xpath);
//	Thread.sleep(10000);		
	
	long serviceend =  System.currentTimeMillis();
			long serviceload = serviceend - servicestart;
			float loadsec=serviceload/1000;
		//	serviceloadtime = Integer.toString((int) loadsec);	
			
		 loadtime=(int)loadsec;
			

//break;



//	}
	

	if(loadtime>10||loadtime==11)
	{
		reportStep(loadmsg+ " more than 10 seconds and actual loading time is "+loadtime , "FAIL");

		
	}
	else {
		reportStep(loadmsg+ " less than 10 seconds  and actual loadtime is " +loadtime, "PASS");

	}

}
	

	
	
	
	
	
	
	public void enterByXpathExplict(String xpathVal, String data) {
		
		try {
			readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		//waitForElement(xpathVal,2);
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			 wait = new WebDriverWait(driver,60);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			element.clear();
			element.sendKeys(data);
			
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");

				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}
	
	public void enterByXpathExplict_noclear(String xpathVal, String data) {
		
		try {
			readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		//waitForElement(xpathVal,2);
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			 wait = new WebDriverWait(driver,60);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
		//	element.clear();
			element.sendKeys(data);
			
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");

				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}
	
	
	public static String GetTodayDate()
	{
		String Fromdate="";		
		
		String D="";
		
		String M="";
		String actualdate="";
	LocalDate currentdate = LocalDate.now();
	int currentDay = currentdate.getDayOfMonth();
	int month =currentdate.getMonthValue();
	String year =Integer.toString(currentdate.getYear()); 
	if(currentDay <=9)
	{
			D ="0"+currentDay;

	}
	else{
		D=Integer.toString(currentDay);

	}



	if(month <=9)
	{
			M ="0"+month;

	}else{
		M=Integer.toString(month);

	}
	actualdate=D+M;
	System.out.println(M+currentDay);
	 return Fromdate =D+M+year;
		
	}

	
	
	////////////////////
		
		
		
		
		

	public static String GetTodayFoematDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String expected = dateFormat.format(date);
		return expected;
	}

	public void fileUploadByXpathExplict(String xpathVal, String data) {
	//	WebDriverWait wait;
		try{
			Thread.sleep(2000);
			
//wait = new WebDriverWait(driver,100);
//WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));

WebElement e=driver.findElement(By.xpath(xpathVal));

		e.sendKeys(data);
		
	
			reportStep("The element with xpath: "+xpathVal+" is entered.", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");

				reportStep("The data: "+xpathVal+" could not be entered in the field.Because No suchelement exception has occured :", "FAIL");

		}
	}
	
	
	
	
	public void uploadfile(String xpathVal, String data) {
		try{
		
			//driver.findElement(By.xpath(xpathVal)).clear();
			WebDriverWait wait = new WebDriverWait(driver,60);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			element.clear();
			element.sendKeys(data);
		//	WebElement element = driver.findElement(By.name("uploadsubmit"));
			//To input the filename along with path
			//		element.sendKeys("D:/file.txt");
			
					
			reportStep("file has been uploaded "+xpathVal +"", "PASS");
		}
		
		
		catch (Exception e) {
		
			
			//	reportStep("The data: "+xpathVal+" could not be entered in the field :"+xpathVal, "FAIL");

reportStep("file has not been uploaded "+xpathVal +"", "FAIL");
		}
	}
	
	
	
	



public void clicklistByxpath(String xpathValue) {
	try {
		List<WebElement> list=driver.findElements(By.xpath(xpathValue));
		Thread.sleep(6000);
		

		list.get(0).click();		
		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
	
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
	}

	catch (TimeoutException e) {
		reportStep("The element with id: "+xpathValue+" could not be clicked.Because Timeout Exception has occured", "FAIL");
	}
		catch (Exception e) {
		
			
	reportStep("The element with id: "+xpathValue+" could not be clicked.", "FAIL");
}
}

public void comparevalues(int a,int b) {
	
		if (a!=b){
			reportStep("size is not equal pass", "PASS");
		}else{
			reportStep("size is  equal failed", "FAIL");
		}
	}

public void comparevaluesGreater(int a,int b,String validmsg,String errormsg) {
	
	if (a<b){
		reportStep(validmsg, "PASS");
	}else{
		reportStep(errormsg, "FAIL");
	}
}




public void comparevaluesEqual(int a,int b,String validmsg,String errormsg) {
	
	if (a==b){
		reportStep(validmsg, "PASS");
	}else{
		reportStep(errormsg, "FAIL");
	}
}

public void verifybyAttributesPreselectxpath(String xpath, String attribute,String comptext,String validmsg,String errorvalidmsg) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	
	try{
		String sText = driver.findElementByXPath(xpath).getAttribute(attribute);
		
		
		if (sText.equalsIgnoreCase(comptext)){
			reportStep(validmsg, "PASS");
		}else{
			reportStep(errorvalidmsg, "FAIL");
		}
	}
	catch (Exception e) {
		reportStep("The "+comptext+" Value does not matched" , "FAIL");
	}
	
	
}







public void verifybyAttributesxpath(String xpath, String text) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try{
		String sText = driver.findElementByXPath(xpath).getAttribute("value");
		if (sText.equalsIgnoreCase(text)){
			reportStep("The attributes value "+sText+" matches with the value :"+text, "PASS");
		}else{
			reportStep("The attributes "+sText+" did not match with the value :"+text, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}


public void booleanResult(Boolean a,String b)
{
	if(a){
		reportStep(b, "WARN");
	}
	
}


public void booleanResultFail(Boolean a,String b)
{
	if(!a){
		reportStep(b, "FAIL");
	}
	
}


public void booleanLogoutNoElementResult(Boolean a,String b)
{
	if(!a){
		LogoutStatus=false;	

		reportStep(b, "WARN");
	}
	
}

public void booleanNoElementPresentResult(Boolean a,String b)
{
	if(!a){

		reportStep(b, "INFO");
	}
	
}


public void loginfoStart(String param1,String param2){
	log.info(param1+" "+param2+ "Scenario has Start Execution");

}
public void loginfoSuccess(String param1,String Param2){
	log.info(param1+ " "+Param2 + " Scenario has Executed Successfuly");

}

public void logfailed(String param1,String param2){
	log.info(param1+" "+param2+ "Scenario has been failed");

}


public void booleanNoElementResult(Boolean a,String b)
{
	if(!a){
		reportStep(b, "WARN");
	}
	
}



public void LogoutbooleanResult(Boolean a,String b)
{
	if(a){
		
		LogoutStatus=false;	

		reportStep(b, "WARN");
	}
	
}

public void verifybyAttributesxpath(String xpath, String text,String attributval) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try{
		String sText = driver.findElementByXPath(xpath).getAttribute(attributval);
		if (sText.equalsIgnoreCase(text)){
			reportStep("The attributes value "+sText+" matches with the value :"+text, "PASS");
		}else{
			reportStep("The attributes "+sText+" did not match with the value :"+text, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public String getAttributesxpath(String xpath, String text) {
	
	String sText = null;
	try{
		sText = driver.findElementByXPath(xpath).getAttribute(text);
		reportStep("The element with xpath: "+xpath+" returned attribute", "PASS");
		
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
	
	return sText;
}



public void AttributesVerifyxpath(String xpath, String value,String valtext) {
	
	String sText = null;
	try{
		sText = driver.findElementByXPath(xpath).getAttribute(value);
		reportStep("The element with xpath: "+xpath+" returned attribute", "PASS");
		
		verifytextmatches(sText, valtext);
		
		
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" returned attribute", "FAIL");
	}
	
}

public String dateMonth(){
	String D="";
	
	String M="";
	String actualdate="";
LocalDate currentdate = LocalDate.now();
int currentDay = currentdate.getDayOfMonth();
int month =currentdate.getMonthValue();

if(currentDay <=9)
{
		D ="0"+currentDay;

}
else{
	D=Integer.toString(currentDay);

}



if(month <=9)
{
		M ="0"+month;

}else{
	M=Integer.toString(month);

}
actualdate=D+M;
System.out.println(M+currentDay);
return actualdate;

	
}



public String dateMonthSlash(){
DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
Date date = new Date();
String expected = dateFormat.format(date);
System.out.println(expected);

return expected;


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


			
	






public  String filespecific_text(int line_no,int value_index ,String filelocation) {
	String strAr[];
	String value = null;	
//	int n =line_no; // The line number
int a;  
  try{
    //String line = Files.readAllLines(Paths.get("C:/Users/Boopathi/Desktop/New folder (8)/RBAU0904.701")).get(n);
    String line = Files.readAllLines(Paths.get(filelocation)).get(line_no);
    System.out.println(line);
	   String strMain =line;
	   String[] arrSplit = strMain.split(",");
	   //23
System.out.println(arrSplit[value_index].toString());
value=arrSplit[value_index].toString();
System.out.println(value);
//modifyFile("C:/Users/Boopathi/Desktop/New folder (8)/ACHDBCR2ACHCR090421.600",date, "12/40/021");

  } 
  catch(IOException e){
    System.out.println(e);
  }
return value;
}



public  String filespecific_cont(int line_no,int value_index ,String filelocation) {
	String strAr[];
	String value = null;	
//	int n =line_no; // The line number
int a;  
  try{
    //String line = Files.readAllLines(Paths.get("C:/Users/Boopathi/Desktop/New folder (8)/RBAU0904.701")).get(n);
    String line = Files.readAllLines(Paths.get(filelocation)).get(line_no);
    System.out.println(line);
	   String strMain =line;
	   String[] arrSplit = strMain.split("\\s+");
	   //23
System.out.println(arrSplit[value_index].toString());
value=arrSplit[value_index].toString();
System.out.println(value);
//modifyFile("C:/Users/Boopathi/Desktop/New folder (8)/ACHDBCR2ACHCR090421.600",date, "12/40/021");

  } 
  catch(IOException e){
    System.out.println(e);
  }
return value;
}









public void modifyFile(String filePath, String oldString, String newString)
{
    File fileToBeModified = new File(filePath);
     
    String oldContent = "";
     
    BufferedReader reader = null;
     
    FileWriter writer = null;
     
    try
    {
        reader = new BufferedReader(new FileReader(fileToBeModified));
         
        //Reading all the lines of input text file into oldContent
         
        String line = reader.readLine();
         
        while (line != null) 
        {
            oldContent = oldContent + line + System.lineSeparator();
             
            line = reader.readLine();
        }
         
        //Replacing oldString with newString in the oldContent
         
        String newContent = oldContent.replaceAll(oldString, newString);
         
        //Rewriting the input text file with newContent
         
        writer = new FileWriter(fileToBeModified);
         
        writer.write(newContent);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    finally
    {
        try
        {
            //Closing the resources
             
            reader.close();
             
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }



}



public void ach_content_check(int linenum, int index,String Renamedfilename_loc,int sub_a,int sub_b,int sub_c,int sub_d,int ran_a,int ran_b){
try{
String value3 =filespecific_cont(linenum,index,Renamedfilename_loc);


String value4=removemiddle_String(value3,sub_a,sub_b,sub_c,sub_d,ran_a,ran_b);

//String value4=removeLastTwoString(value3);
String final_row_1=value4;
//+gettwoRandomNumberString();

modifyFile(Renamedfilename_loc,value3,final_row_1);
}
catch (Exception e) {
	// TODO: handle exception
}

}


public void ach_content_check_lastString(int linenum, int index,String Renamedfilename_loc,int sub_a,int sub_b,int ran_a,int ran_b){
try{
String value3 =filespecific_cont(linenum,index,Renamedfilename_loc);


String value4=removelast_String(value3, sub_a, sub_b, ran_a, ran_b);
//removemiddle_String(value3,sub_a,sub_b,sub_c,sub_d,ran_a,ran_b);

//String value4=removeLastTwoString(value3);
String final_row_1=value4;
//+gettwoRandomNumberString();

modifyFile(Renamedfilename_loc,value3,final_row_1);
}
catch (Exception e) {
	// TODO: handle exception
}

}



public void ach_content_check_lastString_returnval(int linenum, int index,String Renamedfilename_loc,int revval_subc,int revval_subd,int sub_a,int sub_b,int ran_a,int ran_b){
try{
String value3 =filespecific_cont(linenum,index,Renamedfilename_loc);
String value5=value3.substring(revval_subc,revval_subd);

String value4=removelast_String(value5, sub_a, sub_b, ran_a, ran_b);
//removemiddle_String(value3,sub_a,sub_b,sub_c,sub_d,ran_a,ran_b);

//String value4=removeLastTwoString(value3);
String final_row_1=value4;
//+gettwoRandomNumberString();

modifyFile(Renamedfilename_loc,value5,final_row_1);
}
catch (Exception e) {
	// TODO: handle exception
}

}





public void content_check(int linenum, int index,String Renamedfilename_loc){
try{
String value3 =filespecific_cont(linenum,index,Renamedfilename_loc);
String value4=removeLastTwoString(value3);
String final_row_1=value4+gettwoRandomNumberString();

modifyFile(Renamedfilename_loc,value3,final_row_1);
}
catch (Exception e) {
	// TODO: handle exception
}

}


public String removeLastTwoString(String a){
	  String s = "";

	try{
		  s=a.substring(0, a.length() - 2);
      System.out.println(a.substring(0, a.length() - 2)  +"vvvvvvvvvvv");
    
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return s;
      
    
	
	
}

public String removemiddle_String(String value,int sub_a,int sub_b,int sub_c,int sub_d,int ran_a,int ran_b){
	
//	try{
//		  s=a.substring(0, a.length() - 2);
//    System.out.println(a.substring(0, a.length() - 2)  +"vvvvvvvvvvv");
//  
//	}
//	catch (Exception e) {
//		// TODO: handle exception
//	}
//	return s;
    
  
	
	
	String value1 = value;
String ss1 = null;
String ss2=null;
String finalval=null;	
String randomnumber=null;
try{
//		  s=a.substring(0, a.length() - 2);

		  ss1=value1.substring(sub_a,sub_b);
		 ss2=value1.substring(sub_c,sub_d);
		
		System.out.println(ss1);
  System.out.println(ss2);

   randomnumber=gettwoRandomNumber_range_String(ran_a,ran_b);
  System.out.println(randomnumber);
finalval=ss1+randomnumber+ss2;


}
catch (Exception e) {

}
	
	
return finalval;	
}


public String removelast_String(String value,int sub_a,int sub_b,int ran_a,int ran_b){
	
//	try{
//		  s=a.substring(0, a.length() - 2);
//    System.out.println(a.substring(0, a.length() - 2)  +"vvvvvvvvvvv");
//  
//	}
//	catch (Exception e) {
//		// TODO: handle exception
//	}
//	return s;
    
  
	
	
	String value1 = value;
String ss1 = null;
String ss2=null;
String finalval=null;	
String randomnumber=null;
try{
//		  s=a.substring(0, a.length() - 2);

		  ss1=value1.substring(sub_a,sub_b);
		
		System.out.println(ss1);

   randomnumber=gettwoRandomNumber_range_String(ran_a,ran_b);
  System.out.println(randomnumber);
finalval=ss1+randomnumber;


}
catch (Exception e) {

}
	
	
return finalval;	
}


public String removeLastString_index(String a,int b){
	  String s = "";

	try{
		  s=a.substring(0, a.length() - b);
    System.out.println(a.substring(0, a.length() - b)  +"vvvvvvvvvvv");
  
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return s;
    
  
	
	
}
public void verifybyAttributesPresentxpath(String xpath, String attributes ,String compText) throws InterruptedException {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	
	try{
		Thread.sleep(3000);
		String sText = driver.findElementByXPath(xpath).getAttribute(attributes);

		if (sText.equalsIgnoreCase("true")){
			
			reportStep("Attributes has preselected", "PASS");
		}else{
			
			
			reportStep("Attributes has not preselected", "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public void verifyxpathcontainselement(String xpath ,String compText) throws InterruptedException {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try{
		Thread.sleep(3000);
		String sText = xpath;

		
		if (sText.contains(compText)&&driver.findElement(By.xpath(xpath)).isDisplayed()){
			
			reportStep(sText+ "contains the value  "+compText, "PASS");
		}else{
			
			reportStep(sText+ "does not contains the value  "+compText, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}

public void verifybyAttributescontainsxpath(String xpath, String attributes ,String compText) throws InterruptedException {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try{
		Thread.sleep(3000);
		String sText = driver.findElementByXPath(xpath).getAttribute(attributes);
		if (sText.contains(compText)){
			
			reportStep(sText+ "contains the value  "+compText, "PASS");
		}else{
		
			reportStep(sText+ "does not contains the value  "+compText, "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}
}




public void verifybycheckboxpresent(String xpath, String attributes ,String compText,String validmsg,String errormsg) throws InterruptedException {
	try{
		Thread.sleep(3000);
		String sText = driver.findElementByXPath(xpath).getAttribute(attributes);
		if (sText.equalsIgnoreCase(compText)){
			
			reportStep(validmsg+":", "PASS");
		}else{
			
			
			reportStep(errormsg+":", "FAIL");
		}
	}
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	}
	
	catch (TimeoutException e) {
		reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
	}

	catch (Exception e) {
		reportStep("unKnown Exception occur while verify", "FAIL");
	}



}







public void clicklistByxpathExplicitwaitfirst(String xpathValue) {
	try {
		readywithtime(xpathValue);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try {
		
		
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
	
		
	//List <WebElement> myIput=(List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
	
	List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	
	
	myIput.get(0).click();
		
		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
	
	

	
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");


}
}





public void clicklistByxpathExplicitwait(String xpathValue) {
	try {
		readywithtime(xpathValue);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	try {
		WebDriverWait wait= new WebDriverWait(driver, 30);
	List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	//List <WebElement> myIput=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue)));
	myIput.get(0).click();		
reportStep("The element with id: "+xpathValue+" is clicked.", "PASS");

} 
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
}


public void clicklistByxpathNosnap(String xpathValue) {
	try {
		List<WebElement> list=driver.findElements(By.xpath(xpathValue));
		Thread.sleep(4000);

		list.get(0).click();	

reportStep("The element with id: "+xpathValue+" is clicked.", "PASS",false);

} 
	
	catch (NoSuchElementException e) {
		reportStep("The element with xpath: "+xpathValue+" could not be clicked.Because NO Such Element Exception has occured", "FAIL",false);
	}

	catch (TimeoutException e) {
		reportStep("The element with id: "+xpathValue+" could not be clicked.Because Timeout Exception has occured", "FAIL",false);
	}
		catch (Exception e) {
	reportStep("The element with id: "+xpathValue+" could not be clicked.", "FAIL",false);
}
}


public void VerifyElementPresent(String xpath) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isDisplayed())
	{
		reportStep("The element with xpath: "+xpath+" is present.", "PASS");

	}
	
	else {
		reportStep("The element with id: "+xpath+" is not present .", "PASS");

	}
	
	
}
	
public void VerifyElementEnable(String xpath) {
	
	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isEnabled())
	{

	}
	
	else {

	}
	
	
}
	





	
	















public void VerifyElementPresent(String xpath,String validmsg,String ErrorvalidMsg) {
	//waitForElement(xpath,2);
	
	
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}
	
	try{
		Boolean a=VerifyElementpresentreturn(xpath);
	if(a){
		reportStep(validmsg,"PASS");
	}
	else
	{
		reportStep(ErrorvalidMsg,"FAIL");

	}
	
	}

	
	catch (Exception e) {
		reportStep("Element "+xpath+"not found exception has occured ", "FAIL");
	}
	
	
	
}





public void VerifyElementnotPresent(String xpath,String validmsg,String ErrorvalidMsg) {
	try {
		readywithtime(xpath);
		readystate();
		jqueryload();
	} catch (InterruptedException e1) {
	}	
	try {
	WebElement e  =driver.findElement(By.xpath(xpath));
	
	
	if(e.isDisplayed())
	{
		
		reportStep( "Element is present:" +ErrorvalidMsg, "FAIL");

	}
	
	else {
				reportStep("Element is not present" +validmsg , "PASS");

	}
	
	
	}
	catch ( TimeoutException  e) {
		reportStep("Timeout Exception has occured", "FAIL");

		// TODO: handle exception
	}
	catch ( NoSuchElementException  e) {
		reportStep(   "Element not fount" +ErrorvalidMsg , "PASS");

		// TODO: handle exception
	}
	catch ( ElementNotVisibleException  e) {
		reportStep("Element not fount" +ErrorvalidMsg , "PASS");

		// TODO: handle exception
	}
	
	
	catch (Exception e) {
		reportStep("Unknown exception occured ", "FAIL");
	}

}

/*
public void VerifyElementnotPresent(String xpath,String validmsg,String ErrorvalidMsg) {

	try{
		
WebElement e=driver.findElement(By.xpath(xpath));
	
	if(e.isDisplayed())
	{
		
		reportStep( "Element is present:" +ErrorvalidMsg, "FAIL");

	}
	
	else {
				reportStep("Element is not present" +validmsg , "PASS");

	}
	
	
	}
	
	catch (Exception e) {
		reportStep("Element has not found" +validmsg , "PASS");
	}
	
	
	
}
*/



public void VerifyElementenabledORdisabled(String xpath,String msg1,String status1,String Msg2,String Status2) {
	
	try {
		
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		
	if(e.isEnabled())
	{
		
		reportStep( msg1+ " Element is ENABLED" , status1);

	}
	
	else if(!e.isEnabled()) {
				reportStep(Msg2+ " Element is disabled"  , Status2);

	}
	
	
	}
	catch ( TimeoutException  e) {
		reportStep("Timeout Exception has occured", "FAIL");

		// TODO: handle exception
	}
	catch ( NoSuchElementException  e) {
		reportStep(   "Element not fount"  , "FAIL");

		// TODO: handle exception
	}
	catch ( ElementNotVisibleException  e) {
		reportStep("Element not fount"  , "FAIL");

		// TODO: handle exception
	}
	
	
	catch (Exception e) {
		reportStep("Unknown exception occured ", "FAIL");
	}
	
	
	
}

















	

	public void enterById(String idValue, String data) {
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
		}
	}
	public void enterByIdfileupload(String idValue, String data) {
		try {
			//driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+idValue, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+idValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+idValue, "FAIL");
		}
	}
	
	@Override
	public void enterByName(String nameValue, String data) {
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+nameValue, "PASS");

		}
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+nameValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+nameValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		 catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+nameValue, "FAIL");
		}

	}

	
	@Override
	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);	
			reportStep("The data: "+data+" entered successfully in field :"+xpathValue, "PASS");

		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathValue+" could not be entered.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathValue+" could not be entered.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+xpathValue, "FAIL");
		}

	}

	
	@Override
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		String currentUrl = null;
		String url= null;
		try{
			Thread.sleep(4000);
			
			if (driver.getTitle().equalsIgnoreCase(title)){
				
				
				currentUrl=driver.getCurrentUrl();
			 url="  "+currentUrl;
				reportStep("The title of the page matches with the value :"+title+url , "PASS");
				bReturn = true;
			}else
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title+ url, "SUCCESS");

		}
		
		catch (TimeoutException e) {
			reportStep(" while verifying the title Timeout Exception has occured"+title+ url, "FAIL");
		}
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title"+title+ url, "FAIL");
		}
		return bReturn;
	}

	@Override
	public void verifyTextByXpath(String xpath, String text){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try {
			
			
			
			String sText = driver.findElement(By.xpath(xpath)).getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	

	

	
	
	public void verifyTextByXpathExplicitwait(String xpath, String text){
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			String sText = element.getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}
		catch (Exception e) {
			reportStep("The :"+text+" could not be Matched.", "FAIL");
		}
	}
	
	
	public void verifyTextByXpathOR(String xpath1,String xpath2, String xpath1text,String xpath2text){
		String verifytextone = null;
		String verifytexttwo = null;
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
			
			
			WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath2)));
		
			
			verifytextone=element.getText();
			verifytexttwo=element1.getText();
			
			 if(element.isDisplayed()&&verifytextone.contains(xpath1text)){
				 
				 reportStep("The text: "+element.getText()+" matches with the value :"+xpath1text, "PASS");
			 }
			 else if (element1.isDisplayed()&&verifytexttwo.contains(xpath2text)) {
				 reportStep("The text: "+element1.getText()+" matches with the value :"+xpath2text, "PASS");				
			}
			
		}
			 catch (Exception e) {
			reportStep("The : "+verifytextone+ "or "+verifytexttwo+ "text does not matched"  , "FAIL");
		}
	}
	
	
	
	
	
	
	
	public void verifyTextContainsByXpathexplictwait(String xpath, String text){
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String sText = element.getText();
			
						if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	public void verifyTextnumberContainsByXpathexplictwait(String xpath, String text){
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			String sText = element.getText();

			String veritext=sText.replaceAll("[^0-9]", "");
						if (veritext.contains(text)){
				reportStep("The text: "+veritext+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+veritext+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	public void verifyTextContainsByXpathexplictwaitint(String xpath, String text){
		try{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			String sText = element.getText();
			String comptext=sText.replaceAll("[^0-9]", "");

						if (comptext.contains(text)){
							
				reportStep("The text: "+comptext+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+comptext+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("unknown exception has occured", "FAIL");
		}
	}
	
	
	

	public String ReturnXpathtext(String xpath){
		
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		
		String sText = null;
		try{
		sText = driver.findElementByXPath(xpath).getText();
//		reportStep(sText, "PASS");

		
		reportStep("text has returned from element", "PASS");

		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
		return sText;
	
	}
	
	
	public void ReferenceNo(String Refno,String Msg){
		
		try{
		reportStep( Msg+""+Refno, "PASS");

		}
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	public void verifyTextContainsByXpath(String xpath, String text){
		try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		//waitForElement(xpath,2);
		WebDriverWait wait;
		try{
			Thread.sleep(2000);
			
wait = new WebDriverWait(driver,60);
WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

			String sText = element.getText();
			
			
			
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
	}
	
	
	public void verifyTextContainsByXpavalidMsg(String xpath, String text,String validmsg,String Errorvalidmsg){
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				reportStep(validmsg, "PASS");
			}else{
				reportStep(Errorvalidmsg, "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verify", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void verifyUserdashboardPageLanding_TextContainsByXpath(String xpath, String text){
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text+" status in user dashboard page and its landed on userdashboard page", "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text+" status in user dashboard page has opened and its not landed on userboard page", "FAIL");
			}
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}
	
	
	
	
	
    
    public void ScrollclickByXpath(String xpath) {
    	try {
			readywithtime(xpath);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		try{
			JavascriptExecutor JE = driver;  
		    WebElement scroll= driver.findElement(By.xpath(xpath));
		    JE.executeScript("arguments[0].scrollIntoView(true);",scroll);    
		    scroll.click();
		    reportStep("The Page has scrolled element with id: "+xpath+" is clicked.", "PASS");

		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("The element with id: "+xpath+" could not be clicked.", "FAIL");
		}
	}

    
    
    
    
	
	//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(xpathVal)));
			
			
			
			public void verifyUserdashboardPageLanding_TextContainsByXpathExplictiwait(String xpath, String text){
				try{
					
					
					WebDriverWait wait = new WebDriverWait(driver,30);
					
					WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
					
					
					
					String sText = element.getText();
					if (sText.contains(text)){
						reportStep("The text: "+sText+" contains the value :"+text+" status in user dashboard page and its landed on userdashboard page", "PASS");
					}else{
						reportStep("The text: "+sText+" did not contain the value :"+text+" status in user dashboard page has opened and its not landed on userboard page", "FAIL");
					}
				}
				
				catch (Exception e) {
					reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
				}
			}
			
			
			public void verifyUserdashboardPageLanding_TextContainsORoperatorByXpathExplictiwait(String xpath, String text){
				try{
					
					
					WebDriverWait wait = new WebDriverWait(driver,30);
					
					WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
					
					
					
					String sText = element.getText();
					if (sText.contains(text)){
						reportStep("The text: "+sText+" contains the value :"+text+" status in user dashboard page and its landed on userdashboard page", "PASS");
					}else{
						reportStep("The text: "+sText+" did not contain the value :"+text+" status in user dashboard page has opened and its not landed on userboard page", "FAIL");
					}
				}
				
				catch (Exception e) {
					reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
				}
			}
			
			
			
			
			
			
	
	
	public void verifySecondaryLCFopencontainsByXpath(String xpath, String text){
		try{
			
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			
			
			String sText = element.getText();
			
			
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value & Secondary LCF has opened:"+text, "PASS");
			}else{
				reportStep("Fail: "+sText+" Did not contain the value & Secondary LCF has not opened:"+text, "FAIL");
			}
		}
		
		//catch (NoSuchElementException e) {
		//	reportStep("The element with xpath: "+xpath+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
	//	}
		
		//catch (TimeoutException e) {
		//	reportStep("The element with xpath: "+xpath+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		//}
		
		
		catch (Exception e) {
			reportStep("The "+text+" could not be Matched.", "FAIL");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void verifyTextById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)){
				reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	
	public void verifyTextContainsById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)){
				reportStep("The text: "+sText+" contains the value :"+text, "PASS");
			}else{
				reportStep("The text: "+sText+" did not contain the value :"+text, "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be Matched.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	
	
	
	
	
	
	
	
	public void verifyTextRadioBoxType(String id, String text) {
		try{
			

			Thread.sleep(4000);
			
			if (id.contains(text)){
				reportStep("The text: "+text+" contains the value with this :"+id+ " So it allows only single locality", "PASS");
			}else{
				reportStep("The text: "+text+" did not contain the value with this:"+id+" So it allows Multiple locality", "FAIL");
			}
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not  contain " +text+ ".Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not   contain "+text+".Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}
	
	
	
	

	public void closeAllBrowsers() {
		try {
		driver.quit();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "FAIL");
		}

	}
	
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			reportStep("The browser could not be closed.", "FAIL");
		}
	}


	@Override
	public void clickById(String id) {
		try{
			driver.findElement(By.id(id)).click();
			reportStep("The element with id: "+id+" is clicked.", "PASS");

		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
	}

	
	@Override
	public void clickByClassName(String classVal) {
		try{
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with class Name: "+classVal+" is clicked.", "PASS");
		}
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+classVal+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+classVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("The element with class Name: "+classVal+" could not be clicked.", "FAIL");
		}
	}

	
	@Override
	public void clickByName(String name) {
		try{
			driver.findElement(By.name(name)).click();
			reportStep("The element with name: "+name+" is clicked.", "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
	}

	
	@Override
	public void clickByLink(String name) {
		try{
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: "+name+" is clicked.", "PASS");
		} 
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		catch (Exception e) {
			reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}
	}

	
	
	
	
	
	
	
	
	
		

	public void clickByXpath(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		} 
		
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}
	
	
	
	
	public void clickByXpathcontactFind(String xpathVal) {
	
			driver.findElement(By.xpath(xpathVal)).click();
			//reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		
	}
	public void clickXpathFind(String xpathVal) {
		
		driver.findElement(By.xpath(xpathVal)).click();
		
		
		
		//reportStep("The element : "+xpathVal+" is clicked.", "PASS");
	
}
	
	
	public void closeSecondaryLCFclickByXpathExplcitwait(String xpathVal) {
		try{
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
               element.click();	
			reportStep("The element : "+xpathVal+" is clicked.and secondary LCF has closed", "PASS");
		} 
		
		
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked Because No such Element Exception has occured.and secondary LCF has closed", "FAIL");
		}
	}
	
	
	
	
	

	@Override
	public void clickByLinkNoSnap(String name) {
		try{
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: "+name+" is clicked.", "PASS",false);
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+name+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}

	}

	@Override
	public void clickByXpathNoSnap(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS",false);
		
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}		
	}

	
	public void mouseOverByXpath(String xpathVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
	}

	public void mouseOverByLinkText(String linkName) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");
		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+linkName+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+linkName+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		catch (Exception e) {
			reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
	}

public void dropdownSelection(String xpath1,String xpath2) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(2000);
	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')]");

}



public void dropdowncitySelection(String xpath1,String xpath2) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(6000);
	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')]");

}


public List<WebElement> elementListReturn(String xpath1) throws InterruptedException{ 
	List<WebElement>ele = null;
	try{
	ele=driver.findElements(By.xpath(xpath1));
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	return ele;
}





public void dropdownSelectionAutoComplete(String xpath1,String xpath2,String xpath3) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(6000);
enterByXpathExplict(xpath2, xpath3);
Thread.sleep(1000);

	clickByXpathExplict(".//li[contains(@class,'active-result')][contains(text(),'"+xpath3+"')]");
	
}

public void dropdownSelectionindex(String xpath1,String xpath2,int i) throws InterruptedException{ 
	clickByXpathExplict(xpath1);
Thread.sleep(2000);

//(.//li[contains(@class,'active-result')][contains(text(),'SASABB242003333')])
//	clickByXpathExplict("(.//li[contains(@class,'active-result')][contains(text(),'SASABB242003333')])[10]");

	clickByXpathExplict("(.//li[contains(@class,'active-result')][contains(text(),'"+xpath2+"')])["+i+"]");


}
		





	public String getTextByXpath(String xpathVal){
		try {
			readywithtime(xpathVal);
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		}
		
		
		catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	
	public void comparevalues(String startbalance,String endbalance,String valmsg,String invalidmsg){
		
		
		
		try{

			//Converting String into int using Integer.parseInt()  
			int initialamount=Integer.parseInt(startbalance);  
			int endamount=Integer.parseInt(endbalance);  
			if(initialamount!=endamount){
				reportStep(valmsg , "PASS");
			}
			else {
				reportStep(invalidmsg , "FAIL");
			}
			
		}
		
		
		
		catch (Exception e) {
			reportStep(invalidmsg, "FAIL");
		}
		 
	}

	
	
	
	
	public int getSizeByXpath(String xpathVal){
		int elesize = 0 ;
		try{
		List<WebElement>ele=driver.findElements(By.xpath(xpathVal));
		elesize=ele.size();
		
		reportStep("element size is "+elesize+"", "PASS");

		}
		
		
		
		catch (Exception e) {
			reportStep("unable to get size", "FAIL");
		}
		return elesize; 
	}
	

	public String getTextById(String idVal) {
		String bReturn = "";
		try{
			return driver.findElementById(idVal).getText();
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+idVal+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+idVal+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		catch (Exception e) {
			reportStep("The element with id: "+idVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void selectVisibileTextById(String id, String value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
			reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");
		} catch (Exception e) {
			reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
	}


	public void selectVisibileTextByXPath(String xpath, String value) {
		try{
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);;
			reportStep("The element with xpath: "+xpath+" is selected with value :"+value, "PASS");
		} 
		
		
		
		catch (Exception e) {
		reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
	}
	public void selectValueByxpath(String element, String value) {
		try{
			
			
			//new Select(driver.findElement(By.xpath(element))).selectByIndex(value);
			
			Select se = new Select(driver.findElement(By.xpath(element)));
			 
			// Select the option with value "6"
			se.selectByValue(value);
			reportStep("The element with id: "+element+" is selected with index :"+value, "PASS");
		} 
		
		
		catch (Exception e) {
			reportStep("The index: "+value+" could not be selected.", "FAIL");
		}
	}
	
	
	
	public void selectIndexByxpath(String element, int value) {
		try{
			new Select(driver.findElement(By.xpath(element))).selectByIndex(value);
			reportStep("The element with id: "+element+" is selected with index :"+value, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+element+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+element+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		
		catch (Exception e) {
			reportStep("The index: "+value+" could not be selected.", "FAIL");
		}
	}

	

	public void selectIndexById(String id, int value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByIndex(value);
			reportStep("The element with id: "+id+" is selected with index :"+value, "PASS");
		} 
		
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+id+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+id+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
		
		
		
		catch (Exception e) {
			reportStep("The index: "+value+" could not be selected.", "FAIL");
		}
	}

	

	public void switchToParentWindow() {
		try {
						driver.switchTo().window(primaryWindowHandle);
			
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}
	
	public void switchWindow(String a) {
		try {
						driver.switchTo().window(a);
			
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}
	public void windowclose() {
		try{
	
driver.close();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void windowhandlesindex(int j) {
		try{
	
	
	
	
	Set<String> childwindow=driver.getWindowHandles();
	childwindow=driver.getWindowHandles();
    String[] individualHandle = new String[childwindow.size()];
    Iterator<String> it = childwindow.iterator();
    int i =0;
    while(it.hasNext())
    {
        individualHandle[i] = (String) it.next();
        i++;
    }

driver.switchTo().window(individualHandle[j]);
	
	

reportStep("New window has opened", "PASS");

	
		}
		catch (Exception e) {
			reportStep("New window has not opened", "FAIL");
		}
	}

	
	
	
	
	public void getParentWindow() {
		try {
						
		 parentwindow=driver.getWindowHandle();
			
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
			
			
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}
	
	
	public void switchToWindowIndex(int index) {
	    Set<String> windows = driver.getWindowHandles();
	    int totalWin = windows.size();
	    String winTitle = null;
	    for (int i =0; i<= totalWin; i++) {
	        if (i == index) {
	            winTitle = windows.toArray()[i].toString();
	            return;
	        }
	        System.out.println(windows.toArray()[i].toString());

	    }
	    driver.switchTo().window(winTitle);
	    reportStep("Switched to " + driver.getTitle(),"Pass");
	}
	
	public void switchTocurrentWindow() {
		try {
			
			String  currentwindow = driver.getWindowHandle();
			
			driver.switchTo().window(currentwindow);
			
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}
	
	
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			
			reportStep("The alert has been accepted.", "PASS",false);

		}  catch (Exception e) {
		//	reportStep("The alert could not be accepted.", "FAIL",false);
		}


	}

	
	public void PressEnterkey() {
		try {
			Thread.sleep(4000);
			Robot robot =new Robot();
			System.out.println("enter");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.delay(200);
			reportStep("The alert has been accepted.", "PASS",false);

		}  catch (Exception e) {
		//	reportStep("The alert could not be accepted.", "FAIL",false);
		}

	}
	
	
	@Override
	public String getAlertText() {		
		String text = null;
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}
		return text;

	}


	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	
	
	@Override
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			reportStep("Screenshot not Support", "INFO");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "FAIL");
		}
		return number;
	}

	public void firstwindow(String primarywindow){
		try{
			driver.switchTo().window(primarywindow);

		}


		catch (NoSuchElementException e) {
			reportStep(" NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep(" TimeOut Exception has occured", "FAIL");
		}
		

		catch(WebDriverException e){
			reportStep("The window could not be switched to the first window.", "FAIL");
		}


	}


	public void lastwindowhandle(){
		try{



			Set<String> lastWindow = driver.getWindowHandles();
			for (String allWindow : lastWindow) {
				driver.switchTo().window(allWindow);
			}

		}
		
		
		catch (NoSuchElementException e) {
			reportStep(" NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep(" TimeOut Exception has occured", "FAIL");
		}
		
	
 catch (Exception e) {
		reportStep("The window could not be switched to the last window.", "FAIL");
	}
	
	}

	

	
	
	public void closeOverLCFwindow(String xpath){
		try{

			driver.findElement(By.xpath(xpath)).click();
			reportStep("The window could not be switched to the last window.", "PASS");

		}
		catch (NoSuchElementException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because NO Such Element Exception has occured", "FAIL");
			
		}
		
		catch (TimeoutException e) {
			reportStep("The element with xpath: "+xpath+" could not be found.Because TimeOut Exception has occured", "FAIL");
		}
		
	
 catch (Exception e) {
		reportStep("The window could not be switched to the last window.", "FAIL");
	}
	
	}
	
	 public static String GetFutudate(int d)
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
	public void zip() throws Exception{

			
			  String sourceFolderName ="D:\\AutomationWorkspace\\SAABCIB\\reports";
			  
			  String b="reports"+GetFutudate(0);
		      String outputFileName ="D:\\AutomationWorkspace\\SAABCIB\\"+b+".zip";

		      FileOutputStream fos = new FileOutputStream(outputFileName);
		      ZipOutputStream zos = new ZipOutputStream(fos);
		      //level - the compression level (0-9)
		      zos.setLevel(9);

		      addFolder(zos, sourceFolderName, sourceFolderName);

		      zos.close();
		  }

	
	public void selectedElementClick(String xpath,String xpathone,String text) throws Exception{

	
List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(text)){
		
	int j=i+1;
			clickByXpathExplict("("+xpathone+")["+j+"]");
			Thread.sleep(10000);

		}}


	}
	public static void addFolder(ZipOutputStream zos,String folderName,String baseFolderName)throws Exception{
    File f = new File(folderName);
    if(f.exists()){

        if(f.isDirectory()){
            //Thank to peter 
            //For pointing out missing entry for empty folder
            if(!folderName.equalsIgnoreCase(baseFolderName)){
                String entryName = folderName.substring(baseFolderName.length()+1,folderName.length()) + File.separatorChar;
                ZipEntry ze= new ZipEntry(entryName);
                zos.putNextEntry(ze);    
            }
            File f2[] = f.listFiles();
            for(int i=0;i<f2.length;i++){
                addFolder(zos,f2[i].getAbsolutePath(),baseFolderName);    
            }
        }else{
            //add file
            //extract the relative name for entry purpose
            String entryName = folderName.substring(baseFolderName.length()+1,folderName.length());
            ZipEntry ze= new ZipEntry(entryName);
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(folderName);
            int len;
            byte buffer[] = new byte[1024];
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
            zos.closeEntry();

        }
    }else{
    }

    
    
    
}


public void clickBuzzwps(String xpath,String auth1,String auth2) throws InterruptedException{
	try{
List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 60);
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
Thread.sleep(2000);
for (WebElement webElement : element) {
String cate=webElement.getText();
a1.add(cate);
}	
for(int i=0;i<element.size();i++){
String refnumber=element.get(i).getText();
	if(refnumber.contains(getrefnumer)){
int j=i+1;
		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
		Thread.sleep(10000);

	}}


clickByXpathExplict(prop.getProperty("click.view.buxxhistory.xpath"));
pageScroll1400(prop.getProperty("click.view.buxxpage.xpath"));
if(VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth1+"']//a")){	
	AuthUsername=auth1;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth1+"']//a");
}else if (VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth2+"']//a")) {

	AuthUsername=auth2;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth2+"']//a");
}else{
	reportStep("Buzz value has not matched", "FAIL");
}
defaultcontent();
}
catch (Exception e) {
}
}



	public void FilterVerification(String FilterType,String FilterStatus,String refrenceNum,String ReferenceNumStatus) throws InterruptedException{
		//Thread.sleep(8000);
		readystate();
		jqueryload();
		clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
		Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("Click.RequestType.Xpath"));
		clickByXpathExplict(FilterType);
		clickByXpathExplict(prop.getProperty("Click.RequestStatus.Xpath"));
		clickByXpathExplict(FilterStatus);
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
		//List<String>refno=new ArrayList<>();
		Thread.sleep(4000);
		//Thread.sleep(2000);

//		readywithtime(xpath);
		readystate();
		jqueryload();
		//pageScroll400();
		verifyTextlistcontainXpath(prop.getProperty("Filter.DepositReferno.xpath"),refrenceNum);


		if(ReferenceNumStatus.equalsIgnoreCase("Accepted")){
//		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
		
//		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
			
			
		int a=getSizeByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"));
			
		 verifyTextsizecontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),a);
		
		}
		}



	public void FilterSelectVerification(String RequestType,String RequestTypeValue,String RequestStatusType,String RequestStatusValue, String refrenceNum,String ReferenceNumStatus) throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
		
		dropdownSelection(prop.getProperty(RequestType),RequestTypeValue);
		
		//selectVisibileTextByXPath(prop.getProperty(RequestType),RequestTypeValue);
		
		dropdownSelection(prop.getProperty(RequestStatusType),RequestStatusValue);
		
//		selectVisibileTextByXPath(prop.getProperty(RequestStatusType),RequestStatusValue);
		//Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
		
		//Thread.sleep(20000);
		Thread.sleep(4000);		
		//pageScroll400();
		verifyTextlistcontainXpath(prop.getProperty("Filter.DepositReferno.xpath"),refrenceNum);
		if(ReferenceNumStatus.equalsIgnoreCase("Accepted")){
//		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
//		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);

			int a=getSizeByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"));
			verifyTextsizecontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),a);
		
		}
		}	
	
	
	public void FilterSelect(String RequestType,String RequestTypeValue,String RequestStatusType,String RequestStatusValue, String refrenceNum,String ReferenceNumStatus) throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
		
		dropdownSelection(prop.getProperty(RequestType),RequestTypeValue);
		
		//selectVisibileTextByXPath(prop.getProperty(RequestType),RequestTypeValue);
		
		dropdownSelection(prop.getProperty(RequestStatusType),RequestStatusValue);
		
//		selectVisibileTextByXPath(prop.getProperty(RequestStatusType),RequestStatusValue);
		//Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
		Thread.sleep(4000);		
		//pageScroll400();
//		verifyTextlistcontainXpath(prop.getProperty("Filter.DepositReferno.xpath"),refrenceNum);
//		if(ReferenceNumStatus.equalsIgnoreCase("Accepted")){
////		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
////		verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
//
//			int a=getSizeByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"));
//			verifyTextsizecontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),a);
		
//		}
			
		
		}	

public void clickBuzz(String auth1,String auth2) throws InterruptedException{
	try{
List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 60);
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
Thread.sleep(2000);
for (WebElement webElement : element) {
String cate=webElement.getText();
a1.add(cate);
}	
for(int i=0;i<element.size();i++){
String refnumber=element.get(i).getText();
	if(refnumber.contains(getrefnumer)){
int j=i+1;
		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
		Thread.sleep(10000);

	}}


clickByXpathExplict(prop.getProperty("click.view.buxxhistory.xpath"));
pageScroll1400(prop.getProperty("click.view.buxxpage.xpath"));
if(VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth1+"']//a")){	
	AuthUsername=auth1;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth1+"']//a");
}else if (VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth2+"']//a")) {

	AuthUsername=auth2;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth2+"']//a");
}else{
	reportStep("Buzz value has not matched", "FAIL");
}
defaultcontent();
}
catch (Exception e) {
}
}



public void authorizeRequest() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 80);
	Thread.sleep(4000);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(3000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(2000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(2000);
//			scrolltoelementJs(".//div[@id='autorization']//a[text()='Authorize']");	
			//Thread.sleep(4000);
scrolltoelementJs(".//div[@id='autorization']//a[text()='Authorize']");
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(2000);
pageScroll();
	enterByXpathExplict(".//textarea[@id='comment']", "testing");
		
	enterByXpathExplict(".//input[@id='authpwd']", "auth@2020");


			//enterByXpathExplict(".//input[@id='txtOTP']", "777777");
			enterByXpathExplict(".//input[@id='authpwd']", "auth@2020");
//	Thread.sleep(7000);


		
		
	clickByXpathExplict(".//button[text()='Confirm']");

	Thread.sleep(2000);



	break;
	}
		
	}
}		


public void authorizeRequest(String otp) throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 80);
	Thread.sleep(4000);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(3000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(2000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(2000);
//			scrolltoelementJs(".//div[@id='autorization']//a[text()='Authorize']");	
			//Thread.sleep(4000);
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(2000);
pageScroll();
			enterByXpathExplict(".//textarea[@id='comment']", "testing");
		//	Thread.sleep(4000);

			enterByXpathExplict(".//input[@id='authpwd']",otp);
//	Thread.sleep(7000);

	clickByXpathExplict(".//button[text()='Confirm']");
	Thread.sleep(2000);


	break;
	}
		
	}
}		

public void authorizeRequest_fundTrans() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 80);
	Thread.sleep(4000);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(3000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(4000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
		//	Thread.sleep(20000);
//			scrolltoelementJs(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(4000);
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
		//	Thread.sleep(2000);
pageScroll();
			enterByXpathExplict(".//textarea[@id='comment']", "testing");
		//	Thread.sleep(4000);
			
			

			enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	Thread.sleep(3000);

			
			
			Boolean a=driver.getPageSource().contains("Transaction Window");
			
			if(a){
	//		clickByXpathExplict(prop.getProperty("ClicklocalTransfer.apporve.xpath"));
			
				clickJs(prop.getProperty("ClicklocalTransfer.apporve.xpath"));
			}
			
			
			
	clickByXpathExplict(".//button[@id='btn2FAValidate']");
	Thread.sleep(4000);


	break;
	}
		
	}
}		

public void authorizeRequestLocalTransfer() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 80);
	Thread.sleep(4000);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(3000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(6000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(10000);
			
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(2000);
pageScroll();
			enterByXpathExplict(".//textarea[@id='comment']", "just testing");
		//	Thread.sleep(4000);

			enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	Thread.sleep(2000);
	
	Boolean a=VerifyElementpresentreturn(prop.getProperty("ClicklocalTransfer.apporve.xpath"));
//	booleanResult(a, "Transaction cut off time has been elapsed for the day");

	if(a){
	clickByXpath(prop.getProperty("ClicklocalTransfer.apporve.xpath"));
	Thread.sleep(3000);
	}
	clickByXpathExplict(".//button[@id='btn2FAValidate']");
	Thread.sleep(15000);


	break;
	}
		
	}
}		


public void authorizefromDatelineRequest() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){
		Thread.sleep(4000);		
		String refnumber=element.get(i).getText();
			if(refnumber.contains(getrefnumer)){
			
		int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
				Thread.sleep(8000);
				enterByXpathExplict(".//textarea[@id='comment']", "testing");
		enterByXpathExplict(".//input[@id='authpwd']", "auth@2020");
		clickByXpathExplict(".//button[text()='Confirm']");				
	Thread.sleep(12000);
		
		break;
		}
			
	}
}		








/*
 
	for(int i=0;i<element.size();i++){
		Thread.sleep(4000);		
		String refnumber=element.get(i).getText();
			if(refnumber.contains(getrefnumer)){
			
		int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
		enterByXpathExplict(".//textarea[@id='comment']", "just testing");
		enterByXpathExplict(".//input[@id='txtOTP']", "777777");
		clickByXpathExplict(".//button[@id='btn2FAValidate']");				
	break;
		}
	
 */

public void authorizefromDatelineRequest_admin() throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){
		Thread.sleep(4000);		
		String refnumber=element.get(i).getText();
			if(refnumber.contains(getrefnumer)){
			
		int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
				Thread.sleep(8000);
				enterByXpathExplict(".//textarea[@id='comment']", "testing");
//		enterByXpathExplict(".//input[@id='txtOTP']", "777777");
		clickByXpathExplict(".//button[@id='confirm']");				
	Thread.sleep(12000);
		
		break;
		}
			
	}
}		





public void authorizeWPS(String xpath) throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){
		Thread.sleep(4000);		
		String refnumber=element.get(i).getText();
			if(refnumber.contains(getrefnumer)){
			
		int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
		enterByXpathExplict(".//textarea[@id='comment']", "testing");
		enterByXpathExplict(".//input[@id='authpwd']", "auth@2020");
		clickByXpathExplict(".//button[text()='Confirm']");	
	break;
		}
			
	}
}		
public void authorizeWPSFILTER(String Xpath) throws InterruptedException{
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Xpath)));
	Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(8000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(20000);
			
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(15000);

			enterByXpathExplict(".//textarea[@id='comment']", "just testing");
	enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	clickByXpathExplict(".//button[@id='btn2FAValidate']");
	Thread.sleep(15000);


	break;
	}
		
	}
}		




public void getSimulatorUrl(){
	try{

		geturl(Simulator+SimulatorFileName);
		//		geturl("https://sabbcorpdev.sabb.com/Corporate/");
		reportStep(sUrl, "PASS");

	}
catch (Exception e) {

	reportStep("Url has not working", "FAIL");

}
}



public void getnewurl(){
	try{
		geturl(sUrl);
		reportStep(sUrl, "PASS");

	}
catch (Exception e) {

	reportStep("Url has not working", "FAIL");

}
}


public void AdminDatelinePageBuzz(String auth1,String auth2,String Datelinekeyword) throws InterruptedException{
	try{
List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 60);
//List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])")));
Thread.sleep(2000);
for (WebElement webElement : element) {
String cate=webElement.getText();
a1.add(cate);
}	
for(int i=0;i<element.size();i++){
String refnumber=element.get(i).getText();
	if(refnumber.contains(Datelinekeyword)){
		//Corporate User Profile Creation Request
int j=i+1;
getrefnumer=ReturnXpathtext("(.//div[contains(@class,'text-right')]//span[contains(@class,'text-info')])["+j+"]");
/*		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");*/


Thread.sleep(10000);
break;
	}

}

/*
clickByXpathExplict(prop.getProperty("click.view.buxxhistory.xpath"));
pageScroll1400(prop.getProperty("click.view.buxxpage.xpath"));

if(VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth1+"']//a")){	
	AuthUsername=auth1;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth1+"']//a");
}else if (VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+auth2+"']//a")) {

	AuthUsername=auth2;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+auth2+"']//a");
}else{
	reportStep("Buzz value has not matched", "FAIL");
}

*/
defaultcontent();

	}
catch (Exception e) {
	reportStep(""+e+"", "FAIL");
}
}








public void CorporateAdminAuthorizeRequest() throws InterruptedException{
try{
	
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 60);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
	Thread.sleep(15000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();
	a1.add(cate);
	}	

	for(int i=0;i<element.size();i++){

	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
	Thread.sleep(8000);
	clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
			Thread.sleep(20000);
			
			clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
			Thread.sleep(15000);

			enterByXpathExplict(".//textarea[@id='comment']", "just testing");
//	enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	clickByXpathExplict(".//button[@id='confirm']");
	Thread.sleep(30000);


	break;
	}
		
	}
}
catch (Exception e) {

	reportStep("Unable to find Reference  number", "FAIL");
}



}		
}




//public WebElement fluentwaitsClick(By locator)
//{
//  Wait wait = new FluentWait(driver)
//      .withTimeout(60, TimeUnit.MILLISECONDS)
//      .pollingEvery(4, TimeUnit.MILLISECONDS)
//      .ignoring(NoSuchElementException.class);
//  WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() 
//  {
//
//    public WebElement apply(WebDriver driver)
//    {
//      return driver.findElement(locator);
//    }
//  });

	