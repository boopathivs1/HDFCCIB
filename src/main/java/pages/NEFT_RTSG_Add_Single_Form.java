
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class NEFT_RTSG_Add_Single_Form extends ProjectWrapp{
	public   NEFT_RTSG_Add_Single_Form (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	
	
	public LogoutPages fill_NEFT_RTGS_Singleform(String paymode,String selectcompany,String selectbranch,String selectaccount,String beneneft,String amount,String remarks) throws InterruptedException{
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("click.paymode.neftrtgs.xpath"),paymode);
		//selectVisibileTextByXPath(prop.getProperty("click.neft.rtgs.format.select.xpath"),selectformat);
		
		selectVisibileTextByXPath(prop.getProperty("select.neft.company.xpath"),selectcompany);
		Thread.sleep(2000);
		selectVisibileTextByXPath(prop.getProperty("select.neft.branch.xpath"),selectbranch);
		Thread.sleep(2000);
		selectVisibileTextByXPath(prop.getProperty("select.neft.account.xpath"),selectaccount);
		
		getParentWindow();
		clickByXpathExplict(prop.getProperty("click.neft.search.xpath"));
	
		switchToLastWindow();
		enterByXpathExplict(prop.getProperty("enter.neft.bene.xpath"),beneneft);
		clickByXpathExplict(prop.getProperty("click.neft.bene.search.xpath"));
		clickByXpathExplict(".//input[contains(@onclick,'"+beneneft+"')]");
		clickByXpathExplict(prop.getProperty("click.neft.bene.ok.xpath"));	
		 Thread.sleep(4000);
		 switchWindow(parentwindow);
		 defaultcontent();
		 contentFrames();
		enterByXpathExplict(prop.getProperty("enter.neft.amount.xpath"),amount);
		enterByXpathExplict(prop.getProperty("enter.neft.remarks.xpath"),remarks);
		scrolltoelementJs(prop.getProperty("click.addtosingle.save.xpath"));
		clickByXpathExplict(prop.getProperty("click.addtosingle.save.xpath"));
	
		
		Thread.sleep(5000);
		acceptAlert();
		return new LogoutPages(driver, test);
	}
	
		
}


