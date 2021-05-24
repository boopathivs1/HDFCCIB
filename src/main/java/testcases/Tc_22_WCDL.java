package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_22_WCDL  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC22";
		testDescription="WCDL";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC22";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String company,String amount,String interest,
			String month, String authuserid,String authpwd,
			String authgroupid,String compid,String SelectStatus,String Paytype,String acccode,String data,
			String acc12,String statecode,String Prodcode,String data13,String data14,String data15,String data17,String data20,String data21) throws Exception{
		try{
			
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickWorkingCapital()
.clickWCDL()
.clickWCDLNEw()
.fillWCDLpaymentform(company, amount, interest, month)
.getrefnumber()
.clickLogout();		
		
		getnewurl();
		
		new	HDFC_Login_Page(driver, test)
.fillCredentials(authuserid, authpwd, authgroupid)
.clickWorkingCapital()
.clickWCDLMenu()
.clickWCDLAuthorize()
.clickWCDLViewLink()
.clickfirstAuthRec()
.AuthorizePwd(pwd)
.contentFrame()
.Clickback()
.clickWCDLViewLink()
.getAuthStatus("A")
.checkWCDLStatus();

//.clickfirstAuthRec()
//.confirmRecord()
//.contentFrame()
//.Clickback()
//.ClickWCDLReport()
//.clickWCDLViewLink()
//.getWCDLFinalStatus();

defaultcontent();		
clickLogoutLink();

		
		}
	catch (Exception e) {
clickLogoutLink();
		throw new Exception();
		
		// TODO: handle exception
	}

	}
	}