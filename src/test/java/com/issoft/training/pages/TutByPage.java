package com.issoft.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TutByPage extends Page {

    @FindBy(xpath = "//a[@href=\"http://mail.tut.by/#ua:top_menu_www.tut.by~10\"]")
    private WebElement mailLink;

    public TutByPage() {
        super();
    }

    public LoginPage clickMailLink() {
        mailLink.click();

        return new LoginPage();
    }
}
