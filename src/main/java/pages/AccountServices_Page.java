package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class AccountServices_Page extends ProjectWrapp{
	public   AccountServices_Page (RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	
	public AccountServices_Page clickBalancelink() throws InterruptedException{
		LeftMenuFrames();
				clickByXpathExplict(prop.getProperty("click.balance.xpath"));
				
				return this;
			
			}
	
	public AccountServices_Page clickStatementlink() throws InterruptedException{
		LeftMenuFrames();
				clickByXpathExplict(prop.getProperty("click.statement.xpath"));
				
				
				return this;
			
			}
	
	public AccountServices_Page clickStatementFormatlink() throws InterruptedException{
		LeftMenuFrames();
				clickByXpathExplict(prop.getProperty("click.statement.format.xpath"));
				
				
				return this;
			
			}
	
	

	public AccountServices_Page clickChequestatusinquirylink() throws InterruptedException{
		LeftMenuFrames();
				clickByXpathExplict(prop.getProperty("click.cheque.status.xpath"));
				
				
				return this;
			
			}
	
	public AccountServices_Page clickCreateTemplatelink() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.create.template.xpath"));
		defaultcontent();
		return this;
	
	}
	
public AccountServices_Page clickInitiatelink() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.initiate.xpath"));
		defaultcontent();
		return this;
	
	}
	
public AccountServices_Page clickViewlink() throws InterruptedException{
	LeftMenuFrames();
	clickByXpathExplict(prop.getProperty("click.chequestatus.view.xpath"));
	defaultcontent();
	return this;

}
	
	public AccountServices_Page clickEditTemplatelink() throws InterruptedException{
		LeftMenuFrames();
				clickByXpathExplict(prop.getProperty("click.edit.template.xpath"));
				defaultcontent();
				
				
				return this;
			
			}
	
	
	public AccountServices_Page clickHistoryBalancelink() throws InterruptedException{
		
				clickByXpathExplict(prop.getProperty("click.historical.balance.xpath"));
				defaultcontent();
				return this;
			
			}
	
	public AccountServices_Page clickDealerBalancelink() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.dealer.balance.xpath"));
		defaultcontent();
		return this;
	
	}
	
	
	
	public AccountServices_Page clickConsolidatedstatementlink() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.consolidated.statement.xpath"));
		defaultcontent();
		return this;
	
	}
	public AccountServices_Page clickSummarylink() throws InterruptedException{
		
				clickByXpathExplict(prop.getProperty("click.summary.xpath"));
				defaultcontent();
				
				return this;
			
			}
	
	
	public AccountServices_Page fillBalanceSummaryform(String company,String branch,String acc,String currency) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.company.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.branch.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.acc.xpath"),acc);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.currency.xpath"),currency);
		
		clickByXpathExplict(prop.getProperty("click.accountservice.view.xpath"));

		
		return this;
	}
	

	public AccountServices_Page fillHistoryBalanceSummaryform(String company,String branch,String acc) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.Historybalcompany.xpath"),company);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.branch.xpath"),branch);
		
		selectVisibileTextByXPath(prop.getProperty("select.accountservices.acc.xpath"),acc);
		
		clickByXpathExplict(prop.getProperty("click.accountservice.view.xpath"));

		
		return this;
	}
	
public AccountServices_Page fillDealerbalSummaryform(String Remitter) throws InterruptedException{
		
		contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.dealer.remitter.xpath"),Remitter);
		
		clickByXpathExplict(prop.getProperty("click.accountservice.view.xpath"));

		
		return this;
	}



public AccountServices_Page fillConsolidatedform(String formattype) throws InterruptedException{
	
	contentFrames();
	selectVisibileTextByXPath(prop.getProperty("select.consolidated.format.xpath"),formattype);
	
	return this;
}

public AccountServices_Page fillConsolidatedformDownloadType(String Downloadtype) throws InterruptedException{
	
	contentFrames();
	selectVisibileTextByXPath(prop.getProperty("select.consolidated.downloadtype.xpath"),Downloadtype);
	
	return this;
}


public AccountServices_Page fillTemplateform(String Templatename,String formattype,String dateformat) throws InterruptedException{
	
	contentFrames();
	
	enterByXpathExplict(prop.getProperty("enter.template.name.xpath"),Templatename);
	selectVisibileTextByXPath(prop.getProperty("select.formattype.xpath"),formattype);
	selectVisibileTextByXPath(prop.getProperty("select.dateformat.xpath"),dateformat);
	clickByXpathExplict(prop.getProperty("click.template.xave.xpath"));
	
	return this;
}



