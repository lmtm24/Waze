package Challenge.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    String url = "https://www.saucedemo.com/";

    @BeforeTest
    public void baseSetup(){
        driver = new ChromeDriver();
        driver.get(url);
    }

    @AfterTest
    public void baseTearDown(){
        driver.quit();
    }
}
