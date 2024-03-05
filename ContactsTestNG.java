package vTiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.ListenerImplementation;
import CommonUtil.ProperrtyFileUtil;
import CommonUtil.WebDriverUtil;

@Listeners(ListenerImplementation.class)
public class ContactsTestNG {

	ProperrtyFileUtil pfu=new ProperrtyFileUtil();
	WebDriverUtil wdu=new WebDriverUtil();
	ExcelUtil eu=new ExcelUtil();
	JavaUtil ju=new JavaUtil();
	
	@Test
	public void ContactsTest() throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		wdu.maximize(driver);
		
		//to apply wait for findElement()
		wdu.implicitWait(driver);
		
		//read data from property file
		String URL = pfu.getDataFromPropertyFile("url");
		String USERNAME=pfu.getDataFromPropertyFile("username");
		String PASSWORD=pfu.getDataFromPropertyFile("password");
		
		//read data from excel file
		String FIRSTNAME = eu.getDataFromExcel("Contacts", 0, 1);
		String LASTNAME = eu.getDataFromExcel("Contacts", 1, 1);
		String GROUP = eu.getDataFromExcel("Contacts", 2, 1);
		String ORGNAME = eu.getDataFromExcel("Contacts", 3, 1);
		String CHILDURL = eu.getDataFromExcel("Contacts", 4, 1);
		String PARENTURL = eu.getDataFromExcel("Contacts", 5, 1);
		
		//To launch the application
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//click on create contact
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//to fail the testscrpt
		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing--fail";
		Assert.assertEquals(ActualUrl, ExpectedUrl);
		
		//click on group
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//select from dropdown team selling
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wdu.handleDropdown(dropdown, GROUP);
		
		//organization name;-click on add organization.
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//switch from parent to child window
		wdu.switchWindow(driver,CHILDURL);
		
		
		//enter organization name
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		
		//click on search button
		driver.findElement(By.cssSelector("input[name='search']")).click();
		Thread.sleep(1000);
		
		//select organization name
		driver.findElement(By.id("1")).click();
		
		//switch from child to parent window.
		wdu.switchWindow(driver, PARENTURL);
		
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		//take the screenshot
//		Thread.sleep(2000);/
//		wdu.screenshot(driver, "contacts");
		
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wdu.mouseHover(driver, img);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
