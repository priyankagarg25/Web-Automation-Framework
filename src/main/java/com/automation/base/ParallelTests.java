package com.automation.base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class ParallelTests {
	String userDir = System.getProperty("user.dir");

	/*
	 * @Test public void getFirefox() { //
	 * System.setProperty("webdriver.gecko.driver", "geckodriver.exe path");
	 * System.setProperty("webdriver.gecko.driver", userDir +
	 * "\\src\\com\\cp\\driver\\geckodriver.exe");
	 * System.out.println("GetFirefox Method is running on Thread : " +
	 * Thread.currentThread().getId());
	 * 
	 * WebDriver driver = new FirefoxDriver();
	 * driver.get("http://www.SoftwareTestingMaterial.com"); driver.close(); }
	 */

  @Test
	public void getIE() throws InterruptedException {
		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe path");
		System.setProperty("webdriver.ie.driver", userDir + "\\src\\com\\cp\\drivers\\IEDriverServer.exe");
		System.out.println("GetIE Method is running on Thread : " + Thread.currentThread().getId());
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		Facebook.loginFB(driver);
}

	@Test
	public void getChorme() throws InterruptedException {

		Map<String, Integer> prefs = new HashMap<String, Integer>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		System.setProperty("webdriver.chrome.driver", userDir + "\\src\\com\\cp\\drivers\\chromedriver.exe");
		System.out.println("GetChrome Method is running on Thread : " + Thread.currentThread().getId());

		// Create chrome options to set this prefs
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		Facebook.loginFB(driver);
	}

}
