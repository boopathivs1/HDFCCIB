package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class Authorize_page extends ProjectWrapp{
	public Authorize_page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	public Authorize_page clickAuthorize() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.authorize.link.xpath"));
		
		
		defaultcontent();
		return this;
	}
	
	public Authorize_page clickChequebookAuthorize() throws InterruptedException{
		
		
		clickByXpathExplict(prop.getProperty("click.checquebook.Authorize"));
		defaultcontent();
		
		return this;

	}
	

	public Authorize_page clickBillpayView() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.span.view.xpath"));
	
		
		return this;
	
	}
	
	public Authorize_page contentFrame() throws InterruptedException{
	contentFrames();
	
	return this;
}
	
	public Authorize_page fillChequeAuthorizeReqform(String company,String branch,String acc) throws InterruptedException{
		
		
		selectVisibileTextByXPath(prop.getProperty("select.company.dropdown.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.acc.dropdown.xpath"),acc);

		
		clickByXpathExplict(prop.getProperty("click.chequebook.search.xpath"));
		
		
		return this;
	}
	
	
public Authorize_page GetFinalStatus() throws InterruptedException{
		

	String status=getTextByXpath(".//input[@value='"+getrefnumer+"']//following::td[4]");
	//		clickByXpathExplict(prop.getProperty("click.auth.button.stopchq.xpath"));

if(status.contains("PCD")){

reportStep(status+"has been displaying","PASS");

}else if(status.contains("UDP"))
{
reportStep(status+"has not been displaying","WARN");
}
else
{
	reportStep(status+"has not been displaying","FAIL");
}

	
	return this;
}		
	

public Authorize_page AuthIFrame() throws InterruptedException{
		locateFrameByXpath(".//iframe[@id='iframe']");
		
		return this;
	}

	public Authorize_page clickFDAuthorize() throws InterruptedException{
	
		clickByXpathExplict(prop.getProperty("click.FD.Authorize"));
		defaultcontent();
		return this;
	}
	
	
	public Authorize_page clickWCDLAuthorize() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.WCDL.authorise"));
		defaultcontent();
		return this;
	}
	
	public Authorize_page authrecordFrame() throws InterruptedException{
	authrecFrames();
	return this;
}
	public Authorize_page Clickback() throws InterruptedException{
		
		Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("click.back.xpath"));
		
		defaultcontent();
		
		return this;
	}
	
public Authorize_page ClickChequeReview() throws InterruptedException{
		
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.cheque.review.xpath"));
		
		defaultcontent();
		
		return this;
	}


	
	
	public Authorize_page ClickWCDLReport() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.WCDL.report"));
		
		defaultcontent();
		
		return this;
	}
	
	
	public Authorize_page ClickFDReview() throws InterruptedException{
		
		LeftMenuFrames();
		Thread.sleep(10000);
		clickByXpathExplict(prop.getProperty("click.FD.review"));
		Thread.sleep(5000);
		clickByXpathExplict(prop.getProperty("click.FD.review"));
		
		defaultcontent();
		return this;
	}
	
	public Authorize_page filterAuthorize(String compid,String SelectStatus,String Paytype) throws InterruptedException{
	
System.out.println(Paytype+" value");
selectVisibileTextByXPath(prop.getProperty("click.authorize.compid.xpath"),compid);
selectVisibileTextByXPath(prop.getProperty("auth.selectstatus.xpath"),SelectStatus);
selectVisibileTextByXPath(prop.getProperty("auth.paytype.xpath"),Paytype);


		
		return this;
	}
	
	
	public Authorize_page filterAuthorize_entervalue_Date(String compid,String SelectStatus,String Paytype) throws InterruptedException{
		
		System.out.println(Paytype+" value");
		selectVisibileTextByXPath(prop.getProperty("click.authorize.compid.xpath"),compid);
		selectVisibileTextByXPath(prop.getProperty("auth.selectstatus.xpath"),SelectStatus);
		selectVisibileTextByXPath(prop.getProperty("auth.paytype.xpath"),Paytype);


		



		clickByXpathExplict_clear(prop.getProperty("enter.future.value.date.xpath"));	
		
		Thread.sleep(7000);
		acceptAlert();
		
		enterByXpathExplict_noclear(prop.getProperty("enter.future.value.date.xpath"),GetFuturedate(futuredate));
		
		Thread.sleep(2000);

		clickByXpathExplict(prop.getProperty("enter.future.value.date.xpath"));	

enterByXpathExplict_noclear(prop.getProperty("enter.future.value.date.xpath"),GetFuturedate(futuredate));

				
				return this;
			}

	
	
	
	public Authorize_page filterAuthorize_entervalue_Date_cbec(String compid,String SelectStatus,String Paytype) throws InterruptedException{
		
		System.out.println(Paytype+" value");
		selectVisibileTextByXPath(prop.getProperty("click.authorize.compid.xpath"),compid);
		selectVisibileTextByXPath(prop.getProperty("auth.selectstatus.xpath"),SelectStatus);
		selectVisibileTextByXPath(prop.getProperty("auth.paytype.xpath"),Paytype);


		



		clickByXpathExplict_clear(prop.getProperty("enter.future.value.date.xpath"));	
		
		Thread.sleep(7000);
		acceptAlert();
		
		enterByXpathExplict_noclear(prop.getProperty("enter.future.value.date.xpath"),GetFuturedate(14));
		
		Thread.sleep(2000);

		clickByXpathExplict(prop.getProperty("enter.future.value.date.xpath"));	

enterByXpathExplict_noclear(prop.getProperty("enter.future.value.date.xpath"),GetFuturedate(14));

				
				return this;
			}
			

	public Authorize_page filterBilpayAuthorize(String Selectstatus,String name) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.bill.status.xpath"),Selectstatus);
		selectVisibileTextByXPath(prop.getProperty("select.bill.name.xpath"),name);
	
				return this;
			}

	
