package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeAssignment_EditLead {
	/**************************************FINISHED *************************************/
/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
*/
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
			
			// 8	Enter first name
			driver.findElement(By.id("ext-gen248")).sendKeys("Viji");
			
			//9	Click find leads button		
			driver.findElement(By.id("ext-gen334")).click(); //or USE driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(1000);
			
			//10 	 Click First Resulting lead
			driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
			
			//11	Verify the title of the page 
			String verifyTitle=driver.getTitle();
			//System.out.println(verifyTitle); //View Lead | opentaps CRM
						
			if(verifyTitle.equals("View Lead | opentaps CRM"))
				System.out.println("Verified. Page title is "+ verifyTitle);
	        else
	        	System.out.println("Wrong title. Page title is "+verifyTitle);
			
			//12	Click Edit Lead
			driver.findElement(By.xpath("//a[text()='Edit']")).click();			
			
			// 13 Change the company name //updateLeadForm_companyName
			driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
			driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("def");	

			//	14 Click Update ext-gen596
			driver.findElement(By.xpath("//input[@value='Update']")).click();
			
			//	15 Confirm the changed name appears //viewLead_companyName_sp
			String updatedCompanyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
			System.out.println("Updated company name is:" + updatedCompanyName);
			
			//	16. Close the browser (Do not log out)		
			//driver.close();

	}

}
