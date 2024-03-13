package junit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class SeleniumAssignW03 {


    //        Create main method
    public static void main(String[] args) {
//        Task01_week03

//        Create chrome driver
        ChromeDriver driverTask01= new ChromeDriver();
//        Open google home page: https://www.google.com
        driverTask01.get("https://www.google.com");
//        Print Title on page
        String title = driverTask01.getTitle();
        System.out.println("title = " + title);
//        Print Current URL on page
        String urlTask01 = driverTask01.getCurrentUrl();
        System.out.println("url = " + urlTask01);
// using Navigate
        driverTask01.navigate().to("https://clarusway.getlearnworlds.com");
        driverTask01.navigate().back();

//        Close/Quit the browser
        driverTask01.quit();
//________________________________________________________________________________________ //
//        Task02_week03

//        Differences between get() method and navigate to() method?
        // get() method:
        // A part of the WebDriver interface.
        // It takes a single argument, which is the URL of the web page to be loaded.
//        navigate().to() method:
//        A part of the Navigation interface.
//        It is called on the navigate() object, which is a part of the WebDriver interface.
//        It also takes a single argument, which is the URL of the web page to be loaded.
//________________________________________________________________________________________ //
//        Task03_week03

//        Invoke Chrome Driver
        ChromeDriver driverTask03= new ChromeDriver();
        driverTask03.manage().window().maximize();
//        Navigate to Facebook homepage URL: https://www.facebook.com/
        driverTask03.get("https://www.facebook.com/");
//        Verify expected URL equals to the actual URL.
        String expectedURL = "https://www.facebook.com/";
        String actualURL =driverTask03.getCurrentUrl();
        if (actualURL.contentEquals(expectedURL)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }


//        Verify  pagesource of FaceBook contains "Facebook"
        String pageSource = driverTask03.getPageSource();
        if (pageSource.contains("Facebook")) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        driverTask03.close();
    }
}