public Authorize_page clickViewLink() throws InterruptedException{	
	Thread.sleep(6000);
	clickByXpathExplict(prop.getProperty("click.authorize.view.link.xpath"));
	Thread.sleep(10000);
	//defaultcontent();
	return this;

}


public Authorize_page clickWCDLViewLink() throws InterruptedException{	
	Thread.sleep(6000);
	contentFrame();
	clickByXpathExplict(prop.getProperty("click.authorize.view.link.xpath"));
	Thread.sleep(10000);
	clickByXpathExplict(prop.getProperty("click.authorize.view.link.xpath"));
	
	//defaultcontent();
	return this;

}

public Authorize_page clickWCViewLink() throws InterruptedException{	
	Thread.sleep(6000);
	clickByXpathExplict(prop.getProperty("click.authorize.view.link.xpath"));
	Thread.sleep(10000);
	clickByXpathExplict(prop.getProperty("click.authorize.view.link.xpath"));
	
	//defaultcontent();
	return this;

}




public Authorize_page clickreflink(){	
	
clickByXpathExplict(prop.getProperty("click.authorize.refnum.link.xpath"));
	return this;

}

public Authorize_page clickfirstAuthRec(){	
	
	clickByXpathExplict(".//input[contains(@onclick,'"+getrefnumer+"')]");
//clickByXpathExplict(prop.getProperty("select.auth.recone.xpath"));
	return this;

}

public Authorize_page clickChequebookAuthRec(){	
	
	clickByXpathExplict(".//td//input[@value='"+getrefnumer+"']");
//clickByXpathExplict(prop.getProperty("select.auth.recone.xpath"));
	return this;

}

public Authorize_page clickEPIPCSfirstAuthRec(String paytye){	
	
	clickByXpathExplict(".//input[contains(@onclick,'"+paytye+"')]");
//clickByXpathExplict(prop.getProperty("select.auth.recone.xpath"));
	return this;

}


public Authorize_page clickBillpayfirstAuthRec(){	
	
	clickByXpathExplict(".//td//input[contains(@value,'"+getrefnumer+"')]");
//clickByXpathExplict(prop.getProperty("select.auth.recone.xpath"));
	return this;

}

public Authorize_page clickAuthVerify(){	
	
	scrolltoelementJs(prop.getProperty("click.Onscreen.verify.xpath"));
	clickByXpathExplict(prop.getProperty("click.Onscreen.verify.xpath"));
//clickByXpathExplict(prop.getProperty("select.auth.recone.xpath"));
	return this;

}

