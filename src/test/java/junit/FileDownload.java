package junit;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
//import tests.testng.Tests;

public class FileDownload extends testBase {
    /**
     * Go to URL: https://opensource-demo.orangehrmlive.com/
     * Login page valid credentials.
     * Download sample CSV file. pim->configuration->importData
     * Verify if the file downloaded successfully.
     */
    @Test
    public void uploadFile(){

        bot.navigate("https://opensource-demo.orangehrmlive.com/");
        By username = By.name("username");

        wait.until(f->{
            driver.findElement(username).sendKeys("Admin");
            return true;
        });
        By password = By.name("password");

        wait.until(f->{
            driver.findElement(password).sendKeys("admin123");
            return true;
        });
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).submit();
// After log in
        wait.until(f->{
            driver.findElement(By.xpath("//a[contains(@href,'/web/index.php/pim/viewPimModule')]")).click();
            return true;
        });

        // After CLICK
        wait.until(f->{
            driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
            return true;
        });


        // After CLICK
        wait.until(f->{
            driver.findElement(By.xpath("//a[text()='Data Import']")).click();
            return true;
        });

        // After CLICK
        wait.until(f->{
            driver.findElement(By.xpath("//a[text()='Download']")).click();
            return true;
        });

        String fileUploadPath = "Downloads\\importData.csv";

    }
}