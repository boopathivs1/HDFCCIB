package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_11a_SpecialPayment_bpcl  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC11a";
		testDescription="SpecialPayment_bpcl";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC11a";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String Format,String Appformat,
			String amount,String remark,String authuserid,String authpwd,String authgroupid,String compid,String SelectStatus, 
			String Paytype,String pd,String group,String id,String Status,String type,
			String data13,String data17,String data18,String data19, String data20,String data21) throws Exception{
		try{
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickFundTransfers()
.clickAcctoAccLink()
.clickSplpaymentLink()
.fillSplpaymentBPCLform(Format, Appformat, amount, remark)
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