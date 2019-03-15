package com.kshyk.tests.the_internet_herokuapp_com;

import static org.assertj.core.api.BDDAssertions.then;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.kshyk.po.theinternet.FileUploadPage;
import com.kshyk.po.theinternet.HomePage;
import com.kshyk.tests.base.BaseTest;

class UploadPageTests extends BaseTest {
	
	private final ClassLoader classLoader = UploadPageTests.class.getClassLoader();
	private FileUploadPage fileUploadPage;
	
	@Test
	public final void isUploadPageLoaded() {
		this.getPage()
				.getInstance(HomePage.class)
				.goToHerokuapp()
				.goToFileUpload();
		this.fileUploadPage = this.getPage().getInstance(FileUploadPage.class);
		then(this.fileUploadPage.isOpen())
				.as(this.fileUploadPage.getClass().getSimpleName() + " is not loaded.")
				.isTrue();
	}
	
	@Test(dependsOnMethods = "isUploadPageLoaded")
	public final void isFileProperlyUploaded() throws URISyntaxException {
		final var resource = this.classLoader.getResource("upload/not_empty.txt");
		final var fileURI = Objects.requireNonNull(resource).toURI();
		final var emptyFile = new File(fileURI);
		this.fileUploadPage.uploadFile(emptyFile);
		this.getWait().until(textToBePresentInElementLocated(By.tagName("h3"), "File Uploaded!"));
		final var expected = emptyFile.getName();
		final var actual = this.fileUploadPage.getUploadedFileName();
		then(actual).isEqualTo(expected);
	}
	
}