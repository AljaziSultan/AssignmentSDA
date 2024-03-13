package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Assign07_Week06 extends testBase{
//    4/4


    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot
    @Test
    public void amazonScreenShot() throws IOException {
//      Go to amazon.com
        bot.navigate("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");

        // Take Full Page Screenshot
        File fullScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(fullScreenshot, new File("\\amazon_fullpage.png"));

        // Take WebElement Screenshot
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        File elementScreenshot = new File("amazon_searchbar.png");
        FileHandler.copy(searchBar.getScreenshotAs(OutputType.FILE), elementScreenshot);
    }


}
