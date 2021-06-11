package wrappers;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LogoutPages;
import utils.DataInputProvider;
import utils.Dataproviders;

public class ProjectWrapp extends GenericWrappers{
//browerstack
	public static final String USERNAME ="vayanaautomation1";
	 public static final String AUTOMATE_KEY ="WGKy1waWi18dcYnPD8eC";
	
	public static final String URL =  "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	
	public String browserName;
	public String dataSheetName;

	@BeforeSuite(groups={"common"})
	public void beforeSuite() throws IOException{
		//del();
		String os = System.getProperty("os.name").toLowerCase();

		startResult();
	}

	
    
	
	@BeforeTest(groups={"common"})
	public void beforeTest(){
		loadObjects();
	}
	
	
		

		 
		@BeforeMethod(groups={"common"})
	public void beforeMethods() throws IOException{
			test = startTestCase(testCaseName, testDescription);
			test.assignCategory(category);
			test.assignAuthor(authors);
		invokeApp(browserName);
		loginfoStart(testCaseName, testDescription);
//		  JavascriptExecutor js = (JavascriptExecutor)driver;
//String a=js.executeScript("return document.readyState").toString();


		}


	@AfterSuite(groups={"common"})
	public void afterSuite() throws Exception{

//		endResult();
	
		//zip();
	}

	@AfterTest(groups={"common"})
	public void afterTest(){
		unloadObjects();
	}
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod(groups={"common"})
	public void afterMethod() throws InterruptedException{
	//	defaultcontent();
//logout(LogoutStatus,usertype);	
		endTestcase();
//closeAllBrowsers();
	closeBrowser();

	endResult();

	//	reportStep("Application has logged out Successfully", "PASS");

	

	
	
	}

	
	
	
	
	
	
	
	
	
	
	@DataProvider(name="fetch")
	public Object[][] getDataExcel() throws IOException{
		return Dataproviders.geta("./data/"+dataSheetName+".xlsx",testKeyword);		
	}	
	
	public void clickLogoutLink(){
		try {
			defaultcontent();
			topFrames();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickByXpathExplict(prop.getProperty("click.logout.link.xpath"));
	}	

	public void clickLogoutLink_FailCase(){
		try {
			defaultcontent();
			topFrames();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickByXpathExplict(prop.getProperty("click.logout.link.xpath"));
		reportStep("Scenario has been failed","FAIL");
	}	

	
	}