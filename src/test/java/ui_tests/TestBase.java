package ui_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

import static helpers.FileHelper.takeSnapShot;


public class TestBase {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod(alwaysRun = true)
    public void openBrowser(Method method, Object[] param){
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window-size=1800x900");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://propetscom.herokuapp.com/");
        logger.info("Start test: " + method.getName());
        if(param.length != 0) {
            logger.info(" --> With data: " + Arrays.asList(param));
        }
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(ITestResult result) throws Exception {
        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }else{
            logger.error("Test result: FAILED");
            takeSnapShot(driver);

        }
        driver.quit();
        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");
    }






}