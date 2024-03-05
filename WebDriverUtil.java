package CommonUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebDriverUtil {

	
	
	public void maximize(WebDriver driver) {
		
		driver.manage().window().maximize();
	}

	public void implicitWait(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	} 
	
	public void handleDropdown(WebElement element,String targetElement){
		Select s=new Select(element);
		s.selectByVisibleText(targetElement);
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element);
		a.perform();

	}
	
	public void switchWindow(WebDriver driver,String expextedUrl) {
		Set<String> ids = driver.getWindowHandles();
		
		for (String string : ids) {
			String actualUrl = driver.switchTo().window(string).getCurrentUrl();
			System.out.println(actualUrl);
			
			if (actualUrl.contains(expextedUrl)) {
				break;
			}
		}	
	}
	
	public File screenshot(WebDriver driver,String ScreenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenshot/"+ScreenShotName+".png");
		FileUtils.copyFile(tempFile, destination);
		return destination;
	}
}
