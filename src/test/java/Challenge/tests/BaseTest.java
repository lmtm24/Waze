package Challenge.tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    protected WebDriver driver;
    String url = "https://www.saucedemo.com/";

    @Before()
    public void baseSetup(){
        driver = new ChromeDriver();
        driver.get(url);
    }

    @After
    public void baseTearDown(){
        driver.quit();
    }
}
