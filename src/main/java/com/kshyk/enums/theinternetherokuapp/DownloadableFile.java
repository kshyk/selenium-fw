package com.kshyk.enums.theinternetherokuapp;

import com.kshyk.common.CommonUtil;

public enum DownloadableFile {
    BILD("bild.png"),
    BOOK("book.pdf"),
    BOT_LOGO_ICON("bot-logo-icon.png"),
    CARS_0002("cars_0002.jpg"),
    CARS_0062("cars_0062.jpg"),
    DOWNLOAD("download.png"),
    FILE_UPLOAD("fileupload.ts"),
    HANDY_NUMMER("handynummer.png"),
    LOGO("logo.jpg"),
    LUMINOS_LOGO("luminoslogo.png"),
    NEW_TEXT_DOCUMENT("New Text Document.txt"),
    NOT_EMPTY("not_empty.txt"),
    SHELBY("Shelby.jpg"),
    SOME_FILE("some-file.txt"),
    UPLOAD_NOTEPAD("UploadNotepad.txt"),
    URL_MOBILE("url_mobile.txt"),
    WEBDRIVER_IO("webdriverIO.png"),
    ZADANIA("ZADANIA.docx");

    private final String fileName;

    DownloadableFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return CommonUtil.capitalizeEnumName(this.name());
    }
}