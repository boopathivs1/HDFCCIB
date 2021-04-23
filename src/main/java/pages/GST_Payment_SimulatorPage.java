package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class GST_Payment_SimulatorPage extends ProjectWrapp{
	public   GST_Payment_SimulatorPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public GST_Payment_SimulatorPage FillGSTSimulator(String TransID,String challonNo,String amount,String expirydate){
	
		enterByXpathExplict(prop.getProperty("enter.gst.transactionid.xpath"), TransID);
		enterByXpathExplict(prop.getProperty("enter.gst.challon.no.xpath"), challonNo);
		//enterByXpathExplict(prop.getProperty("enter.gst.amt.xpath"), amount);
		enterByXpathExplict(prop.getProperty("enter.gst.expirydate.xpath"), expirydate);
		clickByXpathExplict(prop.getProperty("enter.gst.submit.xpath"));
		acceptAlert();
		
	return this;
}
	
	public GST_Payment_SimulatorPage fillCredentials(String userid,String pwd,String groupid){
		enterByXpathExplict(prop.getProperty("enter.userid.xpath"), userid);
		enterByXpathExplict(prop.getProperty("enter.useridpwd.xpath"),pwd);
		enterByXpathExplict(prop.getProperty("enter.useridgroup.xpath"),groupid);
		
		clickByXpathExplict(prop.getProperty("click.login.id.xpath"));
		
		return this;
	}
	
	
	public LogoutPages SubmitGSTForm(String company, String Branch,String acc) throws InterruptedException{
		
		
		
		selectVisibileTextByXPath(prop.getProperty("select.gst.company"), company);
		selectVisibileTextByXPath(prop.getProperty("select.gst.branch"), Branch);
		selectVisibileTextByXPath(prop.getProperty("select.gst.acc"), acc);
		clickByXpathExplict(prop.getProperty("click.gst.initiate"));
		clickByXpathExplict(prop.getProperty("click.epi.confirm"));
		
		return new  LogoutPages(driver, test);
	}
	
	
	
	
	
			
	

	


	
	
}
