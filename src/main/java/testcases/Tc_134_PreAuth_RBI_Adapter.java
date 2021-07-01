package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.EPI_Payment_SimulatorPage;
import pages.GenS2S;
import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_134_PreAuth_RBI_Adapter  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC134";
		testDescription="PreAuth_RBI_Adapterr";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC134";
		LogoutStatus=true;	
		usertype="CIBUser";
		SimulatorFileName="Gen_s2s_UPloadNEtw_GEneric.html";		
	}
	

			
			
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String domain
			,String filename,String clientcode,
		String totalamt,String transtype,
			
		String authuserid,String authpwd,String authdomain,String Compname,String accno,
		String paytype,String uploadtype,String otp,String totalIns,String data5,String datas0,String data1,String data10,
		String data11,
			String data12,String data14,String data15) throws Exception{
	
		String filenameonly;
		String renamedfilename;
		try{
	
			
/*			
String file1=fileurl+filename;
String filesname1=getfilename(file1);
System.out.println(filesname1);	
String filename2=filesname1.substring(0,4);			
String ranNumber=gettwoRandomNumberString();
String finalfilenaming=filename_final("7",ranNumber, filename2);
System.out.println(finalfilenaming);
*/

			
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
String currentdate=dateMonthSlash();
int li_no=0;
int va_in=22;
String value =filespecific_text(li_no, va_in,Renamedfilename_loc);
System.out.println(value);
System.out.println("oooooooooooo");
modifyFile(Renamedfilename_loc,value,currentdate);



//System.out.println("rrrrrrrrrrrrrrrrrrrrrrrr"+renamedfilename);
//
//
//String filesname2=getfilename_one(filename);
int g=13;
int h=25;
filenameonly=filename_substring(renamedfilename,g,h);
getrefnumer=filenameonly;
System.out.println("substring  is "+filenameonly);

getSimulatorUrl();
new GenS2S(driver, test)
.fillsubmit(Renamedfilename_loc);
}

		
		catch (Exception e) {
throw new Exception();
}
		
		try{

	System.out.println("substring  is uuuuuuuuuuuuuuu"+filenameonly);
	System.out.println("substring  is uuuuuuuuuuuuuuu"+renamedfilename);
	getnewurl();
	new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, domain)
.clickCashManageServiceLink_first()
.click_DisbursementLink()
.click_File_Level_View_Link()
//.filter_FileLevel_Record(clientcode,transtype)

.filter_Cash_FileLevel_Record(clientcode,transtype, filenameonly)
.clickLogoutLink();

	getnewurl();
	new	HDFC_Login_Page(driver, test)
	.fillCredentials(authuserid, authpwd,authdomain)
	.clickCashServiceLink()
	.clickDisbursementLink()

.clickTLA_AuthLink()
//	.filter_TransLevelAuth_Record(Compname,"Pending for first Authorisation", clientcode, accno, uploadtype, paytype)
//	.clickTransNoSort()
//	.authorizeTlaRecord(Authotp)

	.clickTLA_Link()
	.filter_TransLevelAuth_Record(Compname,"ALL",clientcode,accno,uploadtype,paytype)


	.clickTransNoSort()
//	.getAuthStatus("A")

	.Preauthorize_CheckStatus_TLA(Compname,clientcode,accno,uploadtype,paytype);

	//.clicktla_ConfirmRecord()
	//.clickTLA_Link()
	//.filter_TransLevelAuth_Record(Compname,"Confirmed",clientcode,accno,uploadtype,paytype)
	//.clickTransNoSort()
	//.getAuthStatus("C")
	//.defaultcontent_Switch()
	//
	//.clickTLA_Link()
	//.filter_TransLevelAuth_Record(Compname,"ALL",clientcode,accno,uploadtype,paytype)
	//.clickTransNoSort()
	//.getAuthStatus("C")
	//
	//.defaultcontent_Switch()
	//
	//
	//
	//.filter_TransLevelAuth_Record(Compname,"ALL", clientcode, accno,uploadtype, paytype)
	//.clickTransNoSort()
	//.getFinalStatus();
	//
	//


	clickLogoutLink();


	}
	catch (Exception e) {
		clickLogoutLink_FailCase();
	throw new Exception();

	// TODO: handle exception
	}

	}
}