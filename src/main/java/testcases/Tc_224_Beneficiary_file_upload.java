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
public class Tc_224_Beneficiary_file_upload  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC224";
		testDescription="upload Corporate Beneficiary -Creation";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC224";
		LogoutStatus=true;	
		usertype="CIBUser";
	//	SimulatorFileName="Gen_s2s_UPload_Netweaver_INTER.html";		
	}
	

			
			
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String domain
			,String filename,
		
			
		String authuserid,String authpwd,String authdomain,String Beneid,String creatortype,String accno,
		String paytype,String uploadtype,String otp,String totalIns,String totalamt,String transtype,String data5,String datas0,String data1,String data10,
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
int endindex=3;
String  serial_startnumber="1";
 //renamedfilename=renamed_filename_one(filesname1,startindex,endindex, serial_startnumber);
 renamedfilename=renamed_filename_year(filesname1, startindex, endindex, serial_startnumber); 
 
 
System.out.println(renamedfilename);
String actualfilename=fileurl+filename+filesname1;
String Renamedfilename_loc=fileurl+filename+renamedfilename;
System.out.println("++++++++++++");
System.out.println(Renamedfilename_loc);
System.out.println("++++++++++++");
convention(actualfilename,Renamedfilename_loc);

System.out.println(renamedfilename);







String currentdate=dateMonthSlash();
int li_no=0;
int va_in=20;
String value =filespecific_text(li_no, va_in,Renamedfilename_loc);
System.out.println(value);
System.out.println("oooooooooooo");
modifyFile(Renamedfilename_loc,value,currentdate);










int li_num=0;
int va_ins=0;
String value1 =filespecific_text(li_num, va_ins,Renamedfilename_loc);
String value3=value1.substring(0,8);
String rannumA=gettwoRandomNumber_range_String(100,500);
String benecode=value3+rannumA;
System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
System.out.println(value1);
System.out.println(benecode);
//String value2=value1.substring(0,1);
//String file1srowcol=value2+filenameonly+value3;
//System.out.println(file1srowcol);
modifyFile(Renamedfilename_loc,value1,benecode);


int li_numsec=1;
String value4 =filespecific_text(li_numsec, va_ins,Renamedfilename_loc);
String value6=value4.substring(0,8);
String rannumb=gettwoRandomNumber_range_String(501,999);
String benecodenum=value6+rannumb;
System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
System.out.println(value4);
System.out.println(benecodenum);
//String value2=value1.substring(0,1);
//String file1srowcol=value2+filenameonly+value3;
//System.out.println(file1srowcol);
modifyFile(Renamedfilename_loc,value4,benecodenum);


getnewurl();

new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd,domain)
.clickAdministration()
.clickcorpBenelink()
//.clickcorpbeneNewlink()
.uploadcorpbene(Renamedfilename_loc);
//.reliance_fillCorpBeneform(Benefcode, Benefname, paytype, address, city, Country, ifsc, creditacc,corpname);
////.VerifyBeneCreationSuccess();
clickLogoutLink();	

getnewurl();
new	HDFC_Login_Page(driver, test)
.fillCredentials(authuserid, authpwd, authdomain)
.clickAuthAdministration()
.clickcorpBenelink()
.clickcorpbeneAuthorize()
.uploadBeneAuthorizerform(creatortype,renamedfilename)
.uploadAuthorizeBene(Benefcode, Authotp)
.VerifyBeneAuthorisationSuccess();

defaultcontent();		
clickLogoutLink();


}
catch (Exception e) {
clickLogoutLink();
throw new Exception();

// TODO: handle exception
}

}
}