package seelnium_rpa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://gesdev.whirlpool.com/gwsapi/SjtcLogon.jsp");
		driver.manage().window().maximize();

		/*
		 * Scanner myObj = new Scanner(System.in); String input = myObj.nextLine();
		 */
		driver.findElement(By.name("userid")).sendKeys("handes");
		driver.findElement(By.name("passwd")).sendKeys("Dhule123");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String currentURL= driver.getCurrentUrl();
		System.out.println(currentURL);

		
		driver.findElement(By.xpath("//a[contains(text(),'Lab Request')]")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@ng-model='query.testMaster']")).sendKeys("2688187");
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
//		driver.findElement(By.xpath("//input[type='button'][value='Search']")).click();
//		driver.findElement(By.cssSelector("input[type='button']")).click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		// Grab the table
		WebElement table = driver.findElement(By.xpath("//table"));

		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		
		
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.xpath("//th"));
			List<String> tableData = new ArrayList<String>();
			for (WebElement cell : cells) {
				System.out.println("header >>   " + cell.getText());
				tableData.add(cell.getText());
			}
			//write contents to a file
			writeHeaderToFile(tableData);
		}
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.xpath("//td"));
			List<String> tableData = new ArrayList<String>();
			for (WebElement cell : cells) {
				System.out.println("data >>   " + cell.getText());
				tableData.add(cell.getText());
			}
			//write contents to a file
			writeDataToFile(tableData);
		}
		
		//driver.close();
	}

	private static void writeHeaderToFile(List<String> tableData) {
		try {
			FileWriter fileWriter = new FileWriter("c:\\temp\\GWSData.txt");
			for(String str: tableData) {
				fileWriter.append(str).append("\n");
			}
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private static void writeDataToFile(List<String> tableData) {
		try {
			FileWriter fileWriter = new FileWriter("c:\\temp\\GWSData.txt");
			for(String str: tableData) {
				fileWriter.append(str).append("\n");
			}
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
}