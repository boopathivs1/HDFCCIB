package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class AcctoAccSingle extends ProjectWrapp{
	public   AcctoAccSingle (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public LogoutPages fillAcctoAccSingleform(String selectformat,String amount) throws InterruptedException{
contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.format.singleacc.xpath"),selectformat);

		enterByXpathExplict(prop.getProperty("enter.amount.accsingle.xpath"),amount);
		
		clickByXpathExplict(prop.getProperty("click.addtosingle.save.xpath"));
	
		return new LogoutPages(driver, test);
	}
	
	
			
			


	
	
}
