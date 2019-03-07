package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import static org.assertj.core.api.BDDAssertions.then;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;
import com.kshyk.po.teamandpersonal.CookiesBar;
import com.kshyk.po.teamandpersonal.HomePage;
import com.kshyk.po.teamandpersonal.PrivacyPolicyPage;
import com.kshyk.tests.base.BaseTest;

public class CookiesTests extends BaseTest {
	
	private CookiesBar cookiesBar;
	private WebDriver driver;
	
	@BeforeClass
	private void openHomePage() {
		this.driver = this.getDriver();
		this.getPage().getInstance(HomePage.class).open();
	}
	
	@Test
	public final void checkCookieBarVisibilityOnStart() {
		final var actual = this.whenCookiesBar()
				.isOpen();
		
		then(actual).isTrue();
	}
	
	@Test(dependsOnMethods = "checkCookieBarVisibilityOnStart")
	public final void checkCookieBarInfo() {
		final var actual = this.whenCookiesBar()
				.getCookieInfoText();
		
		final var expectedValue = "Serwis wykorzystuje pliki cookies. " +
				"Korzystając ze strony wyrażasz zgodę na wykorzystywanie plików cookies. dowiedz się więcej.";
		then(actual).isEqualTo(expectedValue);
	}
	
	@Test(groups = "GDPR policy", dependsOnMethods = "checkCookieBarVisibilityOnStart")
	public final void checkGDPRLinkJumping() {
		final var privacyPolicyPage = this.getPage()
				.getInstance(PrivacyPolicyPage.class)
				.waitForPrivacyPolicyPage();
		
		final var actual = this.driver.getCurrentUrl();
		final var expected = privacyPolicyPage.getURL();
		then(actual).isEqualTo(expected);
	}
	
	@BeforeGroups(groups = "GDPR policy")
	private void whenPrivacyPolicyPage() {
		this.whenCookiesBar()
				.clickOnPrivacyPolicyLink();
		
		final var lastTab = Iterables.getLast(this.driver.getWindowHandles());
		this.driver.switchTo().window(lastTab);
	}
	
	@AfterGroups(groups = "GDPR policy")
	private void closePrivacyPolicyPage() {
		final var windowHandles = this.driver.getWindowHandles();
		if (windowHandles.size() > 1) {
			final var firstTab = Iterables.getFirst(windowHandles, null);
			this.driver.close();
			this.driver.switchTo().window(firstTab);
		}
	}
	
	@Test(dependsOnMethods = "checkCookieBarInfo")
	public final void checkCookieBarInvisibilityAfterButtonClick() {
		this.whenCookiesBar()
				.clickOnIUnderstandButton();
		final var actual = this.whenCookiesBar()
				.isOpen();
		
		then(actual).isFalse();
	}
	
	private CookiesBar whenCookiesBar() {
		if (this.cookiesBar == null) {
			this.cookiesBar = this.getPage().getInstance(CookiesBar.class);
		}
		return this.cookiesBar;
	}
	
}
