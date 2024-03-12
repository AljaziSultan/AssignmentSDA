package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Assign03_Week06 extends testBase{
//    3/4


// search for "Scroll Methods" by using an Actions object
    @Test
    public void searchScrolling() {
        // go to https://www.google.com/
        bot.navigate("https://www.google.com/");

//      search for "Scroll Methods" by using an Actions object
//       build an actions object
        Actions actions = new Actions(driver);
//       search bar element
        By searchBar = By.tagName("textarea");
//       build the action sequence
        actions.moveToElement(driver.findElement(searchBar)).click().sendKeys("Scroll Methods").perform();
//       press Enter to submit the search
        actions.sendKeys(Keys.ENTER).perform();
     ;

    }
}
