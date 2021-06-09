package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class AcctoAccBulk extends ProjectWrapp{
	public   AcctoAccBulk (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public LogoutPages fillAcctoAccBulkkform(String company,String branch,String acc,String bene ,String amount, String remarks) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.company.dropdown.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.acc.dropdown.xpath"),acc);
		
		clickByXpathExplict(prop.getProperty("click.addpayment.xpath"));

		selectVisibileTextByXPath(prop.getProperty("select.bene.dropdown.xpath"),bene);
	
		enterByXpathExplict(prop.getProperty("enter.amount.bulk.xpath"),amount);
		
		enterByXpathExplict(prop.getProperty("enter.bulk.remarks.xpath"),remarks);
		
		clickByXpathExplict(prop.getProperty("click.bulk.ok.xpath"));
		
		Thread.sleep(10000);
		
		clickByXpathExplict(prop.getProperty("click.quick.save.xpath"));
		
		return new LogoutPages(driver, test);
	}
	
public LogoutPages fillAcctoAccBulkkformFuturedate(String company,String branch,String acc,String bene ,String amount, String remarks) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.company.dropdown.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.acc.dropdown.xpath"),acc);
		
		clickByXpathExplict(prop.getProperty("click.addpayment.xpath"));

		selectVisibileTextByXPath(prop.getProperty("select.bene.dropdown.xpath"),bene);
	
		enterByXpathExplict(prop.getProperty("enter.amount.bulk.xpath"),amount);
		
		//enterByXpathExplict(prop.getProperty("enter.bulk.date.xpath"),GetFuturedate(futuredate));
	//	enterByXpathExplict(prop.getProperty("enter.bulk.date.xpath"),("07/06/2021"));
		
		
		
		
		
	clickByXpathExplict_clear(prop.getProperty("enter.bulk.date.xpath"));	
		
		Thread.sleep(4000);
		acceptAlert();
		
		enterByXpathExplict_noclear(prop.getProperty("enter.bulk.date.xpath"),GetFuturedate(futuredate));
		
		Thread.sleep(2000);

		clickByXpathExplict(prop.getProperty("enter.bulk.date.xpath"));	

enterByXpathExplict_noclear(prop.getProperty("enter.bulk.date.xpath"),GetFuturedate(futuredate));

		
		
		
		
		
		enterByXpathExplict(prop.getProperty("enter.bulk.remarks.xpath"),remarks);
//		
		clickByXpathExplict(prop.getProperty("click.bulk.ok.xpath"));
//		
		Thread.sleep(5000);
//		
		clickByXpathExplict(prop.getProperty("click.quick.save.xpath"));
		
		return new LogoutPages(driver, test);
	}
	
	
			
			


	
	
}
