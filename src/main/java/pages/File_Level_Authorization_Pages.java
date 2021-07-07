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
	
	

public File_Level_Authorization_Pages cash_getValuedate() throws InterruptedException{	
String Valuedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[11]");
reportStep("Reference number for Booking date and Value date "+getrefnumer,"PASS");
reportStep("Booking date before authorization"+Valuedate,"INFO");
return this;

}
public File_Level_Authorization_Pages cash_getGracedate(int d) throws InterruptedException{	

String Gracedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[12]");

reportStep("Reference number for Booking date and Grace date "+getrefnumer,"PASS");
reportStep("Booking date before authorization"+Gracedate,"INFO");

return this;

}

	
	
	

	public File_Level_Authorization_Pages cash_getBooking_Futuredate() throws InterruptedException{	

		String Bookingdate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[2]");
		
		String Futuredate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[3]");


		reportStep("Reference number for Booking date and Future date "+getrefnumer,"PASS");
		reportStep("Booking date before authorization"+Bookingdate,"INFO");

		reportStep("Value date before authorization with grace Period "+Futuredate+ "" ,"INFO");


		//////System.out.println(status);
		//if(Futuredate.equalsIgnoreCase(GetFuturedate(futuredate))){
		////
//			reportStep(Futuredate+ "Expected  Futuredate has been displaying" ,"PASS");
		//}
		//else{
//			reportStep(Bookingdate+ "Expected  Futuredate has  not been displaying" ,"FAIL");
		//}
		return this;

		}


	
	

	
	public File_Level_Authorization_Pages authorizeflaRecord_cash(String filenameonly,String otp) throws InterruptedException{
	clickByXpathExplict("(.//input[contains(@onclick,'"+filenameonly+"')])");
//	clickByXpathExplict(prop.getProperty("click.authorize.flapages.xpath"));
	clickByXpathExplictWithouScreenShot(prop.getProperty("click.authorize.flapages.xpath"));
	
	Thread.sleep(6000);
acceptAlert();
//	dismissAlert();
	
	enterByXpathExplict(prop.getProperty("enter.authorize.flapages.pwd.xpath"),otp);	
	clickByXpathExplict(prop.getProperty("click.fla.auth.submit.xpath"));
	//Thread.sleep(5000);
	//acceptAlert();

					return this;
}

	
	
	
	public File_Level_Authorization_Pages authorizeflaRecord(String filename,String otp) throws InterruptedException{
	clickByXpathExplict("(.//input[contains(@onclick,'"+getrefnumer+"')])");
//	clickByXpathExplict(prop.getProperty("click.authorize.flapages.xpath"));
	clickByXpathExplictWithouScreenShot(prop.getProperty("click.authorize.flapages.xpath"));
	
	Thread.sleep(6000);
acceptAlert();
//	dismissAlert();
	
	enterByXpathExplict(prop.getProperty("enter.authorize.flapages.pwd.xpath"),otp);	
	clickByXpathExplict(prop.getProperty("click.fla.auth.submit.xpath"));
	//Thread.sleep(5000);
	//acceptAlert();

					return this;
}
	
	
	public File_Level_Authorization_Pages getValuedate() throws InterruptedException{	
		String Valuedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[2]");
		reportStep("Reference number for upload date and Value date "+getrefnumer,"PASS");
		reportStep("Upload date before authorization"+Valuedate,"INFO");
		return this;

		}








		public File_Level_Authorization_Pages getGracedate(int d) throws InterruptedException{	

		String Gracedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[3]");

		reportStep("Reference number for Booking date and Grace date "+getrefnumer,"PASS");
		reportStep("Grace date before authorization"+Gracedate,"INFO");
		
		
//		if(Gracedate.equalsIgnoreCase(GetFuturedate(d)))
//		{
//			reportStep("Grace date has been matching"+Gracedate,"INFO");
//				
//		}{
//			reportStep("Grace date has not been matching"+Gracedate,"FAIL");
//			
//		}

		return this;

		}

		public File_Level_Authorization_Pages getHolidaydate(int d) throws InterruptedException{	

		String Gracedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[3]");

		reportStep("Reference number for Booking date and Grace date "+getrefnumer,"PASS");
		reportStep("Holidaydate before authorization"+Gracedate,"INFO");
		
		
//		if(Gracedate.equalsIgnoreCase(GetFuturedate(d)))
//		{
//			reportStep("Grace date has been matching"+Gracedate,"INFO");
//				
//		}{
//			reportStep("Grace date has not been matching"+Gracedate,"FAIL");
//			
//		}

		return this;

		}

		
		

		public File_Level_Authorization_Pages getGrace_currentdate(int d) throws InterruptedException{	

			String Gracedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[3]");

			reportStep("Reference number for Booking date and Grace date "+getrefnumer,"PASS");
			reportStep("Grace date before authorization"+Gracedate,"INFO");
			
			
//			if(Gracedate.equalsIgnoreCase(GetFuturedate(d)))
//			{
//				reportStep("Grace date has been matching"+Gracedate,"INFO");
//					
//			}{
//				reportStep("Grace date has not been matching"+Gracedate,"FAIL");
//				
//			}

			return this;

			}
	
		public File_Level_Authorization_Pages getHoliday_currentdate(int d) throws InterruptedException{	

			String Gracedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[3]");

			reportStep("Reference number for Booking date and Grace date "+getrefnumer,"PASS");
			reportStep("Grace date before authorization"+Gracedate,"INFO");
			
			
		if(Gracedate.equalsIgnoreCase(GetFuturedate(d+1)))
			{
				reportStep("Grace date has been matching"+Gracedate,"INFO");
					
			}{
				reportStep("Grace date has not been matching"+Gracedate,"FAIL");
				
			}

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
	

	
	public File_Level_Authorization_Pages clickFla_ConfirmRecord_cash(String filename) throws InterruptedException{
		//Thread.sleep(20000);
		
		clickByXpathExplict("(.//input[contains(@value,'"+filename+"')][contains(@onclick,'"+getrefnumer+"')])[1]");
		
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

	
	public File_Level_Authorization_Pages getFinalStatus_cash(String filename) throws InterruptedException{	
		Thread.sleep(20000);
		String status=getTextByXpath(".//input[contains(@onclick,'"+filename+"')]/following::span[7]");
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
		}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("C")||status.equalsIgnoreCase("Q")){
			statusVerify(status);
		}


		else{
			reportStep(status+ "Status has been displaying" ,"WARN");
		}
		return this;

		}
	public File_Level_Authorization_Pages getAuthStatus_cash(String verifyStatus,String filenameonly) throws InterruptedException{	

		String status=getTextByXpath(".//input[contains(@onclick,'"+filenameonly+"')]/following::span[7]");
		if(status.equalsIgnoreCase(verifyStatus)){
			statusVerify(status);
		}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("C")||status.equalsIgnoreCase("Q")){
			statusVerify(status);
		}


		else{
			reportStep(status+ "Status has been displaying" ,"WARN");
		}
		return this;

		}
	
	
	
	public File_Level_Authorization_Pages getAuthStatus_file(String verifyStatus,String filename) throws InterruptedException{	

		String status=getTextByXpath(".//input[contains(@onclick,'"+filename+"')]/following::span[7]");
		if(status.equalsIgnoreCase(verifyStatus)){
			statusVerify(status);
		}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("C")||status.equalsIgnoreCase("Q")){
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


	public File_Level_Authorization_Pages cash_getBooked_Futuredate() throws InterruptedException{	

		String Bookingdate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[2]");

		String Futudate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[3]");


		reportStep("Booking date after authorization "+Bookingdate,"PASS");

		reportStep("Value date after authorization "+Futudate,"PASS");



		if(Futudate.equalsIgnoreCase(GetFuturedate(0))){

			reportStep(Futudate+ "Expected  Future date has been displaying" ,"PASS");
		}
		else{
			reportStep(Futudate+ "Expected  Future date has  not been displaying" ,"FAIL");
		}
		return this;

		}

	
	
	public File_Level_Authorization_Pages authorize_CheckStatus_FLA_cash(String filename,String clientcode,String transtype) throws InterruptedException{
		String status=getTextByXpath(".//input[contains(@onclick,'"+filename+"')]/following::span[7]");

//		String status=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
		if(status.equalsIgnoreCase("A")){
			clickFla_ConfirmRecord_cash(filename)
			.defaultFlaLink()


			.clickFLA_Link()
			.filter_FileLevelAuth_Record(clientcode,transtype)
			.clickfilenameSort()		
			.getFinalStatus_cash(filename);

		}
		else{
			getAuthStatus_cash("UP",filename);
			//getFinalStatus();		
			
			
		}
		
		
		
	return this;	
		
	}


	
	
	
}
