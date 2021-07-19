package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_211_ReverseFile_TLV  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC211";
		testDescription="ReverseFile_TLA";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC211";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String domain,String clientcode,
		String totalIns,String totalamt,String transtype,String filename,
			
		String Company,String status,String Uploadtype,String PaymentType,String accno,String uptype,String ptype,String type,String datas0,String data1,String data10,String data11,
			String data12,String data14,String data15,
			String data16) throws Exception{
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
int endindex=4;
String  serial_startnumber="7";
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

//.CMSUploadFormSubmit(clientcode, totalIns, totalamt, transtype, false,fileurl+filename)
.CMSUploadFormSubmit(clientcode, totalIns, totalamt, transtype, false,Renamedfilename_loc)
.getrefnum()
.click_Transaction_Level_View_Link()
.filter_TransactionLevel_Record(Company, status, clientcode,getrefnumer,PaymentType)
.ReverseTlaRecord()

.clickLogoutLink();


		



}
catch (Exception e) {
	
clickLogoutLink();
throw new Exception();

// TODO: handle exception
}

}
}