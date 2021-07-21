package testcases;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class MessageCentre  extends ProjectWrapp{
	public   MessageCentre(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}


	
	public MessageCentre verifyMsgcentre() throws InterruptedException{
		defaultcontent();
		topFrames();
		
		clickByXpathExplict(prop.getProperty("msgcentrlink.xpath"));
		defaultcontent();
		Thread.sleep(15000);
		
		
		msg_contentFrames();
		clickByXpathExplict(prop.getProperty("msgcentre.view.xpath"));
		clickByXpathExplict("(.//a[text()='AUTOINP'])[1]");
		clickByXpathExplict(prop.getProperty("click.msg.link.xpath"));
		
				
		return this;
	}
	
	

}
