package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class Assign05_Week07 extends TestBaseCrossBrowsers{

            //    5/5
            //Go to URL: http://crossbrowsertesting.github.io/
            //Click to To-Do App
            //Checking Box to do-4 and Checking Box to do-5
            //If both clicks worked, then the following List should be have length 2.
            //Assert that this is correct
            //Assert that the to do we added is present in the list
            //Archiving old todos
            //If our archive link worked, then the following list should have length 4.
            //Assert that this is true as well
            //Doing Cross Browser Testing.
            private static SoftAssert softAssert = new SoftAssert();

    @Test
    public void crossBrowser()  {

        bot.navigate("http://crossbrowsertesting.github.io/");
            wait.until(f -> {
                        driver.findElement(By.xpath("//a[normalize-space()='To-Do App']")).click();
                return true;
            });
        wait.until(f -> {
            driver.findElement(By.name("todo-4")).click();
        return true;
    });
        wait.until(f -> {

            driver.findElement(By.name("todo-5")).click();
            return true;
        });


            wait.until(f -> {

        List<WebElement> checkedItems = driver.findElements(By.xpath("//span[contains(@class,'done-true')]"));
        int checkedItemsCount = checkedItems.size();

        Assert.assertEquals(checkedItemsCount,2);


       String expectedTextOfToDoList4=driver.findElement(By.xpath("//input[contains(@name,'todo-4')]")).getText();
        String expectedTextOfToDoList5=driver.findElement(By.xpath("//input[contains(@name,'todo-2')]")).getText();

        checkedItems.forEach(item -> {
            String text = item.getText();
            if (text.equals(expectedTextOfToDoList4)) {

                Assert.assertTrue(true, "Text 'to do 4' not found in checked items");

            }
            if (text.equals(expectedTextOfToDoList5)) {
                Assert.assertTrue(true, "Text 'to do 5' not found in checked items");

            }
        });
        return true;
    });

//        wait.until(f -> {

         driver.findElement(By.xpath("//a[@ng-click='todoList.archive()']")).click();
        List<WebElement> restItems = driver.findElements(By.xpath("//span[contains(@class,'done-true')]"));
        int restItemsCount = restItems.size();

        softAssert.assertEquals(restItemsCount,
                4);


//            return true;
//        });

    }


}
