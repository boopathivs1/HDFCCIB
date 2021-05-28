package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_34a_ACH_Payment_type_Debit  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC34a";
		testDescription="ACH Payment type-Debit";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC34a";
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
			//System.out.println("Actual filename is "+filesname1);
			int startindex=0;
			int endindex=13;
			String  serial_startnumber="4";
			String renamedfilename=renamed_filename_year(filesname1,startindex,endindex, serial_startnumber);
		
			String actualfilename=fileurl+filename+filesname1;
			String Renamedfilename_loc=fileurl+filename+renamedfilename;
			convention(actualfilename,Renamedfilename_loc);

//	String currentdate=dateMonthSlash();
			int li_no=0;
			int va_in=3;
			String value1 =filespecific_cont(li_no, va_in,Renamedfilename_loc);
	String value2=value1.substring(0,26);
		String accno_date=value2+GetTodayDate();
		modifyFile(Renamedfilename_loc,value1,accno_date);

			

			
	content_check(1,10,Renamedfilename_loc);
	content_check(2,8,Renamedfilename_loc);
		content_check(3,10,Renamedfilename_loc);
		content_check(4,8,Renamedfilename_loc);
		content_check(5,9,Renamedfilename_loc);
		content_check(6,9,Renamedfilename_loc);
		content_check(7,9,Renamedfilename_loc);
		content_check(8,8,Renamedfilename_loc);
		content_check(9,8,Renamedfilename_loc);
		content_check(10,12,Renamedfilename_loc);

//		String value3 =filespecific_cont(1,10,Renamedfilename_loc);
//		String value4=removeLastTwoString(value3);
//		String final_row_1=value4+gettwoRandomNumberString();					
//		modifyFile(Renamedfilename_loc,value3,final_row_1);

		
		
		//		
		
			
			
//			System.out.println(value);
//			System.out.println("oooooooooooo");
//			modifyFile(Renamedfilename_loc,value,currentdate);


//			getrefnumer="ACHDBCR2ACHDB010421.402";
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, domain)
.clickCashManageServiceLink()
.clickDisbursementLink()
.clickUploadLink()
.CMSUploadFormSubmit(clientcode, totalIns, totalamt, transtype,false,Renamedfilename_loc)
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
	
		
		.filter_FileLevelAuth_Record(clientcode,paytype)
		.clickfilenameSort()
		.authorizeflaRecord(renamedfilename,otp)
		.clickBackButton()


		.filter_FileLevelAuth_Record(clientcode,paytype)
		.clickfilenameSort()

		.getAuthStatus("A")
		.bulkAuth_Status(renamedfilename, clientcode, transtype);

//		.clickSalary_ConfirmRecord(renamedfilename) 
//		.defaultFlaLink()
//.clickFLA_Link()
//		.filter_FileLevelAuth_Record(clientcode,paytype)
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