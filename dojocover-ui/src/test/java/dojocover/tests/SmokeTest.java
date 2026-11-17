package dojocover.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import dojocover.base.Base;

public class SmokeTest extends Base {
	@Test
	public void coverPageOpens() {
		
		AssertJUnit.assertTrue(getDriver().getCurrentUrl().contains("testdojo.dev"));
	}

}
