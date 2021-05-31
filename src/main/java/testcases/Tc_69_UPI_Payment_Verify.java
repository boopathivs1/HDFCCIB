package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_69_UPI_Payment_Verify  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC69";
		testDescription="UPI_Payment_Verify";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC69";
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
.submitPwd(pwd)
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




/*.clickAuthVerify()
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