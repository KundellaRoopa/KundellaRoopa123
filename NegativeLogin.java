package com.fst.Task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeLogin {
	ChromeDriver driver;
	@Before
	public void Launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@After
	public void Closebrowser() {
		driver.close();
	}
	@Test
	public void loginAcc() {
		//Navigate to the dervice now instance
		driver.get("https://dev144331.service-now.com/login");
		//Verify title is ServiceNow
		
		//User clicks on the login button
		WebElement LoginBtn = driver.findElement(By.name("not_important"));
		LoginBtn.click();
		//Verify the error message as Invalid input in user name!
		WebElement ErrorMessage = driver.findElement(By.xpath("//*[text()='Invalid input in user name!']"));
		 
		if(ErrorMessage.isDisplayed())
		{
		System.out.println("Element found "+ ErrorMessage);
		}
		
		//Enter the username as admin
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		//User clicks on the login button
		WebElement Loginclick = driver.findElement(By.name("not_important"));
		Loginclick.click();
		//Verify the error message contains User name or password invalid
		WebElement errorMsgValid = driver.findElement(By.xpath("//*[text()='User name or password invalid. To reset your admin password click ']"));
		 
		if(errorMsgValid.isDisplayed())
		{
		System.out.println("Element found "+ errorMsgValid);
		}

}
}
