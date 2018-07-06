package com.kshyk.tests.the_internet_herokuapp_com;

import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.HomePage;
import com.kshyk.po.theinternet.TinyMCEPage;
import com.kshyk.tests.base.BaseTest;

public class TinyMCEPageTests extends BaseTest {
	
	@Test
	public final void isTinyMCEPageLoaded() {
		this.getPage().getInstance(HomePage.class).goToHerokuapp();
		this.getPage().getInstance(HomePage.class).goToTinyMCE();
		assertTrue(this.getPage().getInstance(TinyMCEPage.class).isOpen(),
				TinyMCEPage.class.getSimpleName() + " is not loaded.");
	}
	
	@Test(dependsOnMethods = "isTinyMCEPageLoaded")
	public final void clearAndSetNewContent() {
		this.setContent("");
		this.setContent(LocalDateTime.now().toString());
	}
	
	private void setContent(final String content) {
		final JavascriptExecutor jse = (JavascriptExecutor) this.getDriver();
		jse.executeScript("tinymce.activeEditor.setContent(arguments[0]);", content);
	}
}