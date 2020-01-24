package com.wbl.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebDriverUtil {

	static Logger log = LogManager.getLogger(WebDriverUtil.class);

	// Factory design Pattern
	public static WebDriver getDriver(String browserName) {
		WebDriver driver = null;
		try {
			switch (browserName) {
			case "chrome":
				log.info("here all time");
				Thread.sleep(5000);
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\cvheg\\eclipse-workspace\\Amazon_Automation\\resource\\Browsers\\chromedriver.exe");
				driver = new ChromeDriver();
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\cvheg\\eclipse-workspace\\Amazon_Automation\\resource\\Browsers\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;

			case "HtmlUnitDriver":
				driver = new HtmlUnitDriver();
				break;

			default:
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\cvheg\\eclipse-workspace\\Amazon_Automation\\resource\\Browsers\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			log.error("there is exception while creating the Webdriver object" + e.getMessage());
		}
		return driver;
	}
}
