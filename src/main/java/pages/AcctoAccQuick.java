package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class AcctoAccQuick extends ProjectWrapp{
	public   AcctoAccQuick (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public LogoutPages fillAcctoAccQuickform(String selectformat,String amount,String paymentdetail) throws InterruptedException{
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.format.singleacc.xpath"),selectformat);
		
	
		enterByXpathExplict(prop.getProperty("enter.amount.accsingle.xpath"),amount);
		
		enterByXpathExplict(prop.getProperty("enter.payment.detail.xpath"),paymentdetail);
		
		clickByXpathExplict(prop.getProperty("click.quick.save.xpath"));
		
		return new LogoutPages(driver, test);
	}
	
	
			
			


	
	
}
