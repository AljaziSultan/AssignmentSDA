package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class Assign02_Week06 extends testBase{
//    2/4


//   Verify the visibility of Perfect text.

    @Test
    public void dragAndDrop() {
//     Go to URL: http://demo.guru99.com/test/drag_drop.html
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");

//     Drag and drop the BANK button to the Account section in DEBIT SIDE
        By buttonBank = By.xpath("//li[contains(@id,'credit2')]");
        By accountDebitSide = By.xpath("//ol[contains(@id,'bank')]");
        new Actions(driver).dragAndDrop(driver.findElement(buttonBank), driver.findElement(accountDebitSide)).perform();

//   Drag and drop the SALES button to the Account section in CREDIT SIDE
        By buttonSales = By.xpath("//li[contains(@id,'credit1')]");
        By accountCreditSide = By.xpath("//ol[contains(@id,'loan')]");
        new Actions(driver).dragAndDrop(driver.findElement(buttonSales), driver.findElement(accountCreditSide)).perform();

//   Drag and drop the 5000 button to the Amount section in CREDIT SIDE
//   Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        By button5000 = By.xpath("//li[contains(@id,'fourth')]");
        By amountDebitSide = By.xpath("//ol[contains(@id,'amt7')]");
        By amountCreditSide = By.xpath("//ol[contains(@id,'amt8')]");
        new Actions(driver).dragAndDrop(driver.findElement(button5000), driver.findElement(amountCreditSide)).perform();
        new Actions(driver).dragAndDrop(driver.findElement(button5000), driver.findElement(amountDebitSide)).perform();



        WebElement verifyText = driver.findElement(By.xpath("//a[text()='Perfect!']"));
        Assertions.assertTrue(verifyText.isDisplayed());

    }
}
