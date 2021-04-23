package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import testcases.varstore;
import wrappers.ProjectWrapp;

public class FundTransfers_Page  extends ProjectWrapp{
	public   FundTransfers_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public FundTransfers_Page clickAcctoAccLink() throws InterruptedException{
LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.fundtran.submenu.link.xpath"));
		
		return this;
	
	}
	
	

	public IMPSPaymentPage clickIMPSLink() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.imps.xpath"));
		
		return new IMPSPaymentPage(driver, test);
	
	}
	
	public CBECPaymentPage clickCBECLink() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.cbec.xpath"));
		defaultcontent();
		
		return new CBECPaymentPage(driver, test);
	
	}
	
	public ECMSPage clickECMSLink(){
		clickByXpathExplict(prop.getProperty("click.ecms.payment.xpath"));
		defaultcontent();
		return new ECMSPage(driver, test);
	
	}
	

	public ReliancePaymentPage clickRelianceLink(){
		clickByXpathExplict(prop.getProperty("click.reliance.xpath"));
		defaultcontent();
		return new ReliancePaymentPage(driver, test);
	
	}
	
	public SpecialPaymentPage clickSplpaymentLink(){
		clickByXpathExplict(prop.getProperty("click.splpayment.xpath"));
		defaultcontent();
		return new SpecialPaymentPage(driver, test);
	
	}
	

	public FundTransfers_Page clickNEFTRTGSLink() throws InterruptedException{
	LeftMenuFrames();

		clickByXpathExplict(prop.getProperty("click.neft.rtgs.link.xpath"));
		
		return this;
	
	}

	
	public UPI_Collection_Page click_UPI_Link() throws InterruptedException{
		LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.upi.collection.menu.xpath"));
		
		return new UPI_Collection_Page(driver, test);
	
	}
	

	
	
	
	
	public View_CBDT_Page click_View_CBDT_Link() throws InterruptedException{
	LeftMenuFrames();
		clickByXpathExplict(prop.getProperty("click.fund.view.cbdt.registration"));
		defaultcontent();
		return new View_CBDT_Page(driver, test);
	
	}
	
	
	
	public NEFT_Add_Quick_Page click_AddQuick_NEFT_RTGS_Link(){
		clickByXpathExplict(prop.getProperty("Click.addquick.neft.xpath"));
		defaultcontent();
		return new NEFT_Add_Quick_Page(driver, test);
	
	}
	
	public NEFT_Add_Bulk_Page click_AddBulk_NEFT_RTGS_Link(){
		clickByXpathExplict(prop.getProperty("click.neft.addbulk.xpath"));
		defaultcontent();
		return new NEFT_Add_Bulk_Page(driver, test);
	
	}
	
	
	public NEFT_RTSG_Add_Single_Form clickNEFTRTGS_Add_Link(){
		clickByXpathExplict(prop.getProperty("click.neft.rtgs.addsingle.xpath"));
		defaultcontent();
		return new NEFT_RTSG_Add_Single_Form(driver, test);
	
	}

	
	
	public AcctoAccSingle clickAccSingleLink() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.fundtrans.addsingle.xpath"));
		defaultcontent();
		return new AcctoAccSingle(driver, test);
	}
	
	public AcctoAccQuick clickAccQuickLink(){
		clickByXpathExplict(prop.getProperty("click.addquick.xpath"));
		defaultcontent();
		return new AcctoAccQuick(driver, test);
	}
	
	public AcctoAccBulk clickAccBulkLink(){
		clickByXpathExplict(prop.getProperty("click.addbulk.xpath"));
		defaultcontent();
		return new AcctoAccBulk(driver, test);
	}
	
	
	
}
