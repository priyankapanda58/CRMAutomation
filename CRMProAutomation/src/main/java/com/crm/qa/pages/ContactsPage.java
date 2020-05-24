package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtil;

public class ContactsPage extends TestBase{
	
	WebDriverWait wait =  new WebDriverWait(driver,TestUtil.explicit_Wait_Timeout);
	TestUtil testUtil;

	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newBtn;
	
	@FindBy(xpath="//div[text()='Create New Contact']")
	WebElement newContactLabel;
	
	@FindBy(name = "first_name")
	WebElement firstname;
	
	@FindBy(name = "last_name")
	WebElement lastname;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickonNewBtn() throws InterruptedException
	{
		newBtn.click();
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(newContactLabel));
		return newContactLabel.isDisplayed();
	}
	
	
	public void addNewContact(String fname, String lname)
	{
		//String fname = TestUtil.Name();
		//String lname = TestUtil.Name();
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		saveBtn.click();
	}
	
	public void selectContactByName(String name) throws InterruptedException
	{
		
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]")))).click();
		}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public String getContactsLabelText()
	{
		return contactsLabel.getText();
	}
	
	public boolean verifyContactsCheckbox( String name)
	{
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//parent::tr/td[1]")))).isSelected();
	}
}
