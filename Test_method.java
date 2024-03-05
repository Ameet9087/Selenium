package BasicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_method {
	
//	@Test(priority = 2)
//	public void facebook() {
//		WebDriver d=new ChromeDriver();
//		d.manage().window().maximize();
//		d.get("https://www.facebook.com/");
//	}
//
//	@Test(priority = 1,invocationCount = 2)
//	public void ajioTest() {
//		WebDriver d=new ChromeDriver();
//		d.manage().window().maximize();
//		d.get("https://www.ajio.com/");
//	}
//
//	@Test(priority = 0)
//	public void mintra() {
//		WebDriver d=new ChromeDriver();
//		d.manage().window().maximize();
//		d.get("https://www.myntra.com/");
//	}
//.........................................................................	
	//SKIP TEST
	@Test
	public void facebook() {
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.facebook.com/");
		String actual = d.getCurrentUrl();
		String Expected="https://www.facebook.com/ameet";
		Assert.assertEquals(actual, Expected);
	
	}

	@Test(dependsOnMethods = "facebook")
	public void ajioTest() {
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.ajio.com/");
		
	}

	@Test(dependsOnMethods = "facebook")
	public void mintra() {
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.myntra.com/");
	}
}
