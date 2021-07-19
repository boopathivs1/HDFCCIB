package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class AccountServices_Page extends ProjectWrapp{
	public   AccountServices_Page (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public AccountServices_Page clickBalancelink() throws InterruptedException{
		LeftMenuFrames();
				clickByXpathExplict(prop.getProperty("click.balance.xpath"));
				
				return this;
			
			}
	
	
	public AccountServices_Page clickHistoryBalancelink() throws InterruptedException{
		
				clickByXpathExplict(prop.getProperty("click.historical.balance.xpath"));
				defaultcontent();
				return this;
			
			}
	
	public AccountServices_Page clickDealerBalancelink() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.dealer.balance.xpath"));
		defaultcontent();
		return this;
	
	}
	public AccountServices_Page clickSummarylink() throws InterruptedException{
		
				clickByXpathExplict(prop.getProperty("click.summary.xpath"));
				defaultcontent();
				
				return this;
			
			}
	
	
	public AccountServices_Page fillBalanceSummaryform(String company,String branch,String acc,String currency) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.company.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.branch.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.acc.xpath"),acc);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.currency.xpath"),currency);
		
		clickByXpathExplict(prop.getProperty("click.accountservice.view.xpath"));

		
		return this;
	}
	

	public AccountServices_Page fillHistoryBalanceSummaryform(String company,String branch,String acc) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.Historybalcompany.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.branch.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.acc.xpath"),acc);
		
		clickByXpathExplict(prop.getProperty("click.accountservice.view.xpath"));

		
		return this;
	}
	
public AccountServices_Page fillDealerbalSummaryform(String Remitter) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.dealer.remitter.xpath"),Remitter);
		
		clickByXpathExplict(prop.getProperty("click.accountservice.view.xpath"));

		
		return this;
	}
public AccountServices_Page SelectRecord() throws InterruptedException{
	
	
	
	return this;
}
	
	
	
	public LogoutPages clickReport()
	{
		
		clickByXpathExplict(prop.getProperty("click.accountservice.Report.xpath"));
		return new LogoutPages(driver, test);
	}
	
	
	public LogoutPages clickDownload()
	{
		
		clickByXpathExplict(prop.getProperty("click.accountservice.Download.xpath"));
		return new LogoutPages(driver, test);
	}
	
	
			
			


	
	
}
