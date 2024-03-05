package BasicDDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver d=new ChromeDriver();
		d.get("https://demoapp.skillrary.com/");
		Thread.sleep(2000);
		d.findElement(By.linkText("LOGIN")).click();
		Thread.sleep(2000);
		WebElement email = d.findElement(By.id("email"));
		email.sendKeys("admin");
		Thread.sleep(3000);
		WebElement pw = d.findElement(By.id("password"));
		pw.sendKeys("admin");
		Thread.sleep(3000);
		d.findElement(By.id("keepLoggedInCheckBox")).click();
		Thread.sleep(3000);
		d.findElement(By.id("last")).click();
	}

}
