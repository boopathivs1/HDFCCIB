package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_255_AccountSummary_Cheque_Status_Enquiry_Initiate  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC255,TC256";
		testDescription="AccountSummary_Cheque_Status_Enquiry_Initiate&View";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC255";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,
			String company,String branch,String acc,String chqFrm,String chqTo,String status,
			String authpwd,String authgroupid,String SelectStatus,String Paytype,
			String benecode,String data1,String data10,
			String data11,String data12,String data13,
			String data14,String data15,String data16,String data17,String dataS17) throws Exception{
		try{

			
			//getnewurl();
			getnewurl();

			new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickAccountService()
.clickChequestatusinquirylink()
.clickInitiatelink()
.fillCheckReqform(company, branch, acc, chqFrm, chqTo)
.VerifyChequestatusEnquirySuccess()		
.clickViewlink()
.fillViewCheckReqform(company, branch, acc, chqFrm, chqTo,status);		
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