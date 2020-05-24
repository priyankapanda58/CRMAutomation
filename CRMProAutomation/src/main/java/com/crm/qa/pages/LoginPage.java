package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utilities.TestUtil;

public class LoginPage extends TestBase{

	@FindBy(name="email")
	WebElement emailTextBox;
	
	@FindBy(name="password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//div[contains(@class,'submit')]")
	WebElement loginBtn;

	@FindBy(xpath="//a[contains(text(),'Forgot')]")
	WebElement forgotPswLink;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String uname, String psw)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,TestUtil.explicit_Wait_Timeout);
		wait.until(ExpectedConditions.visibilityOf(emailTextBox));
		emailTextBox.sendKeys(uname);
		wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox)).sendKeys(psw);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		return new HomePage();
	}
	
}
