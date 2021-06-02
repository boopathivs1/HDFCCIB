package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.EPI_Payment_SimulatorPage;
import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_105_EPI_Payment2_Verify_Grace_period  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC105";
		testDescription="EPI_Payment2_Verify_Grace_period";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC105";
		LogoutStatus=true;	
		usertype="CIBUser";
		SimulatorFileName="15EPIService.html";
		
		
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String MerchantNo,String Fromdate,String userid,String pwd,String groupid,
			String company,String Branch,String acc,String amount
			,String authuserid,
			String authpwd,String authgroupid,String compid,String SelectStatus,String Paytype,String Expiry,
			String data1,String data10,String data11,String data12,String data15,
			String datas,String data16,String data17) throws Exception{
		try{
			
			getSimulatorUrl();
			new EPI_Payment_SimulatorPage(driver, test)
			.FillEPISimulator(MerchantNo, Fromdate)
			.fillCredentials(userid, pwd, groupid)
			.SubmitEPIForm(company, Branch, acc, amount)
			.getrefnum()
			.clickSimulatorLogout();	
			
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
	//.clickAuthVerify()
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
	.getValuedate()	.
	getGracedate(Graceperiod)
	.getAuthStatus("A")
	.checkGraceStatus();
	/*.clickfirstAuthRec()
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