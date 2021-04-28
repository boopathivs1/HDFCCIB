package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_01_AccToAcc_Single  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC01";
		testDescription="Acc to Acc - Add Single";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC01";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,
			String selectformat,String amount,String authuserid,
			String authpwd,String authgroupid,String compid
			,String SelectStatus,String Paytype,String compBranch,String accno,
			String benecode,String data1,String data10,
			String data11,String data12,String data13,
			String data14,String data15,String data16,String data17,String dataS17) throws Exception{
		try{
String accnum=regvalue(accno);
			
			//getnewurl();
			getnewurl();

			new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickFundTransfers()
.clickAcctoAccLink()
.clickAccSingleLink()
.fillAcctoAccSingleform(selectformat,compid,compBranch,accnum,benecode, amount)
.getrefnum()
.clickLogout();		
		getnewurl();		
		new	HDFC_Login_Page(driver, test)
.fillCredentials(authuserid, authpwd, authgroupid)
.fundTransfersLink()
.clickAuthorize()
.contentFrame()
.filterAuthorize(compid, SelectStatus, Paytype)
.clickViewLink()
.authrecordFrame()
.clickreflink()
.clickfirstAuthRec()
.submitPwd(pwd)
.contentFrame()
.clickViewLink()
.authrecordFrame()
.clickreflink()
.getAuthStatus("A")
.clickfirstAuthRec()
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