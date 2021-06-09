package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Transaction_Level_Auth_Pages extends ProjectWrapp{
	public   Transaction_Level_Auth_Pages(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public Transaction_Level_Auth_Pages 
	authorize_CheckStatus_TLA(String Compname,String clientcode,String accno,String uploadtype,String paytype) throws InterruptedException{
		String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')])[2]//following::span[13]");

		if(status.equalsIgnoreCase("A")){

			
			new Transaction_Level_Auth_Pages(driver, test)
			.clicktla_ConfirmRecord()
			.clickTLA_Link()
			.filter_TransLevelAuth_Record(Compname,"Confirmed",clientcode,accno,uploadtype,paytype)
			.clickTransNoSort()
			.getAuthStatus("C")
			.defaultcontent_Switch()

			.clickTLA_Link()
			.filter_TransLevelAuth_Record(Compname,"ALL",clientcode,accno,uploadtype,paytype)
			.clickTransNoSort()
			.getAuthStatus("C")
			.defaultcontent_Switch()
			
			.filter_TransLevelAuth_Record(Compname,"ALL", clientcode, accno,uploadtype, paytype)
			.clickTransNoSort()
			.getFinalStatus();

		
		
		
		}
		else if(status.equalsIgnoreCase("Z")||status.equalsIgnoreCase("J")){
			statusVerify(status);
		}
		
		
		else{
			getAuthStatus("C");
			//getFinalStatus();		
			
			
		}
		
		
		
		
	return this;	
		
	}


	
	public Transaction_Level_Auth_Pages filter_TransLevelAuth_Record(String compname,String status,String clientcode,String accno,String uploadtype,String paytype) throws InterruptedException{
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.translevel.company.xpath"),compname);
		selectVisibileTextByXPath(prop.getProperty("trans.selectstatus.xpath"),status);
		selectVisibileTextByXPath(prop.getProperty("select.trans.clientcode.xpath"),clientcode);
		selectVisibileTextByXPath(prop.getProperty("select.tla.acc.no.xpath"),accno);
		
		selectVisibileTextByXPath(prop.getProperty("select.filename.tla.xpath"),uploadtype);
		
		
		selectVisibileTextByXPath(prop.getProperty("select.tla.paytype.xpath"),paytype);
Thread.sleep(8000);		
//		defaultcontent();
		clickByXpathExplict(prop.getProperty("click.fla.view.xpath"));
		
		
		return this;
			}
	
	public Transaction_Level_Auth_Pages getAuthStatus(String verifyStatus) throws InterruptedException{	
scrolltoelementJs("(.//input[contains(@value,'"+getrefnumer+"')])[2]//following::span[13]");
		String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')])[2]//following::span[13]");
		if(status.equalsIgnoreCase(verifyStatus)){
			statusVerify(status);
		}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("C")||status.equalsIgnoreCase("Z")||status.equalsIgnoreCase("J")){
			statusVerify(status);
		}


		else{
			reportStep(status+ "Status has been displaying" ,"WARN");
		}
		return this;

		}
		
	
	public Transaction_Level_Auth_Pages getftlaAuthStatus(String Filename,String verifyStatus) throws InterruptedException{	

		pageScroll1400("(.//input[contains(@onclick,'"+Filename+"')])[1]//following::span[13]");
		String status=getTextByXpath("(.//input[contains(@onclick,'"+Filename+"')])[1]//following::span[13]");
		
		if(status.equalsIgnoreCase(verifyStatus)){
			statusVerify(status);
		}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("C")||status.equalsIgnoreCase("Z")||status.equalsIgnoreCase("J")){
			statusVerify(status);
		}


		else{
			reportStep(status+ "Status has been displaying" ,"WARN");
		}
		return this;

		}

	

	public Transaction_Level_Auth_Pages AuthorizeFTLAStatus(String renamedfilename, String Compname,String clientcode,String accno,String paytype, String uploadtype) throws InterruptedException{	

		pageScroll1400("(.//input[contains(@onclick,'"+renamedfilename+"')])[1]//following::span[13]");
		String status=getTextByXpath("(.//input[contains(@onclick,'"+renamedfilename+"')])[1]//following::span[13]");
		
		if(status.contains("A")){
		//new Transaction_Level_Auth_Pages(driver,test);
			clickFtla_ConfirmRecord()
			.clickTLA_Link()
			.filter_TransLevelAuth_Record(Compname,"Confirmed",clientcode,accno,renamedfilename,paytype)
			.clickTransNoSort()
			.getftlaAuthStatus(uploadtype,"C")
			.defaultcontent_Switch()

			.clickTLA_Link()
			.filter_TransLevelAuth_Record(Compname,"ALL",clientcode,accno,renamedfilename,paytype)
			.clickTransNoSort()
			.getftlaAuthStatus(uploadtype,"C")

			.defaultcontent_Switch()

			.filter_TransLevelAuth_Record(Compname,"ALL", clientcode, accno,renamedfilename, paytype)
			.clickTransNoSort()
			.getFTLAFinalStatus(uploadtype);
		}
		else if(status.equalsIgnoreCase("Z")||status.equalsIgnoreCase("J")){
			statusVerify(status);
		}
		
		
		else{
			getFTLAFinalStatus(uploadtype);
			reportStep(status+ "Status has been displaying" ,"WARN");
		}
		return this;

		}
	
	
	
	
	public Transaction_Level_Auth_Pages defaultcontent_Switch() throws InterruptedException{	
defaultcontent();
		return this;

		}

	
	public Transaction_Level_Auth_Pages getFinalStatus() throws InterruptedException{	
		Thread.sleep(15000);
		scrolltoelementJs("(.//input[contains(@value,'"+getrefnumer+"')])[2]//following::span[13]");
		String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')])[2]//following::span[13]");
		
//		(.//input[contains(@value,'"+getrefnumer+"')])[2]//following::span[13]
		if(status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("C")||status.equalsIgnoreCase("Z")||status.equalsIgnoreCase("J")){
			statusVerify(status);
		}

		else{
			reportStep(status+ " Status has been displaying" ,"FAIL");
		}
		return this;

		}
	
	public Transaction_Level_Auth_Pages getFTLAFinalStatus(String filename) throws InterruptedException{	
		Thread.sleep(10000);
		
		pageScroll1400("(.//input[contains(@onclick,'"+filename+"')])[1]//following::span[13]");
		String status=getTextByXpath("(.//input[contains(@onclick,'"+filename+"')])[1]//following::span[13]");
		
//		(.//input[contains(@value,'"+getrefnumer+"')])[2]//following::span[13]
		if(status.contains("UP")||status.contains("U")||status.contains("C")){
			reportStep(status+ " Status has been displaying" ,"PASS");
		}

		else{
			reportStep(status+ " Status has been displaying" ,"FAIL");
		}
		return this;

		}
	
	public Transaction_Level_Auth_Pages clicktla_ConfirmRecord() throws InterruptedException{
		//Thread.sleep(20000);
		clickByXpathExplict(".//input[contains(@onclick,'"+getrefnumer+"')]");
		clickByXpathExplictWithouScreenShot(prop.getProperty("click.fla.confirm.button.xpath"));
		Thread.sleep(4000);
		acceptAlert();
	defaultcontent();
	return this;
		}
	

	
	
		

	public Transaction_Level_Auth_Pages clickFtla_ConfirmRecord() throws InterruptedException{
		Thread.sleep(2000);

		clickByXpathExplict(prop.getProperty("click.FTLA.checkbox.xpath"));
		clickByXpathExplictWithouScreenShot(prop.getProperty("click.fla.confirm.button.xpath"));
		Thread.sleep(4000);
		acceptAlert();
	defaultcontent();
	return this;
		}
	
	public Transaction_Level_Auth_Pages clickTransNoSort(){
		clickByXpathExplict(prop.getProperty("click.trans.link.tla.xpath"));
		clickByXpathExplict(prop.getProperty("click.trans.link.tla.xpath"));
		
	
	
	return this;
}
	public Transaction_Level_Auth_Pages authorizeTlaRecord(String otp) throws InterruptedException{
		
		
		
		clickByXpathExplict("(.//input[contains(@onclick,'"+getrefnumer+"')])[1]");
		clickByXpathExplictWithouScreenShot(prop.getProperty("click.authorize.flapages.xpath"));
		Thread.sleep(6000);
		acceptAlert();
	clickByXpathExplict(prop.getProperty("click.authorize.flapages.xpath"));
	enterByXpathExplict(prop.getProperty("enter.tla.authpwd.xpath"),otp);	
	clickByXpathExplict(prop.getProperty("click.fla.auth.submit.xpath"));
	
	defaultcontent();
	
	
	

					return this;
}

	

	
public Transaction_Level_Auth_Pages authorizeFTlaRecord(String otp) throws InterruptedException{
		
	Thread.sleep(3000);
	clickByXpathExplict(prop.getProperty("click.FTLA.checkbox.xpath"));
		Thread.sleep(6000);
		acceptAlert();
	clickByXpathExplict(prop.getProperty("click.authorize.flapages.xpath"));
	enterByXpathExplict(prop.getProperty("enter.tla.authpwd.xpath"),otp);	
	clickByXpathExplict(prop.getProperty("click.fla.auth.submit.xpath"));
	
	defaultcontent();

					return this;
}
	
	public Transaction_Level_Auth_Pages clickTLA_AuthLink() throws InterruptedException{
		//Thread.sleep(20000);
		clickByXpathExplict(prop.getProperty("click.trans.level.auth.link.xpath"));
	
	
	return this;
	
	}

	public Transaction_Level_Auth_Pages clickTLA_Link() throws InterruptedException{
		//Thread.sleep(20000);
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.trans.level.auth.link.xpath"));
		defaultcontent();

	
	return this;
	
	}

	
	
	
}
