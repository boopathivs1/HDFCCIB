package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class HDFC_Login_Page extends ProjectWrapp{
	public  HDFC_Login_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

public Dashboard_Page fillCredentials(String userid,String pwd,String groupid){
	enterByXpathExplict(prop.getProperty("enter.userid.xpath"), userid);
	enterByXpathExplict(prop.getProperty("enter.useridpwd.xpath"),pwd);
	enterByXpathExplict(prop.getProperty("enter.useridgroup.xpath"),groupid);
	
	clickByXpathExplict(prop.getProperty("click.login.id.xpath"));
	
	return new Dashboard_Page(driver, test);
}


public ForgotPassword_Page clickForgotPwd() throws InterruptedException{
	
	clickByXpathExplict(prop.getProperty("click.forgotpwd.xpath"));

	
	return new ForgotPassword_Page(driver, test);

}

}
