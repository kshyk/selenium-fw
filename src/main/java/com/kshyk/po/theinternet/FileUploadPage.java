package com.kshyk.po.theinternet;

import com.kshyk.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class FileUploadPage extends BasePage {

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

    public boolean isOpen() {
        return this.title.isDisplayed();
    }

    public String getUploadedFileName() {
        return this.uploadedFiles.getText();
    }

    public void uploadFile(final File file) {
        this.browseFileButton.sendKeys(file.getAbsolutePath());
        click(uploadButton);
    }
}
