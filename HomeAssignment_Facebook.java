package week2.day1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeAssignment_Facebook {

	public static void main(String[] args) {
		// Step 1: Download and set the path // Step 2: Launch the chrome browser
		ChromeDriver driver=new ChromeDriver();
		
		//Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		//Allow cookies
		driver.findElement(By.xpath("//button[contains(text(),'Allow all cookies')]")).click();			

		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		
		
		// Step 6: Click on Create New Account button		
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("abc");
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("123");
		// Step 9: Enter the mobile number/email
		driver.findElement(By.name("reg_email__")).sendKeys("abc@123.com");
		//Re-enter email address
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("abc@123.com");
		// Step 10: Enterthe password
		driver.findElement(By.id("password_step_input")).sendKeys("Welcome@!23");
		
		// Step 11: Handle all the three drop downs
		Select day= new Select(driver.findElement(By.xpath("//select[@title='Day']")));
		day.selectByVisibleText("10");
		
		Select month= new Select(driver.findElement(By.xpath("//select[@title='Month']")));
		month.selectByVisibleText("Jan");
		
		Select year= new Select(driver.findElement(By.xpath("//select[@title='Year']")));
		year.selectByVisibleText("1995");
			
		// Step 12: Select the radio button "Female" ( A normal click will do for this step) 
		driver.findElement(By.className("_58mt")).click();
				
		//Submit button
		driver.findElement(By.name("websubmit")).click();
		
		//Save info.
		System.out.println("Creation in progress");	
	
	}

}
