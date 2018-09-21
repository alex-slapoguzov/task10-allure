package com.issoft.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexPage extends Page {

    private WebDriverWait wait;

    @FindBy(css = ".input__control.input__input")
    private WebElement inputField;

    public YandexPage() {
        super();
        this.wait = new WebDriverWait(driver, 15);
    }

    public boolean isInputFieldisPresent() {
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        return inputField.isDisplayed();
    }
}
