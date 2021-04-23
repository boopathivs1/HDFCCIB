package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class NEFT_RTSG_Add_Single_Form extends ProjectWrapp{
	public   NEFT_RTSG_Add_Single_Form (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	
	
	public LogoutPages fill_NEFT_RTGS_Singleform(String paymode,String selectformat,String amount,String remarks) throws InterruptedException{
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("click.paymode.neftrtgs.xpath"),paymode);
		selectVisibileTextByXPath(prop.getProperty("click.neft.rtgs.format.select.xpath"),selectformat);

		enterByXpathExplict(prop.getProperty("enter.neft.amount.xpath"),amount);
		enterByXpathExplict(prop.getProperty("enter.neft.remarks.xpath"),remarks);
		
		clickByXpathExplict(prop.getProperty("click.addtosingle.save.xpath"));
		//defaultcontent();
		
		Thread.sleep(5000);
		acceptAlert();
		return new LogoutPages(driver, test);
	}
	
		
}