public Authorize_page getAuthVerifyStatus(String verifyStatus) throws InterruptedException{	

	String status=getTextByXpath(".//input[contains(@onclick,'"+getrefnumer+"')]/following::span[9]");
	if(status.equalsIgnoreCase(verifyStatus)){
		statusVerify(status);
	}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("P")||status.equalsIgnoreCase("Q")){
		statusVerify(status);
	}


	else{
		reportStep(status+ "Status has been displaying" ,"WARN");
	}
	return this;

	}


public Authorize_page getGSTAuthVerifyStatus(String verifyStatus,String Paytype) throws InterruptedException{	

	String status=getTextByXpath(".//input[contains(@onclick,'"+Paytype+"')]/following::span[9]");
	if(status.equalsIgnoreCase(verifyStatus)){
		statusVerify(status);
	}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("P")){
		statusVerify(status);
	}


	else{
		reportStep(status+ "Status has been displaying" ,"WARN");
	}
	return this;

	}


public Authorize_page getAuthEPIPCSVerifyStatus(String verifyStatus,String Paytype) throws InterruptedException{	

	String status=getTextByXpath(".//input[contains(@onclick,'"+Paytype+"')]/following::span[9]");
	if(status.equalsIgnoreCase(verifyStatus)){
		statusVerify(status);
	}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("P")||status.equalsIgnoreCase("Q")){
		statusVerify(status);
	}


	else{
		reportStep(status+ "Status has been displaying" ,"WARN");
	}
	return this;

	}

public Authorize_page CheckVerifyStatus() throws InterruptedException{	

	String status=getTextByXpath(".//input[contains(@onclick,'"+getrefnumer+"')]/following::span[9]");
	if(status.contains("VP")){
		reportStep(status+"Status has been dispalying","PASS");
		clickAuthVerify();	
	}
	
	return this;

	}


public Authorize_page CheckGSTVerifyStatus(String paytype) throws InterruptedException{	

	String status=getTextByXpath(".//input[contains(@onclick,'"+paytype+"')]/following::span[9]");
	if(status.contains("VP")){
		reportStep(status+"Status has been dispalying","PASS");
		clickAuthVerify();	
	}
	
	return this;

	}

public Authorize_page CheckEPIPCSVerifyStatus(String paytype) throws InterruptedException{	

	String status=getTextByXpath(".//input[contains(@onclick,'"+paytype+"')]/following::span[9]");
	if(status.contains("VP")){
		reportStep(status+"Status has been dispalying","PASS");
		clickAuthVerify();	
	}
	
	return this;

	}



public Authorize_page clickfirstFDAuthRec(){	
	
	clickByXpathExplict(".//input[contains(@value,'"+getrefnumer+"')])[1]");
//clickByXpathExplict(prop.getProperty("select.auth.recone.xpath"));
	return this;

}



public Authorize_page clickSimulatorAuthRec(String paymenttype){	
	
	
	clickByXpathExplict("(.//input[contains(@onclick,'"+paymenttype+"')])[1]");
//clickByXpathExplict(prop.getProperty("select.auth.recone.xpath"));
	return this;

}




public Authorize_page clickrecord(){	
	
	clickByXpathExplict(prop.getProperty("click.authrecord.xpath"));

	return this;

}

public Authorize_page submitPwd(String pwd) throws InterruptedException{	
	
	
//	driver.findElement(By.xpath(".//span[text()='Password']")).click();

	clickByXpathExplict(prop.getProperty("click.authpwd.xpath"));

	Thread.sleep(7000);
	acceptAlert();
	Thread.sleep(3000);
	
	scrolltoelementJs(prop.getProperty("enter.authpwd.xpath"));
	
	enterByXpathExplict(prop.getProperty("enter.authpwd.xpath"),pwd);	

clickByXpathExplict(prop.getProperty("click.authsubmit.xpath"));




defaultcontent();

	return this;

}


