package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_327_SME  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC327";
		testDescription="SME";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC327";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String NavigateURL,String branch,
			String acc,String panno, String amount,String Natureofdept,String month,String Maturity,String Interestpay, 
			String authuserid,String authpwd,String authgroupid,String compid,String SelectStatus,String Paytype, 
			String aid,String apwd,String autid,String cid,String Status,
			String type) throws Exception{
		try{
			getnewurl();
			
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickSME()
.ClickSMESubMenu()
.VerifyThirdPartyPageNavigation(NavigateURL);

		
		
		
		}
	catch (Exception e) {
		clickLogoutLink();
		throw new Exception();
		
		// TODO: handle exception
	}

	}
	}