package com.kshyk.po.teamandpersonal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class MainToolbar extends AbstractPage {
	
	@FindBy(className = "topka-tel")
	private WebElement telephoneLabel;
	@FindBy(css = ".topka-mail a")
	private WebElement mailLink;
	@FindBy(className = "topka-jezyki")
	private WebElement languages;
	@FindBy(className = "topka-facebook")
	private WebElement facebookButton;
	@FindBy(className = "topka-google")
	private WebElement googlePlusButton;
	@FindBy(className = "topka-youtube")
	private WebElement youtubeButton;
	@FindBy(className = "topka-linkedin")
	private WebElement linkedinButton;
	@FindBy(className = "topka-instagram")
	private WebElement instagramButton;
	@FindBy(className = "topka-pinterest")
	private WebElement pinterestButton;
	@FindBy(className = "topka-twitter")
	private WebElement twitterButton;
	
	public MainToolbar(final WebDriver driver) {
		super(driver);
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
	
	public void clickOnFacebookButton() {
		this.basePage.click(this.facebookButton);
	}
	
	public void clickOnGooglePlusButton() {
		this.basePage.click(this.googlePlusButton);
	}
	
	public void clickOnYoutubeButton() {
		this.basePage.click(this.youtubeButton);
	}
	
	public void clickOnLinkedInButton() {
		this.basePage.click(this.linkedinButton);
	}
	
	public void clickOnInstagramButton() {
		this.basePage.click(this.instagramButton);
	}
	
	public void clickOnPinterestButton() {
		this.basePage.click(this.pinterestButton);
	}
	
	public void clickOnTwitterButton() {
		this.basePage.click(this.twitterButton);
	}
	
}
