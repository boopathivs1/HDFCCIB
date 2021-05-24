package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_24_Current_Date_TLA  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC24";
		testDescription="Current_Date_TLA";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC24";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String domain,String clientcode,
		String totalIns,String totalamt,String transtype,String filename,
			
		String authuserid,String authpwd,String authdomain,String Compname,String accno,String paytype,String otpcode,
			
			
		
			
			String uploadtype,String datas0,String data1,String data10,String data11,
			String data12,String data14,String data15,
			String data16) throws Exception{
		try{

		getnewurl();
	new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, domain)
.clickCashManageServiceLink()
.clickDisbursementLink()
.clickUploadLink()

.CMSUploadFormSubmit(clientcode, totalIns, totalamt, transtype, false,fileurl+filename)
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
.filter_TransLevelAuth_Record(Compname,"Pending for first Authorisation", clientcode, accno, uploadtype, paytype)
.clickTransNoSort()
.authorizeTlaRecord(otpcode)

.clickTLA_Link()
.filter_TransLevelAuth_Record(Compname,"Authorised",clientcode,accno,uploadtype,paytype)


.clickTransNoSort()
.getAuthStatus("A")
.clicktla_ConfirmRecord()
.clickTLA_Link()
.filter_TransLevelAuth_Record(Compname,"Confirmed",clientcode,accno,uploadtype,paytype)
.clickTransNoSort()
.getAuthStatus("C")
.defaultcontent_Switch()

.clickTLA_Link()
.filter_TransLevelAuth_Record(Compname,"ALL",clientcode,accno,uploadtype,paytype)
.clickTransNoSort()
.getAuthStatus("C")

.defaultcontent_Switch()



.filter_TransLevelAuth_Record(Compname,"ALL", clientcode, accno,uploadtype, paytype)
.clickTransNoSort()
.getFinalStatus();




clickLogoutLink();


}
catch (Exception e) {
clickLogoutLink();
throw new Exception();

// TODO: handle exception
}

}
}