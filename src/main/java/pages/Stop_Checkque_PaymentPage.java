package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Stop_Checkque_PaymentPage  extends ProjectWrapp{
	public   Stop_Checkque_PaymentPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	
	
	
	public Stop_Checkque_PaymentPage clickstopcheque_serviceslink() throws InterruptedException{
		LeftMenuFrames();
	clickByXpathExplict(prop.getProperty("click.stopcheckque.xpath"));

	return this;
}		
	
	public Stop_Checkque_PaymentPage clickstopcheque_Authorizeserviceslink(){
		
	clickByXpathExplict(prop.getProperty("click.stop.authorize.link.xpath"));
defaultcontent();
	return this;
}		
	
	
	
	public Stop_Checkque_PaymentPage Authorizeservices_form(String comp,String branch,String accno,String otp) throws InterruptedException{
		contentFrames();
enterByXpathExplict(prop.getProperty("enter.stoprefno.xpath"),getrefnumer);		
		

		

				selectVisibileTextByXPath(prop.getProperty("auth.cmcomp.xpath"),comp);



				selectVisibileTextByXPath(prop.getProperty("auth.cmbranch.xpath"),branch);
				selectVisibileTextByXPath(prop.getProperty("auth.cmbacc.xpath"),accno);


				clickByXpathExplict(prop.getProperty("click.stopchq.search.xpath"));
				clickByXpathExplict(".//input[contains(@onclick,'"+getrefnumer+"')]");

			//	clickByXpathExplict(".//input[contains(@onclick,"+getrefnumer+")]/following::td[6]");

				clickByXpathExplict(prop.getProperty("click.auth.button.stopchq.xpath"));

String a=regvalue(otp);
				enterByXpathExplict(prop.getProperty("enter.authpwd.stop.chq.xpath"),a);		
				clickByXpathExplict(prop.getProperty("click.auth.submit.stopchq.xpath"));

defaultcontent();		
	return this;
}		
	
	
	
	
	public Stop_Checkque_PaymentPage verify_stopcheque_new_link(String comp,String branch,String accno) throws InterruptedException{	
LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.view.submit.stopchq.xpath"));
	
		defaultcontent();
		contentFrames();
		enterByXpathExplict(prop.getProperty("enter.stoprefno.xpath"),getrefnumer);		
	


		selectVisibileTextByXPath(prop.getProperty("auth.cmcomp.xpath"),comp);



		selectVisibileTextByXPath(prop.getProperty("auth.cmbranch.xpath"),branch);
		selectVisibileTextByXPath(prop.getProperty("auth.cmbacc.xpath"),accno);

//		click.view.submit.stopchq.xpath
		
			clickByXpathExplict(prop.getProperty("filter.view.services.xpath"));
		//	clickByXpathExplict(prop.getProperty("click.stopchq.record.xpath"));

			String status=getTextByXpath("(.//input[@value='"+getrefnumer+"'])[2]//following::td[6]/span");
			//		clickByXpathExplict(prop.getProperty("click.auth.button.stopchq.xpath"));

if(status.contains("UDP")){
	
	reportStep(status+"has been displaying","WARN");
}else{
	reportStep(status+"has not been displaying","FAIL");
}

			defaultcontent();
			return this;
		}		







	
	


	
	
	public Stop_Checkque_PaymentPage clickstopcheque_new_link(){
		
	clickByXpathExplict(prop.getProperty("click.stop.new.cheque.xpath"));
	//contentFrames();
	defaultcontent();
	return this;
}		
		
	
	public Stop_Checkque_PaymentPage fillcheque(String company,String branch,String accno,String fromchq,String tochq,String chqreason) throws InterruptedException{
		
		contentFrames();

		
		
		selectVisibileTextByXPath(prop.getProperty("Select.acctotacc.comp.xpath"),company);



		selectVisibileTextByXPath(prop.getProperty("Select.acctotacc.compbranch.xpath"),branch);
		selectVisibileTextByXPath(prop.getProperty("Select.acctotacc.accnno.comp.xpath"),accno);

		
		enterByXpathExplict(prop.getProperty("fromchq.xpath"),fromchq);
		Thread.sleep(1000);
String a=regvalue(tochq);
		
		
		enterByXpathExplict(prop.getProperty("tochq.xpath"),a);
		
		enterByXpathExplict(prop.getProperty("stop.reason.enter.xpath"),chqreason);
		
		clickByXpathExplict(prop.getProperty("click.stop.chq.submit.xpath"));
		
		
		
		String refnum=getTextByXpath(prop.getProperty("stop.chque.submit.msg.xpath"));
		
		getrefnumer=refnum.substring(0,12);
		
		System.out.println(getrefnumer);
		
		
		//SCP100044451--Dear  CORPIN01, your request has been accepted and pending for authorization

		defaultcontent();
		return this;
	}		
		
	
				

	
	
	
	
	
}
