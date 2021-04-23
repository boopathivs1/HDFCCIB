package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class UPI_Collection_Page extends ProjectWrapp{
	public   UPI_Collection_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public UPI_Collection_Page clickNew_Upi(){
		clickByXpathExplict(prop.getProperty("click.upi.new.xpath"));
		defaultcontent();
		return this;
	
	}

	public LogoutPages fill_Upi(String upiformat,String UpiCorpRef,String UpiDesc,String UpiAmt,String Expiry) throws InterruptedException{

		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.upi.format.xpath"),upiformat);
enterByXpathExplict(prop.getProperty("enter.upi.corp.refnum.xpath"),UpiCorpRef);
enterByXpathExplict(prop.getProperty("enter.upi.desc.xpath"),UpiDesc);
enterByXpathExplict(prop.getProperty("enter.upi.amt.xpath"),UpiAmt);
enterByXpathExplict(prop.getProperty("enter.expiry.upi.xpath"),Expiry);
clickByXpathExplict(prop.getProperty("click.upi.save.xpath"));


		return new LogoutPages(driver, test);
	
	}

	

}
