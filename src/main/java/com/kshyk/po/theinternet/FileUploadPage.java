package com.kshyk.po.theinternet;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.kshyk.po.AbstractPage;

public class FileUploadPage extends AbstractPage {
	
	@FindBy(xpath = "//*[text()='File Uploader']")
	private WebElement title;
	@FindBy(id = "file-upload")
	private WebElement browseFileButton;
	@FindBy(id = "file-submit")
	private WebElement uploadButton;
	@FindBy(id = "uploaded-files")
	private WebElement uploadedFiles;
	
	public FileUploadPage(final WebDriver driver) {
		super(driver);
	}
	
	public final boolean isOpen() {
		return this.title.isDisplayed();
	}
	
	public final String getUploadedFileName() {
		return this.uploadedFiles.getText();
	}
	
	public final void uploadFile(final File file) {
		this.browseFileButton.sendKeys(file.getAbsolutePath());
		this.basePage.click(this.uploadButton);
	}
}