public Authorize_page AuthorizePwd(String pwd) throws InterruptedException{	
	
	
//	driver.findElement(By.xpath(".//span[text()='Password']")).click();

	clickByXpathExplict(prop.getProperty("click.FD>authorize"));
Thread.sleep(4000);
	
	enterByXpathExplict(prop.getProperty("enter.authpwd.xpath"),pwd);	

clickByXpathExplict(prop.getProperty("click.authsubmit.xpath"));

defaultcontent();

	return this;

}
public Authorize_page AuthorizeCheqReq(String pwd) throws InterruptedException{	
	
	
//	driver.findElement(By.xpath(".//span[text()='Password']")).click();

	clickByXpathExplict(prop.getProperty("click.authorize.cheqre.xpath"));
Thread.sleep(4000);
	
	enterByXpathExplict(prop.getProperty("enter.authpwd.xpath"),pwd);	

clickByXpathExplict(prop.getProperty("click.authsubmit.xpath"));

defaultcontent();

	return this;

}


public Authorize_page defaultcontents(){	

defaultcontent();

	return this;

}

public String getStatus(){
	String status=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
	
	
return status;	
	
}
public Authorize_page checkStatus() throws InterruptedException{
	String status=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
	
	if(status.equalsIgnoreCase("A")){
	//new Authorize_page(driver, test)		
//		.
		clickfirstAuthRec()
		.confirmRecord()
		.contentFrame()
		.clickViewLink()
		.authrecordFrame()
		.clickreflink()
		.getAuthVerifyStatus("UP")
		.defaultcontents()
		.contentFrame()		
		.clickViewLink()
		.authrecordFrame()
		.clickreflink()
		.getFinalStatus();		
	}
	else{
		getAuthVerifyStatus("UP");
		//getFinalStatus();		
			
		
	}
	return this;
		
	}

public Authorize_page checkEPIPCSStatus(String Paytype) throws InterruptedException{
	String status=getTextByXpath("(.//input[contains(@onclick,'"+Paytype+"')]//following::span)[9]");
	
	if(status.equalsIgnoreCase("A")){
	//new Authorize_page(driver, test)		
//		.
		clickEPIPCSfirstAuthRec(Paytype)
		.confirmRecord()
		.contentFrame()
		.clickViewLink()
		.authrecordFrame()
		.clickreflink()
		.getAuthEPIPCSVerifyStatus("UP",Paytype)
		.defaultcontents()
		.contentFrame()		
		.clickViewLink()
		.authrecordFrame()
		.clickreflink()
		.getEPIPCSFinalStatus(Paytype);		
	}
	else{
		getAuthEPIPCSVerifyStatus("UP",Paytype);
		//getFinalStatus();		
			
		
	}
	return this;
		
	}
	
	public Authorize_page checkBillpayStatus() throws InterruptedException{
		String status=getTextByXpath("(.//td//input[contains(@value,'"+getrefnumer+"')]//following::span)[6]");
		
		if(status.equalsIgnoreCase("A")){
		//new Authorize_page(driver, test)		
//			.
			clickBillpayfirstAuthRec()
			.confirmRecord()
			.contentFrame()
			.clickViewLink()
			//.authrecordFrame()
			//.clickreflink()
			.getBillpayAuthStatus("UP")
			.defaultcontents()
			.contentFrame()		
			.clickViewLink()
			//.authrecordFrame()
			//.clickreflink()
			.getBillpayFinalStatus();		
		}
		else{
			getBillpayAuthStatus("UP");
			//getFinalStatus();		
			
			
		}

return this;	
	
}




public Authorize_page checkGraceStatus() throws InterruptedException{
	String status=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
	if(status.equalsIgnoreCase("A")){
	//new Authorize_page(driver, test)		
//		.
		
		clickfirstAuthRec()
		.confirmRecord()
		.contentFrame()
		.clickViewLink()
		.authrecordFrame()
		.clickreflink()
		.getAuthStatus("UP")
		.defaultcontents()
		.contentFrame()		
		.clickViewLink()
		.authrecordFrame()
		.clickreflink()
		.getFinalStatus()
		.getAuthorizeddate();
		
		
	}
	else{
		getAuthStatus("UP")
		.getAuthorizeddate();
		
		//getFinalStatus();		
		
		
	}
	

return this;	
	
}



