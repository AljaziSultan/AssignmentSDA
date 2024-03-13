package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class Assign04_Week06 extends testBase{
//    4/4


    @Test
    public void amazonScrolling() throws AWTException, InterruptedException {
//        Go to  https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166
        bot.navigate("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");


//        Scroll to the bottom of the page using a robot
        Robot robot = new Robot();
        robot.delay(10);
        robot.mouseWheel(4);
        Thread.sleep(5000);


//        Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
            bot.click(By.xpath("//a[contains(@href,'/?ref_=footer_logo')]"));


//        Click on the "Back to top" web element
        driver.findElement(By.xpath("//div[contains(@class,'navFooterBackToTop')]")).click();


//       Use Actions to type "ClarusWay" in the search box and perform the search
        Actions actions = new Actions(driver);
        By searchBar = By.id("twotabsearchtextbox");
        actions.moveToElement(driver.findElement(searchBar)).click().sendKeys("ClarusWay").perform();


    }
}
