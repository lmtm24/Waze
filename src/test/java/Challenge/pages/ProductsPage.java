package Challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    By shoppingCartButton = By.cssSelector("div#shopping_cart_container > a");
    By addBackPackButton = By.cssSelector("div:nth-of-type(1) > .pricebar > .btn_inventory.btn_primary");
    By addBoltTShirtButton = By.cssSelector(".inventory_list .inventory_item:nth-of-type(3) .btn_inventory");
    By addBikeLightButton = By.cssSelector(".inventory_list .inventory_item:nth-of-type(2) .btn_inventory");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickShoppingCartButton(){
        click(shoppingCartButton);
    }

    public void addBackPackItem(){
        click(addBackPackButton);
    }

    public void addBoltTShirtItem(){
        click(addBoltTShirtButton);
    }

    public void addBikeLightItem(){
        click(addBikeLightButton);
    }

}