public Authorize_page getAuthStatus(String verifyStatus) throws InterruptedException{	

String status=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
//System.out.println(status);
if(status.equalsIgnoreCase(verifyStatus)){
	statusVerify(status);
}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("Q")){
	statusVerify(status);
}
else{
	reportStep(status+ "Status has been displaying" ,"WARN");
}
return this;

}


public Authorize_page getBillpayAuthStatus(String verifyStatus) throws InterruptedException{	

String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')]//following::span)[6]");
//System.out.println(status);
if(status.equalsIgnoreCase(verifyStatus)){
	statusVerify(status);
}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")||status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("Q")){
	statusVerify(status);
}
else{
	reportStep(status+ "Status has been displaying" ,"WARN");
}
return this;

}


public Authorize_page getValuedate() throws InterruptedException{	

String Valuedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[11]");


reportStep("Reference number for Booking date and Value date "+getrefnumer,"PASS");
reportStep("Booking date before authorization"+Valuedate,"INFO");
//System.out.println(status);
//if(Valuedate.equalsIgnoreCase(dateMonthSlash())){
//
//	reportStep(Valuedate+ "Expected Bookingdate has been displaying" ,"PASS");
//}
//else{
//	reportStep(Valuedate+ "Expected Bookingdate has  not been displaying" ,"FAIL");
//}
return this;

}

public Authorize_page getNoREfValuedate(String Paytype) throws InterruptedException{	

String Valuedate=getTextByXpath("(.//input[contains(@onclick,'"+Paytype+"')]//following::span)[11]");


reportStep("Reference number for Booking date and Value date "+Paytype,"PASS");
reportStep("Booking date before authorization"+Valuedate,"INFO");
//System.out.println(status);
//if(Valuedate.equalsIgnoreCase(dateMonthSlash())){
//
//	reportStep(Valuedate+ "Expected Bookingdate has been displaying" ,"PASS");
//}
//else{
//	reportStep(Valuedate+ "Expected Bookingdate has  not been displaying" ,"FAIL");
//}
return this;

}


public Authorize_page getGSTValuedate(String Paytype) throws InterruptedException{	

String Valuedate=getTextByXpath("(.//input[contains(@onclick,'"+Paytype+"')]//following::span)[11]");


reportStep("Reference number for Booking date and Value date "+Paytype,"PASS");
reportStep("Booking date before authorization"+Valuedate,"INFO");
//System.out.println(status);
//if(Valuedate.equalsIgnoreCase(dateMonthSlash())){
//
//	reportStep(Valuedate+ "Expected Bookingdate has been displaying" ,"PASS");
//}
//else{
//	reportStep(Valuedate+ "Expected Bookingdate has  not been displaying" ,"FAIL");
//}
return this;

}

public Authorize_page getGracedate(int d) throws InterruptedException{	

String Gracedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[12]");

reportStep("Reference number for Booking date and Grace date "+getrefnumer,"PASS");
reportStep("Booking date before authorization"+Gracedate,"INFO");

//System.out.println(status);
//if(Gracedate.equalsIgnoreCase(GetFuturedate(d))){
//
//	reportStep(Gracedate+ "Expected  Gracedate has been displaying" ,"PASS");
//}
//else{
//	reportStep(Gracedate+ "Expected  Gracedate has  not been displaying" ,"FAIL");
//}
return this;

}


public Authorize_page getGSTGracedate(String paytype) throws InterruptedException{	

String Gracedate=getTextByXpath("(.//input[contains(@onclick,'"+paytype+"')]//following::span)[12]");

reportStep("Reference number for Booking date and Grace date "+paytype,"PASS");
reportStep("Booking date before authorization"+Gracedate,"INFO");

//System.out.println(status);
//if(Gracedate.equalsIgnoreCase(GetFuturedate(d))){
//
//	reportStep(Gracedate+ "Expected  Gracedate has been displaying" ,"PASS");
//}
//else{
//	reportStep(Gracedate+ "Expected  Gracedate has  not been displaying" ,"FAIL");
//}
return this;

}


