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

//		System.out.println("111111111");
//		System.out.println(GetFuturedate(futuredate));
//		System.out.println("111111111");		
//		String futudate=GetFuturedate(futuredate).toString();

		////
		
	clickByXpathExplict_clear(prop.getProperty("enter.cbec.date.xpath"));	
		
		Thread.sleep(7000);
		acceptAlert();
		
		enterByXpathExplict_noclear(prop.getProperty("enter.cbec.date.xpath"),GetFuturedate(futuredate));
		
		Thread.sleep(2000);

		clickByXpathExplict(prop.getProperty("enter.cbec.date.xpath"));	

enterByXpathExplict_noclear(prop.getProperty("enter.cbec.date.xpath"),GetFuturedate(futuredate));

		
		
		////
		
//		enterByXpathExplict(prop.getProperty("enter.cbec.date.xpath"),futudate);

		selectVisibileTextByXPath(prop.getProperty("select.cbec.acccode.xpath"),acccode);

		
		
		enterByXpathExplict(prop.getProperty("enter.cbec.amount.xpath"),amount);
	
		clickByXpathExplict(prop.getProperty("click.cbec.submit.xpath"));
		
		return new LogoutPages(driver,test);
	}
	
public LogoutPages fillCBECpaymentform_future_Dates_cbec(String paytype,String company,String branch,String acc,String acccode,String amount) throws InterruptedException{
	
	contentFrames();
	Thread.sleep(3000);
	selectVisibileTextByXPath(prop.getProperty("select.paytype.xpath"),paytype);
	
	clickByXpathExplict(prop.getProperty("click.cbec.view"));
	
	clickByXpathExplict(prop.getProperty("select.record.checkbox"));
	
	clickByXpathExplict(prop.getProperty("click.cbec.initiate.xpath"));

	selectVisibileTextByXPath(prop.getProperty("select.cbec.comany.xpath"),company);
	
	selectVisibileTextByXPath(prop.getProperty("select.cbec.branch.xpath"),branch);
	
	selectVisibileTextByXPath(prop.getProperty("select.cbec.account.xpath"),acc);

//	System.out.println("111111111");
//	System.out.println(GetFuturedate(futuredate));
//	System.out.println("111111111");		
//	String futudate=GetFuturedate(futuredate).toString();

	////
	
clickByXpathExplict_clear(prop.getProperty("enter.cbec.date.xpath"));	
	
	Thread.sleep(7000);
	acceptAlert();
	
	enterByXpathExplict_noclear(prop.getProperty("enter.cbec.date.xpath"),GetFuturedate(14));
	
	Thread.sleep(2000);

	clickByXpathExplict(prop.getProperty("enter.cbec.date.xpath"));	

enterByXpathExplict_noclear(prop.getProperty("enter.cbec.date.xpath"),GetFuturedate(14));

	
	
	////
	
//	enterByXpathExplict(prop.getProperty("enter.cbec.date.xpath"),futudate);

	selectVisibileTextByXPath(prop.getProperty("select.cbec.acccode.xpath"),acccode);

	
	
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
