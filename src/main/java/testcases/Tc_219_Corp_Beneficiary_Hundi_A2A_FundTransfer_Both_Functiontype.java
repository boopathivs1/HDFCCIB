package testcases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HDFC_Login_Page;
import wrappers.ProjectWrapp;
public class Tc_219_Corp_Beneficiary_Hundi_A2A_FundTransfer_Both_Functiontype  extends ProjectWrapp {
	@BeforeClass(groups={"common"})
	public void setDatag() {
		testCaseName="TC216";
		testDescription="Corp_Beneficiary_Hundi_A2A_FundTransfer_Both_Functiontype";
		browserName="Chrome";
		dataSheetName="HDFCCIB";
		category="Regression";
		authors="Sreejith";
		testKeyword="TC219";
		LogoutStatus=true;	
		usertype="CIBUser";
	}
	@Test(groups={"sanity"},dataProvider="fetch")
	public void checkAccSummary(String casename,String userid,String pwd,String groupid,String Benecode,String Benename,
			String paytype,String address,String city,String Country,String ifsc, String creditacc,String authuserid,String authpwd,String authgroupid,String Creatortype,String SelectStatus,String Ptype, 
			String apwd,String autid,String cid,String Relclientcode,String Relcompcode,String Status,String Branchname
			) throws Exception{
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
.fillCorpBeneInternal_FundTransferform(Benefcode, Benefname, paytype, address, city, Country, ifsc, creditacc);
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