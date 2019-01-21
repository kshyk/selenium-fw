package com.kshyk.tests.teamandpersonal_pl;

import static org.assertj.core.api.BDDAssertions.then;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.kshyk.po.teamandpersonal.HomePage;
import com.kshyk.po.teamandpersonal.MainToolbar;
import com.kshyk.tests.base.BaseTest;

public class NavigationBarTests extends BaseTest {
	
	private MainToolbar toolbar;
	
	@BeforeGroups(groups = "check navigation")
	private void open() {
		this.getPage().getInstance(HomePage.class).open();
		this.toolbar = this.getPage().getInstance(MainToolbar.class);
	}
	
	@Test(groups = "check navigation")
	public void checkTelephone() {
		final String actual = this.toolbar.getTelephoneText();
		then(actual).isEqualTo("+48 660 22 77 22");
	}
	
	@Test(groups = "check navigation")
	public void checkMailRefAttribute() {
		final String actual = this.toolbar.getMailLinkElement().getAttribute("href");
		then(actual).isEqualTo("mailto:biuro@teamandpersonal.pl");
	}
	
	@Test(groups = "check navigation")
	public void checkMail() {
		final String actual = this.toolbar.getMailLinkText();
		then(actual).isEqualTo("biuro [at] teamandpersonal.pl");
	}
}
