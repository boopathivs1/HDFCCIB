package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_244_AccountSummary_Balance_Report  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC244";
		testDescription="AccountSummary_Balance_Report";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC244";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,
			String compid,String compBranch,String accno,String Currency,String amount,String authuserid,
			String authpwd,String authgroupid,String SelectStatus,String Paytype,
			String benecode,String data1,String data10,
			String data11,String data12,String data13,
			String data14,String data15,String data16,String data17,String dataS17) throws Exception{
		try{
String accnum=regvalue(accno);
			
			//getnewurl();
			getnewurl();

			new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickAccountService()
.clickBalancelink()
.clickSummarylink()
.fillBalanceSummaryform(compid,compBranch,accnum,Currency)
.SelectRecord()
.clickReport();
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