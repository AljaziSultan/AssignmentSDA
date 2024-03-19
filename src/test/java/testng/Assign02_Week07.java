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
        @DataProvider(parallel = true)
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
    @Step
    public void dataProviderClass(String username,String password) throws InterruptedException {
            bot.navigate("https://opensource-demo.orangehrmlive.com/");


    wait.until(f->{
            driver.findElement(By.name("username")).sendKeys(username);

        return true;
    });
        wait.until(f->{

            driver.findElement(By.name("password")).sendKeys(password);
        return true;
    });

Thread.sleep(1000);
        wait.until(f->{

           WebElement btn= driver.findElement(By.tagName("button"));

                  btn.click();
        return true;
    });


        wait.until(f->{
                Assert.assertTrue(driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).isDisplayed());

                return true;
    });



    }


}
