package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Cash_Management_Service extends ProjectWrapp{
	public  Cash_Management_Service(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public Cash_Management_Service clickDisbursementLink() throws InterruptedException{
		//Thread.sleep(20000);
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.disbursement.link.xpath"));
		
		return this;
	
	
	}
	
	

	public Cash_Manage_UploadPages click_DisbursementLink() throws InterruptedException{
		//Thread.sleep(20000);
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.disbursement.link.xpath"));
		defaultcontent();
		return new Cash_Manage_UploadPages(driver, test);
	
	}
	
	
	
	
	public File_Level_Authorization_Pages clickFLA_AuthLink() throws InterruptedException{
		//Thread.sleep(20000);
		clickByXpathExplict(prop.getProperty("click.filelevel.auth.link.xpath"));
	defaultcontent();
	
	return new File_Level_Authorization_Pages(driver, test);
	
	}
	
	
	public File_Level_Authorization_Pages clickFLA_Link() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.filelevel.auth.link.xpath"));
	defaultcontent();
	
	return new File_Level_Authorization_Pages(driver, test);
	
	}
	
	
	public Transaction_Level_Auth_Pages clickTLA_AuthLink() throws InterruptedException{
		//Thread.sleep(20000);
		clickByXpathExplict(prop.getProperty("click.trans.level.auth.link.xpath"));
	
	defaultcontent();
	return new Transaction_Level_Auth_Pages(driver, test);
	
	}
	
	public Cash_Manage_UploadPages clickUploadLink() throws InterruptedException{
	
		clickByXpathExplict(prop.getProperty("click.upload.link.cash.xpath"));
		defaultcontent();
		return new Cash_Manage_UploadPages(driver, test);
	
	}
	
	
	
	
		
	
	


	
	
}
