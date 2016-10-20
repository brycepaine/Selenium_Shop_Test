package myPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Sheet;

public class Shopping {

    
	private WebDriver driver;
    
    @BeforeTest
    private void openPage() {
    	   System.out.println("opening gamestop");
           driver = new ChromeDriver();
           driver.get("http://www.gamestop.com/");
    }
    
    @Test 
    private void myTest(){
//    	driver = new ChromeDriver();
    	
    	firstItem();
    	
    	
    }
    
    private void firstItem(){
    	WebElement searchBox = driver.findElement(By.xpath("//*[@id='searchtext']"));
    	searchBox.click();
    	searchBox.sendKeys("grand theft auto 5");
    	WebElement searchButton = driver.findElement(By.xpath("//*[@id='searchbutton']"));
    	searchButton.click();
    	WebElement addItemToCart = (new WebDriverWait(driver, 10))
    			   .until(ExpectedConditions.elementToBeClickable(By.id("mainContentPlaceHolder_dynamicContent_ctl00_RepeaterResultFoundTemplate_ResultFoundPlaceHolder_1_ctl00_1_ctl00_1_StandardPlaceHolderTop_2_ctl00_2_rptResults_2_res_0_btnAddToCart_0")));
    	addItemToCart.click();
    	
//    	WebElement table = driver.findElement(By.xpath("//*[@class = 'cart ats-cartlineitemslist']"));
    	
    	WebElement deleteItem = (new WebDriverWait(driver, 10))
 			   .until(ExpectedConditions.elementToBeClickable(By.className("ats-remove")));
    	 
//    	WebElement deleteItem = driver.findElement(By.className("ats-remove"));
    	deleteItem.click();
    	
    	Sheet sheet = ;
    	
    	
    }
	
}
