package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class NEFT_Add_Bulk_Page extends ProjectWrapp{
	public   NEFT_Add_Bulk_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	public NEFT_Add_Bulk_Page fill_NEFT_RTGS_Add_Bulk_Submitform(String company,String branch,String account) throws InterruptedException{
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.company.addbulk.xpath"),company);
		selectVisibileTextByXPath(prop.getProperty("select.addbulk.branch.xpath"),branch);

		selectVisibileTextByXPath(prop.getProperty("select.addbulk.acc.xpath"),account);

				
		
		Thread.sleep(5000);
		
		clickByXpathExplict(prop.getProperty("click.addbulk.payment.xpath"));
		
		return this;
	}


	
	
	
	public LogoutPages fill_NEFT_RTGS_Add_Bulkform(String paymode,String selectformat,String amount,String remarks) throws InterruptedException{
		selectVisibileTextByXPath(prop.getProperty("click.paymode.neftrtgs.xpath"),paymode);
		selectVisibileTextByXPath(prop.getProperty("click.neft.rtgs.format.select.xpath"),selectformat);

		enterByXpathExplict(prop.getProperty("enter.addbulk.amount.xpath"),amount);
		enterByXpathExplict(prop.getProperty("enter.addbulk.narration.xpath"),remarks);
		
		clickByXpathExplict(prop.getProperty("click.addbulk.neft.save.xpath"));
		Thread.sleep(5000);
		acceptAlert();
		
		clickByXpathExplict(prop.getProperty("click.addbulk.neft.finalsave.xpath"));
		
		
	//	defaultcontent();
		return new LogoutPages(driver, test);
	}

}
