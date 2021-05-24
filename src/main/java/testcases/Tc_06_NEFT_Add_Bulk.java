package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_06_NEFT_Add_Bulk  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC06";
		testDescription="NEFT - Add Bulk";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC06";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,
			String company,String branch,String account,String remarks,
			String paymode,String beneneft, String amount,String PayRemarks,String authuserid,
			String authpwd,String authgroupid,String compid,String SelectStatus,String Paytype,String selectformat,
			String data1,String data10,String data11,String data16,String data17,String data20) throws Exception{
		try{
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickFundTransfers()
.clickNEFTRTGSLink()
.click_AddBulk_NEFT_RTGS_Link()
.fill_NEFT_RTGS_Add_Bulk_Submitform(company, branch, account)
.fill_NEFT_RTGS_Add_Bulkform(paymode,beneneft,amount,PayRemarks)


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
.checkStatus();

/*
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