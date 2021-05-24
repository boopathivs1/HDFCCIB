package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.CBDT_Payment_SimulatorPage;
import pages.EPI_Payment_SimulatorPage;
import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_13_CBDT_Payment  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC13";
		testDescription="CBDT_Payment";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC13";
		LogoutStatus=true;	
		usertype="CIBUser";
		SimulatorFileName="13aCBDTSimulatorPayment.html";
		
		
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String Fromdate,String userid,String pwd,String groupid,
			String company,String Branch,String acc,String amount
			,String authuserid,
			String authpwd,String authgroupid,String compid,String SelectStatus,String Paytype,String Expiry,String merchantno,
			String data1,String data10,String data11,String data12,String data15,
			String datas,String data16,String data17) throws Exception{
		try{
			getSimulatorUrl();
			new CBDT_Payment_SimulatorPage(driver, test)
			.FillCBDTSimulator(Fromdate)
			.fillCredentials(userid, pwd, groupid)
			.SubmitCBDTForm(company, Branch, acc, amount)
			.clickCBDTSimulatorLogout();	
			
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
	.submitPwd(pwd)
	.contentFrame()
	.clickViewLink()
	.authrecordFrame()
	.clickreflink()
	.getSimulatorAuthStatus(Paytype,"A")
	.checkSimulatorStatus(Paytype);
			
//	.clickSimulatorAuthRec(Paytype)
//	.confirmRecord()
//	.contentFrame()
//	.clickViewLink()
//	.authrecordFrame()
//	.clickreflink()
//	.getSimulatorAuthStatus(Paytype,"UP")
//	.defaultcontents()
//	.contentFrame()		
//	.clickViewLink()
//	.authrecordFrame()
//	.clickreflink()
//	.getSimulatorFinalStatus(Paytype);
			
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