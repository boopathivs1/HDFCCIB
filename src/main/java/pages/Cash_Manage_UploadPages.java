package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import testcases.MessageCentre;
import wrappers.ProjectWrapp;

public class Cash_Manage_UploadPages  extends ProjectWrapp{
	public  Cash_Manage_UploadPages(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public Cash_Manage_UploadPages clickUploadLink() throws InterruptedException{
		//Thread.sleep(20000);
		topFrames();
		clickByXpathExplict(prop.getProperty("click.upload.link.cash.xpath"));
		defaultcontent();
		return new Cash_Manage_UploadPages(driver, test);
	
	}
	
	public Cash_Manage_UploadPages CMSUploadFormSubmit(String clientcode,String totalIns,String totalamt,String transtype,Boolean enablestatus,String filelocation) throws InterruptedException{
	contentFrames();
		selectVisibileTextByXPath(prop.getProperty("select.upload.clientcode.xpath"),clientcode);
		selectVisibileTextByXPath(prop.getProperty("select.transtype.xpath"),transtype);
		if(enablestatus){
enterByXpathExplict(prop.getProperty("select.totalinstruction.xpath"),totalIns);		
enterByXpathExplict(prop.getProperty("select.totalamt.xpath"),totalamt);	}	
		

uploadfile(prop.getProperty("upload.file.cms.xpath"),filelocation);
//clickByXpathExplict(prop.getProperty("click.cms.upload.xpath"));
clickByXpathExplictWithouScreenShot(prop.getProperty("click.cms.upload.xpath"));
		return this;
	
	}
	
	
	public Cash_Manage_UploadPages UploadFormSubmit(String clientcode,String totalIns,String totalamt,String transtype,Boolean enablestatus,String filelocation) throws InterruptedException{
		contentFrames();
			selectVisibileTextByXPath(prop.getProperty("select.upload.clientcode.xpath"),clientcode);
			selectVisibileTextByXPath(prop.getProperty("select.transtype.xpath"),transtype);
//			if(enablestatus){
//	enterByXpathExplict(prop.getProperty("select.totalinstruction.xpath"),totalIns);		
//	enterByXpathExplict(prop.getProperty("select.totalamt.xpath"),totalamt);	}	
//			

	uploadfile(prop.getProperty("upload.file.cms.xpath"),filelocation);
	//clickByXpathExplict(prop.getProperty("click.cms.upload.xpath"));
	clickByXpathExplictWithouScreenShot(prop.getProperty("click.cms.upload.xpath"));
			return this;
		
		}


	public Cash_Manage_UploadPages getrefnum() throws InterruptedException{
		
		
		String reference=getTextByXpath(prop.getProperty("get.refnum.fundtrans.xpath"));		
		//	String trimrefnum=regvalue(reference);
			getrefnumer=reference.substring(0,12);
				System.out.println(getrefnumer);
				
			
				defaultcontent();
				return this;
			}
	
public MessageCentre navigatemsg(){
	
	
	
	return new MessageCentre(driver, test);
	}

public Cash_Manage_UploadPages getrefnumAch(int a,int b) throws InterruptedException{
		
		
		String reference=getTextByXpath(prop.getProperty("get.refnum.fundtrans.xpath"));		
		//	String trimrefnum=regvalue(reference);
			getrefnumer=reference.substring(a,b);
				System.out.println(getrefnumer);
				
			
				defaultcontent();
				return this;
			}
			
	
	public File_Level_View_pages click_File_Level_View_Link() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.filelevel.view.xpath"));
	
	
	defaultcontent();
	return new File_Level_View_pages(driver, test);
	
	}
	
	
	
	public File_Level_View_pages click_Transaction_Level_View_Link() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.TLV.view.xpath"));
	
	
	defaultcontent();
	return new File_Level_View_pages(driver, test);
	
	}
	
	
	
	
	
}
