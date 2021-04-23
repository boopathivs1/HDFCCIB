package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class IMPSPaymentPage extends ProjectWrapp{
	public   IMPSPaymentPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	
	public IMPSPaymentPage ClickIMPSNew()
	{
		clickByXpathExplict(prop.getProperty("click.imps.new.xpath"));
		defaultcontent();
		return this;
	}
	
	public LogoutPages fillIMPSpaymentform(String format,String custno,String amount) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.imps.template"),format);

		enterByXpathExplict(prop.getProperty("enter.imps.custno"),custno);
		
		enterByXpathExplict(prop.getProperty("enter.imps.amount"),amount);
	
		clickByXpathExplict(prop.getProperty("click.imps.save"));
		
		PressEnterkey();
		
		return new LogoutPages(driver,test);
	}
	
	
			
			

	


	
	
}
