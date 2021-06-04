package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class BillPay_Page extends ProjectWrapp {
	
	public BillPay_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	public BillPay_Page clickBillpaysubmenu() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.billpay.submenu.xpath"));
		
		return this;
		
	
	}
	
	public BillPay_Page clickReview() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.billpay.review.xpath"));
		defaultcontent();
		
		return this;
	
	}
	
	public Authorize_page clickAuthorizebill() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.authorize.bill.xpath"));
		defaultcontent();
		
		return new Authorize_page(driver, test);
	
	}



	
	
public LogoutPages fillBillpaymentform(String status,String name,String company,String branch,String accno) throws InterruptedException{
		
		contentFrames();
		
		
		selectVisibileTextByXPath(prop.getProperty("select.bill.status.xpath"),status);
		
		selectVisibileTextByXPath(prop.getProperty("select.bill.name.xpath"),name);
		
		clickByXpathExplict(prop.getProperty("click.span.view.xpath"));
		
		clickByXpathExplict(prop.getProperty("select.billpay.record.xpath"));
		
		scrolltoelementJs(prop.getProperty("select.billpay.company.xpath"));
		selectVisibileTextByXPath(prop.getProperty("select.billpay.company.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.billpay.branchid.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.billpay.accno.xpath"),accno);
		
		clickByXpathExplict(prop.getProperty("select.billpay.submit.xpath"));
		
		
		return new LogoutPages(driver,test);
	}
			
	
}
