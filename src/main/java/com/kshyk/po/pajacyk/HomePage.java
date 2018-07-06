package com.kshyk.po.pajacyk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class HomePage extends BasePage {

	@FindBy(className = "paj-click")
	private WebElement greenBellyBefore;
	@FindBy(className = "paj-click2")
	private WebElement yellowBellyHover;

	public HomePage(final WebDriver driver) {
		super(driver);
	}

	public final void goToPajacyk() {
		this.getDriver().get("https://www.pajacyk.pl/#index");
	}

	public final void clickOnBelly() {
		this.mouseOver(this.greenBellyBefore);
		this.click(this.yellowBellyHover);
	}

}