public Authorize_page getEPCSGracedate(String paytype) throws InterruptedException{	

String Gracedate=getTextByXpath("(.//input[contains(@onclick,'"+paytype+"')]//following::span)[12]");

reportStep("Reference number for Booking date and Grace date "+paytype,"PASS");
reportStep("Booking date before authorization"+Gracedate,"INFO");

//System.out.println(status);
//if(Gracedate.equalsIgnoreCase(GetFuturedate(d))){
//
//	reportStep(Gracedate+ "Expected  Gracedate has been displaying" ,"PASS");
//}
//else{
//	reportStep(Gracedate+ "Expected  Gracedate has  not been displaying" ,"FAIL");
//}
return this;

}


public Authorize_page getBooking_Futuredate() throws InterruptedException{	

String Bookingdate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[11]");

String Futuredate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[12]");


reportStep("Reference number for Booking date and Future date "+getrefnumer,"PASS");
reportStep("Booking date before authorization"+Bookingdate,"INFO");

reportStep("Value date before authorization with grace Period "+Futuredate+ "" ,"INFO");


//////System.out.println(status);
//if(Futuredate.equalsIgnoreCase(GetFuturedate(futuredate))){
////
//	reportStep(Futuredate+ "Expected  Futuredate has been displaying" ,"PASS");
//}
//else{
//	reportStep(Bookingdate+ "Expected  Futuredate has  not been displaying" ,"FAIL");
//}
return this;

}


public Authorize_page getNoREfBooking_Futuredate(String Paytype) throws InterruptedException{	

String Bookingdate=getTextByXpath("(.//input[contains(@onclick,'"+Paytype+"')]//following::span)[11]");

String Futuredate=getTextByXpath("(.//input[contains(@onclick,'"+Paytype+"')]//following::span)[12]");


reportStep("Reference number for Booking date and Future date "+Paytype,"PASS");
reportStep("Booking date before authorization"+Bookingdate,"INFO");

reportStep("Value date before authorization with grace Period "+Futuredate+ "" ,"INFO");


//////System.out.println(status);
//if(Futuredate.equalsIgnoreCase(GetFuturedate(futuredate))){
////
//	reportStep(Futuredate+ "Expected  Futuredate has been displaying" ,"PASS");
//}
//else{
//	reportStep(Bookingdate+ "Expected  Futuredate has  not been displaying" ,"FAIL");
//}
return this;

}
public Authorize_page getBooked_Futuredate() throws InterruptedException{	

String Bookingdate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[11]");

String Futudate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[12]");


reportStep("Booking date after authorization "+Bookingdate,"PASS");

reportStep("Value date after authorization "+Futudate,"PASS");



if(Futudate.equalsIgnoreCase(GetFuturedate(futuredate))){

	reportStep(Futudate+ "Expected  Future date has been displaying" ,"PASS");
}
else{
	reportStep(Futudate+ "Expected  Future date has  not been displaying" ,"FAIL");
}
return this;

}

public Authorize_page getNorefBooked_Futuredate(String Paytype) throws InterruptedException{	

String Bookingdate=getTextByXpath("(.//input[contains(@onclick,'"+Paytype+"')]//following::span)[11]");

String Futudate=getTextByXpath("(.//input[contains(@onclick,'"+Paytype+"')]//following::span)[12]");


reportStep("Booking date after authorization "+Bookingdate,"PASS");

reportStep("Value date after authorization "+Futudate,"PASS");



if(Futudate.equalsIgnoreCase(GetFuturedate(futuredate))){

	reportStep(Futudate+ "Expected  Future date has been displaying" ,"PASS");
}
else{
	reportStep(Futudate+ "Expected  Future date has  not been displaying" ,"FAIL");
}
return this;

}



public Authorize_page getAuthorizeddate() throws InterruptedException{	

String Valuedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[12]");


//System.out.println(status);
if(Valuedate.equalsIgnoreCase(dateMonthSlash())){

	reportStep(Valuedate+ "Expected Authorizeddate has been displaying" ,"PASS");
}
else{
	reportStep(Valuedate+ "Expected Authorizeddate has  not been displaying" ,"FAIL");
}
return this;

}


public Authorize_page getNoREFAuthorizeddate(String Paytype) throws InterruptedException{	

String Valuedate=getTextByXpath("(.//input[contains(@onclick,'"+Paytype+"')]//following::span)[12]");


System.out.println(Valuedate);
if(Valuedate.equalsIgnoreCase(dateMonthSlash())){

	reportStep(Valuedate+ "Expected Authorizeddate has been displaying" ,"PASS");
}
else{
	reportStep(Valuedate+ "Expected Authorizeddate has  not been displaying" ,"FAIL");
}
return this;

}


