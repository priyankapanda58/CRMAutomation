package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTestCases extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	
	public HomePageTestCases()
	{
		super();
	}

	@BeforeMethod
	public void Setup()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		//testUtil.switchToFrame("downloadFrame");
	}
	
	@Test(priority =1)
	public void verifyPageTitle()
	{
		String title = homepage.getHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority =2)
	public void verifyWelcomeText()
	{
		String welcometext = homepage.getWelcomeText();
		Assert.assertTrue(homepage.verifyWelcomeText());
		Assert.assertEquals(welcometext, "Priyanka Panda");
	}
	
	@Test(priority =3)
	public void clickOnContactsLink()
	{
		
		contactspage = homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
