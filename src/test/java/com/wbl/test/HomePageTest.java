package com.wbl.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.base.CommonPage;
import com.wbl.page.HomePage;

public class HomePageTest extends BaseTest {

	HomePage hm;
	CommonPage cm;

	@Test(enabled = true)
	public void headerNavBarTest() {
		cm = PageFactory.initElements(driver, CommonPage.class);
		WebElement e = cm.headerNavBar();
		Assert.assertEquals(e, e);
	}

	@Test(enabled = true)
	public void footerNavBarTest() {
		cm = PageFactory.initElements(driver, CommonPage.class);
		String e = cm.footerNavBar();
		Assert.assertEquals(e, "Back to top");

	}

	@Test(enabled = true)
	public void slideCountTest() {
		hm = PageFactory.initElements(driver, HomePage.class);
		int actual = hm.slideCount();
		Assert.assertEquals(actual, 6);
	}

//	@Test(enabled = true)
//	public void sortByTest() {
//		hm = PageFactory.initElements(driver, HomePage.class);
//		String actual = hm.sortBy();
//		Assert.assertEquals(actual,
//				"https://www.amazon.com/s?k=laptops&s=price-desc-rank&qid=1575572504&ref=sr_st_price-desc-rank");
//	}
}
