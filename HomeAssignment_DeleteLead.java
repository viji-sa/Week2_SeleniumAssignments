package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeAssignment_DeleteLead {
	/****************************************** FINISHED ***********************************************/
/*	/*http://leaftaps.com/opentaps/control/main
		 
		Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
*/
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		WebElement eleUsername = driver.findElement(By.id("username"));
		eleUsername.sendKeys("Demosalesmanager");		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		//click Leads Link
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
				
		/****NEED HELP - I've saved phone number but it isn't listing on clicking 'Find Leads'*****/
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		driver.findElement(By.name("phoneCountryCode")).sendKeys("");
		
		driver.findElement(By.name("phoneAreaCode")).sendKeys("");
		
		driver.findElement(By.name("phoneNumber")).sendKeys("");
			
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
	    
	    //Capture lead ID of First Resulting lead
	    String firstLead=driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
	    System.out.println("First result set: " + firstLead);
	    
	    //Click First Resulting lead
	    driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
	    
	    //Delete
	    driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstLead);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Verify message "No records to display" in the Lead List. 
		String verifyMessage = driver.findElement(By.id("ext-gen437")).getText();
		
		if(verifyMessage.equals("No records to display")) {
			System.out.println("Passed...");
		}
		else {
			System.out.println("Nah...");
		}
		driver.close();
	}

}
