package TakeScreenShot;


import java.text.SimpleDateFormat;
import java.util.Date;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.apache.commons.io.FileUtils;
import java.io.File;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.Test;



public class Test5 {
	
	static WebDriver driver;


	
	
	@Test
	public void AddNationalitiess() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	// File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// FileUtils.copyFile(scrFile, new File("C:\\ScreenShot1.jpg"));
	
	 driver.get("https://opensource-demo.orangehrmlive.com/");
	 Test5.TakescreenShot("screenshot1.jpg");
	 
	 Thread.sleep(3000);
	 
	 
	 findElement(By.name("username")).sendKeys("Admin");
	 Test5.TakescreenShot("screenshot2.jpg");
	  
	  
	  findElement(By.name("password")).sendKeys("admin123");
	  Test5.TakescreenShot("screenshot3.jpg");
	  
	  findElement(By.xpath("//button[@type='submit']")).click();
	  Test5.TakescreenShot("screenshot4.jpg");
	 

		
	
	
	
	}
	
	

	
	public static void TakescreenShot(String str1)throws Exception 
	{
		 TakesScreenshot scrShot4 =((TakesScreenshot)driver);// we are asking the driver to capture the screenshot
		  File SrcFile4=scrShot4.getScreenshotAs(OutputType.FILE); // we are asking the driver to convert to file format 
		  
		  String str="C:\\TC03_Login\\"+str1;
		  
		  FileUtils.copyFile(SrcFile4, new File(str));
		  
	}
	
	
	
	
	 public  static WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}
	 
	
	
	
	
	
	
	
	
	
	
	

}
