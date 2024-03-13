package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class SeleniumAssignW04 {
    WebDriver driverTask1;
    WebDriver driverTask2;
    WebDriver driverTask3;
    WebDriver driverTask4;
    WebDriver driverTask5;


    @BeforeEach
    public void beforeEach(){
        driverTask1 = new ChromeDriver();
        driverTask1.manage().window().maximize();
        driverTask1.navigate().to("https://testpages.herokuapp.com/styled/index.html");
//
        driverTask2 = new ChromeDriver();
        driverTask2.manage().window().maximize();
        driverTask2.navigate().to("https://id.heroku.com/login");
//
        driverTask3 = new ChromeDriver();
        driverTask3.manage().window().maximize();
        driverTask3.navigate().to("https://testpages.herokuapp.com/styled/index.html");
//
        driverTask4 = new ChromeDriver();
        driverTask4.manage().window().maximize();
        driverTask4.navigate().to("https://www.linkedin.com/");
//
        driverTask5 = new ChromeDriver();
        driverTask5.manage().window().maximize();
        driverTask5.navigate().to("https://www.linkedin.com/");


    }
    //    Task 01
//    Click on Locators - Find By Playground Test Page
//    Print the URL
//    Navigate back
//    Print the URL
//    Click on WebDriver Example Page
//    Print the URL
//    Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
//    And then verify ‘two, zero’ message is displayed on page
//    Close driver.
    @Test
    public void Task01(){
        driverTask1.findElement(By.linkText("Locators - Find By Playground Test Page")).click();
        System.out.println("Current URL after clicking on Locators link: " + driverTask1.getCurrentUrl());
        driverTask1.navigate().back();
        System.out.println("Current URL after navigating back: " + driverTask1.getCurrentUrl());
        driverTask1.findElement(By.linkText("WebDriver Example Page")).click();
        System.out.println("Current URL after clicking on WebDriver link: " + driverTask1.getCurrentUrl());
        By input = By.xpath("//input[@id='numentry']");
        driverTask1.findElement(input).sendKeys("20");
        driverTask1.findElement(input).submit();

        By Label = By.xpath("//p[@id='message']");

        String displayedText = driverTask1.findElement(Label).getText();
        Assertions.assertEquals("two, zero", displayedText, "It is displayed");
    }
    //
//
//
//
//
////    __________________________________________________________________________________________
////    Task 02
////    Enter an e-mail address.
////    Enter a password.
////    Click on the Login button.
////    There was a problem with your login.
////    If text is visible, print "Registration Failed".
////    If the text is not visible, print "Registered".
////    Close all pages.
    @Test
    public void Task02(){
        By inputEmail = By.xpath("//input[@id='email']");
        driverTask2.findElement(inputEmail).sendKeys("username@gmail.com");
        By inputPassword = By.xpath("//input[@id='password']");
        driverTask2.findElement(inputPassword).sendKeys("Password123");
        By loginButton = By.xpath("//button[@class='btn btn-primary btn-lg btn-block']");
        WebElement loginButton2 = driverTask2.findElement(loginButton);
        loginButton2.click();
        By errorMessage = By.xpath("//div[@class=\"alert alert-danger\"]");
        Assertions.assertTrue(driverTask2.findElement(errorMessage).isDisplayed(), "Registered");
        Assertions.assertFalse(driverTask2.findElement(errorMessage).isDisplayed(), "Registration Failed ");

    }
    //
////    __________________________________________________________________________________________
////    Task 03
////    Click on Simple Calculator under Micro Apps.
////    Type any number in the first input.
////    Type any number in the second input.
////    Click on Calculate.
////    Get the result.
////    Print the result.
    @Test
    public void Task03(){

        By simpleCalLINK = By.xpath("//a[@id='calculatetest']");
        driverTask3.findElement(simpleCalLINK).click();
        By input1 = By.xpath("//input[@id='number1']");
        driverTask3.findElement(input1).sendKeys("4");
        By input2 = By.xpath("//input[@id='number2']");
        driverTask3.findElement(input2).sendKeys("6");
        By Cal = By.xpath("//input[@id='calculate']");
        driverTask3.findElement(Cal).click();
        By Label = By.xpath("//span[@id='answer']");
        String displayedText = driverTask3.findElement(Label).getText();
        System.out.println("The Result is : " + displayedText);
    }

    //    __________________________________________________________________________________________
//    Task 04
//    find the locators of webelements on page https://www.linkedin.com/
//    id, name, className, linkText, PLinkTest
    @Test
    public void Task04(){

        WebElement link01 = driverTask4.findElement(By.id("session_key"));
        System.out.println("Current URL after clicking on Locators link01: " + link01.getAttribute("id"));
//
        WebElement link02 = driverTask4.findElement(By.name("session_key"));
        System.out.println("Current URL after clicking on Locators link02: " + link02.getAttribute("name"));
//
        WebElement link03= driverTask4.findElement(By.className("mt-1.5"));
        System.out.println("(Class name): " + link03.getAttribute("class"));
//
        WebElement link04= driverTask4.findElement(By.partialLinkText("Forgot"));
        System.out.println("(Partial link text): " + link04.getAttribute("href"));
//
        WebElement link05=driverTask4.findElement(By.linkText("Forgot password?"));
        System.out.println("(Link text): " + link05.getAttribute("href"));

    }
    //    __________________________________________________________________________________________
//    Task 05
//
//    Go to URL: https://www.linkedin.com/
//    Locate the "Email or phone", "password", "Sign in" button using absolute xpath and relative xpath
    @Test
    public void Task05(){
        //input01
        By emailRet = By.xpath("//input[@id='id attribute is not available for this element']");
        By emailAbs = By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
//input02
        By passRet = By.xpath("//input[@id='session_password']");
        By passAbs = By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]");

        By signinRet = By.xpath("//button[@type='submit']");
        By signinAbs = By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/form[1]/div[2]/button[1]");

    }
    @AfterEach
    public void afterEach(){
        driverTask1.quit();
        driverTask2.quit();
        driverTask3.quit();
        driverTask4.quit();
        driverTask5.quit();
    }
}
