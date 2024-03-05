package vTiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.ListenerImplementation;
import CommonUtil.ProperrtyFileUtil;
import CommonUtil.WebDriverUtil;

@Listeners(ListenerImplementation.class)
public class Organization {

	ProperrtyFileUtil pfu=new ProperrtyFileUtil();
	WebDriverUtil wdu=new WebDriverUtil();
	ExcelUtil eu=new ExcelUtil();
	JavaUtil ju=new JavaUtil();
	
	@Test
	public void organizationTest() throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		wdu.maximize(driver);
		
		//to apply wait for findElement()
		wdu.implicitWait(driver);
		
		//read data from property file
		String URL = pfu.getDataFromPropertyFile("url");
		String USERNAME=pfu.getDataFromPropertyFile("username");
		String PASSWORD=pfu.getDataFromPropertyFile("password");
		
		//read data from excel file
		String ORGNAME = eu.getDataFromExcel("Organization", 0, 1);
		String GROUP = eu.getDataFromExcel("Organization", 1, 1);
		
		//To launch the application
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on organization 
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//click on create organization...(+)
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		//enter organization name
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME + ju.getRandomNumber());
		
		//in assignedTo click on group
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//in the dropdown select support group
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wdu.handleDropdown(dropdown, GROUP);
		
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(3000);
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wdu.mouseHover(driver, img);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
	}
}
