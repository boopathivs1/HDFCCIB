package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_67_Onscreen_Payment_CBECPayment_without_verification  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC67";
		testDescription="Onscreen_Payment_CBECPayment_without_verification";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC67";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String paytype,String company,
			String branch,String acc, String acccode,String amount,String authuserid,String authpwd,String authgroupid,String compid,String SelectStatus,String Paytype, 
			String aid,String apwd,String autid,String cid,String Status,
			String type,String data13,String data17,String data18) throws Exception{
		try{
			
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickFundTransfers()
.clickCBECLink()
.fillCBECpaymentform(paytype, company, branch, acc, acccode, amount)
.getrefnumber()
.clickLogoutLink();		
		
		getnewurl();		
		new	HDFC_Login_Page(driver, test)
		.fillCredentials(authuserid, authpwd,authgroupid)
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
.defaultcontents()
.contentFrame()	
.clickViewLink()
.authrecordFrame()
.clickreflink()
.clickfirstAuthRec()
.submitPwd(Authotp)
.contentFrame()
.clickViewLink()
.authrecordFrame()
.clickreflink()
.getAuthStatus("A")
.checkStatus();
		
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

/*
.clickAuthVerify()
.defaultcontents()
.contentFrame()	
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
*/