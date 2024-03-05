package BasicTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfter {

	@Test
	public void faceBook() {
		System.out.println("test 1");
	}
	
	@BeforeMethod
	public void ajio() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public void amazon() {
		System.out.println("after method");
	}
	
	@Test
	public void mintra() {
		System.out.println("test 2");
	}
	
	@BeforeClass
	public void BeforeClas() {
		System.out.println("before class");
	}
	
	@AfterClass
	public void AfterClas() {
		System.out.println("after class");
	}
	
	@BeforeTest
	public void Beforetests() {
		System.out.println("before test");
	}
	
	@AfterTest
	public void Aftertests() {
		System.out.println("After test");
	}
	
	@BeforeSuite
	public void BeforeSuit() {
		System.out.println("before suite");
	}
	
	@AfterSuite
	public void afterSuit() {
		System.out.println("after suite");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
