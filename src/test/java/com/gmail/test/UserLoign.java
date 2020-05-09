package com.gmail.test;

import java.io.IOException;
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
import org.testng.annotations.*;
import org.apache.log4j.Logger;
import org.testng.asserts.IAssert;
import utilities.base;

import static utilities.ScreenShot.takeSnapShot;

public class UserLoign extends base implements LoginInterface {
    static Logger logger = Logger.getLogger(UserLoign.class);
    public static WebDriver driver;
    public static ExtentReports report;
    public static ExtentTest test;

    @BeforeClass
    public static void startTest() throws IOException {
        driver = initializedriver();
        logger.info("DRIVER INITIALIZED and url opend>>>");
    }

    @Test
    public static void gmailLogin() {
        // TODO Auto-generated method stub
        String title = driver.getTitle();
        logger.info("Title : " + title);
        Assert.assertTrue(title.contains("Facebook"));
        takeSnapShot(driver, "SShot");
    }

    @Test
    @Override
    public void login() {
        String uname = "FaceBookUser";
        logger.info("User Name is : " + uname);
        String name = LoginInterface.Iuname;
        logger.info("Interface Constant Variable : " + name);
    }

    @Override
    public void clicklogin() {
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
