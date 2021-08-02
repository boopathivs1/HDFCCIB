package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class ThirdParty_Page extends ProjectWrapp{
	public   ThirdParty_Page (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public ThirdParty_Page ClickAccessCommercialCreditcard() throws InterruptedException{
		
	LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.access.commercial.creditcard.xpath"));
		//defaultcontent();
		Thread.sleep(3000);
		acceptAlert();
		Thread.sleep(3000);
				return this;
			
			}
	
	
	public ThirdParty_Page ClickNACHOutwardSubMenu() throws InterruptedException{
		
		LeftMenuFrames();
			clickByXpathExplict(prop.getProperty("click.NACH.submenu.xpath"));
//			defaultcontent();
			Thread.sleep(8000);
			acceptAlert();
			Thread.sleep(3000);
					return this;
				
				}
	
public ThirdParty_Page ClickAccessRET() throws InterruptedException{
		
		LeftMenuFrames();
			clickByXpathExplict(prop.getProperty("click.accessRET.xpath"));
//			defaultcontent();
			Thread.sleep(8000);
			acceptAlert();
			Thread.sleep(3000);
					return this;
				
				}
	
	
public ThirdParty_Page ClickSMESubMenu() throws InterruptedException{
		
		LeftMenuFrames();
			clickByXpathExplict(prop.getProperty("click.sme.submenu.xpath"));
//			defaultcontent();
			Thread.sleep(8000);
			acceptAlert();
			Thread.sleep(3000);
					return this;
				
				}
	
	
	public ThirdParty_Page VerifyThirdPartyPageNavigation(String NavigateURL) throws InterruptedException{
		
		try {
//			readywithtime(xpathVal);
			//	readystate();
					jqueryload();
				} catch (InterruptedException e1) {
			}
		Thread.sleep(2000);
		
		String expected = driver.getCurrentUrl();
		
		if(expected.contains(NavigateURL))
		{
			reportStep(expected+"::"+"page navigated succesfully", "PASS");
		}
		else
		{
			reportStep(expected+"::"+"page navigated Unsuccesfull", "FAIL");
		}
		
		return this;
				
				}
	
	
}
