package com.whirlpool.scrapping;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.Table;
import com.spire.doc.TableCell;
import com.spire.doc.TableRow;
import com.spire.doc.documents.Paragraph;

public class OneLabScrapping {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://onelab.whirlpool.com/Thingworx/FormLogin/OneLAB");
		driver.manage().window().maximize();
		driver.findElement(By.name("thingworx-form-userid")).sendKeys("");
		driver.findElement(By.name("thingworx-form-password")).sendKeys("");
		driver.findElement(By.name("Login")).click();

		String currentURL= driver.getCurrentUrl();
		System.out.println(currentURL);
		
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("root_pagemashupcontainer-2_mashupcontainer-67_ptcstextfield-437")).click();

		driver.findElement(By.id("root_pagemashupcontainer-2_mashupcontainer-67_ptcstextfield-437")).sendKeys("376");
		
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id=\"root_pagemashupcontainer-2_menu-62\"]/li[4]/table/tbody/tr/td/a")).click();
		
		Thread.sleep(2000);

		driver.navigate().to("https://onelab.whirlpool.com/Thingworx/Onelab/TinyMCE/AnalyticsTextEditor.html");
		currentURL= driver.getCurrentUrl();
		System.out.println(currentURL);
		
		driver.switchTo().frame("editorId2_ifr");
				
		WebElement desc =  driver.findElement(By.xpath("//*[@id=\"requestDetails\"]/div[4]"));
	    String descStr =desc.getText().split(":")[1];
	    
	    WebElement runId =  driver.findElement(By.xpath("//*[@id=\"runDetails\"]/tbody/tr[2]/td[2]"));
	    String runIdStr =runId.getText();
	    
	    WebElement model =  driver.findElement(By.xpath("//*[@id=\"genericMetadata\"]/tbody/tr[2]/td[3]"));
	    String modelStr =model.getText();
	    
	    WebElement technician =  driver.findElement(By.xpath("//*[@id=\"unitDetails\"]/tbody/tr[2]/td[10]"));
	    String technicianStr = technician.getText();
	    
	    WebElement date =  driver.findElement(By.xpath("//*[@id=\"genericMetadata\"]/tbody/tr[2]/td[4]"));
	    String dateStr = date.getText();
	    
	    Document document = new Document("C:\\Users\\REVARVS\\Downloads\\run-data.docx");  
	     
	     
	     Section section = document.getSections().get(0);  
	     
	     Table table1 = section.getTables().get(0);  
	     Map<String, String> map = new HashMap<String, String>();  
	     map.put("desc",descStr); 
	     map.put("model",modelStr); 
	     map.put("technician",technicianStr); 

	     replaceTextinTable(map,table1);
	     
	     Table table2 = section.getTables().get(1);  
	     Map<String, String> map1 = new HashMap<String, String>();  
	     map1.put("serial","1"); 
	     map1.put("date",dateStr); 
	     map1.put("runId",runIdStr); 

	     replaceTextinTable(map1,table2);

	     document.saveToFile("CreateByReplacingPlaceholder.docx", FileFormat.Docx_2013);  
	    
	     System.out.println("Done");

	}
	
	 static void replaceTextinTable(Map<String, String> map, Table table){  
	        for(TableRow row:(Iterable<TableRow>)table.getRows()){  
	            for(TableCell cell : (Iterable<TableCell>)row.getCells()){  
	                for(Paragraph para : (Iterable<Paragraph>)cell.getParagraphs()){  
	                    for (Map.Entry<String, String> entry : map.entrySet()) {  
	                        para.replace("${" + entry.getKey() + "}", entry.getValue(), false, true);  
	                    }  
	                }  
	            }  
	        }  
	    }  
	
}