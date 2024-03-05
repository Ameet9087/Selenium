package BasicTestNG;

import org.testng.annotations.Test;

public class BeforeAfter_suite {

	@Test
	public void beforeSuit() {
		System.out.println("After suite");
	}
}
