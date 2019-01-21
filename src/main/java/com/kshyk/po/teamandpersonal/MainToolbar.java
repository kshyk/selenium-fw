package com.kshyk.po.teamandpersonal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.core.BasePage;

public class MainToolbar {
	
	private final BasePage basePage;
	@FindBy(className = "home-link")
	private WebElement logo;
	@FindBy(className = "topka-tel")
	private WebElement telephoneLabel;
	@FindBy(css = ".topka-mail a")
	private WebElement mailLink;
	@FindBy(className = "topka-facebook")
	private WebElement facebookButton;
	@FindBy(className = "topka-google")
	private WebElement googlePlusButton;
	@FindBy(className = "topka-youtube")
	private WebElement youtubeButton;
	@FindBy(className = "topka-tnp")
	private WebElement pollingButton;
	@FindBy(linkText = "TEAM&PERSONAL")
	private WebElement teamAndPersonalLink;
	@FindBy(linkText = "O FIRMIE")
	private WebElement aboutLink;
	@FindBy(linkText = "WYJAZDY INTEGRACYJNE")
	private WebElement integrationTripsLink;
	@FindBy(linkText = "TEAM BUILDING")
	private WebElement teamBuildingLink;
	@FindBy(linkText = "SZKOLENIA")
	private WebElement coursesLink;
	@FindBy(linkText = "EVENTY")
	private WebElement eventsLink;
	@FindBy(linkText = "KONTAKT")
	private WebElement contactLink;
	
	public MainToolbar(final WebDriver driver) {
		this.basePage = new BasePage(driver);
	}
	
	public void clickOnLogo() {
		this.basePage.click(this.logo);
	}
	
	public String getTelephoneText() {
		return this.basePage.readText(this.telephoneLabel);
	}
	
	public WebElement getMailLinkElement() {
		return this.mailLink;
	}
	
	public String getMailLinkText() {
		return this.basePage.readText(this.mailLink);
	}
	
	public void clickOnMailLink() {
		this.basePage.click(this.mailLink);
	}
	
	public void clickOnFacebookButton() {
		this.basePage.click(this.facebookButton);
	}
	
	public void clickOnGooglePlusButton() {
		this.basePage.click(this.googlePlusButton);
	}
	
	public void clickOnYoutubeButton() {
		this.basePage.click(this.youtubeButton);
	}
	
	public void clickOnPollingButton() {
		this.basePage.click(this.pollingButton);
	}
	
	public void clickOnTeamAndPersonalLink() {
		this.basePage.click(this.teamAndPersonalLink);
	}
	
	public void clickOnAboutLink() {
		this.basePage.click(this.aboutLink);
	}
	
	public void clickOnIntegrationTripsLink() {
		this.basePage.click(this.integrationTripsLink);
	}
	
	public void clickOnTeamBuildingLink() {
		this.basePage.click(this.teamBuildingLink);
	}
	
	public void clickOnCoursesLink() {
		this.basePage.click(this.coursesLink);
	}
	
	public void clickOnEventsLink() {
		this.basePage.click(this.eventsLink);
	}
	
	public void clickOnContactLink() {
		this.basePage.click(this.contactLink);
	}
}
