package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_123_Onscreen_Payment_CBDT_Verify_Future_Date  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC123";
		testDescription="Onscreen_Payment_CBDT_Verify_future date";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC123";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String domain,String Challanno,String recordno,
			String compid,String branch,String accno,String taxnum,	String authuserid,String authpwd,String authdomain,
			String SelectStatus,String Paytype,String data1,String data10,String data11,
			String data12,String data14,String data15,
			String data16,String data17,String data20,String data21) throws Exception{
		try{
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, domain)
.clickFundTransfers()
.click_View_CBDT_Link()
.intiate_CBDT(Challanno, recordno)
.fill_CBDT_future_date(compid,branch,accno,taxnum)
		.getrefnum();

		clickLogoutLink();


		getnewurl();		
		new	HDFC_Login_Page(driver, test)
		.fillCredentials(authuserid, authpwd,authdomain)
.fundTransfersLink()
.clickAuthorize()
.contentFrame()
.filterAuthorize(compid, SelectStatus, Paytype)
.clickViewLink()
.authrecordFrame()
.clickreflink()
.clickfirstAuthRec()
.getAuthVerifyStatus("VP")
.CheckVerifyStatus()
//.clickAuthVerify()
.defaultcontents()
.contentFrame()	
.clickViewLink()
.authrecordFrame()
.clickreflink()
.getBooking_Futuredate()
.clickfirstAuthRec()
.submitPwd(Authotp)
.contentFrame()
.clickViewLink()
.authrecordFrame()
.clickreflink()
.getValuedate()	.
getGracedate(Graceperiod)
.getAuthStatus("A")
.checkGraceStatus()
.getBooked_Futuredate();
/*.clickfirstAuthRec()
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
.getFinalStatus();*/
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


/*		
getnewurl();
new	HDFC_Login_Page(driver, test)
.fillCredentials(authuserid, authpwd,authdomain)
.fundTransfersLink()
.clickAuthorize()
.filterAuthorize(compid, SelectStatus, Paytype)
.clickViewLink()
.clickreflink()
.submitPwd(pwd)
.clickViewLink()
.clickreflink()
.getAuthStatus("A")
.confirmRecord()
.clickViewLink()
.clickreflink()
.getAuthStatus("UP")
.clickViewLink()
.clickreflink()
.getFinalStatus();

clickLogoutLink();


}
catch (Exception e) {
clickLogoutLink();
throw new Exception();

// TODO: handle exception
}

}
}*/