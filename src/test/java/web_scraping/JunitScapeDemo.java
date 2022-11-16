package web_scraping;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class JunitScapeDemo {

	/*
	 * @Test public void test() { //fail("Not yet implemented"); }
	 */

	@Test
	public void test() {
//	System.setProperty("webdriver.chrome.driver","C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe");
	System.setProperty("webdriver.gecko.driver","\"C:\\Users\\handes\\AppData\\Local\\Mozilla Firefox\\firefox.exe\"");
//	WebDriver driver = new ChromeDriver();
	WebDriver driver = new FirefoxDriver();
	
	driver.navigate().to("https://www.indeed.com/");
	driver.manage().window().maximize();
	}
}
