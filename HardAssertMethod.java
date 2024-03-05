package BasicTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertMethod {

	@Test
	public void Myntra() {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.myntra.com/");
		
		//ASSERTEQUAL()
//		String actual = d.getTitle();
//		String expected="Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
//		Assert.assertEquals(actual, expected);
//		System.out.println(actual);
		
		//ASSERTTRUE()
//		WebElement search = d.findElement(By.className("desktop-searchBar"));
////		Assert.assertTrue(search.isDisplayed());//----true-next line executed
////		System.out.println("good morning");
//		Assert.assertTrue(search.isSelected());//----false-next line not executed
//		System.out.println("good morning");
		
		//ASSERTFALSE()
//		WebElement search = d.findElement(By.className("desktop-searchBar"));
////		Assert.assertFalse(search.isDisplayed());//-----false-next line not executed
////		System.out.println("welcome");
//		Assert.assertFalse(search.isSelected());//----true-next line executed
//		System.out.println("welcome");
	}

}
