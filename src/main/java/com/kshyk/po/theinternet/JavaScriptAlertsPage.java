package com.kshyk.po.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class JavaScriptAlertsPage extends AbstractPage {
	
	@FindBy(xpath = "//*[text()='JavaScript Alerts']")
	private WebElement title;
	@FindBy(css = "[onclick='jsAlert()']")
	private WebElement alertButton;
	@FindBy(css = "[onclick='jsConfirm()']")
	private WebElement confirmButton;
	@FindBy(css = "[onclick='jsPrompt()']")
	private WebElement promptButton;
	@FindBy(id = "result")
	private WebElement result;
	
	public JavaScriptAlertsPage(final WebDriver driver) {
		super(driver);
	}
	
	public final void alert() {
		this.alertButton.click();
	}
	
	public final void confirm() {
		this.confirmButton.click();
	}
	
	public final void prompt() {
		this.promptButton.click();
	}
	
	public final String getResult() {
		return this.result.getText();
	}
	
	public final boolean isOpen() {
		return this.title.isDisplayed();
	}
}
