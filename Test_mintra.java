package BasicTestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_mintra {

	@Test
	public void Myntra() {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.myntra.com/");
		String actualurl = d.getCurrentUrl();
		
		String expectedUrl="https://www.myntra.com/pune";
		
		//call assertequals(boolean actual,boolean expected)
		Assert.assertEquals(actualurl, expectedUrl);
		
//..........................................................		
//		if (url.equals("https://www.myntra.com/")) {
//			System.out.println("matched");
//		} else {
//			System.out.println("not matched");
//		}
//...........................................................		
		System.out.println(actualurl);
		//String tittle = d.getTitle();
		//System.out.println(tittle);
	}
	
}
