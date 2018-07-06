package com.kshyk.po.neobux;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kshyk.core.BasePage;

public class AdvertWindow extends BasePage {

	private static final int LONG_TIMEOUT = 90;
	private final WebDriverWait wait;
	@FindBy(css = "[onclick='wClose()']")
	private WebElement close;
	@FindBy(id = "nxt_bt_a")
	private WebElement next;

	public AdvertWindow(final WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, LONG_TIMEOUT);
	}

	public final void close() {
		this.wait.until(ExpectedConditions.visibilityOf(this.close)).click();
		final String firstTab = this.getDriver().getWindowHandles().stream().findFirst().orElse(null);
		this.getDriver().switchTo().window(firstTab);
	}

	public final void next() {
		this.wait.until(ExpectedConditions.visibilityOf(this.next)).click();
	}

}