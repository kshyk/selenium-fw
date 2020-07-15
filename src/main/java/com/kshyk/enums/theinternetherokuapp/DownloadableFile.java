package com.kshyk.enums.theinternetherokuapp;

import com.kshyk.common.CommonUtil;

public enum DownloadableFile {
    NOT_EMPTY("not_empty.txt");

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