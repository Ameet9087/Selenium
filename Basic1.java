package BasicDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		//d.get("https://demoapp.skillrary.com/");
		
		
		//step-1.create object of fileInputStream class in fileinputstream constructor
		FileInputStream file=new FileInputStream("src\\test\\resources\\data.properties");
		
		//step-2.create the object of properties class
		Properties p=new Properties();
		
		//step-3.load input stream instream to fetch the location of external file
		p.load(file);
		
		//step-4.call getproperty() to fetch the keys
		String email = p.getProperty("email");
		String pass = p.getProperty("password");
		String u=p.getProperty("url");
		
		d.get(u);
		Thread.sleep(2000);
		d.findElement(By.linkText("LOGIN")).click();
		Thread.sleep(2000);
	    d.findElement(By.id("email")).sendKeys("email");
		Thread.sleep(3000);
	    d.findElement(By.id("password")).sendKeys("pass");
	}

}
