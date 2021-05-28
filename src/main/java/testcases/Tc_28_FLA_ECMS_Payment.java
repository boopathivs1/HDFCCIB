package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_28_FLA_ECMS_Payment  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC28";
		testDescription="FLA - ECMS Payment";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC28";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String domain,
		String	clientcode,String totalIns,String totalamt,String transtype,String filename
			,String otp,	String authuserid,String authpwd,String authdomain,
			String data1,String data10,String data11,
			String data12,String data14,String data15,
			String data16,String data17,String data20,String data21,String data22,String data23) throws Exception{
		try{
		
			String filesname1=getfilename_one(filename);
			System.out.println("Actual filename is "+filesname1);
			int startindex=0;
			int endindex=4;
			String  serial_startnumber="5";
			String renamedfilename=renamed_filename_one(filesname1,startindex,endindex, serial_startnumber);
			System.out.println("rename");
			System.out.println(renamedfilename);
			System.out.println("rename");
			String actualfilename=fileurl+filename+filesname1;
			String Renamedfilename_loc=fileurl+filename+renamedfilename;
			System.out.println("++++++++++++");
			System.out.println(Renamedfilename_loc);
			System.out.println("++++++++++++");
			convention(actualfilename,Renamedfilename_loc);
			String currentdate=dateMonthSlash();
			int li_no=2;
			int va_in=22;
			String value =filespecific_text(li_no, va_in,Renamedfilename_loc);
			System.out.println(value);
			System.out.println("oooooooooooo");
			modifyFile(Renamedfilename_loc,value,currentdate);

			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, domain)
.clickCashManageServiceLink()
.clickDisbursementLink()
.clickUploadLink()

.CMSUploadFormSubmit(clientcode, totalIns, totalamt, transtype, false,Renamedfilename_loc)
.getrefnum()
.click_File_Level_View_Link()
.filter_FileLevel_Record(clientcode,transtype)
.clickLogoutLink();

//getrefnumer="RBAU2703.128";
		getnewurl();
		new	HDFC_Login_Page(driver, test)
		.fillCredentials(authuserid, authpwd,authdomain)
		.clickCashServiceLink()
		.clickDisbursementLink()
		.clickFLA_AuthLink()
	
		
		.filter_FileLevelAuth_Record(clientcode,transtype)
		.clickfilenameSort()
		.authorizeflaRecord(filename,otp)
		.clickBackButton()


		.filter_FileLevelAuth_Record(clientcode,transtype)
		.clickfilenameSort()

		.getAuthStatus("A")
		
		.authorize_CheckStatus_FLA(filename,clientcode,transtype);


		
//		.clickFla_ConfirmRecord(filename)
//		.defaultFlaLink()
//.clickFLA_Link()
//		.filter_FileLevelAuth_Record(clientcode,transtype)
//		.clickfilenameSort()		
//		.getFinalStatus();
//



		clickLogoutLink();


		}
		catch (Exception e) {
		clickLogoutLink_FailCase();

		throw new Exception();


		}

		}
		}