package com.issoft.training;

import com.issoft.training.driver.Driver;
import com.issoft.training.pages.LoginPage;
import com.issoft.training.pages.MailPage;
import com.issoft.training.pages.TutByPage;
import com.issoft.training.pages.YandexPage;
import com.issoft.training.testng.TutByListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TutByListener.class)
public class LoginToTutByWithPageFactoryPatternTest {

    private TutByPage tutByPage;
    private LoginPage loginPage;
    private MailPage mailPage;
    private YandexPage yandexPage;
    private final static String LOGIN = "seleniumtests10";
    private final static String PASSWORD = "060788avavav";

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        tutByPage = new TutByPage();
        mailPage = new MailPage();
        yandexPage = new YandexPage();
        loginPage = new LoginPage();

        Driver.openHomePage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Driver.closeDriver();
    }

    @Feature("Login")
    @Description("Verify the ability to LOGIN")
    @TmsLink("TUT-1")
    @Test
    public void loginTutByTest() {
        loginPage = tutByPage.clickMailLink();
        mailPage = loginPage.login(LOGIN, PASSWORD);
        Assert.assertTrue(mailPage.isFormPresent(), "Form isn't present");
    }

    @Feature("LogOut")
    @Description("Verify the ability to logout")
    @TmsLink ("TUT-2")
    @Test(dependsOnMethods = {"loginTutByTest"})
    public void logOutTutByTest() {
        mailPage.logout();
        Assert.assertTrue(yandexPage.isInputFieldisPresent(), "Input field isn't on Yandex page");
    }
}
