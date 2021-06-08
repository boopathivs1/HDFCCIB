package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SpecialPaymentPage extends ProjectWrapp{
	public   SpecialPaymentPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public LogoutPages fillSplpaymentIOCLform(String Format,String bene,String amount,String remark,String company,String branch,String acc,String statecode,String Prodcode) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.splpayment.format.xpath"),Format);
		
		selectVisibileTextByXPath(prop.getProperty("select.bene.dropdown.xpath"),bene);
		
		enterByXpathExplict(prop.getProperty("enter.amount.bulk.xpath"),amount);
		
		enterByXpathExplict(prop.getProperty("enter.spl.remarks.xpath"),remark);
		
		selectVisibileTextByXPath(prop.getProperty("select.company.dropdown.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.acc.dropdown.xpath"),acc);
		
		selectVisibileTextByXPath(prop.getProperty("select.xtatecode.xpath"),statecode);
	
		selectVisibileTextByXPath(prop.getProperty("select.Prodcode.xpath"),Prodcode);
	
		clickByXpathExplict(prop.getProperty("click.spl.save.xpath"));
		
		return new LogoutPages(driver,test);
	}
	
	
	public LogoutPages fillSplpaymentIOCLform_future_Date(String Format,String bene,String amount,String remark,String company,String branch,String acc,String statecode,String Prodcode) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.splpayment.format.xpath"),Format);
		
		selectVisibileTextByXPath(prop.getProperty("select.bene.dropdown.xpath"),bene);
		
		enterByXpathExplict(prop.getProperty("enter.amount.bulk.xpath"),amount);
		
		clickByXpathExplict_clear(prop.getProperty("enter.iocl.spl.futuredate.xpath"));	
		
		Thread.sleep(7000);
		acceptAlert();
		
		enterByXpathExplict_noclear(prop.getProperty("enter.iocl.spl.futuredate.xpath"),GetFuturedate(futuredate));
		
		Thread.sleep(2000);

		clickByXpathExplict(prop.getProperty("enter.iocl.spl.futuredate.xpath"));	

enterByXpathExplict_noclear(prop.getProperty("enter.iocl.spl.futuredate.xpath"),GetFuturedate(futuredate));
		
		
		enterByXpathExplict(prop.getProperty("enter.spl.remarks.xpath"),remark);
		
		selectVisibileTextByXPath(prop.getProperty("select.company.dropdown.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.acc.dropdown.xpath"),acc);
		
		selectVisibileTextByXPath(prop.getProperty("select.xtatecode.xpath"),statecode);
	
		selectVisibileTextByXPath(prop.getProperty("select.Prodcode.xpath"),Prodcode);
	
		clickByXpathExplict(prop.getProperty("click.spl.save.xpath"));
		
		return new LogoutPages(driver,test);
	}
			
			
public LogoutPages fillSplpaymentBPCLform(String Format,String Appformat,String amount,String remark) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.splpayment.format.xpath"),Format);
		
		selectVisibileTextByXPath(prop.getProperty("select.spl.applyformat.xpath"),Appformat);
		enterByXpathExplict(prop.getProperty("enter.reliance.amt"),amount);
		System.out.println("11111111111");
		System.out.println(GetFuturedate(futuredate));
		System.out.println("11111111111");	
		enterByXpathExplict(prop.getProperty("enter.iocl.date.trans.xpath"),GetFuturedate(futuredate));
		
		//enterByXpathExplict(prop.getProperty("enter.iocl.date.trans.xpath"),"09/06/2021");
		
		
		enterByXpathExplict(prop.getProperty("enter.reliance.amt"),amount);
		
		enterByXpathExplict(prop.getProperty("enter.bpcl.remark"),remark);
		
		clickByXpathExplict(prop.getProperty("click.spl.save.xpath"));
		
		return new LogoutPages(driver,test);
	}
	


	
	
}
