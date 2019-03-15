package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

import java.time.LocalDateTime;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.TinyMCEPage;
import com.kshyk.tests.base.BaseTest;

class TinyMCEPageTests extends BaseTest {
	
	@Test
	public final void isTinyMCEPageLoaded() {
		this.getPage()
				.getInstance(HomePage.class)
				.goToHerokuapp()
				.goToTinyMCE();
		then(this.getPage()
				.getInstance(TinyMCEPage.class)
				.isOpen())
				.as(TinyMCEPage.class.getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnMethods = "isTinyMCEPageLoaded")
	public final void clearAndSetNewContent() {
		this.setContent("");
		this.setContent(LocalDateTime.now().toString());
	}
	
	private void setContent(final String content) {
		final var jse = (JavascriptExecutor) this.getDriver();
		jse.executeScript("tinymce.activeEditor.setContent(arguments[0]);", content);
	}
}