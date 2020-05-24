package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utilities.TestUtil;
import com.crm.qa.utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			String filepath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
			FileInputStream fis = new FileInputStream(filepath);
			prop.load(fis);
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		String driverPath = System.getProperty("user.dir")+"\\Drivers\\";
				
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverPath+"/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", driverPath+"/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", driverPath+"/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
          e_driver = new EventFiringWebDriver(driver);
          eventListener = new WebEventListener();
          e_driver.register(eventListener);
          driver = e_driver;

		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait_Timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	} 

}
