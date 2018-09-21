package com.issoft.training.pages;

import com.issoft.training.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

    WebDriver driver;

    public Page() {
        driver = Driver.getDriver().get();
        PageFactory.initElements(driver, this);
    }
}
