package Challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;

    }

    public void type(String text, By locator){
        driver.findElement(locator).sendKeys(text);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public String getText(By element){
        String text=driver.findElement(element).getText();
        return text;
    }




}
