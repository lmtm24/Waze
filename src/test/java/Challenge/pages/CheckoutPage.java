package Challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class CheckoutPage extends BasePage {

    By firstNameInputField = By.id("first-name");
    By lastNameInputField = By.id("last-name");
    By postalCodeInputField = By.id("postal-code");
    By continueButton = By.cssSelector("[type='submit']");
    By overviewValidation = By.cssSelector("div#contents_wrapper > .subheader");
    By cartListOverview = By.cssSelector(".cart_list");
    By postalCodeError = By.xpath("//div[@id='checkout_info_container']//form/h3");
    By completeOrderMessage = By.id("checkout_complete_container");
    By finishButton = By.linkText("FINISH");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void typeFirstName(String name){
        type(name,firstNameInputField);
    }
    public void typeLastName(String lastName){
        type(lastName,lastNameInputField);
    }
    public void typeZipCode(String postalCode){
        type(postalCode,postalCodeInputField);
    }

    public void clickContinueButton(){
        click(continueButton);
    }

    public String getPostalCodeValidationMessage(){
        return getText(postalCodeError);
    }
    public String getOverValidationMessage(){
        return getText(overviewValidation);
    }
    public String getCartList(){
        return getText(cartListOverview);
    }
    public String getCompleteOrderMessage(){
        return getText(completeOrderMessage);
    }
    public void clickFinishButton(){
        click(finishButton);
    }






}
