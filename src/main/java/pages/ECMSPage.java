package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class ECMSPage extends ProjectWrapp{
	public   ECMSPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public LogoutPages fillECSform(String company,String branch,String acc,String bene ,String amount) throws InterruptedException{
		
		contentFrames();
		
		selectVisibileTextByXPath(prop.getProperty("select.ecms.company.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.ecms.account.xpath"),acc);
	
		selectVisibileTextByXPath(prop.getProperty("select.bene.dropdown.xpath"),bene);
	
		enterByXpathExplict(prop.getProperty("enter.amount.bulk.xpath"),amount);
		
		clickByXpathExplict(prop.getProperty("click.addtosingle.save.xpath"));
		
		return new LogoutPages(driver,test);
	}
	
	
			
			


	
	
}
