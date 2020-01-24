package com.wbl.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.page.HomePage;
import com.wbl.page.SearchPage;

public class SearchPageTest extends BaseTest {
	HomePage hm;

	@Test(enabled = true)
	public void enterValueInSearchFieldTest() {
		hm = PageFactory.initElements(driver, HomePage.class);
		SearchPage sp = hm.enterValueInSearchField();
		Assert.assertEquals(driver.getTitle(), "Amazon.com: laptops");
	}
}
