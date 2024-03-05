package BasicDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fb_Assi {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		
		FileInputStream file=new FileInputStream("src\\test\\resources\\fb.properties");
		
		Properties p=new Properties();
		p.load(file);
		
		String mail=p.getProperty("email");
		String pw=p.getProperty("pass");
		String url=p.getProperty("url");
		
		d.get(url);
		Thread.sleep(2000);
		d.findElement(By.id("email")).sendKeys("asiinghmeet");
		Thread.sleep(2000);
		d.findElement(By.id("pass")).sendKeys("0");
		Thread.sleep(2000);
		

	}

}
