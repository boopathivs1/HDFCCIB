package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CorpBeneficiary_Page extends ProjectWrapp{
	public   CorpBeneficiary_Page (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public CorpBeneficiary_Page clickcorpBenelink() throws InterruptedException{
		LeftMenuFrames();
				clickByXpathExplict(prop.getProperty("click.corp.bene.xpath"));
				
				return this;
			
			}
	
	public CorpBeneficiary_Page clickcorpbeneNewlink() throws InterruptedException{
		
				clickByXpathExplict(prop.getProperty("click.corp.bene.new.xpath"));
				
				defaultcontent();
				return this;
			
			}
	
	public CorpBeneficiary_Page clickcorpbeneAuthorize() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.bene.authorize.xpath"));
		
		defaultcontent();
		return this;
	
	}
	
		
	
	public CorpBeneficiary_Page fillCorpBeneform(String Benecode,String Benename,String paytype,String address,String city,String Country,String ifsc,String creditacc) throws InterruptedException{
		
		contentFrames();
		enterByXpathExplict(prop.getProperty("enter.benecode.xpath"),Benecode);
		
		enterByXpathExplict(prop.getProperty("enter.benename.xpath"),Benename);
		
		selectVisibileTextByXPath(prop.getProperty("select.bene.paytype.xpath"),paytype);
		
		clickByXpathExplict(prop.getProperty("click.others.radiobtn"));
		
		clickByXpathExplict(prop.getProperty("click.other.benefunctiontype.xpath"));
		
		enterByXpathExplict(prop.getProperty("enter.name.address.xpath"),address);
		
		enterByXpathExplict(prop.getProperty("enter.city.xpath"),city);
		
		selectVisibileTextByXPath(prop.getProperty("select.country.xpath"),Country);
		
		enterByXpathExplict(prop.getProperty("enter.ifsc.code.xpath"),ifsc);
		
		
		clickByXpathExplict(prop.getProperty("click.ifsc.search.xpath"));
		Thread.sleep(3000);
		acceptAlert();
		Thread.sleep(3000);
		
		
		enterByXpathExplict(prop.getProperty("enter.bene.creditacc..xpath"),creditacc);
		
		
		
		clickByXpathExplict(prop.getProperty("click.bene.save.xpath"));

		
		return this;
	}
	
	
	
public CorpBeneficiary_Page fillCorpBeneInternal_FundTransferform(String Benecode,String Benename,String paytype,String address,String city,String Country,String ifsc,String creditacc)throws InterruptedException{
		
		contentFrames();
		enterByXpathExplict(prop.getProperty("enter.benecode.xpath"),Benecode);
		
		enterByXpathExplict(prop.getProperty("enter.benename.xpath"),Benename);
		
		selectVisibileTextByXPath(prop.getProperty("select.bene.paytype.xpath"),paytype);
		
		clickByXpathExplict(prop.getProperty("click.others.radiobtn"));
		
		clickByXpathExplict(prop.getProperty("click.other.benefunctiontype.xpath"));
		
		enterByXpathExplict(prop.getProperty("enter.name.address.xpath"),address);
		
		enterByXpathExplict(prop.getProperty("enter.city.xpath"),city);
		
		selectVisibileTextByXPath(prop.getProperty("select.country.xpath"),Country);
		
//		enterByXpathExplict(prop.getProperty("enter.ifsc.code.xpath"),ifsc);
//		
//		
//		clickByXpathExplict(prop.getProperty("click.ifsc.search.xpath"));
//		Thread.sleep(3000);
//		acceptAlert();
//		Thread.sleep(3000);
		
		enterByXpathExplict(prop.getProperty("enter.bene.inteecreditacc.xpath"),creditacc);
		
		//enterByXpathExplict(prop.getProperty("enter.bene.inter.branch.xpath"),Branchname);
		
		clickByXpathExplict(prop.getProperty("enter.bene.inter.branch.xpath"));
		
		clickByXpathExplict(prop.getProperty("click.bene.proceed.xpath"));

		
		return this;
	}


	public CorpBeneficiary_Page VerifyBeneCreationSuccess() throws InterruptedException{
		
		verifyElementpresentByXpathExplicitwait(prop.getProperty("verify.bene.succss.xpath"));

		defaultcontent();
		return this;
	}
	
	
public CorpBeneficiary_Page VerifyBeneAuthorisationSuccess() throws InterruptedException{
		
		verifyElementpresentByXpathExplicitwait(prop.getProperty("verify.bene.authorizer.success"));
		return this;
	}
	
public CorpBeneficiary_Page fillCorpBeneAuthorizerform(String Benecode,String Benename,String Creatortype) throws InterruptedException{
		
		contentFrames();
		enterByXpathExplict(prop.getProperty("enter.authorizer.benecode.xpath"),Benecode);
		clickByXpathExplict(prop.getProperty("click.auth.searchcode.xpath"));
		
	
		Thread.sleep(3000);
		selectVisibileTextByXPath(prop.getProperty("select.benecode.xpath"),Benecode);
		
		enterByXpathExplict(prop.getProperty("enter.benename.xpath"),Benename);
		
		selectVisibileTextByXPath(prop.getProperty("select.createtype.xpath"),Creatortype);
		
		clickByXpathExplict(prop.getProperty("click.authbene.view"));

		
		return this;
	}
public CorpBeneficiary_Page AuthorizeBene(String Benename,String pwd) throws InterruptedException{
	
	
	clickByXpathExplict(".//table//input[@value='"+Benename+"']//preceding-sibling::td/input");
	

	clickByXpathExplict(prop.getProperty("click.authorize.cheqre.xpath"));
Thread.sleep(4000);
	
	enterByXpathExplict(prop.getProperty("enter.authpwd.xpath"),pwd);	

clickByXpathExplict(prop.getProperty("click.authsubmit.xpath"));


	
	
	return this;
}



	
	
}
