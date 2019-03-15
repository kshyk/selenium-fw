package com.kshyk.tests.the_internet_herokuapp_com;

import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Iterables.getLast;
import static org.assertj.core.api.BDDAssertions.then;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textMatches;

import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.MultipleWindowsPage;
import com.kshyk.tests.base.BaseTest;

class MultipleWindowsPageTests extends BaseTest {
	
	private final String multipleWindowsName = MultipleWindowsPage.class.getSimpleName();
	private MultipleWindowsPage multipleWindowsPO;
	
	@Test
	public void isMultipleWindowsPageLoaded() {
		this.getPage()
				.getInstance(HomePage.class)
				.goToHerokuapp()
				.goToMultipleWindows();
		this.multipleWindowsPO = this.getPage().getInstance(MultipleWindowsPage.class);
		then(this.multipleWindowsPO.isOpen())
				.as(this.multipleWindowsName + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnMethods = "isMultipleWindowsPageLoaded")
	public void isNewWindowOpened() {
		this.multipleWindowsPO
				.openNewWindow();
		this.switchToLastTab();
		final var resultText = Pattern.compile("New Window");
		this.getWait().until(textMatches(tagName("body"), resultText));
	}
	
	@Test(dependsOnMethods = "isNewWindowOpened")
	public void isDefaultContentPresentAfterNewWindowClose() {
		this.switchToFirstTab();
		then(this.multipleWindowsPO.isOpen())
				.as(this.multipleWindowsName + " is not loaded.")
				.isTrue();
	}
	
	private void switchToFirstTab() {
		final var driver = this.getDriver();
		driver.close();
		final var firstTab = getFirst(driver.getWindowHandles(), "");
		driver.switchTo().window(firstTab);
	}
	
	private void switchToLastTab() {
		this.getWait().until(numberOfWindowsToBe(2));
		final var driver = this.getDriver();
		final var windowHandles = driver.getWindowHandles();
		final var lastTab = getLast(windowHandles);
		driver.switchTo().window(lastTab);
	}
}