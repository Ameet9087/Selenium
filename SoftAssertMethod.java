package BasicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertMethod {

	@Test
	public void Myntra() {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.myntra.com/");
		
		String actual = d.getCurrentUrl();
		String expected="https://www.myntra.com/pune";
		//create object of SoftAssert class
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(actual, expected);
		System.out.println("welcome");
		sa.assertAll();//--use to fail the condition IF You want falure=1
	}
}
