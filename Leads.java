package vTiger;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtil.ExcelUtil;
import CommonUtil.ProperrtyFileUtil;
import CommonUtil.WebDriverUtil;

public class Leads {

	WebDriverUtil wdu=new WebDriverUtil();
	ProperrtyFileUtil pfu=new ProperrtyFileUtil();
	ExcelUtil eu=new ExcelUtil();
	
	@Test
	public void LeadsTest() throws IOException {
		WebDriver driver=new ChromeDriver();
		wdu.maximize(driver);
		wdu.implicitWait(driver);
		
		String URL = pfu.getDataFromPropertyFile("url");
		String USERNAME = pfu.getDataFromPropertyFile("username");
		String PASSWORD = pfu.getDataFromPropertyFile("password");
		
		String FIRSTNAME = eu.getDataFromExcel("Contacts", 0, 1);
		String LASTNAME = eu.getDataFromExcel("Contacts", 1, 1);
		String GROUP = eu.getDataFromExcel("Contacts", 2, 1);
		String ORGNAME = eu.getDataFromExcel("Organization", 0, 1);
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	    driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
	    driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
	    
	    driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
	    driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	    driver.findElement(By.name("company")).sendKeys(ORGNAME);
	    
	    driver.findElement(By.xpath("(//input[@name='assigntype'])[1]")).click();
	    WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wdu.handleDropdown(dropdown, GROUP);

	}
}
