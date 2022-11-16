package web_scraping;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_firefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//setting the driver executable
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\handes\\AppData\\Local\\Mozilla Firefox\\firefox.exe");

		//Initiating your chromedriver
		WebDriver driver=new FirefoxDriver();
		
		driver.navigate().to("https://www.indeed.com/");;
		  
		  //closing the browser driver.close();
	    driver.manage().window().maximize();
	    
	    driver.close();

	}
}
