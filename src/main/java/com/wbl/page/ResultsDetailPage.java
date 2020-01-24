package com.wbl.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.CommonPage;

public class ResultsDetailPage extends CommonPage {

	public ResultsDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Add to Cart")
	WebElement addToCart;

	@FindBy(css = "#nav-cart")
	WebElement cartIcon;
	@FindBy(id = "nav-cart-count")
	WebElement count;

	public String addToCart() {
		addToCart.click();
		String actual = driver.getTitle();
		return actual;
	}

	public String cartCount() {
		cartIcon.click();
		String s = cartIcon.getAttribute("aria-label");
		return s;
		// count.getAttribute(attributeValue);
	}
}
