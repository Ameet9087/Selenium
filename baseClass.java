package CommonUtil;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class baseClass {
	
	//public WebDriver driver;
	protected WebDriver driver=new ChromeDriver();

	WebDriverUtil wdu=new WebDriverUtil();
	ProperrtyFileUtil pfu=new ProperrtyFileUtil();
	
	
	
	@BeforeSuite           //connect to the data base
	public void BS() {
		System.out.println("Connect to data base");
	}
	
	
	@BeforeClass            //launch the browser
	public void BC() throws IOException {
		String URL = pfu.getDataFromPropertyFile("url");
		

		wdu.maximize(driver);
		wdu.implicitWait(driver);
		driver.get(URL);
	}
	
	
	@BeforeMethod			//login to the application
	public void BM() throws IOException {
		String USERNAME=pfu.getDataFromPropertyFile("username");
		String PASSWORD=pfu.getDataFromPropertyFile("password");
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();	
	}
	
	
	@AfterSuite			//dis-connect from data base
	public void AS() {
		System.out.println("dis-connect from data base");
	}
	

	@AfterClass			//close the browser
	public void AC() {
		driver.quit();
		
	}
			
	@AfterMethod			//logout from the application
	public void AM() throws InterruptedException {
		Thread.sleep(3000);
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wdu.mouseHover(driver, img);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
