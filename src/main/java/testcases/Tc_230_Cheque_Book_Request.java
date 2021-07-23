package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_230_Cheque_Book_Request  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC230";
		testDescription="Cheque_Book_Request";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC230";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String company,String branch,
			String acc,String authuserid,String authpwd,String authgroupid,String compid,String SelectStatus,String Paytype, 
			String panno, String amount,String Natureofdept,String month,String Maturity,String Interestpay,String aid,String apwd,String autid,String cid,String Status,
			String type) throws Exception{
		try{
			getnewurl();
			
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickService()
.clickChequebookReq()
.clickChequebookReqNew()
.fillChequeReqform(company, branch, acc)
.getrefnumAch(0,12)
.clickLogoutLink();	
		
		getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(authuserid, authpwd, authgroupid)
.clickService()
.clickChequeReq()
.clickChequebookAuthorize()
.contentFrame()
.fillChequeAuthorizeReqform(company, branch, acc)
.clickChequebookAuthRec()

.AuthorizeCheqReq(Authotp)
.contentFrame()
.Clickback()
.ClickChequeReview()
.contentFrame()
.fillChequeAuthorizeReqform(company, branch, acc)
.GetFinalStatus();
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