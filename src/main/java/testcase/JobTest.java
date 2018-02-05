package testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import techgigassigmnet.BrowserFactory;
import techgigassigmnet.ExcelFactory;
import techgigassigmnet.HomePage;
import techgigassigmnet.JobApplyPage;
import techgigassigmnet.JobPage;
import techgigassigmnet.JobapplyStatusPage;

public class JobTest  extends LoginTest{
	
	HomePage homePage;
	JobPage jobPage;
	JobApplyPage jobApplyPage;
	JobapplyStatusPage jobapplyStatusPage;
	@Test (dataProvider ="Jobs", dependsOnMethods = { "ValidLogin" })	
	public void verifysearchJob(String type,String keyword,String apply)
	{
		System.out.println("verifysearchJob started  "+type+"     "+keyword+"  "+apply);
		
		homePage=PageFactory.initElements(BrowserFactory.driver, HomePage.class);
		jobPage=homePage.searchJob(type);
		jobApplyPage=jobPage.searchsearch(keyword);
	
	}

	@Test (dataProvider ="Jobs", dependsOnMethods = { "verifysearchJob" })		
	public void verifyJobapply(String type,String keyword,String apply)
	{
		System.out.println("verifyJobapply started  "+type+"     "+keyword+"  "+apply);
		jobapplyStatusPage=jobApplyPage.Apply(apply);
		
		String status= jobapplyStatusPage.jobapplysuccess();
		System.out.println("status of job >> "+status);
		Assert.assertTrue(status.contains("Successfully"));
		
	}
	
	@DataProvider
	 public Object[][] Jobs() throws Exception{
	//	ExcelFactory excelFactory=new ExcelFactory();
		Object[][] testObjArray = ExcelFactory.getTableArray("D:\\selenium_jar\\excel\\login.xlsx",Integer.parseInt("1"));
		 
   	return (testObjArray);
	}

}
