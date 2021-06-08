package testIonicPartner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class RunAboutTest {

	static WebDriver webDriver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Selenium/chromedriver/chromedriver.exe");

		// Demo purpose - can be deleted
		System.out.println("Test About Page Test case: Starting");
        Thread.sleep(3000);
        
		String baseUrl = "https://www.ionicpartners.com/";
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get(baseUrl);	
		
		
		if(testAboutPage())
		{
			// Demo purpose - can be deleted
			System.out.println("Test About Page Test case: Passed");
		}
		else
		{		
			// Demo purpose - can be deleted
			System.out.println("Test About Page Test case: Failed");			
		}


		// Close the browser and WebDriver
		webDriver.close();
		webDriver.quit();
		

	}
	
	private static boolean testAboutPage() throws InterruptedException
	{
		// Load the URL, Explicitly wait till About item is loaded and get its Web Element		
        WebDriverWait pageLoadWaitVar = new WebDriverWait(webDriver,10);          
        WebElement aboutElement = pageLoadWaitVar.until(presenceOfElementLocated(By.id("slider-11-slide-47-layer-32")));

		// Demo purpose - Below two lines can be deleted
        System.out.println("Web Site index page loaded");
        Thread.sleep(3000);
	  
        if(aboutElement != null)
        {
        	// About element is clicked and explicit wait till About page is loaded
        	aboutElement.click();        	
        	WebElement aboutPageElement =
        			pageLoadWaitVar.until(presenceOfElementLocated(By.xpath("//a[@href='/about-us']")));
        
        	// Demo purpose - Below two lines can be deleted        	
        	System.out.println("About Page Clicked");        	
        	Thread.sleep(3000);

        	// Scroll till end of the page
            webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);

            // Demo purpose - Below two lines can be deleted
        	System.out.println("About Page Scrolled");        	
        	Thread.sleep(3000); 
        	
        	WebElement twitterElement = 
        			webDriver.findElement(By.xpath("//a[@href='https://twitter.com/IonicPartners']"));
        	
        	if(twitterElement != null)
        	{
        		String twitterURLIonicPartners = "https://twitter.com/IonicPartners";
        		        		
        		twitterElement.click();
        		
        		// Demo purpose - Below line can be deleted
            	System.out.println("Twitter link Clicked");               		

            	pageLoadWaitVar.until(ExpectedConditions.urlToBe(twitterURLIonicPartners));
            	
        		// Demo purpose - Below two lines can be deleted
            	System.out.println("Twitter page Loaded");        	
            	Thread.sleep(3000);         		
                
            	return true;		        		
        	}
        	else
        	{
                return false;		        		
        	}           
        }
        else
        {
            return false;		        	
        }	  
	}	
}
