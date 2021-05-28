package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_34b_ACH_Payment_type_Credit  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC34b";
		testDescription="ACH Payment type-Credit";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC34b";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String domain,
		String	clientcode,String totalIns,String totalamt,String transtype,String filename
			,String otp,	String authuserid,String authpwd,String authdomain,
			String paytype,String data10,String data11,
			String data12,String data14,String data15,
			String data16,String data17,String data20,String data21,String data22,String data23) throws Exception{
		try{
			String filesname1=getfilename_one(filename);
			int startindex=0;
			int endindex=13;
			String  serial_startnumber="6";
			String renamedfilename=renamed_filename_year(filesname1,startindex,endindex, serial_startnumber);
			String actualfilename=fileurl+filename+filesname1;
			String Renamedfilename_loc=fileurl+filename+renamedfilename;
			convention(actualfilename,Renamedfilename_loc);

			
			
			
			String value1 =filespecific_cont(0, 3,Renamedfilename_loc);
			String value2=removeLastString_index(value1,8);
			String value3=value2+GetTodayDate();

		modifyFile(Renamedfilename_loc,value1,value3);

			

			
	content_check(1,5,Renamedfilename_loc);
	content_check(2,5,Renamedfilename_loc);
		content_check(3,5,Renamedfilename_loc);
		content_check(4,5,Renamedfilename_loc);
		content_check(5,5,Renamedfilename_loc);
		content_check(6,5,Renamedfilename_loc);
		content_check(7,5,Renamedfilename_loc);
		content_check(8,5,Renamedfilename_loc);
		content_check(9,5,Renamedfilename_loc);
		content_check(10,5,Renamedfilename_loc);

			
			
//			String currentdate=dateMonthSlash();
//			int li_no=2;
//			int va_in=22;
//			String value =filespecific_text(li_no, va_in,Renamedfilename_loc);
//			System.out.println(value);
//			System.out.println("oooooooooooo");
//			modifyFile(Renamedfilename_loc,value,currentdate);


			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, domain)
.clickCashManageServiceLink()
.clickDisbursementLink()
.clickUploadLink()
.CMSUploadFormSubmit(clientcode, totalIns, totalamt, transtype,false,fileurl+filename)
.getrefnumAch(0,23)
.click_File_Level_View_Link()
.filter_FileLevel_Record(clientcode,paytype)
.clickLogoutLink();

//getrefnumer="RBAU2703.128";
		getnewurl();
		new	HDFC_Login_Page(driver, test)
		.fillCredentials(authuserid, authpwd,authdomain)
		.clickCashServiceLink()
		.clickDisbursementLink()
		.clickFLA_AuthLink()
	
		
		.filter_FileLevelAuth_Record(clientcode,"All")
		.clickfilenameSort()
		.authorizeflaRecord(filename,otp)
		.clickBackButton()


		.filter_FileLevelAuth_Record(clientcode,"All")
		.clickfilenameSort()

		.getAuthStatus("A")
		.clickSalary_ConfirmRecord(filename) 
		.defaultFlaLink()
.clickFLA_Link()
		.filter_FileLevelAuth_Record(clientcode,"All")
		.clickfilenameSort()		
		.getFinalStatus();




		clickLogoutLink();


		}
		catch (Exception e) {
		clickLogoutLink_FailCase();

		throw new Exception();


		}

		}
		}