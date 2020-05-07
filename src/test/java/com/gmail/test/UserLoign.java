package com.gmail.test;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.asserts.IAssert;

public class UserLoign {
	static Logger logger = Logger.getLogger(UserLoign.class);
	public static WebDriver driver;
public static ExtentReports report;
	public static ExtentTest test;
    @BeforeTest
    public static void startTest()
    {
        //report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");

       // test = report.startTest("UserLoign");
    }
	@Test
	public static void gmailLogin()
 {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\ExeandJars\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	    logger.info("Driver Initialized");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com");
		String title = driver.getTitle();
	    logger.info("Title : " + title);
        Assert.assertTrue(title.contains("Guru"));


      	driver.quit();

	}
}
