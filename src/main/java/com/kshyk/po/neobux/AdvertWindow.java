package com.kshyk.po.neobux;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterables;
import com.kshyk.po.AbstractPage;

public class AdvertWindow extends AbstractPage {
	
	private static final int LONG_TIMEOUT = 90;
	private final WebDriverWait wait;
	@FindBy(css = "[onclick='wClose()']")
	private WebElement close;
	@FindBy(id = "nxt_bt_a")
	private WebElement next;
	
	public AdvertWindow(final WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, LONG_TIMEOUT);
	}
	
	public final void close() {
		this.wait.until(visibilityOf(this.close)).click();
		final var windowHandles = this.driver.getWindowHandles();
		this.driver.switchTo().window(Iterables.getFirst(windowHandles, null));
	}
	
	public final void next() {
		this.wait.until(visibilityOf(this.next)).click();
		this.basePage.sleep(3500);
	}
	
}
