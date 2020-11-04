package Challenge.tests;

import Challenge.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogin extends BaseTest{

    LoginPage loginPage;
    String password = "secret_sauce", validUserName = "standard_user";

    @BeforeTest
    public void setup(){
        loginPage = new LoginPage(driver);
    }


    @Test
    public void testValidUser(){
        loginPage.typeValidUsername(validUserName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        Assert.assertEquals("Products",loginPage.validateSuccessLogin());

    }
    @Test
    public void testInvalidUser(){
        String InvalidText="Epic sadface: Username and password do not match any user in this service" , invalidUSerName = "invalid";
        loginPage.typeInvalidUsername(invalidUSerName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        Assert.assertEquals(InvalidText,loginPage.validateFailureLogin());
    }
    @Test
    public void testLogoutProductsPage() throws InterruptedException {
        loginPage.typeValidUsername(validUserName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.clickBurgerButton();
        loginPage.clickLogoutButton();
        loginPage.clickLogin();
    }



}
