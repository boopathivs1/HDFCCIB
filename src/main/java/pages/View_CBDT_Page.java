
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class View_CBDT_Page extends ProjectWrapp{
	public   View_CBDT_Page (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public View_CBDT_Page intiate_CBDT(String Challanno,String recordno) throws InterruptedException{
	contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.cbdt.challan.num.xpath"),Challanno);
		
		clickByXpathExplict(prop.getProperty("click.view.cbdt.link.xpath"));
		clickByXpathExplict(".//input[contains(@onclick,'"+recordno+"')]");
		
		clickByXpathExplict(prop.getProperty("click.cbdt.initiate.xpath"));

		
//select.cbdt.challan.num.xpath=.//select[@id="challanno"]
//280
//click.view.cbdt.link.xpath=.//span[contains(text(),'View')]
//click.cbdt.record.xpath=.//input[contains(@onclick,'280')]
//click.cbdt.initiate.xpath=.//span[contains(text(),'InitiatePayment')]
		
	defaultcontent();
		return this;
	
	
	}
	
	
	
	
	
	
	public LogoutPages fill_CBDT(String compid,String branch,String accno,String taxnum) throws InterruptedException{
		Thread.sleep(10000);
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.cbdt.comp.xpath"),compid);
		Thread.sleep(10000);

		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

				
		selectVisibileTextByXPath(prop.getProperty("select.cbdt.branch.xpath"),branch);
		
		
		Thread.sleep(2000);
		selectVisibileTextByXPath(prop.getProperty("select.cbdt.accnum.xpath"),accno);
		
		enterByXpathExplict(prop.getProperty("enter.cbdt.tax.num.xpath"),taxnum);
		
		clickByXpathExplict(prop.getProperty("click.cbdt.form.submit.xpath"));
		Thread.sleep(4000);
		acceptAlert();
		
		return new LogoutPages(driver, test);
	
	
	}
		
	
	
	public LogoutPages fill_CBDT_future_date(String compid,String branch,String accno,String taxnum) throws InterruptedException{
		Thread.sleep(4000);
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.cbdt.comp.xpath"),compid);
		Thread.sleep(10000);
		

		
		//selectVisibileTextByXPath(prop.getProperty("select.cbdt.branch.xpath"),branch);
	//	selectVisibileTextByXPath(prop.getProperty("select.cbdt.branch.xpath"),"759, #ITC CENTREANNA SALAI, Opp T.V.S.");
		
		selectValueByxpath(prop.getProperty("select.cbdt.branch.xpath"),"0004");
		
//		value="0004"
		Thread.sleep(2000);
		selectVisibileTextByXPath(prop.getProperty("select.cbdt.accnum.xpath"),accno);
		
		enterByXpathExplict(prop.getProperty("enter.cbdt.tax.num.xpath"),taxnum);
		enterByXpathExplict(prop.getProperty("enter.cbdt.date.xpath"),GetFuturedate(futuredate));
		
		clickByXpathExplict(prop.getProperty("click.cbdt.form.submit.xpath"));
		Thread.sleep(4000);
		acceptAlert();
		
		return new LogoutPages(driver, test);
	
	
	}
	
}

