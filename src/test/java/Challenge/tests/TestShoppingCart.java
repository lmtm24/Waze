package Challenge.tests;

import Challenge.pages.LoginPage;
import Challenge.pages.ProductsPage;
import Challenge.pages.ShoppingCartPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestShoppingCart extends BaseTest {

    LoginPage loginPage;
    ShoppingCartPage shoppingCartPage;
    ProductsPage productsPage;
    String userName="standard_user";
    String password="secret_sauce";
    String backpack = "Sauce Labs Backpack";

    @Before
    public void setup(){
        loginPage = new LoginPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void testShoppingCartNavigation() throws InterruptedException {
        String message = "Your Cart" ;
        loginPage.typeValidUsername(userName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        productsPage.clickShoppingCartButton();
        Assert.assertEquals(message,shoppingCartPage.getShoppingCartText());
    }
    @Test
    public void validateShoppingCartSingleItem() throws InterruptedException {
        loginPage.typeValidUsername(userName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        productsPage.addBackPackItem();
        productsPage.clickShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getShoppingCartItem().contains(backpack));
    }
    @Test
    public void validateShoppingCartMultipleItems() throws InterruptedException {
        String tshirt = "Sauce Labs Bolt T-Shirt", bike = "Sauce Labs Bike Light";
        loginPage.typeValidUsername(userName);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        productsPage.addBackPackItem();
        productsPage.addBikeLightItem();
        productsPage.addBoltTShirtItem();
        productsPage.clickShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getShoppingCartItem().contains(backpack));
        Assert.assertTrue(shoppingCartPage.getShoppingCartItem().contains(tshirt));
        Assert.assertTrue(shoppingCartPage.getShoppingCartItem().contains(bike));
    }

}
