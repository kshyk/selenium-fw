package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import static org.assertj.core.api.BDDAssertions.then;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kshyk.po.teamandpersonal.HomePage;
import com.kshyk.po.teamandpersonal.MainToolbar;
import com.kshyk.tests.base.BaseTest;

public class SocialMediaTests extends BaseTest {
	
	private MainToolbar toolbar;
	
	@BeforeClass
	private void openHomePage() {
		this.getPage().getInstance(HomePage.class).open();
	}
	
	@AfterMethod
	private void goBack() {
		this.getDriver().navigate().back();
		this.getPage().getInstance(HomePage.class)
				.waitForHomePage();
	}
	
	@Test
	public void checkFacebook() {
		this.whenToolbar()
				.clickOnFacebookButton();
		
		final var expectedUrl = "https://www.facebook.com/TeamAndPersonal/?ref=bookmarks";
		this.thenSocialMediaPage(expectedUrl);
	}
	
	@Test
	public void checkGooglePlus() {
		this.whenToolbar()
				.clickOnGooglePlusButton();
		
		final var expectedUrl = "https://plus.google.com/+TeamandpersonalPl";
		this.thenSocialMediaPage(expectedUrl);
	}
	
	@Test
	public void checkYouTube() {
		this.whenToolbar()
				.clickOnYoutubeButton();
		
		final var expectedUrl = "https://www.youtube.com/channel/UCealDsXd2QtuW_on0wjSqtw";
		this.thenSocialMediaPage(expectedUrl);
	}
	
	@Test
	public void checkLinkedIn() {
		this.whenToolbar()
				.clickOnLinkedInButton();
		
		final var expectedUrl = "https://www.linkedin.com/company/teamandpersonal/";
		this.thenSocialMediaPage(expectedUrl);
	}
	
	@Test
	public void checkInstagram() {
		this.whenToolbar()
				.clickOnInstagramButton();
		
		final var expectedUrl = "https://www.instagram.com/teamandpersonal/";
		this.thenSocialMediaPage(expectedUrl);
	}
	
	@Test
	public void checkPinterest() {
		this.whenToolbar()
				.clickOnPinterestButton();
		
		final var expectedUrl = "https://www.pinterest.com/teampersonal/?sender=602708500040250336&invite_code=6877095e58a1439aa50df3831a86b83f";
		this.thenSocialMediaPage(expectedUrl);
	}
	
	@Test
	public void checkTwitter() {
		this.whenToolbar()
				.clickOnTwitterButton();
		
		final var expectedUrl = "https://twitter.com/TeamAndPersonal";
		this.thenSocialMediaPage(expectedUrl);
	}
	
	private MainToolbar whenToolbar() {
		if (this.toolbar == null) {
			this.toolbar = this.getPage().getInstance(MainToolbar.class);
		}
		return this.toolbar;
	}
	
	private void thenSocialMediaPage(final String expectedUrl) {
		final var actualUrl = this.getDriver().getCurrentUrl();
		then(actualUrl).contains(expectedUrl);
	}
	
}
