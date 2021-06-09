package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class IMPSPaymentPage extends ProjectWrapp{
	public   IMPSPaymentPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	
	public IMPSPaymentPage ClickIMPSNew()
	{
		clickByXpathExplict(prop.getProperty("click.imps.new.xpath"));
		defaultcontent();
		return this;
	}
	
	public LogoutPages fillIMPSpaymentform(String format,String custno,String amount,String compid,String compbranch,
			String accno,String benecode,String beneisfccode,String benename,String beneImpsAccno ) throws InterruptedException{
				contentFrames();
				String accnum=regvalue(accno);
				String impsno=regvalue(beneImpsAccno);
		String custnumber=regvalue(custno);
		String impsamount=regvalue(amount);	
			//		selectVisibileTextByXPath(prop.getProperty("select.imps.template"),format);
		selectVisibileTextByXPath(prop.getProperty("IMPS.companyname.xpath"),compid);
	
		selectVisibileTextByXPath(prop.getProperty("select.imps.quickbranch.xpath"),compbranch);
		selectVisibileTextByXPath(prop.getProperty("select.imps.accno.xpath"),accnum);
		//selectVisibileTextByXPath(prop.getProperty("Select.acctotacc.benecode.xpath"),benecode);
//				enterByXpathExplict(prop.getProperty("enter.amount.accsingle.xpath"),amount);
//				clickByXpathExplict(prop.getProperty("click.addtosingle.save.xpath"));
		enterByXpathExplict(prop.getProperty("bene.ifsc.code.xpath"),beneisfccode);
		enterByXpathExplict(prop.getProperty("bene.imps.name.xpath"),benename);
		
		enterByXpathExplict(prop.getProperty("enter.bene.imps.accno.xpath"),impsno);
		
		
				enterByXpathExplict(prop.getProperty("enter.imps.custno"),custnumber);
				
				enterByXpathExplict(prop.getProperty("enter.imps.amount"),impsamount);
				enterByXpathExplict(prop.getProperty("enter.imps.amount"),impsamount);
				
				
				
				clickByXpathExplict(prop.getProperty("click.imps.save"));
				PressEnterkey();
		
		
		
		
		return new LogoutPages(driver,test);
	}
	
	
	public LogoutPages fillIMPSpaymentform_futuredate(String format,String custno,String amount,String compid,String compbranch,
			String accno,String benecode,String beneisfccode,String benename,String beneImpsAccno ) throws InterruptedException{
				contentFrames();
				String accnum=regvalue(accno);
				String impsno=regvalue(beneImpsAccno);
		String custnumber=regvalue(custno);
		String impsamount=regvalue(amount);	
			//		selectVisibileTextByXPath(prop.getProperty("select.imps.template"),format);
		selectVisibileTextByXPath(prop.getProperty("IMPS.companyname.xpath"),compid);
	
		selectVisibileTextByXPath(prop.getProperty("select.imps.quickbranch.xpath"),compbranch);
		selectVisibileTextByXPath(prop.getProperty("select.imps.accno.xpath"),accnum);
		//selectVisibileTextByXPath(prop.getProperty("Select.acctotacc.benecode.xpath"),benecode);
//				enterByXpathExplict(prop.getProperty("enter.amount.accsingle.xpath"),amount);
//				clickByXpathExplict(prop.getProperty("click.addtosingle.save.xpath"));
		enterByXpathExplict(prop.getProperty("bene.ifsc.code.xpath"),beneisfccode);
		enterByXpathExplict(prop.getProperty("bene.imps.name.xpath"),benename);
		
		enterByXpathExplict(prop.getProperty("enter.bene.imps.accno.xpath"),impsno);
		
		
				enterByXpathExplict(prop.getProperty("enter.imps.custno"),custnumber);
				
				enterByXpathExplict(prop.getProperty("enter.imps.amount"),impsamount);
				enterByXpathExplict(prop.getProperty("enter.imps.amount"),impsamount);
//				enterByXpathExplict(prop.getProperty("enter.imps.date.xpath"),GetFuturedate(futuredate));
				
				
				
				
				
				clickByXpathExplict_clear(prop.getProperty("enter.imps.date.xpath"));	
				
				Thread.sleep(7000);
				acceptAlert();
				
				enterByXpathExplict_noclear(prop.getProperty("enter.imps.date.xpath"),GetFuturedate(futuredate));
				
				Thread.sleep(2000);

				clickByXpathExplict(prop.getProperty("enter.imps.date.xpath"));	

		enterByXpathExplict_noclear(prop.getProperty("enter.imps.date.xpath"),GetFuturedate(futuredate));


				
							
				clickByXpathExplict(prop.getProperty("click.imps.save"));
				PressEnterkey();
		
		
		
		
		return new LogoutPages(driver,test);
	}
	
		
	
	
			
			

	


	
	
}
