package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumAssignW05 {
    WebDriver driverTask1;
    WebDriver driverTask2;
    WebDriver driverTask3;
    //
//
    WebDriver driverTask4;
    WebDriver driverTask5;
    WebDriver driverTask6;
    @BeforeEach
    public void beforeEach(){
        driverTask1 = new ChromeDriver();
        driverTask1.manage().window().maximize();
        driverTask1.navigate().to("https://demoqa.com/");
////
        driverTask2 = new ChromeDriver();
        driverTask2.manage().window().maximize();
        driverTask2.navigate().to("https://demoqa.com/radio-button");
////
        driverTask3 = new ChromeDriver();
        driverTask3.manage().window().maximize();
        driverTask3.navigate().to("https://www.saucedemo.com/v1/inventory.html");


        driverTask4 = new ChromeDriver();
        driverTask4.manage().window().maximize();
        driverTask4.navigate().to("https://demoqa.com/select-menu");

        driverTask5 = new ChromeDriver();
        driverTask5.manage().window().maximize();
        driverTask5.navigate().to("http://demo.automationtesting.in/Alerts.html");

        driverTask6 = new ChromeDriver();
        driverTask6.manage().window().maximize();
        driverTask6.navigate().to("http://demo.guru99.com/test/guru99home/");
    }

    //Assg 1
/*
Go to URL: https://demoqa.com/
Click on Elements.
Click on Checkbox.
Verify if Home checkbox is selected.
Verify that "You have selected" is visible.
     */
    @Test
    public void taskOne() {
        // By Elements = RelativeLocator.with(By.tagName("h5")).below(By.className("card-body"));
        driverTask1.findElement(By.xpath("//div[contains(@class,'category-cards')]//div[1]//div[1]//div[1]")).click();

        driverTask1.findElement(By.xpath("//span[text()='Check Box']")).click();
        By checkBox = By.xpath("//span[text()='Home']");
        driverTask1.findElement(checkBox).click();

        boolean isChecked = driverTask1.findElement(checkBox).isSelected();

        Assertions.assertFalse(isChecked,"it is not selected");

        // By statementLocation = RelativeLocator.with(By.tagName("span")).below(By.xpath("//div[@class='display-result mt-4']"));
        WebElement visibleStatement =  driverTask1.findElement(By.xpath("//span[normalize-space()='You have selected :']"));


        Assertions.assertFalse( visibleStatement.isDisplayed(), "it is not visible");
    }

    //Assg 2
/*
Go to URL: https://demoqa.com/radio-button
Verify whether all 3 options given to the question can be selected.
When each option is selected, print the following texts on the console.
 */
    @Test
    public void taskTwo() throws InterruptedException {
//
        WebElement yesRadio = driverTask2.findElement( By.xpath("//label [text()='Yes']"));
        WebElement impressiveRadio = driverTask2.findElement( By.xpath("//label [text()='Impressive']"));
        WebElement noRadio = driverTask2.findElement (By.xpath("//label [text()='No']"));

//         Yes
        yesRadio.click();
        Assertions.assertTrue(yesRadio.isEnabled(), "Yes Radio button is not expected to be enabled.");
        Thread.sleep(1000);
//          Impressive
        impressiveRadio.click();
        Assertions.assertTrue(impressiveRadio.isEnabled(), "Impressive  Radio button is not expected to be enabled.");
        Thread.sleep(1000);
//          No
        noRadio.click();
        Assertions.assertFalse(noRadio.isEnabled(), "No Radio button is not expected to be enabled.");
        Thread.sleep(1000);


    }
    //Assg 3
 /*
 navigate to this url https://www.saucedemo.com/v1/inventory.html
 add the first item you find to your cart
 open your cart*
 assert that the item name is correct inside the cart
 */
    @Test
    public void taskThree()
    {

        By firstItemAddToCart = By.xpath( "//button[text()='ADD TO CART']");
        driverTask3.findElement(firstItemAddToCart).click();

        WebElement itemNameInTheMainPage =driverTask3.findElement(By.linkText("Sauce Labs Backpack"));
        String actualItemNameInTheMainPage = itemNameInTheMainPage.getText();
        // System.out.println(actualItemNameInTheMainPage);

        By cartPage = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/a[1]/*[name()='svg'][1]");
        driverTask3.findElement(cartPage).click();

        WebElement itemNameInTheCartPage =driverTask3.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        String actualItemNameInTheCartPage = itemNameInTheCartPage.getText();
        // System.out.println(actualItemNameInTheCartPage);


        Assertions.assertEquals(actualItemNameInTheMainPage, actualItemNameInTheCartPage, "These Name Items Are Not The Same ");


    }

//   //https://demoqa.com/select-menu
//   //Get all the options of the dropdown
//   //Options size
//   //Print all test
//   //Verify the dropdown has option "Black"
//   //Print FirstSelectedOptionTest
//   //Select option "Yellow"

    @Test
    public void taskFour(){

        WebElement dropdown = driverTask4.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropdown);
        //   //Get all the options of the dropdown
        List<WebElement> allOpt = select.getOptions();

        for (WebElement each : allOpt) {
            //   //Print all test
            System.out.println("each.getText() = " + each.getText());
            //   //Options size
            int size = allOpt.size();
            System.out.println("size = " + size);
        }
        //   //Verify the dropdown has option "Black"
        By blackOption= By.xpath("//option[@value='5']");
        String presenedtOption = select.getOptions().toString();
        Assertions.assertNotEquals(blackOption, presenedtOption,"The selected option is  Black");

        //   //Select option "Yellow"
        select.selectByVisibleText("Yellow");
        //   //Print FirstSelectedOptionTest

        WebElement selectedOption = select.getFirstSelectedOption();
        Assertions.assertEquals("Yellow", selectedOption.getText(),"Yellow is not selected");

    }

    //    Task05
//
    //Go to URL: http://demo.automationtesting.in/Alerts.html
    //Click "Alert with OK" and click 'click the button to display an alert box:’
    //Accept Alert(I am an alert box!) and print alert on console.
    //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
    //Cancel Alert (Press a Button !)
    //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
    //And then sendKeys «Bootcamp» (Please enter your name)
    //Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
    @Test
    public void taskFive(){
        driverTask5.findElement(By.xpath("//a[contains(@href,'#OKTab')]")).click();
        driverTask5.findElement(By.xpath("//button[contains(@class,'btn btn-danger')]")).click();
//        driverTask5.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Alert alert = driverTask5.switchTo().alert();
        String text = alert.getText();
        System.out.println( text);

        alert.accept();

        driverTask5.findElement(By.xpath("//a[contains(@href,'#CancelTab')]")).click();
        driverTask5.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]")).click();
//        driverTask5.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        alert.dismiss();
        driverTask5.findElement(By.xpath("//a[contains(@href,'#Textbox')]")).click();
        driverTask5.findElement(By.xpath("//button[contains(@class,'btn btn-info')]")).click();
//        driverTask5.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        alert.sendKeys("Aljazi Alkhalaf");
        alert.accept();
        System.out.println(driverTask5.findElement(By.id("demo1")));


    }
    // Task06
    //Go to URL: http://demo.guru99.com/test/guru99home/
    //Find the number of iframes on the page.
    //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
    //Exit the iframe and return to the main page.
    @Test
    public void taskSix(){

        int numiframes = driverTask6.findElements(By.tagName("iframe")).size();
        System.out.println("No. Frames: " + numiframes);
        WebElement thirdIframe = driverTask6.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driverTask6.switchTo().frame(thirdIframe);
        By jMeter = By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']");
        driverTask6.findElement(jMeter).click();

        driverTask6.switchTo().defaultContent();


    }
    @AfterEach
    public void afterEach(){
        driverTask1.quit();
        driverTask2.quit();
        driverTask3.quit();
        driverTask4.quit();
        driverTask5.quit();
        driverTask6.quit();

    }
}
