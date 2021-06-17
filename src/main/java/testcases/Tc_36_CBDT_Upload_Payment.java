package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_36_CBDT_Upload_Payment  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC36";
		testDescription="CBDT_Upload_Payment";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC36";
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
			int endindex=9;
			String  serial_startnumber="1";
			String renamedfilename=renamed_filename_one(filesname1,startindex,endindex, serial_startnumber);
			System.out.println(renamedfilename);
			String actualfilename=fileurl+filename+filesname1;
			String Renamedfilename_loc=fileurl+filename+renamedfilename;
			System.out.println("++++++++++++");
			System.out.println(Renamedfilename_loc);
			System.out.println("++++++++++++");
			convention(actualfilename,Renamedfilename_loc);
			String currentdate=dateMonthSlash();
			int li_no=2;
			int va_in=6;
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

.UploadFormSubmit(clientcode, totalIns, totalamt, transtype,true,Renamedfilename_loc)
.getrefnumAch(0,17)
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
		.authorizeflaRecord(renamedfilename,Authotp)
		.clickBackButton()


		.filter_FileLevelAuth_Record(clientcode,transtype)
		.clickfilenameSort()

		.getAuthStatus("A")
//		.clickFla_ConfirmRecord(filename)
//		.defaultFlaLink()
//
//
//.clickFLA_Link()
//		.filter_FileLevelAuth_Record(clientcode,transtype)
//		.clickfilenameSort()		
//		.getFinalStatus();
		.authorize_CheckStatus_FLA(renamedfilename,clientcode,transtype);




		clickLogoutLink();


		}
		catch (Exception e) {
		clickLogoutLink_FailCase();

		throw new Exception();


		}

		}
		}