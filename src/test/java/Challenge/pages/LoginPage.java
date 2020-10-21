package Challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By inputUsername = By.cssSelector("input#user-name");
    By inputPassword = By.cssSelector("input#password");
    By loginButton = By.cssSelector("input#login-button");
    By labelSuccessLogin = By.className("product_label");
    By invalidLoginMessage = By.cssSelector("h3");
    By burgerButton = By.cssSelector(".bm-burger-button > button");
    By logoutButton = By.id("logout_sidebar_link");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeValidUsername(String userName){
                type(userName,inputUsername);
    }
    public void typePassword(String password){
        type(password,inputPassword);
    }
    public void clickLogin(){
        click(loginButton);
    }
    public String validateSuccessLogin(){
        return getText(labelSuccessLogin);
    }
    public void typeInvalidUsername(String invalidUser){
        type(invalidUser,inputUsername);
    }
    public String validateFailureLogin(){
        return getText(invalidLoginMessage);
    }
    public void clickBurgerButton(){
        click(burgerButton);
    }
    public void clickLogoutButton(){ click(logoutButton);
    }

}
