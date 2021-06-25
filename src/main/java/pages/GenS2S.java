package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class GenS2S extends ProjectWrapp{
	public   GenS2S (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}


	public GenS2S fillsubmit(String url) throws InterruptedException{
		//Thread.sleep(20000);
		
fileUploadByXpathExplict(prop.getProperty("file.upload.gens2s.xpath"),url);	

		
clickByXpath_Explict(prop.getProperty("file.upload.gens2s.submit.xpath"));
//verifyTextByXpathExplicitwait(prop.getProperty("file.uploaded.successfully.xpath"),"SUCCESSFULLY");

verifyTextContainsByXpathexplictwait(prop.getProperty("file.uploaded.successfully.xpath"),"SUCCESSFULLY");
		return this;
	
	}
	
	
	
	
	
	
	
	
	
	
	
}