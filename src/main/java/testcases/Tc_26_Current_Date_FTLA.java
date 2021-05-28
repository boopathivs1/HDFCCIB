package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_26_Current_Date_FTLA  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC26";
		testDescription="Current_Date_FTLA";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC26";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String domain,String clientcode,
		String totalIns,String totalamt,String transtype,String filename,
			
		String authuserid,String authpwd,String authdomain,String Compname,String accno,String uploadtype,String paytype,String otpcode,
			
			String datas0,String data1,String data10,String data11,
			String data12,String data14,String data15,
			String data16) throws Exception{
		try{

			
			String filesname1=getfilename_one(filename);
			System.out.println("Actual filename is "+filesname1);
			int startindex=0;
			int endindex=4;
			String  serial_startnumber="1";
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
			int li_no=1;
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


				getnewurl();
		new	HDFC_Login_Page(driver, test)
		.fillCredentials(authuserid, authpwd,authdomain)
		.clickCashServiceLink()
		.clickDisbursementLink()

		.clickTLA_AuthLink()
		.filter_TransLevelAuth_Record(Compname,"Pending for first Authorisation", clientcode, accno,renamedfilename, paytype)
		.clickTransNoSort()
		.authorizeFTlaRecord(otpcode)

		.clickTLA_Link()
		.filter_TransLevelAuth_Record(Compname,"Authorised",clientcode,accno,renamedfilename,paytype)
		.clickTransNoSort()
		.getftlaAuthStatus(uploadtype,"A")
		.clickFtla_ConfirmRecord()
		.clickTLA_Link()
		.filter_TransLevelAuth_Record(Compname,"Confirmed",clientcode,accno,renamedfilename,paytype)
		.clickTransNoSort()
		.getftlaAuthStatus(uploadtype,"C")
		.defaultcontent_Switch()

		.clickTLA_Link()
		.filter_TransLevelAuth_Record(Compname,"ALL",clientcode,accno,renamedfilename,paytype)
		.clickTransNoSort()
		.getftlaAuthStatus(uploadtype,"C")

		.defaultcontent_Switch()

		.filter_TransLevelAuth_Record(Compname,"ALL", clientcode, accno,renamedfilename, paytype)
		.clickTransNoSort()
		.getFTLAFinalStatus(uploadtype);

		clickLogoutLink();


		}
		catch (Exception e) {
		clickLogoutLink();
		throw new Exception();

		// TODO: handle exception
		}

		}
		}