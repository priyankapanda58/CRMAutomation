package com.crm.qa.testcases;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginpageTestCases extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	Logger log = Logger.getLogger(LoginpageTestCases.class);
	
    public LoginpageTestCases()
	{
		super();
		log.info("super class constructor called");
	}

	@BeforeMethod
	public void Setup()
	{
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority =1)
	public void verifyPageTitle()
	{
		String title = loginpage.getLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority =2)
	public void signin()
	{
		String uname = prop.getProperty("email");
		String psw = prop.getProperty("password");
		homepage = loginpage.login(uname, psw);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
