package com.kshyk.tests.the_internet_herokuapp_com;

import static org.testng.Assert.assertTrue;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.MultipleWindowsPage;
import com.kshyk.tests.base.BaseTest;

public class MultipleWindowsPageTests extends BaseTest {
	
	private MultipleWindowsPage multipleWindowsPO;
	
	@Test
	public void isMultipleWindowsPageLoaded() {
		this.getPage().getInstance(HomePage.class).goToHerokuapp();
		this.getPage().getInstance(HomePage.class).goToMultipleWindows();
		this.multipleWindowsPO = this.getPage().getInstance(MultipleWindowsPage.class);
		assertTrue(this.multipleWindowsPO.isOpen(), MultipleWindowsPage.class.getSimpleName() + " is not loaded.");
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
		final Stream<String> stream = this.getPage().getDriver().getWindowHandles().stream();
		final Optional<String> rootTab = stream.findFirst();
		this.getPage().getDriver().close();
		rootTab.ifPresent(tab -> this.getPage().getDriver().switchTo().window(tab));
		assertTrue(this.multipleWindowsPO.isOpen(), MultipleWindowsPage.class.getSimpleName() + " is not loaded.");
	}
	
}