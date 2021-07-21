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
public class Tc_203_S2S_Upload_File_Borker_onlychecksum  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC203d";
		testDescription="S2S_Upload_File Brokerpayout_Paymenttype";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC203d";
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
			String  serial_startnumber="3";
			 renamedfilename=renamed_filename_one(filesname1,startindex,endindex, serial_startnumber);
			System.out.println(renamedfilename);
			String actualfilename=fileurl+filename+filesname1;
			String Renamedfilename_loc=fileurl+filename+renamedfilename;
			System.out.println("++++++++++++");
			System.out.println(Renamedfilename_loc);
			System.out.println("++++++++++++");
		convention(actualfilename,Renamedfilename_loc);
//			String filesname1=getfilename_one(filename);
//			System.out.println("Actual filename is "+filesname1);
//			int startindex=0;
//			int endindex=4;
//			String  serial_startnumber="5";
//		renamedfilename=renamed_filename_one(filesname1,startindex,endindex, serial_startnumber);
//			System.out.println(renamedfilename);
//			String actualfilename=fileurl+filename+filesname1;
//			String Renamedfilename_loc=fileurl+filename+renamedfilename;
//			System.out.println("++++++++++++");
//			System.out.println(Renamedfilename_loc);
//			System.out.println("++++++++++++");
//			convention(actualfilename,Renamedfilename_loc);
//		
//			String currentdate=dateMonthSlash();
//			int li_no=2;
//			int va_in=22;
//			String value =filespecific_text(li_no, va_in,Renamedfilename_loc);
//			System.out.println(value);
//			System.out.println("oooooooooooo");
//			modifyFile(Renamedfilename_loc,value,currentdate);


			int g=13;
			int h=25;
			filenameonly=filename_substring(renamedfilename,g,h);
			getrefnumer=filenameonly;
			System.out.println("substring  is "+filenameonly);

		
			
			
			copy_file(fileurl+filename,only_Checksum_Pick_Path);
			Start_bat_Execution();
			service_killer();
			String finaldropfilepath=Only_Check_SumDROPDIR+"/"+renamedfilename;


getSimulatorUrl();
new GenS2S(driver, test)
.fillsubmit(finaldropfilepath);

//.fillsubmit(finaldropfilepath);
}

		
		catch (Exception e) {
throw new Exception();
}
		try{
			
		
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, domain)
.clickCashManageServiceLink_first()
.click_DisbursementLink()
.click_File_Level_View_Link()


//.click_File_Level_View_Link()
.filter_FileLevel_Record(clientcode,transtype)
.clickLogoutLink();


		getnewurl();
		new	HDFC_Login_Page(driver, test)
		.fillCredentials(authuserid, authpwd,authdomain)
		.clickCashServiceLink()
		.clickDisbursementLink()
		.clickFLA_AuthLink()
	
		
		.filter_FileLevelAuth_Record(clientcode,transtype)
		.clickfilenameSort()
		.authorizeflaRecord(filenameonly,authpwd)
		.clickBackButton()


		.filter_FileLevelAuth_Record(clientcode,transtype)
		.clickfilenameSort()

		
		
		.getAuthStatus("A")
		.bulkAuth_Status(filenameonly, clientcode, transtype);
		
//		.clickSalary_ConfirmRecord(renamedfilename) 
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