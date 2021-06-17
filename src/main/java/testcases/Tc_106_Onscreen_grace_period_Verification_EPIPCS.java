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
public class Tc_106_Onscreen_grace_period_Verification_EPIPCS  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC106";
		testDescription="Onscreen_grace_period_Verification_EPIPCS";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC106";
		LogoutStatus=true;	
		usertype="CIBUser";
		SimulatorFileName="EPIPCSService.html";
		
		
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String MerchantNo,String userid,String pwd,String groupid,
			String company,String Branch,String acc
			,String authuserid,
			String authpwd,String authgroupid,String compid,String SelectStatus,String Paytype,String Expiry,String Fromdate,String amount,
			String data1,String data10,String data11,String data12,String data15,
			String datas,String data16,String data17) throws Exception{
		try{
			getSimulatorUrl();
			new EPI_Payment_SimulatorPage(driver, test)
			.FillEPIPCSSimulator(MerchantNo)
			.fillCredentials(userid, pwd, groupid)
			.SubmitEPIpcsForm(company, Branch, acc)
			.clickEPIPCSSimulatorLogout();	
			
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
	.clickEPIPCSfirstAuthRec(Paytype)
	
	.getAuthEPIPCSVerifyStatus("VP",Paytype)
	.CheckEPIPCSVerifyStatus(Paytype)
	.defaultcontents()
	.contentFrame()	
	.clickViewLink()
	.authrecordFrame()
	.clickreflink()
	.clickEPIPCSfirstAuthRec(Paytype)
	.submitPwd(Authotp)
	.contentFrame()
	.clickViewLink()
	.authrecordFrame()
	.clickreflink()
	.getNoREfValuedate(Paytype)	
	.getEPCSGracedate(Paytype)
	.getAuthEPIPCSVerifyStatus("A",Paytype)
	.checkEPIPCSStatus(Paytype)
	.getNoREFAuthorizeddate(Paytype);
			
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