package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public static WebDriver driver;
    static Logger logger = Logger.getLogger(base.class);
    public static WebDriver initializedriver() throws IOException {
        // TODO Auto-generated method stub


        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("config.properties");
        //FileInputStream fio = new FileInputStream("D:\\Siva-SeliniumWorkSpace\\GmailPage\\src\\main\\resources\\config.properties");
        Properties prop = new Properties();
        prop.load(stream);
        String br = prop.getProperty("browser");
        logger.info("Browser:" + br);
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\ExeandJars\\chromedriver\\chromedriver.exe");
            // //System.setProperty("webdriver.chrome.driver", "./resources//chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        logger.info("Driver Initialized");
        String wurl = prop.getProperty("url");
       logger.info("url  :  " + wurl);
        driver.get(wurl);
        logger.info("WebPage Opend");
        return driver;
    }
}

