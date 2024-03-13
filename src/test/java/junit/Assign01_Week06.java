package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class Assign01_Week06 extends testBase{
//    1/4


    @Test
    public void verifyingWebsiteElements() {
        //Go to URL: https://the-internet.herokuapp.com/windows
        bot.navigate("https://the-internet.herokuapp.com/windows");
        var originalWindowHandle = driver.getWindowHandle();

        //Verify the text: “Opening a new window”
        String verifyText = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
        Assertions.assertEquals(verifyText, "Opening a new window");


        //Verify the title of the page is “The Internet”
        String verifyTitle = driver.getTitle();
        Assertions.assertEquals(verifyTitle, "The Internet");


        //Click on the “Click Here” button
//       driver.findElement(By.xpath("//a[text()='Click Here']")).click();


        //Verify the new window title is “New Window”

        Set<String > handles = driver.getWindowHandles();
        handles.remove(originalWindowHandle);
        String  newWindowHandle= (String) handles.toArray()[0];
        driver.switchTo().window(newWindowHandle);
        var verifyTitleOfNewWindow = driver.getTitle();
        Assertions.assertEquals(verifyTitleOfNewWindow, "New Window");


        //Go back to the previous window and then verify the title: “The Internet”
        driver.navigate().back();
    }
}
