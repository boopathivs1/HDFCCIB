package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class File_Level_View_pages extends ProjectWrapp{
	public   File_Level_View_pages(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
public LogoutPages filter_FileLevel_Record(String clientcode,String trantype) throws InterruptedException{
		contentFrames();
	selectVisibileTextByXPath(prop.getProperty("select.filelevel.clientcode.xpath"),clientcode);
	selectVisibileTextByXPath(prop.getProperty("select.filelevel.pay.xpath"),trantype);
	
	
	Thread.sleep(10000);
		clickByXpathExplict(prop.getProperty("click.file.level.view.link.xpath"));
		
		clickByXpathExplict(prop.getProperty("click.filelevel.filename.xpath"));
		clickByXpathExplict(prop.getProperty("click.filelevel.filename.xpath"));
		
		
		
		
	String a=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[1]");
	if(a.equalsIgnoreCase("PA")){
		reportStep("Pending for Authorizartion status has been displaying for this file","PASS");
	}
/*	else if(a.equalsIgnoreCase("PV")){
		reportStep("Pending for Verification status has been displaying for this file","PASS");
	}
	*/
	else{
		clickByXpathExplict(".//input[contains(@onclick,'"+getrefnumer+"')]");
		clickByXpathExplict(prop.getProperty("click.filelevel.download.xpath"));
		Thread.sleep(5000);
		acceptAlert();
	Thread.sleep(5000);
	
//	clickLogoutLink();
	
		reportStep("Status not matching and files downloaded","FAIL");	
	
	}
	
	defaultcontent();
	return new LogoutPages(driver, test);
		
}




public LogoutPages filter_FileLevel(String clientcode,String trantype) throws InterruptedException{
	contentFrames();
selectVisibileTextByXPath(prop.getProperty("select.filelevel.clientcode.xpath"),clientcode);
selectVisibileTextByXPath(prop.getProperty("select.filelevel.pay.xpath"),trantype);


Thread.sleep(10000);
	clickByXpathExplict(prop.getProperty("click.file.level.view.link.xpath"));
	
	clickByXpathExplict(prop.getProperty("click.filelevel.filename.xpath"));
	clickByXpathExplict(prop.getProperty("click.filelevel.filename.xpath"));
	
	
	
	
String a=getTextByXpath("(.//input[contains(@onclick,'"+getrefnumer+"')]//following::span)[1]");


//if(a.equalsIgnoreCase("PA")){
//	reportStep("Pending for Authorizartion status has been displaying for this file","PASS");
//}
//else{
//	clickByXpathExplict(".//input[contains(@onclick,'"+getrefnumer+"')]");
//	clickByXpathExplict(prop.getProperty("click.filelevel.download.xpath"));
//	Thread.sleep(5000);
//	acceptAlert();
//Thread.sleep(5000);
//	reportStep("Status not matching and files downloaded","FAIL");	
//
//}

defaultcontent();
return new LogoutPages(driver, test);
	
}

public LogoutPages filter_Cash_FileLevel_Record(String clientcode,String trantype,String filename) throws InterruptedException{
	contentFrames();
selectVisibileTextByXPath(prop.getProperty("select.filelevel.clientcode.xpath"),clientcode);
selectVisibileTextByXPath(prop.getProperty("select.filelevel.pay.xpath"),trantype);


Thread.sleep(10000);
	clickByXpathExplict(prop.getProperty("click.file.level.view.link.xpath"));
	
	clickByXpathExplict(prop.getProperty("click.filelevel.filename.xpath"));
	clickByXpathExplict(prop.getProperty("click.filelevel.filename.xpath"));
	
	
	
	
String a=getTextByXpath("(.//input[contains(@onclick,'"+filename+"')]//following::span)[1]");
if(a.equalsIgnoreCase("PA")){
	reportStep("Pending for Authorizartion status has been displaying for this file","PASS");
}
/*	else if(a.equalsIgnoreCase("PV")){
	reportStep("Pending for Verification status has been displaying for this file","PASS");
}
*/
else{
	clickByXpathExplict(".//input[contains(@onclick,'"+filename+"')]");
	clickByXpathExplict(prop.getProperty("click.filelevel.download.xpath"));
	Thread.sleep(5000);
	acceptAlert();
Thread.sleep(5000);

//clickLogoutLink();

	reportStep("Status not matching and files downloaded","FAIL");	

}

defaultcontent();
return new LogoutPages(driver, test);
	
}
	
	
	
	
	
	
	
	
	
	
	

public LogoutPages filter_Cash_FileLevel_Record_preauth(String clientcode,String trantype,String filename) throws InterruptedException{
	contentFrames();
selectVisibileTextByXPath(prop.getProperty("select.filelevel.clientcode.xpath"),clientcode);
selectVisibileTextByXPath(prop.getProperty("select.filelevel.pay.xpath"),trantype);


Thread.sleep(40000);
	clickByXpathExplict(prop.getProperty("click.file.level.view.link.xpath"));
	
	clickByXpathExplict(prop.getProperty("click.filelevel.filename.xpath"));
	clickByXpathExplict(prop.getProperty("click.filelevel.filename.xpath"));
	
	
	
	
String a=getTextByXpath("(.//input[contains(@onclick,'"+filename+"')]//following::span)[1]");
if(a.equalsIgnoreCase("PV")||a.equalsIgnoreCase("VF")){
	clickByXpathExplict(".//input[contains(@onclick,'"+filename+"')]");
	clickByXpathExplict(prop.getProperty("click.filelevel.download.xpath"));
	Thread.sleep(5000);
	acceptAlert();
Thread.sleep(5000);

//clickLogoutLink();
	reportStep("Status not matching and files downloaded","FAIL");	


}


defaultcontent();
return new LogoutPages(driver, test);
	



}


}
