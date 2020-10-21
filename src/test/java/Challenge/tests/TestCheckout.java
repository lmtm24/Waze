package Challenge.tests;

import Challenge.pages.CheckoutPage;
import Challenge.pages.LoginPage;
import Challenge.pages.ProductsPage;
import Challenge.pages.ShoppingCartPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class TestCheckout extends BaseTest{

    LoginPage loginPage;
    ProductsPage productsPage;
    CheckoutPage checkoutPage;
    ShoppingCartPage shoppingCartPage;


    String userName = "standard_user";
    String password = "secret_sauce";
    String firstName = "Luis";
    String lastName = "Toscano";
    String zipCode = "45900";



    @Before
    public void setup(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void validateMissingZipCode(){
        String error = "Error: Postal Code is required";
        loginPage.typeValidUsername(userName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        productsPage.addBoltTShirtItem();
        productsPage.addBikeLightItem();
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();
        checkoutPage.typeFirstName(firstName);
        checkoutPage.typeLastName(lastName);
        checkoutPage.clickContinueButton();
        Assert.assertEquals(error,checkoutPage.getPostalCodeValidationMessage());
    }

    @Test
    public void validateOverviewNavigation(){
        String checkout = "Checkout: Overview";
        loginPage.typeValidUsername(userName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        productsPage.addBoltTShirtItem();
        productsPage.addBikeLightItem();
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();
        checkoutPage.typeFirstName(firstName);
        checkoutPage.typeLastName(lastName);
        checkoutPage.typeZipCode(zipCode);
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkout,checkoutPage.getOverValidationMessage());
    }
    @Test
    public void validateItemsAddedInOverview(){
        String backpack = "Sauce Labs Backpack",tshirt = "Sauce Labs Bolt T-Shirt", bike = "Sauce Labs Bike Light";
        loginPage.typeValidUsername(userName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        productsPage.addBoltTShirtItem();
        productsPage.addBikeLightItem();
        productsPage.addBackPackItem();
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();
        checkoutPage.typeFirstName(firstName);
        checkoutPage.typeLastName(lastName);
        checkoutPage.typeZipCode(zipCode);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.getCartList().contains(backpack));
        Assert.assertTrue(checkoutPage.getCartList().contains(tshirt));
        Assert.assertTrue(checkoutPage.getCartList().contains(bike));

    }
    @Test
    public void ValidatePurchaseCompleted(){
        String thankYou = "THANK YOU FOR YOUR ORDER";
        loginPage.typeValidUsername(userName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        productsPage.addBoltTShirtItem();
        productsPage.addBikeLightItem();
        productsPage.addBackPackItem();
        productsPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();
        checkoutPage.typeFirstName(firstName);
        checkoutPage.typeLastName(lastName);
        checkoutPage.typeZipCode(zipCode);
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();
        Assert.assertTrue(checkoutPage.getCompleteOrderMessage().contains(thankYou));
    }




}