public Authorize_page checkWCDLStatus() throws InterruptedException{
	
	
Boolean a=VerifyElementpresentreturn("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
			
			if(a){
				
				VerifyWCDLstatus();			
			}
			else{
				
				defaultcontent();
				ClickWCDLReport();
				clickWCDLViewLink();
				getWCDLFinalStatus();
			}
				
//			}
	
	return this;
}

public Authorize_page getWCDLAuthStatus(String verifyStatus) throws InterruptedException{	

Boolean a=VerifyElementpresentreturn("(.//input[contains(@value,'"+getrefnumer+"')]//following::span)[9]");

if(a){
	GetWcdlsatus(verifyStatus);
}
else{
	
	reportStep("record has been moved" ,"PASS");
	}
	
return this;

}


public Authorize_page GetWcdlsatus(String verifyStatus)

{
	String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')]//following::span)[9]");
	if(status.contains(verifyStatus)){
		
		reportStep(status+ "Status has been displaying" ,"PASS");
	}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")){
		statusVerify(status);
	}
	return this;
	
}


public Authorize_page VerifyWCDLstatus() throws InterruptedException
{
	
	String status=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
	if(status.contains("A")){
		
		clickfirstAuthRec()
		.confirmRecord()
		.contentFrame()
		.Clickback()
		.ClickWCDLReport()
		.clickWCDLViewLink()
		.getWCDLFinalStatus();
	}
	return this;
	
}


public Authorize_page getFDAuthStatus(String verifyStatus) throws InterruptedException{	

	Thread.sleep(4000);
String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')])[1]//following::td[5]");
if(status.contains(verifyStatus)){
	
	reportStep(status+ "Status has been displaying" ,"PASS");
}
else{
	reportStep(status+ "Status has been displaying" ,"WARN");
}
return this;

}

public Authorize_page getSimulatorAuthStatus(String paytype ,String verifyStatus) throws InterruptedException{	

String status=getTextByXpath("(.//input[contains(@onclick,'"+paytype+"')]//following::span)[9]");
if(status.equalsIgnoreCase(verifyStatus)){
	statusVerify(status);
}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")){
	statusVerify(status);
}


else{
	reportStep(status+ "Status has been displaying" ,"WARN");
}
return this;

}

public Authorize_page get_gst_AuthStatus_grace_date(String paytype) throws InterruptedException{	

String status=getTextByXpath("(.//input[contains(@onclick,'"+paytype+"')]//following::span)[9]");
if(status.equalsIgnoreCase("A")){
	
	clickSimulatorAuthRec(paytype)
	.confirmRecord()
	.contentFrame()
	.clickViewLink()
	.authrecordFrame()
	.clickreflink()
	.getSimulatorAuthStatus(paytype,"U")
	.defaultcontents()
	.contentFrame()		
	.clickViewLink()
	.authrecordFrame()
	.clickreflink()
	.getSimulatorFinalStatus(paytype)
	.getNoREFAuthorizeddate(paytype);
	
	
	
//	statusVerify(status);
}

else{
	getSimulatorAuthStatus(paytype,"UP");
	//getFinalStatus();		
	getNoREFAuthorizeddate(paytype);
	
}





return this;

}

public Authorize_page get_gst_AuthStatus(String paytype) throws InterruptedException{	

String status=getTextByXpath("(.//input[contains(@onclick,'"+paytype+"')]//following::span)[9]");
if(status.equalsIgnoreCase("A")){
	
	clickSimulatorAuthRec(paytype)
	.confirmRecord()
	.contentFrame()
	.clickViewLink()
	.authrecordFrame()
	.clickreflink()
	.getSimulatorAuthStatus(paytype,"U")
	.defaultcontents()
	.contentFrame()		
	.clickViewLink()
	.authrecordFrame()
	.clickreflink()
	.getSimulatorFinalStatus(paytype);
//	getAuthorizeddate();
	
	
	
//	statusVerify(status);
}

else{
	getSimulatorAuthStatus(paytype,"UP");
	//getFinalStatus();		
//	getAuthorizeddate();
	
}





return this;

}






