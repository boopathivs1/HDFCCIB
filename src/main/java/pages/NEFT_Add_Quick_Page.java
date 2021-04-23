package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class NEFT_Add_Quick_Page extends ProjectWrapp{
	public   NEFT_Add_Quick_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	
	public LogoutPages fill_NEFT_Add_Quickform(String paymode,String selectformat,String amount,String remarks) throws InterruptedException{
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("click.paymode.neftrtgs.xpath"),paymode);
		selectVisibileTextByXPath(prop.getProperty("click.neft.rtgs.format.select.xpath"),selectformat);

		enterByXpathExplict(prop.getProperty("enter.neft.addquick.amount.xpath"),amount);
		enterByXpathExplict(prop.getProperty("enter.neft.addquick.detail.xpath"),remarks);
		
		clickByXpathExplict(prop.getProperty("NEFT.Add.quick.save.xpath"));
		Thread.sleep(6000);
		acceptAlert();
		return new LogoutPages(driver, test);
	}
	

	public LogoutPages fill_RTGS_Add_Quickform(String paymode,String selectformat,String amount) throws InterruptedException{
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("click.paymode.neftrtgs.xpath"),paymode);
		selectVisibileTextByXPath(prop.getProperty("click.neft.rtgs.format.select.xpath"),selectformat);

		enterByXpathExplict(prop.getProperty("enter.neft.addquick.amount.xpath"),amount);
		
		clickByXpathExplict(prop.getProperty("NEFT.Add.quick.save.xpath"));
		
		return new LogoutPages(driver, test);
	}
	
	
}
