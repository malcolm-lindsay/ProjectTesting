package com.qa.testing.ProjectTesting;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UserTesting {


	public class selenium {	
		
		WebDriver driver;
		String url;
			
			@Before
			public void setup() {
				url = "http://localhost:3000";
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\malco\\Desktop\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			
			@After
			public void tearDown() {
				driver.quit();
			}
			
			
			@Test
			public void TestUser() throws InterruptedException {
				driver.manage().window().maximize();
				driver.get(url);
				driver.findElement(By.id("CreateButton")).click();
						
				WebElement Username = driver.findElement(By.id("UsernameInput"));
				WebElement DietryRequirements = driver.findElement(By.id("DietryRequirementsInput"));
				WebElement EmailAddress = driver.findElement(By.id("EmailAddressInput"));
				WebElement Age = driver.findElement(By.id("AgeInput"));
				WebElement AddUser = driver.findElement(By.xpath("//*[@id=\"SubmitButton\"]"));
				Username.sendKeys("Malcolm11");
				DietryRequirements.sendKeys("None");
				EmailAddress.sendKeys("email");
				Age.sendKeys(String.valueOf(22));
				AddUser.click(); 
				
				

			
				WebElement success = driver.findElement(By.xpath("//*[@id=\"tables\"]/div/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[2]"));
				//how to check for any row rather than just this particular one? 
				assertEquals("Malcolm", success.getAttribute("innerHTML"));
			}			
	}
}
