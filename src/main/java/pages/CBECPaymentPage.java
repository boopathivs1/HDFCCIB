package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CBECPaymentPage extends ProjectWrapp{
	public   CBECPaymentPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	

	//	enter.cbec.date.xpath
	
	
public LogoutPages fillCBECpaymentform_future_Dates(String paytype,String company,String branch,String acc,String acccode,String amount) throws InterruptedException{
		
		contentFrames();
		Thread.sleep(3000);
		selectVisibileTextByXPath(prop.getProperty("select.paytype.xpath"),paytype);
		
		clickByXpathExplict(prop.getProperty("click.cbec.view"));
		
		clickByXpathExplict(prop.getProperty("select.record.checkbox"));
		
		clickByXpathExplict(prop.getProperty("click.cbec.initiate.xpath"));

		selectVisibileTextByXPath(prop.getProperty("select.cbec.comany.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbec.branch.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbec.account.xpath"),acc);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbec.acccode.xpath"),acccode);
		
		enterByXpathExplict(prop.getProperty("enter.cbec.date.xpath"), GetFuturedate(futuredate));

		
		
		enterByXpathExplict(prop.getProperty("enter.cbec.amount.xpath"),amount);
	
		clickByXpathExplict(prop.getProperty("click.cbec.submit.xpath"));
		
		return new LogoutPages(driver,test);
	}
	

	public LogoutPages fillCBECpaymentform(String paytype,String company,String branch,String acc,String acccode,String amount) throws InterruptedException{
		
		contentFrames();
		Thread.sleep(3000);
		selectVisibileTextByXPath(prop.getProperty("select.paytype.xpath"),paytype);
		
		clickByXpathExplict(prop.getProperty("click.cbec.view"));
		
		clickByXpathExplict(prop.getProperty("select.record.checkbox"));
		
		clickByXpathExplict(prop.getProperty("click.cbec.initiate.xpath"));

		selectVisibileTextByXPath(prop.getProperty("select.cbec.comany.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbec.branch.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbec.account.xpath"),acc);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbec.acccode.xpath"),acccode);
		
		enterByXpathExplict(prop.getProperty("enter.cbec.amount.xpath"),amount);
	
		clickByXpathExplict(prop.getProperty("click.cbec.submit.xpath"));
		
		return new LogoutPages(driver,test);
	}
	
	
			
			
	public LogoutPages fillCBECpaymentform_future_Date(String paytype,String company,String branch,String acc,String acccode,String amount) throws InterruptedException{
		
		contentFrames();
		Thread.sleep(3000);
		selectVisibileTextByXPath(prop.getProperty("select.paytype.xpath"),paytype);
		
		clickByXpathExplict(prop.getProperty("click.cbec.view"));
		
		clickByXpathExplict(prop.getProperty("select.record.checkbox"));
		
		clickByXpathExplict(prop.getProperty("click.cbec.initiate.xpath"));

		selectVisibileTextByXPath(prop.getProperty("select.cbec.comany.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbec.branch.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbec.account.xpath"),acc);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbec.acccode.xpath"),acccode);
		
		enterByXpathExplict(prop.getProperty("enter.cbec.amount.xpath"),amount);
	
		clickByXpathExplict(prop.getProperty("click.cbec.submit.xpath"));
		
		return new LogoutPages(driver,test);
	}
	

	


	
	
}
