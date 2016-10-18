package myPackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shopping {
	public String baseUrl = "http://newtours.demoaut.com/";
    public WebDriver driver;
    
    @BeforeTest
    public void setupDriver() {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\1326590\\Desktop\\geckodriver.exe");
            //System.setProperty("webdriver.firefox.marionette","C:\\GeckoDriver\\geckodriver.exe");
            driver = new ChromeDriver();
    }
    
    @Test
    public void verifyHomePageTitle() {
            driver.get(baseUrl);
            String expectedTitle = "Welcome: Mercury Tours";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);
            driver.quit();
    }
	
}
