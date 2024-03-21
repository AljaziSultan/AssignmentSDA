package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Level.*;


public class Assign03_Week07 {

            //    3/5
                    /* Add three different log messages for the task below:
            go to "https://practicetestautomation.com/practice-test-login/"
            enter username - "student"
            enter password - "incorrectPassword"
            and login
            SOFT ASSERT the error message shown
            SOFT ASSERT the error message is "Your password is invalid!" */
            private static WebDriver driver;

    private static SoftAssert softAssert = new SoftAssert();
    private static final Logger logger = Logger.getLogger(Assign03_Week07.class.getName());

//    private static final Logger loggers = (Logger) java.util.logging.Logger.getLogger(Assign03_Week07.class.getName());
    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        logger.info( "WebDriver started");
    }
    @Test
    public void logMessages() throws InterruptedException {
        logger.fine("Opening URL");
             driver.get("https://practicetestautomation.com/practice-test-login/");

        logger.info("Entering the data");
            Thread.sleep(4000);
            driver.findElement(By.xpath("//input[@name,'username']")).sendKeys("student" );
            Thread.sleep(4000);
            driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("incorrectPassword");
            Thread.sleep(4000);
            driver.findElement(By.xpath("//button[contains(@id,'submit')]")).click();
            Thread.sleep(4000);


        logger.warning("SoftAssertion Message");
            Thread.sleep(4000);
            WebElement inText = driver.findElement(By.xpath("//div[contains(@id,'error')]"));
            Thread.sleep(4000);
            softAssert.assertTrue(inText.isDisplayed());
            Thread.sleep(4000);
            softAssert.assertEquals(inText, "Your password is invalid!");



    }
    @AfterClass
    public static void closeDown() {
        driver.quit();
        logger.log(Level.INFO, "WebDriver closed");
    }

}
