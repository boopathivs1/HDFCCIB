package pages;

import java.time.LocalDate;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CBDT_Payment_SimulatorPage extends ProjectWrapp{
	public   CBDT_Payment_SimulatorPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public CBDT_Payment_SimulatorPage FillCBDTSimulator(){
	
		enterByXpathExplict(prop.getProperty("enter.transdate.xpath"), GetTodayDate());
		clickByXpathExplict(prop.getProperty("click.cbdt.go"));
		
	return this;
}
	
	public CBDT_Payment_SimulatorPage fillCredentials(String userid,String pwd,String groupid){
		enterByXpathExplict(prop.getProperty("enter.userid.xpath"), userid);
		enterByXpathExplict(prop.getProperty("enter.useridpwd.xpath"),pwd);
		enterByXpathExplict(prop.getProperty("enter.useridgroup.xpath"),groupid);
		
		clickByXpathExplict(prop.getProperty("click.login.id.xpath"));
		
		return this;
	}
	
	
	public LogoutPages SubmitCBDTForm(String company, String Branch,String acc,String Tax ) throws InterruptedException{
		
		Thread.sleep(6000);
		
		selectVisibileTextByXPath(prop.getProperty("select.cbdt.sim.xpath"),company);
		selectVisibileTextByXPath(prop.getProperty("select.cbdt.sim.branch.xpath"), Branch);
		selectVisibileTextByXPath(prop.getProperty("select.cbdt.sim.acc.xpath"), acc);
		enterByXpathExplict(prop.getProperty("enter.cbdt.tax.xpath"),Tax);
		clickByXpathExplict(prop.getProperty("click.cbdt.confirm"));
		//PressEnterkey();
		Thread.sleep(7000);
		acceptAlert();
		Thread.sleep(3000);
	
		verifyElementpresentByXpathExplicitwait("//center[contains(.,'sucessfully')]");
		
		
		return new  LogoutPages(driver, test);
	}
	
	
	
	
	
			
	

	


	
	
}
