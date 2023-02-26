package test.tek.sdet.framework.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import test.tek.sdet.framework.config.TestBrowser;
import test.tek.sdet.framework.config.TestChromeBrowser;
import test.tek.sdet.framework.config.TestChromeHeadless;
import test.tek.sdet.framework.config.TestEdgeBrowser;
import test.tek.sdet.framework.config.TestFireFoxBrowser;
import test.tek.sdet.framework.utilities.TestReadYamlFiles;

public class TestBaseSetup {
	// this class is parent class of all Step Def, Utilities class and POM classes
	private static WebDriver webDriver;
	private final TestReadYamlFiles environmentVariables;
	public static Logger logger;

	public TestBaseSetup() {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
		String log4JPath = System.getProperty("user.dir") + "/src/main/resources/log4j.properties";
		try {
			environmentVariables = TestReadYamlFiles.getInstance(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("Failed for Load environment context. check possible file path errors");
			e.printStackTrace();
			throw new RuntimeException("Failed for Load environment context with message " + e.getMessage());

		}
		logger = logger.getLogger("logger_File");
		PropertyConfigurator.configure(log4JPath);
	}

	public WebDriver getDriver() {
		return webDriver;
	}

	public void setupBrowser() {
		HashMap uiProperties = environmentVariables.getYamlProperty("ui");
		String url = uiProperties.get("url").toString();
		TestBrowser browser;
		switch (uiProperties.get("browser").toString().toLowerCase()) {
		case "chrome":
			if ((boolean) uiProperties.get("headless")) {
				browser = new TestChromeHeadless();
			} else {
				browser = new TestChromeBrowser();
			}
			webDriver = browser.openBrowser(url);
			break;
		case "firefox":
			browser = new TestFireFoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge":
			browser = new TestEdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;
		default:
			throw new RuntimeException("Unknown Browser check environment properties");
		}

		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

	}

	public void quitBrowser() {
		if (webDriver != null)
			webDriver.quit();
	}
}