package testIonicPartner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class RunBlogTest {
	static WebDriver webDriver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Selenium/chromedriver/chromedriver.exe");

		// Demo purpose - can be deleted
		System.out.println("Test Blog Page Test case: Starting");
        Thread.sleep(3000);
        
		String baseUrl = "https://www.ionicpartners.com/";
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get(baseUrl);	
		
		
		if(testBlogPage())
		{
			// Demo purpose - can be deleted
			System.out.println("Test Blog Page Test case: Passed");
		}
		else
		{		
			// Demo purpose - can be deleted
			System.out.println("Test Blog Page Test case: Failed");			
		}


		// Close the browser and WebDriver
		webDriver.close();
		webDriver.quit();
		

	}
	
	private static boolean testBlogPage() throws InterruptedException
	{
				
		// Load the URL, Explicitly wait till Blog item is loaded and get its Web Element		
        WebDriverWait pageLoadWaitVar = new WebDriverWait(webDriver,10);          
        WebElement blogElement = pageLoadWaitVar.until(presenceOfElementLocated(By.id("slider-11-slide-47-layer-30")));

		// Demo purpose - Below two lines can be deleted
        System.out.println("Web Site index page loaded");
        Thread.sleep(3000);
	  
        if(blogElement != null)
        {
        	// Blog element is clicked and explicit wait till Blog page is loaded
        	blogElement.click();        	
        	WebElement blogPageElement =
        			pageLoadWaitVar.until(presenceOfElementLocated(By.xpath("//a[@href='/blog']")));
        
        	// Demo purpose - Below two lines can be deleted        	
        	System.out.println("Blog Page Clicked");        	
        	Thread.sleep(3000);

        	// Scroll till end of the page
            webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);

            // Demo purpose - Below two lines can be deleted
        	System.out.println("Blog Page Scrolled");        	
        	Thread.sleep(3000); 
        	
        	return true;
        }
        else
        {
            return false;		        	
        }	  
	}	
}
