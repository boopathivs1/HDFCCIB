package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class WCDLPage extends ProjectWrapp{
	public   WCDLPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	

	public WCDLPage clickWCDL() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.WCDL.xpath"));
		
		return this;
	
	}

	public WCDLPage clickWCDLNEw(){
		clickByXpathExplict(prop.getProperty("click.WCDL.new.xpath"));
		
		defaultcontent();
		
		return this;
	
	}
	
	public LogoutPages fillWCDLpaymentform(String company,String amount,String interest,String month) throws InterruptedException{
		
		contentFrames();
		
		selectVisibileTextByXPath(prop.getProperty("select.WCDL.company.xpath"),company);
		
	
		enterByXpathExplict(prop.getProperty("enter.addbulk.amount.xpath"),amount);
		
		enterByXpathExplict(prop.getProperty("enter.WCDL.interest.rate.xpath"),interest);
		
		enterByXpathExplict(prop.getProperty("enter.WCDL.month.xpath"),month);
		
		clickByXpathExplict(prop.getProperty("click.WDL.save.xpath"));
		
		return new LogoutPages(driver,test);
	}
			
	public Authorize_page clickFixeddeposit(){
		clickByXpathExplict(prop.getProperty("click.FD.xpath"));
		
		return new Authorize_page(driver, test);
	
	}	

	
	public Authorize_page clickWCDLMenu() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.WCDL.xpath"));
		
		return new Authorize_page(driver, test);
	
	}

	
	
}
