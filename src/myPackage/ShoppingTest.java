package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingTest {
  
	WebDriver driver;
	String baseUrl = "http://www.gamestop.com";

	@BeforeTest
	public void openPage() {
		System.out.println("opening gamestop");
		driver = new ChromeDriver();
		driver.get("http://www.gamestop.com/");
	}
	 
	@Test
	public void myTest() {
		firstItem();
		secondItem();
		checkout();
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
    	WebElement deleteItem = (new WebDriverWait(driver, 10))
 			   .until(ExpectedConditions.elementToBeClickable(By.className("ats-remove")));
    	deleteItem.click();	
	}
	
	private void secondItem(){
		WebElement searchBox = (new WebDriverWait(driver, 10))
	 			   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='searchtext']")));
    	searchBox.click();
    	searchBox.sendKeys("playstation vr");
    	WebElement searchButton = driver.findElement(By.xpath("//*[@id='searchbutton']"));
    	searchButton.click();
    	
    	WebElement addItem = (new WebDriverWait(driver, 10))
	 			   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainContentPlaceHolder_dynamicContent_ctl00_RepeaterResultFoundTemplate_ResultFoundPlaceHolder_1_ctl00_1_ctl00_1_StandardPlaceHolderTop_2_ctl00_2_rptResults_2_res_5_btnAddToCart_5']")));
    	addItem.click();
	}
	
	private void checkout(){
		
		WebElement checkout = (new WebDriverWait(driver, 10))
	 			   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cartcheckoutbtn']")));
		checkout.click();
			
		WebElement buyAsGuest = (new WebDriverWait(driver, 10))
	 			   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='buyasguest']")));
		buyAsGuest.click();
		
		WebElement firstName = (new WebDriverWait(driver, 10))
	 			   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ShipTo_FirstName']")));
		firstName.sendKeys("John");		
		WebElement lastName = driver.findElement(By.xpath("//*[@id='ShipTo_LastName']"));
		lastName.sendKeys("Doe");		
		WebElement address = driver.findElement(By.xpath("//*[@id='ShipTo_Line1']"));
		address.sendKeys("234 Imaginary Ln");		
		WebElement city = driver.findElement(By.xpath("//*[@id='ShipTo_City']"));
		city.sendKeys("A Fake Place");		
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='USStates']")));
		dropdown.selectByVisibleText("California");		
		WebElement zip = driver.findElement(By.xpath("//*[@id='ShipTo_PostalCode']"));
		zip.sendKeys("12345");		
		WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='ShipTo_PhoneNumber']"));
		phoneNumber.sendKeys("1231231234");		
		WebElement email = driver.findElement(By.xpath("//*[@id='ShipTo_EmailAddress']"));
		email.sendKeys("fakefakefake@gmail.com");
		
		WebElement continueCheckout = driver.findElement(By.xpath("//*[@id='shipaddressform']/div[3]/a"));
		continueCheckout.click();
		
		WebElement finishCheckout = (new WebDriverWait(driver, 10))
	 			   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='shipsubmitbtn']")));
		finishCheckout.click();

		WebElement cardNumber = (new WebDriverWait(driver, 10))
	 			   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ccNumber']")));
		Select cardType = new Select(driver.findElement(By.xpath("//*[@id='cardType']")));
		cardType.selectByVisibleText("Visa");
		cardNumber.sendKeys("1234567812345678");
		Select monthExpires = new Select(driver.findElement(By.xpath("//*[@id='expMonth']")));
		monthExpires.selectByVisibleText("12");
		Select yearExpires = new Select(driver.findElement(By.xpath("//*[@id='expYear']")));
		yearExpires.selectByVisibleText("2017");
		WebElement pin = driver.findElement(By.xpath("//*[@id='cvv']"));
		pin.sendKeys("111");
		
		WebElement Submit = driver.findElement(By.xpath("//*[@id='paymentform']/div[3]/div[2]/a"));
		Submit.click();	
	}
}
