package com.crm.qa.utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long page_Load_Timeout = 300;
	public static long implicit_Wait_Timeout = 100;
	public static long explicit_Wait_Timeout = 20;
	//String userdir = System.getProperty("user.dir");
	public static String Excel_Contacts_Data = System.getProperty("user.dir")+"/src/main/java/com/crm/qa/testdata/Contacts.xlsx";
	
	public void switchToFrame()
	{
		driver.switchTo().frame("downloadFrame");
	}
	
	public static String Name()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("PP"+generatedString);
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
