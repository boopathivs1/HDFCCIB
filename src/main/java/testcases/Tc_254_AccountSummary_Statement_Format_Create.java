package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_254_AccountSummary_Statement_Format_Create  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC254";
		testDescription="AccountSummary_Statement_Format_Create&Edit";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC254";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,
			String Templatename,String formattype,String dateformat,String UpdatedFormattype,String amount,String authuserid,
			String authpwd,String authgroupid,String SelectStatus,String Paytype,
			String benecode,String data1,String data10,
			String data11,String data12,String data13,
			String data14,String data15,String data16,String data17,String dataS17) throws Exception{
		try{

			Template =Templatename+gettwoRandomNumberString();
			//getnewurl();
			getnewurl();

			new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickAccountService()
.clickStatementFormatlink()
.clickCreateTemplatelink()
.fillTemplateform(Template, formattype, dateformat)
.VerifyTemplateCreationSuccess()
.clickEditTemplatelink()
.EDitTemplateform(Template, UpdatedFormattype)
.VerifyUpdatedTemplateSuccess();
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