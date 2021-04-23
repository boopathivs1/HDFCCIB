package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class FixedDepositPage extends ProjectWrapp{
	public   FixedDepositPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public FixedDepositPage clickFDNew(){
		clickByXpathExplict(prop.getProperty("click.FD.new.xpath"));
		defaultcontent();
		
		return this;
	
	}
	

	
	public LogoutPages fillFDpaymentform(String company,String branch,String acc,String panno,String amount ,String Natureofdept,String month,String Maturity,String Interestpay) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.company.dropdown.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.acc.dropdown.xpath"),acc);

		enterByXpathExplict(prop.getProperty("enter.FD.pan.xpath"),panno);
		
		enterByXpathExplict(prop.getProperty("enter.depamt.xpath"),amount);
		
		selectVisibileTextByXPath(prop.getProperty("select.nature.of.deposit.xpath"),Natureofdept);
		
		enterByXpathExplict(prop.getProperty("enter.month.xpath"),month);
		
		selectVisibileTextByXPath(prop.getProperty("select.maturity.instruction.xpath"),Maturity);
		selectVisibileTextByXPath(prop.getProperty("select.interest.pay.xpath"),Interestpay);
		
		clickByXpathExplict(prop.getProperty("click.accepterms.checkbox.xpath"));
	
		clickByXpathExplict(prop.getProperty("click.cbec.submit.xpath"));
		
		return new LogoutPages(driver,test);
	}
	
	
			
			

	


	
	
}
