package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[@class='user-display']")
	WebElement welcometext;
	
	@FindBy(xpath="//a[contains(@href,'calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath="//a[contains(@href,'contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(@href,'companies')]")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[contains(@href,'deals')]")
	WebElement dealsLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyWelcomeText()
	{
		return welcometext.isDisplayed();
	}
	
	public String getWelcomeText()
	{
		return welcometext.getText();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		 contactsLink.click();
		 return new ContactsPage();
	}
	
	public CalendarPage clickOnCalendarLink()
	{
		calendarLink.click();
		 return new CalendarPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		 dealsLink.click();
		 return new DealsPage();
	}
}