public AccountServices_Page fillCheckReqform(String company,String branch,String acc,String chqFrm,String chqTo) throws InterruptedException{
	
	contentFrames();
	selectVisibileTextByXPath(prop.getProperty("select.company.dropdown.xpath"),company);
	
	selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
	
	selectVisibileTextByXPath(prop.getProperty("select.acc.dropdown.xpath"),acc);
	
	enterByXpathExplict(prop.getProperty("enter.cheqfrm.xpath"),chqFrm);
	enterByXpathExplict(prop.getProperty("enter.cheqto.xpath"),chqTo);
	
	clickByXpathExplict(prop.getProperty("click.checq.enquiry.xpath"));

	
	return this;
}

public AccountServices_Page fillViewCheckReqform(String company,String branch,String acc,String chqFrm,String chqTo,String Status ) throws InterruptedException{
	
	contentFrames();
	selectVisibileTextByXPath(prop.getProperty("select.company.dropdown.xpath"),company);
	
	selectVisibileTextByXPath(prop.getProperty("select.branch.dropdown.xpath"),branch);
	
	selectVisibileTextByXPath(prop.getProperty("select.acc.dropdown.xpath"),acc);
	
	enterByXpathExplict(prop.getProperty("enter.cheqfrm.xpath"),chqFrm);
	enterByXpathExplict(prop.getProperty("enter.cheqto.xpath"),chqTo);
	selectVisibileTextByXPath(prop.getProperty("select.chequestatus.xpath"),Status);
	clickByXpathExplict(prop.getProperty("click.checkview.xpath"));

	
	return this;
}



public AccountServices_Page EDitTemplateform(String Templatename,String UpdatedFormattype) throws InterruptedException{
	
	contentFrames();

	selectVisibileTextByXPath(prop.getProperty("select.edit.format.xpath"),Templatename);
	selectVisibileTextByXPath(prop.getProperty("select.edit.formattype.xpath"),UpdatedFormattype);
	clickByXpathExplict(prop.getProperty("click.template.xave.xpath"));
	
	return this;
}


public AccountServices_Page VerifyTemplateCreationSuccess() throws InterruptedException{
	
	verifyElementpresentByXpathExplicitwait(prop.getProperty("verify.template.success.xpath"));
	defaultcontent();
	
	return this;
}

public AccountServices_Page VerifyChequestatusEnquirySuccess() throws InterruptedException{
	
	verifyElementpresentByXpathExplicitwait(prop.getProperty("verify.chequestatusinquiry.success.xpath"));
	defaultcontent();
	
	return this;
}


public AccountServices_Page VerifyUpdatedTemplateSuccess() throws InterruptedException{
	
	verifyElementpresentByXpathExplicitwait(prop.getProperty("verify.Updated.template.success.xpath"));
	
	return this;
}

public AccountServices_Page ClickBack() throws InterruptedException{
	
	clickByXpathExplict(prop.getProperty("click.template.back.xpath"));
	
	return this;
}


public AccountServices_Page SelectRecord() throws InterruptedException{
	
	
	
	return this;
}
	
	
	
	public LogoutPages clickReport()
	{
		
		clickByXpathExplict(prop.getProperty("click.accountservice.Report.xpath"));
		return new LogoutPages(driver, test);
	}
	
	
	public LogoutPages clickDownload()
	{
		
		clickByXpathExplict(prop.getProperty("click.accountservice.Download.xpath"));
		return new LogoutPages(driver, test);
	}
	
	public LogoutPages clickConsolidatedDownload() throws InterruptedException
	{
		
		clickByXpathExplict(prop.getProperty("click.consolidated.download.xpath"));
		Thread.sleep(3000);
		acceptAlert();
		Thread.sleep(3000);
		
		return new LogoutPages(driver, test);
	}
			
	public LogoutPages clickConsolidatedTypeDownload() throws InterruptedException
	{
		
		clickByXpathExplict(prop.getProperty("select.consolidated.downloadtype.download.xpath"));
		Thread.sleep(3000);
		acceptAlert();
		Thread.sleep(3000);
		
		return new LogoutPages(driver, test);
	}


	
	
}
