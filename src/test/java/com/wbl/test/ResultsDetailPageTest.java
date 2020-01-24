package com.wbl.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;
import com.wbl.page.ResultsDetailPage;
import com.wbl.page.SearchPage;
import com.wbl.util.ScreenshotUtil;

public class ResultsDetailPageTest extends BaseTest {
	HomePage hm;
	SearchPage sp;
	ResultsDetailPage rp;

	@Test(enabled = true)
	public void clickOnTheResulTest() {
		System.out.println("*****************" + driver.getTitle());
		hm = PageFactory.initElements(driver, HomePage.class);
		sp = hm.enterValueInSearchField();
		rp = sp.clickOnTheResult();
		String actual = rp.addToCart();
		Assert.assertTrue(actual.equals("Amazon.com Shopping Cart"));
	}

	@Test(enabled = true)
	public void cartCount() {
		hm = PageFactory.initElements(driver, HomePage.class);
		sp = hm.enterValueInSearchField();
		rp = sp.clickOnTheResult();
		rp.addToCart();
		String actual = rp.cartCount();
		Assert.assertEquals(actual, "1 item in cart");
		ScreenshotUtil.takeScreenshot("addedToCart", driver);
	}
}
