package com.kshyk.po.theinternet;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class HoversPage extends BasePage {

	@FindBy(xpath = "//*[text()='Hovers']")
	private WebElement title;

	@FindBy(css = ".figcaption h5")
	private List<WebElement> names;

	@FindBy(css = ".figure img")
	private List<WebElement> avatars;

	public HoversPage(final WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getAvatars() {
		return this.avatars;
	}

	public <T> void mouseOverAvatar(final T avatar) {
		this.mouseOver(avatar);
	}

	public String getVisibleName() {
		final Optional<WebElement> element = this.names.stream().filter(WebElement::isDisplayed).findFirst();
		return element.map(WebElement::getText).orElse(null);
	}

	public final boolean isOpen() {
		return this.title.isDisplayed();
	}
}