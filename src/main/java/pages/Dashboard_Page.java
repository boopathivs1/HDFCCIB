package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Dashboard_Page  extends ProjectWrapp{
	public   Dashboard_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public FundTransfers_Page clickFundTransfers() throws InterruptedException{
		//Thread.sleep(20000);
		topFrames();
		clickByXpathExplict(prop.getProperty("click.fundtrans.menu.xpath"));
		defaultcontent();
		return new FundTransfers_Page(driver, test);
	
	}
	public Stop_Checkque_PaymentPage clickserviceslink() throws InterruptedException{
		topFrames();
		clickByXpathExplict(prop.getProperty("click.services.link.xpath"));
defaultcontent();
		return new Stop_Checkque_PaymentPage(driver,test);
	}	
	
	public AccountServices_Page clickAccountService() throws InterruptedException{
		//Thread.sleep(20000);
		topFrames();
		clickByXpathExplict(prop.getProperty("click.account.service.xpath"));
		defaultcontent();
		return new AccountServices_Page(driver, test);
	
	}
	

	public ServicePage clickService() throws InterruptedException{
		topFrames();
		clickByXpathExplict(prop.getProperty("click.service.xpath"));
		defaultcontent();
		
		return new ServicePage(driver, test);
	
	}

	
	public CorpBeneficiary_Page clickAdministration() throws InterruptedException{
		topFrames();
		clickByXpathExplict(prop.getProperty("click.administration.xpath"));
		defaultcontent();
		
		return new CorpBeneficiary_Page(driver, test);
	
	}
	
	public CorpBeneficiary_Page clickAuthAdministration() throws InterruptedException{
		topFrames();
		clickByXpathExplict(prop.getProperty("click.authorizer.administration.xpath"));
		defaultcontent();
		
		return new CorpBeneficiary_Page(driver, test);
	
	}

	
	public WCDLPage clickWorkingCapital() throws InterruptedException{
		topFrames();
		clickByXpathExplict(prop.getProperty("click.Working.capital.xpath"));
		defaultcontent();
		
		return new WCDLPage(driver, test);
	
	}
	
	public BillPay_Page clickBillpay() throws InterruptedException{
		topFrames();
		clickByXpathExplict(prop.getProperty("click.billpay.xpath"));
		defaultcontent();
		
		return new BillPay_Page(driver, test);
	
	}

	

			public Cash_Management_Service clickCashManageServiceLink() throws InterruptedException{
				Thread.sleep(8000);
				topFrames();
				clickByXpathExplict(prop.getProperty("click.cash.manage.servoce.xpath"));
				defaultcontent();
				return new Cash_Management_Service(driver, test);
			
			}
			
			public Cash_Management_Service clickCashManageServiceLink_first() throws InterruptedException{
				Thread.sleep(8000);
				topFrames();
				clickByXpathExplict(prop.getProperty("click.cash.manage.servoce.single.xpath"));
				defaultcontent();
				return new Cash_Management_Service(driver, test);
			
			}
			
			
			
			public Cash_Management_Service clickCashServiceLink() throws InterruptedException{
				Thread.sleep(8000);
				topFrames();
				clickByXpathExplict(prop.getProperty("click.cash.manage.servoce.single.xpath"));
				defaultcontent();
				return new Cash_Management_Service(driver, test);
			
			}
	
			
	
	
	public Authorize_page fundTransfersLink() throws InterruptedException{
		topFrames();

		clickByXpathExplict(prop.getProperty("click.fundtrans.menu.xpath"));
		defaultcontent();
		return new Authorize_page(driver, test);
	
	}
	
}
