package com.kshyk.tests.the_internet_herokuapp_com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.FileUploadPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

public class UploadPageTests extends BaseTest {
	
	@Test
	public final void isUploadPageLoaded() {
		this.getPage().getInstance(HomePage.class).goToHerokuapp();
		this.getPage().getInstance(HomePage.class).goToFileUpload();
		assertTrue(this.getPage().getInstance(FileUploadPage.class).isOpen(),
				FileUploadPage.class.getSimpleName() + " is not loaded.");
	}
	
	@Test(dependsOnMethods = "isUploadPageLoaded")
	public final void isFileProperlyUploaded() throws URISyntaxException {
		final ClassLoader classLoader = UploadPageTests.class.getClassLoader();
		final URL resource = classLoader.getResource("upload/not_empty.txt");
		final URI fileURI = Objects.requireNonNull(resource).toURI();
		final File emptyFile = new File(fileURI);
		this.getPage().getInstance(FileUploadPage.class).uploadFile(emptyFile);
		this.getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "File Uploaded!"));
		final String expected = emptyFile.getName();
		final String actual = this.getPage().getInstance(FileUploadPage.class).getUploadedFileName();
		assertEquals(actual, expected);
	}
	
}