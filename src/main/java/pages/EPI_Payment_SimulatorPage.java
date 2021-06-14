package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class EPI_Payment_SimulatorPage extends ProjectWrapp{
	public   EPI_Payment_SimulatorPage (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public EPI_Payment_SimulatorPage FillEPISimulator(String MerchantNo, String date){
	
		String Merno= regvalue(MerchantNo);
		 
		enterByXpathExplict(prop.getProperty("enter.epi.simu.merchantNo"), Merno+gettwoRandomNumber_range_String(100,999));
		enterByXpathExplict(prop.getProperty("enter.epi.simu.date.xpath"), GetTodayFoematDate()+" "+"12:30:45");
		clickByXpathExplict(prop.getProperty("click.epi.submit.xpath"));
		
	return this;
}
	
	public EPI_Payment_SimulatorPage FillEPIFutureSimulator(String MerchantNo, String date){
		
		 
		enterByXpathExplict(prop.getProperty("enter.epi.simu.merchantNo"), MerchantNo+gettwoRandomNumberString());
		enterByXpathExplict(prop.getProperty("enter.epi.simu.date.xpath"), GetFuturedate(futuredate)+" "+"12:30:45");
		clickByXpathExplict(prop.getProperty("click.epi.submit.xpath"));
		
	return this;
}
	
	public EPI_Payment_SimulatorPage FillEPIPCSSimulator(String MerchantNo){
		
		 
		enterByXpathExplict(prop.getProperty("enter.epipcs.merchantno.xpath"), MerchantNo+getRandomNumberString());
		
		clickByXpathExplict(prop.getProperty("click.epi.submit.xpath"));
		
	return this;
}
	
	
	public EPI_Payment_SimulatorPage fillCredentials(String userid,String pwd,String groupid){
		enterByXpathExplict(prop.getProperty("enter.userid.xpath"), userid);
		enterByXpathExplict(prop.getProperty("enter.useridpwd.xpath"),pwd);
		enterByXpathExplict(prop.getProperty("enter.useridgroup.xpath"),groupid);
		
		clickByXpathExplict(prop.getProperty("click.login.id.xpath"));
		
		return this;
	}
	
	
	public LogoutPages SubmitEPIForm(String company, String Branch,String acc,String amount ) throws InterruptedException{
		
		contentFrames();
		
		selectVisibileTextByXPath(prop.getProperty("select.epi.company"), company);
		selectVisibileTextByXPath(prop.getProperty("select.epi.branch"), Branch);
		selectVisibileTextByXPath(prop.getProperty("select.epi.account"), acc);
		//enterByXpathExplict(prop.getProperty("enter.epi.amount.xpath"),amount);
	
		clickByXpathExplict(prop.getProperty("click.epi.verify.xpath"));
		clickByXpathExplict(prop.getProperty("click.epi.confirm"));
		defaultcontent();
		
		return new  LogoutPages(driver, test);
	}
	
	

	
public LogoutPages SubmitEPIpcsForm(String company, String Branch,String acc) throws InterruptedException{
		
		contentFrames();
		
		selectVisibileTextByXPath(prop.getProperty("select.epi.company"), company);
		selectVisibileTextByXPath(prop.getProperty("select.epi.branch"), Branch);
		selectVisibileTextByXPath(prop.getProperty("select.epi.account"), acc);
		//enterByXpathExplict(prop.getProperty("enter.epi.amount.xpath"),amount);
	
		//clickByXpathExplict(prop.getProperty("click.epi.verify.xpath"));
		clickByXpathExplict(prop.getProperty("click.epi.confirm"));
		
		verifyElementpresentByXpathExplicitwait(prop.getProperty("verify.epipcs.success.xpath"));
		defaultcontent();
		
		return new  LogoutPages(driver, test);
	}
	
			
	

	


	
	
}
