package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class ForgotPassword_Page extends ProjectWrapp{
	public   ForgotPassword_Page (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public ForgotPassword_Page FillforgotPwdForm(String domainID, String UserID,String Email) throws InterruptedException{
		
		enterByXpathExplict(prop.getProperty("enter.Forgotdomainid.xpath"), domainID);
		enterByXpathExplict(prop.getProperty("enter.Forgot.userid.xpath"), UserID);
		enterByXpathExplict(prop.getProperty("enter.Forgot.emailid.xpath"), Email);
		
				return this;
			
			}
	
	
	
	
}
