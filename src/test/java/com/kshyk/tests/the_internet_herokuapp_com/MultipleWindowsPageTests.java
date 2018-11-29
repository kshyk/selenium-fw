package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.MultipleWindowsPage;
import com.kshyk.tests.base.BaseTest;

class MultipleWindowsPageTests extends BaseTest {
	
	private final String multipleWindowsName = MultipleWindowsPage.class.getSimpleName();
	private MultipleWindowsPage multipleWindowsPO;
	
	@Test
	public void isMultipleWindowsPageLoaded() {
		final HomePage homePage = this.getPage().getInstance(HomePage.class);
		homePage.goToHerokuapp().goToMultipleWindows();
		this.multipleWindowsPO = this.getPage().getInstance(MultipleWindowsPage.class);
		then(this.multipleWindowsPO.isOpen())
				.as(this.multipleWindowsName + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnMethods = "isMultipleWindowsPageLoaded")
	public void isNewWindowOpened() {
		this.multipleWindowsPO.openNewWindow();
		this.getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
		this.multipleWindowsPO.switchToLastTab();
		final Pattern resultText = Pattern.compile("New Window");
		this.getWait().until(ExpectedConditions.textMatches(By.tagName("body"), resultText));
	}
	
	@Test(dependsOnMethods = "isNewWindowOpened")
	public void isDefaultContentPresentAfterNewWindowClose() {
		final WebDriver driver = this.getPage().getDriver();
		driver.close();
		driver.switchTo().window(Iterables.getFirst(driver.getWindowHandles(), ""));
		then(this.multipleWindowsPO.isOpen())
				.as(this.multipleWindowsName + " is not loaded.")
				.isTrue();
	}
}