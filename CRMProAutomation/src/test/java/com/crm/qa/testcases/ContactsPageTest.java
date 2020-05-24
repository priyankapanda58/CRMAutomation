package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

import com.crm.qa.utilities.XLUtils;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactsLink();
		Thread.sleep(3000);
	    //testUtil.switchToFrame("downloadFrame");
		homepage.clickOnCalendarLink();
		Thread.sleep(3000);
		contactspage = homepage.clickOnContactsLink();
		Thread.sleep(3000);
	}
	
	@Test(priority =1,enabled=false)
	public void verifyWelcomeText()
	{
		String text = contactspage.getContactsLabelText();
		Assert.assertTrue(contactspage.verifyContactsLabel());
		Assert.assertEquals(text, "Contacts");
	}
	
	@Test(priority =2,enabled=false)
	public void selectSingleContact() throws InterruptedException
	{
		
		contactspage.selectContactByName("priya panda");
	}
	
	@Test(priority =3,enabled=false)
	public void selectMultipleContacts() throws InterruptedException
	{
		
		contactspage.selectContactByName("priya panda");
		contactspage.selectContactByName("second contact");
		
	}
	
	@Test(priority =4,enabled=true,dataProvider="getContactsData")
	public void addNewContact(String fname, String lname) throws InterruptedException
	{
		Assert.assertTrue(contactspage.clickonNewBtn());
		contactspage.addNewContact(fname,lname);
		
	}
	
	@DataProvider
	public String[][] getContactsData() throws IOException
	{
		//String userdir = System.getProperty("user.dir");
		//String path = userdir+"/src/main/java/com/crm/qa/testdata/Contacts.xlsx";
		int rowcount = XLUtils.getRowCount(TestUtil.Excel_Contacts_Data, "Sheet1");
		int colcount = XLUtils.getCellCount(TestUtil.Excel_Contacts_Data, "Sheet1", rowcount);
		System.out.println("No. of rows:"+rowcount+" No. of columns"+colcount);
		String contactsData[][] = new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				contactsData[i-1][j] = XLUtils.getCellData(TestUtil.Excel_Contacts_Data, "Sheet1", i, j);
				
			}
		}
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				System.out.print(contactsData[i][j]+" ");
			}
			System.out.println();
		}
		
		
		return contactsData;
	}

	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
