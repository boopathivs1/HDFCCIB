package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.GenS2S;
import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_145_PreAuth_Upload_File_collectiion_Adapter  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC145";
		testDescription="PreAuth_Upload_File_collectiion_Adapter";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC145";
		LogoutStatus=true;	
		usertype="CIBUser";
		SimulatorFileName="Gen_s2s_UPloadNEtw_GEneric.html";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String domain,
		String	clientcode,String totalIns,String totalamt,String transtype,String filename
			,String otp,	String authuserid,String authpwd,String authdomain,
			String data1,String data10,String data11,
			String data12,String data14,String data15,
			String data16,String data17,String data20,String data21,String data22,String data23) throws Exception{
		String filenameonly;
		String renamedfilename;
		try{
			String filesname1=getfilename_one(filename);
			System.out.println("Actual filename is "+filesname1);
			int startindex=0;
			int endindex=17;
			String  serial_startnumber="1";
			 renamedfilename=renamed_filename_one(filesname1,startindex,endindex, serial_startnumber);
			System.out.println(renamedfilename);
			String actualfilename=fileurl+filename+filesname1;
			String Renamedfilename_loc=fileurl+filename+renamedfilename;
			System.out.println("++++++++++++");
			System.out.println(Renamedfilename_loc);
			System.out.println("++++++++++++");
		convention(actualfilename,Renamedfilename_loc);
		
		int g=13;
		int h=25;
		filenameonly=filename_substring(renamedfilename,g,h);
		getrefnumer=filenameonly;
		System.out.println("substring  is "+filenameonly);
	
		
		
			//			String filesname1=getfilename_one(filename);
//			System.out.println("Actual filename is "+filesname1);
//			int startindex=0;
//			int endindex=5;
//			String  serial_startnumber="1";
//		renamedfilename=renamed_filename_one(filesname1,startindex,endindex, serial_startnumber);
//			System.out.println(renamedfilename);
//			String actualfilename=fileurl+filename+filesname1;
//			String Renamedfilename_loc=fileurl+filename+renamedfilename;
//			System.out.println("++++++++++++");
//			System.out.println(Renamedfilename_loc);
//			System.out.println("++++++++++++");
//			convention(actualfilename,Renamedfilename_loc);			
			int li_no=0;
			int va_in=1;
			String value =filespecific_text(li_no, va_in,Renamedfilename_loc);
			System.out.println(value);
			System.out.println("oooooooooooo");
	
			modifyFile(Renamedfilename_loc,value,"     "+filenameonly);
		int line_no=1;
		int se_in=5;
		String se_value =filespecific_text(line_no, se_in,Renamedfilename_loc);
		String value1=se_value.substring(0,6);
		String value2=se_value.substring(0,4);
		String SerialVal=value2+gettwoRandomNumberString();			
		modifyFile(Renamedfilename_loc,value1,SerialVal);

		
			
		
		getSimulatorUrl();
		new GenS2S(driver, test)
		.fillsubmit(Renamedfilename_loc);
		}

				
				catch (Exception e) {
		throw new Exception();
		}
		
			
//			String currentdate=dateMonthSlash();
//			int li_no=2;
//			int va_in=22;
//			String value =filespecific_text(li_no, va_in,Renamedfilename_loc);
//			System.out.println(value);
//			System.out.println("oooooooooooo");
//		modifyFile(Renamedfilename_loc,value,currentdate);

		
		
		
		
try{
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, domain)
.clickCashManageServiceLink_first()
.click_DisbursementLink()
.click_File_Level_View_Link()



//.CMSUploadFormSubmit(clientcode, totalIns, totalamt, transtype,true,Renamedfilename_loc)
//.getrefnum()

.filter_FileLevel_Record(clientcode,transtype)
.clickLogoutLink();

//getrefnumer="RBAU2703.128";
		getnewurl();
		new	HDFC_Login_Page(driver, test)
		.fillCredentials(authuserid, authpwd,authdomain)
		.clickCashServiceLink()
		.clickDisbursementLink()
		.clickFLA_AuthLink()
	
		
//		.filter_FileLevelAuth_Record(clientcode,transtype)
//		.clickfilenameSort()
//		.authorizeflaRecord(filenameonly,Authotp)
//		.clickBackButton()


		.filter_FileLevelAuth_Record(clientcode,transtype)
		.clickfilenameSort()

//		.getAuthStatus("A")
		.authorize_CheckStatus_FLA(filenameonly,clientcode,transtype);

		
		
//		.clickFla_ConfirmRecord(filename)
//		.defaultFlaLink()
//.clickFLA_Link()
//		.filter_FileLevelAuth_Record(clientcode,transtype)
//		.clickfilenameSort()		
//		.getFinalStatus();




		clickLogoutLink();


		}
		catch (Exception e) {
		clickLogoutLink_FailCase();

		throw new Exception();


		}

		}
		}