package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*/* * //Pseudo Code
 *  * 1. Launch URL "http://leaftaps.com/opentaps/control/login" * 
 * 2. Enter UserName and Password Using Id Locator * 
 * 3. Click on Login Button using Class Locator * 
 * 4. Click on CRM/SFA Link * 
 * 5. Click on contacts Button * 
 * 6. Click on Create Contact *  
 * 7. Enter FirstName Field Using id Locator * 
 * 8. Enter LastName Field Using id Locator * 
 * 9. Enter FirstName(Local) Field Using id Locator * 
 * 10. Enter LastName(Local) Field Using id Locator * 
 * 11. Enter Department Field Using any Locator of Your Choice * 
 * 12. Enter Description Field Using any Locator of your choice  * 
 * 13. Enter your email in the E-mail address Field using the locator of your choice * 
 * 14. Select State/Province as NewYork Using Visible Text * 
 * 15. Click on Create Contact * 
 * 16. Click on edit button  * 
 * 17. Clear the Description Field using .clear * 
 * 18. Fill ImportantNote Field with Any text * 
 * 19. Click on update button using Xpath locator * 
 * 20. Get the Title of Resulting Page.*/

public class HomeAssignment_CreateContact {
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		WebElement eleUsername = driver.findElement(By.id("username"));
		eleUsername.sendKeys("Demosalesmanager");		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//click contact button and then Create Contact Link
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
		//enter details
		driver.findElement(By.id("firstNameField")).sendKeys("Viji");
		driver.findElement(By.id("lastNameField")).sendKeys("SA");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Viji_SA");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("SASA");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("MATHS");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Maths_Algebra");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("123@aaa.com");
		
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select stateProv = new Select(state);
		stateProv.selectByVisibleText("Texas");		
		
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Enter important note");		
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click(); //Used XPath 
		// or USE driver.findElement(By.className("smallSubmit")).click();
		
		String title=driver.getTitle();
		//System.out.println(title);
		
		if(title.equals("View Contact | opentaps CRM"))
			System.out.println("Passed - created successfully. Page title is "+title);
        else
        	System.out.println("Failed - Creation failed. Page title is "+title);
	}
	}


