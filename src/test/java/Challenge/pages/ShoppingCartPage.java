package Challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    By cartValidation = By.cssSelector("div#contents_wrapper > .subheader");
    By cartListValidation = By.cssSelector(".cart_list");
    By buttonCheckout = By.cssSelector(".btn_action.checkout_button");



    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    public String getShoppingCartText(){
        return getText(cartValidation);
    }
    public String getShoppingCartItem(){
        return getText(cartListValidation);
    }
    public void clickCheckOutButton(){
        click(buttonCheckout);
    }



}
