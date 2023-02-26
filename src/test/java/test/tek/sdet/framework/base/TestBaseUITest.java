package test.tek.sdet.framework.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import test.tek.sdet.framework.utilities.TestCommonUtility;

public class TestBaseUITest extends TestCommonUtility {

	@Before
	public void setupTests() {
		super.setupBrowser();
	}

	@After
	public void closeTests(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = takeScreenShotAsBytes();
			scenario.attach(screenshot, "image/png", scenario.getName() + " scenario Failed");
		}

		super.quitBrowser();
	}
}
