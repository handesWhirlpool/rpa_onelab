package seelnium_rpa;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.*;
 
public class FirstTestInSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//setting the driver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe");

		//Initiating your chromedriver
		WebDriver driver=new ChromeDriver();
		
		  // WebDriver driver=new EdgeDriver();
		  
		  //Applied wait time driver.manage().timeouts().implicitlyWait(10,
		//  TimeUnit.SECONDS); //maximize window driver.manage().window().maximize();
		  
		  //open browser with desried URL driver.get("https://www.google.com"); //
		  driver.get("https://gesdev.whirlpool.com/gwsapi/view/query");
		  
		  //closing the browser driver.close();
		 
		
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	            
	    String baseUrl = "http://www.google.co.uk/";
	    driver.get(baseUrl);
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		/*
		 * driver.switchTo().window(tabs.get(1)); //switches to new tab
		 * driver.get("https://www.facebook.com");
		 */
	    
	    driver.switchTo().window(tabs.get(0)); // switch back to main screen        
	    driver.get("https://www.news.google.com");
	    
	    driver.close();

	}

}