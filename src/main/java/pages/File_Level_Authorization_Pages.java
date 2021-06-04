package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class File_Level_Authorization_Pages extends ProjectWrapp{
	public   File_Level_Authorization_Pages(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public File_Level_Authorization_Pages filter_FileLevelAuth_Record(String clientcode,String transtype) throws InterruptedException{
		contentFrames();
		
		selectVisibileTextByXPath(prop.getProperty("select.clientcode.flapage.xpath"),clientcode);
		selectVisibileTextByXPath(prop.getProperty("select.paytype.fla.xpath"),transtype);
		Thread.sleep(20000);
			clickByXpathExplict(prop.getProperty("click.fla.view.xpath"));
		return this;
			}
	public File_Level_Authorization_Pages clickfilenameSort(){
		clickByXpathExplict(prop.getProperty("click.fla.authorize.filename.xpath"));
		clickByXpathExplict(prop.getProperty("click.fla.authorize.filename.xpath"));
		
		
	
	return this;
}

	
	
	
	
	
	public File_Level_Authorization_Pages authorizeflaRecord(String filename,String otp) throws InterruptedException{
	clickByXpathExplict("(.//input[contains(@onclick,'"+getrefnumer+"')])");
//	clickByXpathExplict(prop.getProperty("click.authorize.flapages.xpath"));
	clickByXpathExplictWithouScreenShot(prop.getProperty("click.authorize.flapages.xpath"));
	
	Thread.sleep(10000);
acceptAlert();
//	dismissAlert();
	
	enterByXpathExplict(prop.getProperty("enter.authorize.flapages.pwd.xpath"),otp);	
	clickByXpathExplict(prop.getProperty("click.fla.auth.submit.xpath"));
	

					return this;
}
	
	
	public File_Level_Authorization_Pages clickBackButton() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.back.button.fla.xpath"));
	defaultcontent();
	return this;
}
	
	
	
	public File_Level_Authorization_Pages clickFLA_AuthLink() throws InterruptedException{
		//Thread.sleep(20000);
		clickByXpathExplict(prop.getProperty("click.filelevel.auth.link.xpath"));
	
	
	return this;
	
	
	}

	public File_Level_Authorization_Pages clickFLA_Link() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.filelevel.auth.link.xpath"));
	defaultcontent();
	
	return this;
	
	}
	public File_Level_Authorization_Pages clickFla_ConfirmRecord(String filename) throws InterruptedException{
		//Thread.sleep(20000);
		
		clickByXpathExplict("(.//input[contains(@value,'"+getrefnumer+"')][contains(@onclick,'"+getrefnumer+"')])[1]");
		
//		clickByXpathExplict("(.//input[contains(@value,'"+getrefnumer+"')])[2]");
		clickByXpathExplict(prop.getProperty("click.fla.confirm.button.xpath"));
		
	
	return this;
		}
	
	
	public File_Level_Authorization_Pages clickSalary_ConfirmRecord(String filename) throws InterruptedException{
		//Thread.sleep(20000);
		clickByXpathExplict("(.//input[contains(@value,'"+getrefnumer+"')][@type='checkbox'])");
		clickByXpathExplict(prop.getProperty("click.fla.confirm.button.xpath"));
		
	
	return this;
		}
	
	
	
	
	
	
	
	public File_Level_Authorization_Pages defaultFlaLink() throws InterruptedException{
	defaultcontent();	
	
	return this;
		}
	
	public File_Level_Authorization_Pages getFinalStatus() throws InterruptedException{	
		Thread.sleep(20000);
		String status=getTextByXpath(".//input[contains(@onclick,'"+getrefnumer+"')]/following::span[7]");
		if(status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("C")){
			statusVerify(status);
		}
		else{
			reportStep(status+ "Status has been displaying" ,"FAIL");
		}
		return this;

		}

	public File_Level_Authorization_Pages getAuthStatus(String verifyStatus) throws InterruptedException{	

		String status=getTextByXpath(".//input[contains(@onclick,'"+getrefnumer+"')]/following::span[7]");
		if(status.equalsIgnoreCase(verifyStatus)){
			statusVerify(status);
		}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("C")){
			statusVerify(status);
		}


		else{
			reportStep(status+ "Status has been displaying" ,"WARN");
		}
		return this;

		}
	
	
	
	public File_Level_Authorization_Pages bulkAuth_Status(String renamedfilename,String clientcode,String transtype) throws InterruptedException{	

		String status=getTextByXpath(".//input[contains(@onclick,'"+getrefnumer+"')]/following::span[7]");
		if(status.equalsIgnoreCase("A")){
		   new File_Level_Authorization_Pages(driver, test)
			.clickSalary_ConfirmRecord(renamedfilename) 
			.defaultFlaLink()
	.clickFLA_Link()
			.filter_FileLevelAuth_Record(clientcode,transtype)
			.clickfilenameSort()		
			.getFinalStatus();

			
			
		}


		else{
			getAuthStatus("UP");
		}
		return this;

		}
	
	
	
	
	public File_Level_Authorization_Pages ifsc_Auth_Status(String renamedfilename,String clientcode,String transtype) throws InterruptedException{	

		String status=getTextByXpath(".//input[contains(@onclick,'"+getrefnumer+"')]/following::span[7]");
		if(status.equalsIgnoreCase("A")){
		new File_Level_Authorization_Pages(driver, test)
			.clickSalary_ConfirmRecord(renamedfilename)
//			.clickFla_ConfirmRecord(filename)
			.defaultFlaLink()


	.clickFLA_Link()
			.filter_FileLevelAuth_Record(clientcode,transtype)
			.clickfilenameSort()		
			.getFinalStatus();


			
		}
		else{
			getAuthStatus("UP");
		}
		return this;

		}
		
	
	public File_Level_Authorization_Pages authorize_CheckStatus_FLA(String filename,String clientcode,String transtype) throws InterruptedException{
		String status=getTextByXpath(".//input[contains(@onclick,'"+getrefnumer+"')]/following::span[7]");

//		String status=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
		if(status.equalsIgnoreCase("A")){
			clickFla_ConfirmRecord(filename)
			.defaultFlaLink()


			.clickFLA_Link()
			.filter_FileLevelAuth_Record(clientcode,transtype)
			.clickfilenameSort()		
			.getFinalStatus();

		}
		else{
			getAuthStatus("UP");
			//getFinalStatus();		
			
			
		}
		
		
		
	return this;	
		
	}


	
	
	
}
