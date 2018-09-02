package com.issoft.training.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private final static String HOME_URL = "https://www.tut.by/";
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static void openHomePage() {
        getDriver().get().navigate().to(HOME_URL);
    }

    public static ThreadLocal<WebDriver> getDriver() {
        if (driver.get() == null) {
            WebDriver d = new ChromeDriver();
            d.manage().window().maximize();
            d.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

            driver.set(d);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.get().close();
        driver.set(null);
    }
}
