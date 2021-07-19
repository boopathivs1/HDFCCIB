package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class LogoutPages extends ProjectWrapp{
	public  LogoutPages (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public LogoutPages getrefnum() throws InterruptedException{
		
		
String reference=getTextByXpath(prop.getProperty("get.refnum.fundtrans.xpath"));		
	String trimrefnum=regvalue(reference);
	getrefnumer=trimrefnum.substring(25,39);
		System.out.println(getrefnumer);
		
	
		defaultcontent();
		return this;
	}
	

	
	public LogoutPages ReverseTlaRecord() throws InterruptedException{
		
		
		
		scrolltoelementJs(".//input[contains(@onclick,'"+getrefnumer+"')]");
		clickByXpathExplict(".//input[contains(@onclick,'"+getrefnumer+"')]");
		clickByXpathExplict(prop.getProperty("click.Reversefile.download.xpath"));
		
		//clickByXpathExplictWithouScreenShot(prop.getProperty("click.authorize.flapages.xpath"));
		
	defaultcontent();




					return this;
	}
	
public LogoutPages ReverseS2SFlaRecord() throws InterruptedException{
		
		
	scrolltoelementJs(".//input[contains(@onclick,'"+getrefnumer+"')]");
	clickByXpathExplict(".//input[contains(@onclick,'"+getrefnumer+"')]");
	clickByXpathExplict(prop.getProperty("click.s2s.reverse.doenload.xpath"));
	Thread.sleep(5000);
	defaultcontent();
	
	
	

					return this;
}

	
public LogoutPages getrefnumber() throws InterruptedException{
		
		
		String reference=getTextByXpath(prop.getProperty("get.refnum.fundtrans.xpath"));		
		String finalvalue="";
		
		for(int i=0; i<reference.length();i++)
		{
			char  c = reference.charAt(i);
			
			if(Character.isDigit(c))
			{
				finalvalue=finalvalue+c;
			}
	}
		getrefnumer="FT"+finalvalue;
		
		System.out.println(getrefnumer);
		defaultcontent();
		return this;
	}
				
			

	
	
	public LogoutPages clickLogout() throws InterruptedException{
		Thread.sleep(4000);
		
	topFrames();
		clickByXpathExplict(prop.getProperty("click.logout.link.xpath"));
		defaultcontent();
		return this;
	}
	public LogoutPages clickSimulatorLogout() throws InterruptedException{
		Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("click.simulator.logout.xpath"));
		defaultcontent();
		return this;
	}
	
	
	public LogoutPages clickEPIPCSSimulatorLogout() throws InterruptedException{
		Thread.sleep(2000);
		topEPIPCSFrames();
		clickByXpathExplict(prop.getProperty("click.epipcs.logout.xpath"));
		defaultcontent();
		return this;
	}
	
	public LogoutPages clickCBDTSimulatorLogout() throws InterruptedException{
		Thread.sleep(6000);
		clickByXpathExplict(prop.getProperty("click.cbdt.simulator.logout"));
		defaultcontent();
		return this;
	}
	

}
