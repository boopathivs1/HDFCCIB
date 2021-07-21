package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class ChequeBookReqPage extends ProjectWrapp{
	public   ChequeBookReqPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
public ChequeBookReqPage clickChequebookReqNew() throws InterruptedException{
		
		
		clickByXpathExplict(prop.getProperty("click.chequebookreq.new.xpath"));
		defaultcontent();
		
		return this;
	
	}



	
public ChequeBookReqPage fillChequeReqform(String company,String branch,String acc) throws InterruptedException{
	
	contentFrames();
	selectVisibileTextByXPath(prop.getProperty("select.company.dropdown.xpath"),company);
	
	selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
	
	selectVisibileTextByXPath(prop.getProperty("select.acc.dropdown.xpath"),acc);

	
	clickByXpathExplict(prop.getProperty("click.cbec.submit.xpath"));
	
	return this;
}

public LogoutPages getrefnumAch(int a,int b) throws InterruptedException{
	
	
	String reference=getTextByXpath(prop.getProperty("get.refnum.fundtrans.xpath"));		
	//	String trimrefnum=regvalue(reference);
		getrefnumer=reference.substring(a,b);
			System.out.println(getrefnumer);
			
		
			defaultcontent();
			return new LogoutPages(driver, test);
		}




	public ChequeBookReqPage clickWCDL() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.WCDL.xpath"));
		
		return this;
	
	}

	public ChequeBookReqPage clickWCDLNEw(){
		clickByXpathExplict(prop.getProperty("click.WCDL.new.xpath"));
		
		defaultcontent();
		
		return this;
	
	}
	
	public LogoutPages fillWCDLpaymentform(String company,String amount,String interest,String month) throws InterruptedException{
		
		contentFrames();
		
		selectVisibileTextByXPath(prop.getProperty("select.WCDL.company.xpath"),company);
		
	
		enterByXpathExplict(prop.getProperty("enter.addbulk.amount.xpath"),amount);
		
		enterByXpathExplict(prop.getProperty("enter.WCDL.interest.rate.xpath"),interest);
		
		enterByXpathExplict(prop.getProperty("enter.WCDL.month.xpath"),month);
		
		clickByXpathExplict(prop.getProperty("click.WDL.save.xpath"));
		
		return new LogoutPages(driver,test);
	}
			
	public Authorize_page clickFixeddeposit(){
		clickByXpathExplict(prop.getProperty("click.FD.xpath"));
		
		return new Authorize_page(driver, test);
	
	}	

	
	public Authorize_page clickWCDLMenu() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.WCDL.xpath"));
		
		return new Authorize_page(driver, test);
	
	}

	
	
}
