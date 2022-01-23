package TestNGpac;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class TestNGNTest {
	
	public WebDriver driver;
//  @Test
//  public void f() {
//	  System.setProperty("webdriver.chrome.driver", "E:\\SAspire\\chromedriver.exe");
//      driver=new ChromeDriver();
//     driver.get("https://www.google.com/");
//     String expectedTitle="Google";
//     String actualTitle=driver.getTitle();
//     Assert.assertEquals(actualTitle, expectedTitle);
//  }
	
	@Test(priority=0)
	  public void launch() {
		  System.setProperty("webdriver.chrome.driver", "E:\\SAspire\\chromedriver.exe");
	      driver=new ChromeDriver();
	     driver.get("https://aspireapp.odoo.com/web/login");
	     WebDriverWait w=new WebDriverWait(driver,30);
	     w.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
	     String expectedTitle="Odoo";
	     String actualTitle=driver.getTitle();
	     Assert.assertEquals(actualTitle, expectedTitle);
	  }
	@Test(priority=1)
	public void validatetitle() throws IOException
	{
		//String expectedTitle="Odoo";
	String pagetitle=driver.getTitle();
	
	if(pagetitle.contains("Odoo"))
	{
		Assert.assertTrue(true, "title test was passed");
	}
	else
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File dest=new File("ss1.png");
    FileUtils.copyFile(src,dest);
    Reporter.log("ss1.png");
    Assert.assertTrue(false,"title test was failed");
    
	}
	}
	
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Starting the browser session");
  }

  @AfterMethod
  public void afterMethod() {

	  System.out.println("Closing the browser session");
      driver.quit();	  
  }


}
