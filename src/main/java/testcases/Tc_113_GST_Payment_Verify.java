package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.EPI_Payment_SimulatorPage;
import pages.GST_Payment_SimulatorPage;
import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_113_GST_Payment_Verify  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC113";
		testDescription="Onscreen grace period Verification-GST";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC113";
		LogoutStatus=true;	
		usertype="CIBUser";
		SimulatorFileName="12GSTN_Simulator_3_INTER.html";
		
		
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String TransID,String challonNo,String amount,String expirydate,String userid,
			String pwd,String groupid,String company,String Branch,String acc
			,String authuserid,
			String authpwd,String authgroupid,String compid,String SelectStatus,String Paytype,String Expiry,
			String data1,String data10,String data11,String data12,String data15,
			String datas,String data16) throws Exception{
		try{
			getSimulatorUrl();
			new GST_Payment_SimulatorPage(driver, test)
			.FillGSTSimulator(TransID, challonNo, amount, expirydate)
			.fillCredentials(userid, pwd, groupid)
			.SubmitGSTForm(company, Branch, acc);
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
	.clickSimulatorAuthRec(Paytype)
	.getSimulatorAuthVerifyStatus(Paytype,"VP")
	.CheckGSTVerifyStatus(Paytype)
	.defaultcontents()
	.contentFrame()	
	.clickViewLink()
	.authrecordFrame()
	.clickreflink()
	.clickSimulatorAuthRec(Paytype)
	.submitPwd(pwd)
	.contentFrame()
	.clickViewLink()
	.authrecordFrame()
	.clickreflink()
	.getGSTValuedate(Paytype)
	.getGSTGracedate(Paytype)
	.getSimulatorAuthStatus(Paytype,"A")
	.get_gst_AuthStatus_grace_date(Paytype);
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