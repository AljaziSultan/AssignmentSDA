package testng;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assign04_Week07 extends TestBase{

            //    4/5
        //Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search function do it with Data Provider for Mac, iPad and Samsung.

//(create an array structure with "Mac, iPad and Samsung". You can see it in Assignment 2)
        @DataProvider
        public Object[][] getData(){
            return new Object[][]{
                    {"Mac"},
                    {"Ipad"},
                    {"Samsung"},

            };
        }

    @Test(dataProvider = "getData")
    public void dataProviderClass(String word) {
            bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
//    wait.until(f->{
            driver.findElement(By.xpath("//input[@name,'search']")).sendKeys(word+ Keys.ENTER);
//            driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys(password);
//        return true;
//    });

            driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
            wait.until(f->{
        WebElement inText = driver.findElement(By.xpath("//div[contains(@class,'oxd-alert-content--error')]"));
                Assert.assertTrue(inText.isDisplayed());

                return true;
    });
//        Assert.assertTrue(inText.isDisplayed());



    }


}