public Authorize_page getSimulatorAuthVerifyStatus(String paytype ,String verifyStatus) throws InterruptedException{	

String status=getTextByXpath("(.//input[contains(@onclick,'"+paytype+"')]//following::span)[9]");
if(status.equalsIgnoreCase(verifyStatus)){
	statusVerify(status);
}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("P")){
	statusVerify(status);
}


else{
	reportStep(status+ "Status has been displaying" ,"WARN");
}
return this;

}




public Authorize_page checkSimulatorStatus(String paytype) throws InterruptedException{
	String status=getTextByXpath("(.//input[contains(@onclick,'"+paytype+"')]//following::span)[9]");
	if(status.equalsIgnoreCase("A")){
	
//new Authorize_page(driver, test)		
//		.
		clickSimulatorAuthRec(paytype)
		.confirmRecord()
		.contentFrame()
		.clickViewLink()
		.authrecordFrame()
		.clickreflink()
		.getSimulatorAuthStatus(paytype,"UP")
		.defaultcontents()
		.contentFrame()		
		.clickViewLink()
		.authrecordFrame()
		.clickreflink()
		.getSimulatorFinalStatus(paytype);
	}
	else{
		getSimulatorFinalStatus(paytype);
		//getFinalStatus();			
	}
	return this;
	}

public Authorize_page getFinalStatus() throws InterruptedException{	
Thread.sleep(30000);
String status=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
if(status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")){
	statusVerify(status);
}

else{
	reportStep(status+ "Status has been displaying" ,"FAIL");
}
return this;

}



public Authorize_page getEPIPCSFinalStatus(String paytye) throws InterruptedException{	
Thread.sleep(30000);
String status=getTextByXpath("(.//input[contains(@onclick,'"+paytye+"')]//following::span)[9]");
if(status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")){
	statusVerify(status);
}

else{
	reportStep(status+ "Status has been displaying" ,"FAIL");
}
return this;

}


public Authorize_page getBillpayFinalStatus() throws InterruptedException{	
Thread.sleep(30000);
String status=getTextByXpath("(.//td//input[contains(@value,'"+getrefnumer+"')]//following::span)[6]");
if(status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")){
	statusVerify(status);
}

else{
	reportStep(status+ "Status has been displaying" ,"FAIL");
}
return this;

}

public Authorize_page getWCDLFinalStatus() throws InterruptedException{	
Thread.sleep(3000);
String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')]//following::span)[9]");
scrolltoelementJs("(.//input[contains(@value,'"+getrefnumer+"')]//following::span)[9]");
System.out.println(status);
if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")){
	
	reportStep(status+ "Status has been displaying" ,"PASS");
}
else if(status.contains("UP")||status.contains("U")){
	
	reportStep(status+ "Status has been displaying" ,"WARN");
}


else{
	reportStep(status+ "Status has been displaying" ,"FAIL");
}
return this;

}


public Authorize_page getSimulatorFinalStatus(String paytype) throws InterruptedException{	
Thread.sleep(30000);
String status=getTextByXpath("(.//input[contains(@onclick,'"+paytype+"')]//following::span)[9]");
if(status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("U")){
	statusVerify(status);
}

else{
	reportStep(status+ "Status has been displaying" ,"FAIL");
}
return this;

}

public Authorize_page getFDFinalStatus() throws InterruptedException{	
Thread.sleep(30000);
String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')])[1]//following::td[5]");

System.out.println(status+"actual value");



	if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")){

	
		reportStep(status+ "Status has been displaying" ,"PASS");
		}
	else if(status.contains("A")||status.contains("Accepted")||status.equalsIgnoreCase("UP")||status.contains("U")){
		reportStep(status+ "Status has been displaying" ,"WARN");
		
		
	}
    	
else{
	System.out.println("fail");
	reportStep(status+ "Status has been displaying" ,"FAIL");
}
return this;

}


	


public Authorize_page confirmRecord(){	
	
	clickByXpathExplict(prop.getProperty("click.auth.confirm.record.xpath"));
defaultcontent();
	return this;

}

	

}
