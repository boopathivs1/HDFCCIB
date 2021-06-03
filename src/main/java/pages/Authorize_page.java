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
	
	
	public Authorize_page contentFrame() throws InterruptedException{
	contentFrames();
	
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


public Authorize_page clickreflink(){	
	
clickByXpathExplict(prop.getProperty("click.authorize.refnum.link.xpath"));
	return this;

}

public Authorize_page clickfirstAuthRec(){	
	
	clickByXpathExplict(".//input[contains(@onclick,'"+getrefnumer+"')]");
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
	}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.equalsIgnoreCase("P")){
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
		.getAuthStatus("UP")
		.defaultcontents()
		.contentFrame()		
		.clickViewLink()
		.authrecordFrame()
		.clickreflink()
		.getFinalStatus();		
	}
	else{
		getAuthStatus("UP");
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


public Authorize_page getValuedate() throws InterruptedException{	

String Valuedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[11]");


//System.out.println(status);
if(Valuedate.equalsIgnoreCase(dateMonthSlash())){

	reportStep(Valuedate+ "Expected Bookingdate has been displaying" ,"PASS");
}
else{
	reportStep(Valuedate+ "Expected Bookingdate has  not been displaying" ,"FAIL");
}
return this;

}

public Authorize_page getGracedate(int d) throws InterruptedException{	

String Gracedate=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[12]");


//System.out.println(status);
if(Gracedate.equalsIgnoreCase(GetFuturedate(d))){

	reportStep(Gracedate+ "Expected  Gracedate has been displaying" ,"PASS");
}
else{
	reportStep(Gracedate+ "Expected  Gracedate has  not been displaying" ,"FAIL");
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


public Authorize_page checkWCDLStatus() throws InterruptedException{
	String status=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[9]");
	if(status.contains("A")){
	
//new Authorize_page(driver, test)		
//		.
		clickfirstAuthRec()
		.confirmRecord()
		.contentFrame()
		.Clickback()
		.ClickWCDLReport()
		.clickWCDLViewLink()
		.getWCDLFinalStatus();
	}
	else{
		getWCDLFinalStatus();
		//getFinalStatus();		
			
	}
	return this;
}

public Authorize_page getWCDLAuthStatus(String verifyStatus) throws InterruptedException{	

String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')]//following::span)[9]");
if(status.contains(verifyStatus)){
	
	reportStep(status+ "Status has been displaying" ,"PASS");
}else if(status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")){
	statusVerify(status);
}

else{
	reportStep(status+ "Status has been displaying" ,"WARN");
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

	
	
	
//	statusVerify(status);
}

else{
	getAuthStatus("UP");
	//getFinalStatus();		
	
	
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

public Authorize_page getWCDLFinalStatus() throws InterruptedException{	
Thread.sleep(3000);
String status=getTextByXpath("(.//input[contains(@value,'"+getrefnumer+"')]//following::span)[9]");
scrolltoelementJs("(.//input[contains(@value,'"+getrefnumer+"')]//following::span)[9]");
System.out.println(status);
if(status.contains("UP")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.contains("U")){
	
	reportStep(status+ "Status has been displaying" ,"PASS");
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

	if(status.contains("Accepted")||status.equalsIgnoreCase("UP")||status.equalsIgnoreCase("E")||status.equalsIgnoreCase("R")||status.contains("U")){
	
		reportStep(status+ "Status has been displaying" ,"PASS");
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
