package com.issoft.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(id = "Username")
    private WebElement loginField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(css = ".button.loginButton.gradientforbutton")
    private WebElement loginButton;

    public LoginPage() {
        super();
    }

    public MailPage login(String login, String password) {
        loginField.clear();
        loginField.sendKeys(login);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();

        return new MailPage();
    }
}
