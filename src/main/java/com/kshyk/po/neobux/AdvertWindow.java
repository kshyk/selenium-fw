package com.kshyk.po.neobux;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;
import com.kshyk.core.BasePage;

public class AdvertWindow {
	
	private static final int LONG_TIMEOUT = 90;
	private final WebDriverWait wait;
	private final WebDriver driver;
	private final BasePage basePage;
	@FindBy(css = "[onclick='wClose()']")
	private WebElement close;
	@FindBy(id = "nxt_bt_a")
	private WebElement next;
	
	public AdvertWindow(final WebDriver driver) {
		this.basePage = new BasePage(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, LONG_TIMEOUT);
		PageFactory.initElements(driver, this);
	}
	
	public final void close() {
		this.wait.until(ExpectedConditions.visibilityOf(this.close)).click();
		final var windowHandles = this.driver.getWindowHandles();
		this.driver.switchTo().window(Iterables.getFirst(windowHandles, null));
	}
	
	public final void next() {
		this.wait.until(ExpectedConditions.visibilityOf(this.next)).click();
		this.basePage.sleep(3500);
	}
	
	public final void sleep(final int millis) {
		this.basePage.sleep(millis);
	}
}
