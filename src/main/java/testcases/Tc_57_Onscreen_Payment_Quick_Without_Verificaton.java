package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_57_Onscreen_Payment_Quick_Without_Verificaton  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC57";
		testDescription="Onscreen_Payment_Quick";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC57";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String selectformat,String amount,
			String paymentdetail,String authuserid,String authpwd,String authgroupid,String compid,
			String SelectStatus,String Paytype,String data1,String data11,String data12,String data13,
			String data14,String data15,String data16,String data17,String data18,String data19, String data20,String data21) throws Exception{
		try{
			getnewurl();
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickFundTransfers()
.clickAcctoAccLink()
.clickAccQuickLink()
.fillAcctoAccQuickform(selectformat, amount,paymentdetail)
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
	}*/