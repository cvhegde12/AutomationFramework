package com.wbl.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.wbl.util.ConfigUtils;
import com.wbl.util.Constants;
import com.wbl.util.ScreenshotUtil;
import com.wbl.util.WebDriverUtil;

public class BaseTest {

	protected static WebDriver driver;
	protected static String url;
	protected static String browser;

	@BeforeSuite
	public void beforeSuite() {
		ConfigUtils configUtils = new ConfigUtils(Constants.resourcePath + "\\Properties\\config.properties");
		url = configUtils.getProperty("QAurl");
		browser = configUtils.getProperty("browser");
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver = WebDriverUtil.getDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@AfterMethod(enabled = true)
	public void afterMethod(ITestResult rs) {
		if (ITestResult.FAILURE == rs.getStatus()) {
			ScreenshotUtil.takeScreenshot(rs.getName(), driver);
		}
		driver.quit();
	}
}
