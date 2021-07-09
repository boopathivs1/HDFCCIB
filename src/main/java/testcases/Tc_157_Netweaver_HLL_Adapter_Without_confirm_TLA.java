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
public class Tc_157_Netweaver_HLL_Adapter_Without_confirm_TLA  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC157";
		testDescription="Netweaver_HLL_Adapter With_confirm_TLA";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC157";
		LogoutStatus=true;	
		usertype="CIBUser";
		SimulatorFileName="Gen_s2s_UPload_Netweaver_INTER.html";		
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
String  serial_startnumber="5";
 renamedfilename=renamed_filename_one(filesname1,startindex,endindex, serial_startnumber);
System.out.println(renamedfilename);
String actualfilename=fileurl+filename+filesname1;
String Renamedfilename_loc=fileurl+filename+renamedfilename;
System.out.println("++++++++++++");
System.out.println(Renamedfilename_loc);
System.out.println("++++++++++++");
convention(actualfilename,Renamedfilename_loc);

int li_no=0;
int va_in=0;
String value1 =filespecific_cont(li_no, va_in,Renamedfilename_loc);
int g=13;
int h=25;
filenameonly=filename_substring(renamedfilename,g,h);
//getrefnumer=filenameonly;
String value3=value1.substring(1,5);
String value2=value1.substring(0,1);
String file1srowcol=value2+filenameonly+value3;
System.out.println(file1srowcol);
modifyFile(Renamedfilename_loc,value1,file1srowcol);





int li1=1;
int val0=0;
String val4 =filespecific_cont(li1, val0,Renamedfilename_loc);
String olddateval=val4.substring(1,11);
modifyFile(Renamedfilename_loc,olddateval,dateMonthSlash());







int sub_a=0;
int sub_b=5;
int revval_subc=1;
int revval_subd=11;
int ran_a=10000;
int ran_b=99999;
//ach_content_check_lastString(7,0, Renamedfilename_loc, sub_a,sub_b,ran_a,ran_b);
//
ach_content_check_lastString_returnval(6,0, Renamedfilename_loc, revval_subc, revval_subd, sub_a, sub_b, ran_a, ran_b);
ach_content_check_lastString_returnval(7,0, Renamedfilename_loc, revval_subc, revval_subd, sub_a, sub_b, ran_a, ran_b);
ach_content_check_lastString_returnval(8,0, Renamedfilename_loc, revval_subc, revval_subd, sub_a, sub_b, ran_a, ran_b);
ach_content_check_lastString_returnval(9,0, Renamedfilename_loc, revval_subc, revval_subd, sub_a, sub_b, ran_a, ran_b);
//ach_content_check_lastString_returnval(11,0, Renamedfilename_loc, revval_subc, revval_subd, sub_a, sub_b, ran_a, ran_b);



//String currentdate=dateMonthSlash();
//int li_no=0;
//int va_in=22;
//String value =filespecific_text(li_no, va_in,Renamedfilename_loc);
//System.out.println(value);
//System.out.println("oooooooooooo");
//modifyFile(Renamedfilename_loc,value,currentdate);



//System.out.println("rrrrrrrrrrrrrrrrrrrrrrrr"+renamedfilename);
//
//
////String filesname2=getfilename_one(filename);
//int g=13;
//int h=25;
//filenameonly=filename_substring(renamedfilename,g,h);
//getrefnumer=filenameonly;
//System.out.println("substring  is "+filenameonly);

	
getSimulatorUrl();
new GenS2S(driver, test)
.Netweaverfillsubmit(Renamedfilename_loc);
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
	.filter_TransLevelAuth_Record(Compname,"Pending for first Authorisation", clientcode, accno, filenameonly, paytype)
	.clickTransNoSort()
	.authorizeTlaRecord(authpwd)

	.clickTLA_Link()
	.filter_TransLevelAuth_Record(Compname,"ALL",clientcode,accno,filenameonly,paytype)


	.clickTransNoSort()
	.getAuthStatus_tla("A")

	.authorize_CheckStatus_TL(Compname,clientcode,accno,filenameonly,paytype);

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