package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;

public class Tc_23_Billpay extends ProjectWrapp {
	
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC23";
		testDescription="Billpay";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC23";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String status,String name,String company,String branch,String accno,
			 String authuserid,String authpwd,
			String authgroupid,String SelectStatus,String Paytype,String acccode,String compid,String data,
			String acc12,String statecode,String Prodcode,String data13,String data14,String data15,String data17,String data20) throws Exception{
		try{
			
			getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickBillpay()
.clickBillpaysubmenu()
.clickReview()
.fillBillpaymentform(status, name, company, branch, accno)
.getrefnumber()
.clickLogout();		
		
		getnewurl();
		
		new	HDFC_Login_Page(driver, test)
.fillCredentials(authuserid, authpwd, authgroupid)
.clickBillpay()
.clickBillpaysubmenu()
.clickAuthorizebill()
.filterBilpayAuthorize(SelectStatus,name)
.clickViewLink()
.clickBillpayfirstAuthRec()
.AuthorizePwd(Authotp)
.contentFrame()
.Clickback()
.filterBilpayAuthorize(SelectStatus,name)
.clickViewLink()
//.authrecordFrame()
.getBillpayAuthStatus("A")
.checkBillpayStatus();

//.clickfirstAuthRec()
//.confirmRecord()
//.contentFrame()
//.Clickback()
//.ClickWCDLReport()
//.clickWCDLViewLink()
//.getWCDLFinalStatus();

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
	


