package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class ServicePage extends ProjectWrapp{
	public   ServicePage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	
	public FixedDepositPage clickFD() throws InterruptedException{
		
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.FD.xpath"));
		
		return new FixedDepositPage(driver, test);
	
	}
	

	public ChequeBookReqPage clickChequebookReq() throws InterruptedException{
		
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.chequebookReq.xpath"));
		
		return new ChequeBookReqPage(driver, test);
	
	}
	


	public Authorize_page clickChequeReq() throws InterruptedException{
		
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.chequebookReq.xpath"));
		
		return new Authorize_page(driver, test);
	
	}
	
			
	public Authorize_page clickFixeddeposit() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.FD.xpath"));
		return new Authorize_page(driver, test);
	
	}	

	


	
	
}
