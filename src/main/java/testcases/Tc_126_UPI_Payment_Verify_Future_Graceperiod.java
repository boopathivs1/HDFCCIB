package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_126_UPI_Payment_Verify_Future_Graceperiod  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC126";
		testDescription="UPI_Payment_Verify_Future_Graceperiod ";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC126";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,
			String selectcompany,String selectbranch,String selectaccount,String UpiBene
			,String SelectCorp,String Remupi,String SelectRemccno,String Remaccno,String UpiCorpRef,String UpiDesc,String UpiAmt,String Expiry,String authuserid,
			String authpwd,String authgroupid,String compid,String SelectStatus,String Paytype,
			String data1,String data10,String data11) throws Exception{
		try{
			getnewurl();	
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickFundTransfers()
.click_UPI_Link()
.clickNew_Upi()
.fill_Upi(selectcompany, selectbranch, selectaccount, UpiBene, SelectCorp, Remupi, SelectRemccno, Remaccno, UpiCorpRef, UpiDesc, UpiAmt, Expiry)
.getrefnum()
.clickLogout();		
		
		getnewurl();		
	new	HDFC_Login_Page(driver, test)
.fillCredentials(authuserid, authpwd, authgroupid)
.fundTransfersLink()
.clickAuthorize()
.contentFrame()
.filterAuthorize_entervalue_Date(compid, SelectStatus, Paytype)
.clickViewLink()
.authrecordFrame()
.clickreflink()
.clickfirstAuthRec()
.getAuthVerifyStatus("VP")
.CheckVerifyStatus()
.defaultcontents()
.contentFrame()	
.clickViewLink()
.authrecordFrame()
.clickreflink()
.getBooking_Futuredate()
.clickfirstAuthRec()
.submitPwd(pwd)
.contentFrame()
.clickViewLink()
.authrecordFrame()
.clickreflink()
.getValuedate()	.
getGracedate(Graceperiod)
.getAuthStatus("A")
.checkGraceStatus()
.getBooked_Futuredate();
		
//.clickfirstAuthRec()
//.confirmRecord()
//.contentFrame()
//.clickViewLink()
//.authrecordFrame()
//.clickreflink()
//.getAuthStatus("UP")
//.defaultcontents()
//.contentFrame()		
//.clickViewLink()
//.authrecordFrame()
//.clickreflink()
//.getFinalStatus();

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