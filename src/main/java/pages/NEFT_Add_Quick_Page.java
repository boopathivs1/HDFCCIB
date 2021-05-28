package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class NEFT_Add_Quick_Page extends ProjectWrapp{
	public   NEFT_Add_Quick_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	
	public LogoutPages fill_NEFT_Add_Quickform(String paymode,String selectcompany,String selectbranch,String selectaccount,String beneneft,String amount,String remarks)throws InterruptedException{
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
		enterByXpathExplict(prop.getProperty("enter.neft.addquick.amount.xpath"),amount);
		enterByXpathExplict(prop.getProperty("enter.neft.addquick.detail.xpath"),remarks);
		
		clickByXpathExplict(prop.getProperty("NEFT.Add.quick.save.xpath"));
		Thread.sleep(6000);
		acceptAlert();
		return new LogoutPages(driver, test);
	}
	

	public LogoutPages fill_RTGS_Add_Quickform(String paymode,String selectcompany,String selectbranch,String selectaccount,String beneneft,String amount,String remarks) throws InterruptedException{
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("click.paymode.neftrtgs.xpath"),paymode);
		//selectVisibileTextByXPath(prop.getProperty("click.neft.rtgs.format.select.xpath"),selectformat);
		selectVisibileTextByXPath(prop.getProperty("select.neft.company.xpath"),selectcompany);
		Thread.sleep(2000);
		selectVisibileTextByXPath(prop.getProperty("select.neft.branch.xpath"),selectbranch);
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
		enterByXpathExplict(prop.getProperty("enter.neft.addquick.amount.xpath"),amount);
		
		clickByXpathExplict(prop.getProperty("NEFT.Add.quick.save.xpath"));
		
		return new LogoutPages(driver, test);
	}
	
	
}
