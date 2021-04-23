package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class ReliancePaymentPage extends ProjectWrapp{
	public   ReliancePaymentPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public LogoutPages fillReliancepaymentform(String company,String branch,String acc,String bene,String custcode,String toacc,String amount) throws InterruptedException{
		
		
		contentFrames();
		
		selectVisibileTextByXPath(prop.getProperty("select.reliance.company"),company);
		selectVisibileTextByXPath(prop.getProperty("select.reliance.branch"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.reliance.account"),acc);
		
		selectVisibileTextByXPath(prop.getProperty("select.reliance.bene"),bene);
		
		selectVisibileTextByXPath(prop.getProperty("select.reliance.custcode"),custcode);
		
		selectVisibileTextByXPath(prop.getProperty("select.reliance.toaccount"),toacc);
		
		enterByXpathExplict(prop.getProperty("enter.reliance.amt"),amount);
	
		clickByXpathExplict(prop.getProperty("click.spl.save.xpath"));
		
		return new LogoutPages(driver,test);
	}
	
	
			
			

	


	
	
}
