package com.kshyk.tests.teamandpersonal_pl.navigationbar;

import static org.assertj.core.api.BDDAssertions.then;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kshyk.po.teamandpersonal.HomePage;
import com.kshyk.po.teamandpersonal.MainToolbar;
import com.kshyk.tests.base.BaseTest;

public class ContactTests extends BaseTest {
	
	private MainToolbar toolbar;
	
	@BeforeClass
	private void openHomePage() {
		this.getPage().getInstance(HomePage.class).open();
	}
	
	@Test
	public final void checkTelephone() {
		final var actual = this.whenToolbar()
				.getTelephoneText();
		
		then(actual).isEqualTo("+48 660 22 77 22");
	}
	
	@Test
	public final void checkMailRefAttribute() {
		final var actual = this.whenToolbar()
				.getMailLinkElement()
				.getAttribute("href");
		
		then(actual).isEqualTo("mailto:biuro@teamandpersonal.pl");
	}
	
	@Test
	public final void checkMail() {
		final var actual = this.whenToolbar()
				.getMailLinkText();
		
		then(actual).isEqualTo("biuro [at] teamandpersonal.pl");
	}
	
	private MainToolbar whenToolbar() {
		if (this.toolbar == null) {
			this.toolbar = this.getPage().getInstance(MainToolbar.class);
		}
		return this.toolbar;
	}
	
}
