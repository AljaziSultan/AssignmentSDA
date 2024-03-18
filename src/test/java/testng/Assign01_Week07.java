package testng;

import org.testng.annotations.Test;

public class Assign01_Week07 extends TestBase{

//    1/5
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    @Test
    public void facebook() {
        bot.navigate("https://www.facebook.com/");
}

    @Test(dependsOnMethods = "facebook")
    public void google() {
        bot.navigate("https://www.google.com/");
    }

    @Test(dependsOnMethods = "google")
    public void amazon() {
        bot.navigate("https://www.amazon.com/");
    }
}
