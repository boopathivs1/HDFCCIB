package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_222_Screen_new_ECMS_Both_function_type  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC222";
		testDescription="Screen new for ECMS in Both function type";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC222";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String Benecode,String Benename,
			String paytype,String address,String city,String Country,String ifsc, String creditacc,String authuserid,String authpwd,String authgroupid,String Creatortype,String corpname,String Ptype, 
			String apwd,String autid,String cid,String Relclientcode,String Relcompcode,String Status,
			String type) throws Exception{
		try{
			
			Benefcode =Benecode+gettwoRandomNumberString();
			Benefname =Benename+gettwoRandomNumberString();
			System.out.println(Benefcode);
			System.out.println(Benefname);
			getnewurl();
			
		new	HDFC_Login_Page(driver, test)
.fillCredentials(userid, pwd, groupid)
.clickAdministration()
.clickcorpBenelink()
.clickcorpbeneNewlink()
.ecms_fillCorpBeneform(Benefcode, Benefname, paytype, address, city, Country, ifsc, creditacc,corpname)
.VerifyBeneCreationSuccess();
clickLogoutLink();	
		
		getnewurl();
		new	HDFC_Login_Page(driver, test)
.fillCredentials(authuserid, authpwd, authgroupid)
.clickAuthAdministration()
.clickcorpBenelink()
.clickcorpbeneAuthorize()
.fillCorpBeneAuthorizerform(Benefcode, Benefname, Creatortype)
.AuthorizeBene(Benefcode, Authotp)
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