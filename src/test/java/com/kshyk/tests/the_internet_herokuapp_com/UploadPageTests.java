package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;

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

class UploadPageTests extends BaseTest {
	
	private final ClassLoader classLoader = UploadPageTests.class.getClassLoader();
	private FileUploadPage fileUploadPage;
	
	@Test
	public final void isUploadPageLoaded() {
		final HomePage homePage = this.getPage().getInstance(HomePage.class);
		homePage
				.goToHerokuapp()
				.goToFileUpload();
		this.fileUploadPage = this.getPage().getInstance(FileUploadPage.class);
		then(this.fileUploadPage.isOpen())
				.as(this.fileUploadPage.getClass().getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnMethods = "isUploadPageLoaded")
	public final void isFileProperlyUploaded() throws URISyntaxException {
		final URL resource = this.classLoader.getResource("upload/not_empty.txt");
		final URI fileURI = Objects.requireNonNull(resource).toURI();
		final File emptyFile = new File(fileURI);
		this.fileUploadPage.uploadFile(emptyFile);
		this.getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "File Uploaded!"));
		final String expected = emptyFile.getName();
		final String actual = this.fileUploadPage.getUploadedFileName();
		then(actual).isEqualTo(expected);
	}
	
}