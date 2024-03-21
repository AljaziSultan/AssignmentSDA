package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Step;
public class Assign02_Week07 extends TestBase{

        //    2/5
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        //Login with negative credentilas by Data Provider.
        //Then assert that ‘’Invalid credentials’’ is displayed.
        //Run it parallel with 3 threads
        //Generate Allure report
        @DataProvider
        public Object[][] getData(){
            return new Object[][]{
                    {"admin*","admin123"},
                    {"admin12","123"},
                    {"Admin1","***00**"},
                    {"test","123"},
                    {"user","369"},
            };
        }

    @Test(dataProvider = "getData")
//    @Step
    public void dataProviderClass(String username,String password) {
            bot.navigate("https://opensource-demo.orangehrmlive.com/");


wait.until(f->{
            driver.findElement(By.name("username")).sendKeys(username);
    return true;
});


            driver.findElement(By.name("password")).sendKeys(password);
            WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
                    login.click();

        wait.until(f->{

            Assert.assertTrue(driver.findElement(By
                     .xpath("//div[@class='orangehrm-login-slot-wrapper']"))
                    .isDisplayed());
        return true;
    });



    }


}
