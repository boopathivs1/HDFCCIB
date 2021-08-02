package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_223_Reliance_Both_function_type  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC223";
		testDescription="Screen new for Reliance  in Both function type";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Boopathi";
		testKeyword="TC223";
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
.reliance_fillCorpBeneform(Benefcode, Benefname, paytype, address, city, Country, ifsc, creditacc,corpname);
//.VerifyBeneCreationSuccess();
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