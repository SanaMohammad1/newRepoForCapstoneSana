package test.tek.sdet.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class TestOperaBrowser implements TestBrowser{

	@Override
	public WebDriver openBrowser(String url) {
		WebDriverManager.operadriver().setup();
		@SuppressWarnings("deprecation")
		WebDriver driver = new OperaDriver();
		driver.get(url);
		return driver;
	}
	
}
