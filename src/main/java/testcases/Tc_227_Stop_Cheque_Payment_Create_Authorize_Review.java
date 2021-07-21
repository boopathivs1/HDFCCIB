package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_227_Stop_Cheque_Payment_Create_Authorize_Review  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC227";
		testDescription="Stop Cheque Payment- Create,Authorize,Review";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC227";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String company,
			String branch,String acc,String fromchq,String tochq,String chqreason, String authuserid,String authpwd,
			String authgroupid,String otp,String data7,String data1,String data10,String data13,String data14,String data15,
			String data16,String data17,String data18,String data19,String data21) throws Exception{
		
		
		try{
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickserviceslink()
.clickstopcheque_serviceslink()
.clickstopcheque_new_link()
.fillcheque(company, branch,acc,fromchq,tochq,chqreason);
clickLogoutLink();	
		
		getnewurl();	
		
		new	HDFC_Login_Page(driver, test)
.fillCredentials(authuserid, authpwd, authgroupid)
.clickserviceslink()
.clickstopcheque_serviceslink()
.clickstopcheque_Authorizeserviceslink()
.Authorizeservices_form(company,branch,acc,otp)
.verify_stopcheque_new_link(company,branch,acc);
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