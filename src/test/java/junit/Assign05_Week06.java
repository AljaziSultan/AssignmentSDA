package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class Assign05_Week06 extends testBase{
//    5/4

    /*   Go to URL: http://facebook.com
          ,
          addCookie,
          deleteCookieNamed,
          deleteAllCookies
       */
    @Test
    public void cookiesMethods()  {
//         Go to URL: http://facebook.com
        bot.navigate("http://facebook.com");

//        getCookies
        System.out.println("Initial list of cookies:");
        driver.manage().getCookies().forEach(System.out::println);

//        addCookie
        driver.manage().addCookie(new Cookie("AcceptUsername","Saif"));

//        deleteCookieNamed
        driver.manage().deleteCookieNamed("AcceptUsername");

//        deleteAllCookies
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0, driver.manage().getCookies().size());


    }
}
