package com.wbl.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.wbl.base.CommonPage;

public class HomePage extends CommonPage {

	Logger log = LogManager.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
		// PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id='twotabsearchtextbox']")
	@CacheLookup
	WebElement mainSearchField;

	@FindBy(css = ".a-carousel-card")
	List<WebElement> slides;

	@FindBy(css = "#s-result-sort-select")
	WebElement sortDropDown;

	public SearchPage enterValueInSearchField() {
		mainSearchField.sendKeys("laptops");
		mainSearchField.sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return  document.readyState").equals("complete");
		return new SearchPage(driver);
	}

	public int slideCount() {
		log.info("The size of the slides: " + slides.size());
		for (WebElement e : slides) {
			log.info(e.getLocation());
		}
		return slides.size();
	}

//	public String sortBy() {
//		mainSearchField.sendKeys("laptops");
//		mainSearchField.sendKeys(Keys.ENTER);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("return  document.readyState").equals("complete");
//		sortDropDown.click();
//		Select s = new Select(sortDropDown);
//		s.selectByValue("price-desc-rank");
//		// s.selectByIndex(3);
//		// s.selectByVisibleText("Price: High to Low");
//		return driver.getCurrentUrl();
//	}
}
