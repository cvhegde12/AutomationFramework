package com.wbl.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

	Logger log = LogManager.getLogger(CommonPage.class);
	protected WebDriver driver;

	@FindBy(id = "nav-xshop-container")
	WebElement navBarHeader;

	@FindBy(linkText = "Back to top")
	WebElement navBarFooter;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement headerNavBar() {
		WebElement element = navBarHeader;
		log.info(element.getText());
		return element;
	}

	public String footerNavBar() {
		WebElement element = navBarFooter;
		return element.getText();
	}
}
