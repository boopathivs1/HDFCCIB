package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class AcctoAccSingle extends ProjectWrapp{
	public   AcctoAccSingle (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public LogoutPages fillAcctoAccSingleform(String selectformat,String compid,String compBranch,String accno,String benecode,String amount) throws InterruptedException{
contentFrames();
	
//	selectVisibileTextByXPath(prop.getProperty("select.format.singleacc.xpath"),selectformat);
selectVisibileTextByXPath(prop.getProperty("Select.acctotacc.comp.xpath"),compid);
selectVisibileTextByXPath(prop.getProperty("Select.acctotacc.compbranch.xpath"),compBranch);
selectVisibileTextByXPath(prop.getProperty("Select.acctotacc.accnno.comp.xpath"),accno);
selectVisibileTextByXPath(prop.getProperty("Select.acctotacc.benecode.xpath"),benecode);


/* 
Select.acctotacc.comp.xpath=.//select[@id="cmbCompany"]
#AUTOMATIONHDFC
Select.acctotacc.compbranch.xpath=.//select[@name="cmbBranch"]
#759, #ITC CENTREANNA SALAI, Opp T.V.S.
Select.acctotacc.compaccno.xpath=.//select[@id="cmbAccount"]
#00040330004923
Select.acctotacc.benecode.xpath=.//select[@id="cmbBenecode"]
#ACCTOACC 
*/


		enterByXpathExplict(prop.getProperty("enter.amount.accsingle.xpath"),amount);
		
		clickByXpathExplict(prop.getProperty("click.addtosingle.save.xpath"));
	
		return new LogoutPages(driver, test);
	}
	
	
			
			


	
	
}
