package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*http://leaftaps.com/opentaps/control/main

1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Email
9	Enter Email
10	Click find leads button
11	Capture name of First Resulting lead
12	Click First Resulting lead
13	Click Duplicate Lead
14	Verify the title as 'Duplicate Lead'
15	Click Create Lead
16	Confirm the duplicated lead name is same as captured name
17	Close the browser (Do not log out)

*/

public class HomeAssignment_DuplicateLead {
	/******************************************* FINISHED ******************************************/
	
	public static void main(String[] args) throws InterruptedException {
		//1	Launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		// 2	Enter the username
		WebElement eleUsername = driver.findElement(By.id("username"));
		eleUsername.sendKeys("Demosalesmanager");	
		
		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// 4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//5		Click crm/sfa link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		// 6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click(); //or use driver.findElement(By.linkText("Leads")).click(); 
		
		// 7	Click Find leads
		driver.findElement(By.xpath("//a[contains(text(),'Find')]")).click(); 
		
		// 8	Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		// 9. Enter Email
		driver.findElement(By.id("ext-gen282")).sendKeys("test@gmail.com");
		
		//10	Click find leads button		
		driver.findElement(By.id("ext-gen334")).click(); //or USE driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		
		//11	Capture name of First Resulting lead
		String capText1 =driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
		System.out.println("First resulting lead is " + capText1);

		//12 	 Click First Resulting lead
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		
		//13	Click Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		//14	Verify the title as 'Duplicate Lead'
		String capText2 = driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).getText();
		System.out.println(driver.getTitle());
		
		//15	Click Create Lead
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		//16. Confirm the duplicated lead name is same as captured name		
		String dupName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		if(capText2.equals(dupName))
			System.out.println("This name is same as the captured name");
		else
			System.out.println("Not same");
		
		//17. Close the browser (Do not log out)		
		driver.close();		
	}
}
